@ECHO off

REM ============================= /!\ WARNING /!\ =============================
REM Before running this script, make sure that the DEF export files exist!!
REM It is possible to generate these files by calling command "make defs"
REM from "mdsobjects\cpp" directory under MinGW terminal for example
REM ============================= /!\ WARNING /!\ =============================

REM Obtain SRCDIR from location of this script

set OLDDIR=%CD%
cd %~dp0..\..
set SRCDIR=%CD%
cd %OLDDIR%

REM A subset of the Visual Studio binaries, libs and headers
REM Change VSVER, VCVER and WKVER to use your current version of Visual Studio and SDK

set VSVER=2019
set VCVER=14.24.28314
set WKVER=10.0.17134.0

set MVS=C:\Program Files (x86)\Microsoft Visual Studio\%VSVER%\Community\VC\Tools\MSVC\%VCVER%
set WK=C:\Program Files (x86)\Windows Kits\10
set PATH=%MVS%\bin\HostX64\x64;%WK%\bin\%WKVER%\x64
set INCLUDE=%MVS%\include;%WK%\include\%WKVER%\shared;%WK%\include\%WKVER%\ucrt;%WK%\include\%WKVER%\um;
set LIB=%MVS%\lib\x64;%MVS%\lib\onecore\x64; %MVS%\atlmfc\lib\x64;%WK%\lib\%WKVER%\ucrt\x64;%WK%\Lib\%WKVER%\um\x64

REM Various directories used for compiles, links and lib generation

set CPP=%SRCDIR%\mdsobjects\cpp
set BUILD64=%SRCDIR%\bin_x86_64
set BUILD32=%SRCDIR%\bin_x86

mkdir %BUILD64%
mkdir %BUILD32%

REM Build Visual Studio compatible lib files for the C based libraries (both 64 and 32 bit versions)

for %%i in (%SRCDIR%\defs\*.def) do lib /def:%%i /out:%BUILD64%\%%~ni.lib /machine:x64
for %%i in (%SRCDIR%\defs\*.def) do lib /def:%%i /out:%BUILD32%\%%~ni.lib /machine:x86


REM Use Visual studio compiler to compile the CPP modules

set CL_OPTS=/c /GS /W3 /Zc:wchar_t /I"%SRCDIR%\include" /I"%SRCDIR%\tdishr" /Zi /Gm- /O2 ^
 /Fd"%TEMP%\vc%VCVER%.pdb" /Zc:inline /fp:precise /D "WIN32" /D "NDEBUG" /D "WINDOWS_H" ^
 /D "_WINDOWS" /D "_USRDLL" /D "MDSOBJECTSCPPSHRVS_EXPORTS" /D "NOMINMAX" ^
 /D "_CRT_SECURE_NO_WARNINGS" /D "_WINDLL" /errorReport:prompt /WX- /Zc:forScope ^
 /Gd /MD /EHsc /nologo  /Fp"MdsObjectsCppShr-VS.pch" /diagnostics:classic

cl %CL_OPTS% %CPP%\mdsdata.c
cl %CL_OPTS% %CPP%\mdsdataobjects.cpp
cl %CL_OPTS% %CPP%\mdseventobjects.cpp
cl %CL_OPTS% %CPP%\mdsipobjects.cpp
cl %CL_OPTS% %CPP%\mdstree.c
cl %CL_OPTS% %CPP%\mdstreeobjects.cpp


REM Link MdsObjectsCppShr-VS.dll x64

link /OUT:"%BUILD64%\MdsObjectsCppShr-VS.dll" /NXCOMPAT /PDB:"MdsObjectsCppShr-VS.pdb" ^
 /DYNAMICBASE "MdsShr.lib" "TreeShr.lib" "TdiShr.lib" "MdsIpShr.lib" "kernel32.lib" "user32.lib" ^
 "gdi32.lib" "winspool.lib" "comdlg32.lib" "advapi32.lib" "shell32.lib" "ole32.lib" "oleaut32.lib" ^
 "uuid.lib" "odbc32.lib" "odbccp32.lib" /IMPLIB:"%BUILD64%\MdsObjectsCppShr-VS.lib" /DLL /MACHINE:X64 ^
 /OPT:REF /INCREMENTAL:NO /SUBSYSTEM:WINDOWS /MANIFEST /MANIFESTUAC:"level='asInvoker' uiAccess='false'" ^
 /MANIFEST:embed /OPT:ICF /ERRORREPORT:PROMPT /NOLOGO ^
 /LIBPATH:"%BUILD64%" /TLBID:1 ^
 mdsdata.obj mdsdataobjects.obj mdseventobjects.obj mdsipobjects.obj mdstree.obj mdstreeobjects.obj
