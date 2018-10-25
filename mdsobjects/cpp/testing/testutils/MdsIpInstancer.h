#ifndef TESTUTILS_MDSIPMAIN_H
#define TESTUTILS_MDSIPMAIN_H
#define USE_FORK // could also be set by CXXFLAGS=-DUSE_FORK

#ifdef _WIN32
 #ifdef _WIN32_WINNT
  #undef _WIN32_WINNT
 #endif
 #define _WIN32_WINNT _WIN32_WINNT_WIN8 // Windows 8.0
 #include <winsock2.h>
 #define REUSEADDR_TYPE BOOL
#else
#include <string.h>
 #ifndef USE_FORK
  #include <spawn.h>
 #endif
 #define SOCKET int
 #define INVALID_SOCKET -1
 #include <sys/socket.h>
 #include <netinet/in.h>
 #include <arpa/inet.h>
 #define REUSEADDR_TYPE int
 #include <signal.h>
 #include <errno.h>
#endif
#include <unistd.h>
#include <fstream>
#include <sys/types.h>
#include <testutils/Singleton.h>

#include <mdsobjects.h>


extern char **environ;

namespace mds = MDSplus;
namespace testing {
class MdsIpInstancer {
    struct HostFile {
        HostFile() {
            std::string hosts_default =
                    "* | MAP_TO_LOCAL \n"
                    "* | nobody \n";

            std::ofstream hosts_file;
            hosts_file.open("testing.hosts");
            hosts_file << hosts_default << "\n";
            hosts_file.close();
        }
        ~HostFile() {
            remove("testing.hosts");
        }
        const char *name() const { return "testing.hosts"; }
    };

    Singleton<HostFile> m_host_file;
    pid_t m_pid;
    unsigned short m_port;
    std::string m_protocol;

public:

    MdsIpInstancer(const char *protocol,unsigned short port, const char *mode) :
        m_port(port),
        m_protocol(protocol)
    {
	if (port==0) {
	  m_pid = 0;
	  return;
	}
        // build lazy singleton instance //
	m_host_file.get_instance();
	char port_str[20];
	char *argv[] = {(char*)"mdsip",(char*)"-P",(char*)m_protocol.c_str(),(char*)"-h",(char*)m_host_file->name(),(char*)"-p",port_str,(char*)mode, NULL};
	// get first available port  //
	int offset = 0;
	while(!available(m_port,m_protocol) && offset<100 )
	  m_port += offset++;
	if(offset==100)
	  throw std::out_of_range("any port found within 100 tries");
	sprintf(port_str,"%i",m_port);
#ifdef _WIN32
	if (!(m_pid = _spawnvpe(P_NOWAIT, argv[0], argv+1, environ)))
#elif defined(USE_FORK)
	std::cout << "FORKING PROCESS!" << std::flush;
	m_pid = fork();
	if(m_pid==0) // child process
	//   exit(execvpe(argv[0], argv, environ));
	   exit(execvp(argv[0], argv) ? errno : 0);
	else if (m_pid<0) // spawn failed
#else
	if (posix_spawnp(&m_pid, "mdsip", NULL, NULL, argv, environ))
#endif
	  throw std::runtime_error("Could not start mdsip server");
	else
	  std::cout << "started mdsip server for " << m_protocol << " on port: " << m_port << " pid: " << m_pid << "\n" << std::flush;
    }

    ~MdsIpInstancer() {
	if(m_pid>0){
	  std::cout << "removing mdsip for " << m_protocol << "\n" << std::flush;
#ifdef _WIN32
	  HANDLE explorer;
	  explorer = OpenProcess(PROCESS_ALL_ACCESS,false,m_pid);
	  TerminateProcess(explorer,1);
#else
	  kill(m_pid,SIGKILL);
#endif
	}
    }

    int getPort() const { return m_port; }

    std::string getAddress() const {
        std::stringstream ss;
        if (m_port==0)                 ss << m_protocol << "://tunnel";
        else if (m_protocol=="tcp")    ss << "tcp://127.0.0.1:" << m_port;
        else if (m_protocol=="udt")    ss << "udt://127.0.0.1:" << m_port;
        else if (m_protocol=="tcpv6")  ss << "tcpv6://::1#" << m_port;
        else if (m_protocol=="udtv6")  ss << "udtv6://::1#" << m_port;
        else if (m_protocol=="gsi")    ss << "gsi://localhost:" << m_port;
        else                           ss << m_protocol << "://localhost:" << m_port;
        return ss.str();
    }

    bool waitForServer(int retries = 5, int usec = 500000) const {
        if(m_pid > 0) { // only parent can wait //
            for(int retry = 0; retry<retries; ++retry) {
                try {
                    mds::Connection cnx((char *)this->getAddress().c_str());
                    (void)cnx;
                    return true; }
                catch (mds::MdsException &e) {
                    (void)e;
                    usleep(usec);
                }
            }
        }
        return false;
    }

private:


    // Allocate a new TCP server socket, and return
    // its handler
    int allocate(const std::string &protocol) {
        SOCKET sock = INVALID_SOCKET;
        int addr,data,proto;
	if(protocol == "tcpv6" || protocol == "udtv6")
	  addr = AF_INET6; else addr = AF_INET;
        if(protocol == "udt" || protocol == "udt6") {
           data  = SOCK_DGRAM;
           proto = IPPROTO_UDP;
	} else {
           data  = SOCK_DGRAM;
           proto = IPPROTO_UDP;
	}
	sock = socket(addr, data, proto);
        if (sock == INVALID_SOCKET) {
            if (errno == EMFILE) {
                /* too many open files */
                return 0;
            }
            fprintf(stderr,"error allocating socket '%s': ", protocol.c_str());
            perror("");
            exit(1);
        }
	REUSEADDR_TYPE optval = 1;
        setsockopt(sock, SOL_SOCKET, SO_REUSEADDR, (char*)&optval, sizeof(optval));
        return sock;
    }

    // Check whether the provided TCP port is available
    // at the moment and return 1 if it's avaiable, zero otherwise
    int available(int port, const std::string protocol) {
        int sock = allocate(protocol);
	// TODO: AF_INET6 supported sockaddr_in
        struct sockaddr_in addr;
        memset(&addr, 0, sizeof(addr));
        addr.sin_family = AF_INET;
	addr.sin_port = htons(port);
	addr.sin_addr.s_addr = htonl(INADDR_ANY); //inet_addr("0.0.0.0")
        int error = bind(sock, (struct sockaddr*) &addr, sizeof(addr));
        if(!error) {
            shutdown(sock,2);
            close(sock);
        }
        return error == 0;
    }

};
} // testing

#endif // MDSIPMAIN_H

