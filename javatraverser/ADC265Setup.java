/*
		A basic implementation of the DeviceSetup class.
*/

import java.awt.*;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class ADC265Setup extends DeviceSetup
{
	public ADC265Setup(Frame parent)
	{
		super(parent);
		
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		//{{INIT_CONTROLS
		getContentPane().setLayout(null);
		setSize(533,505);
		deviceField1.setNumCols(30);
		deviceField1.setTextOnly(true);
		deviceField1.setOffsetNid(3);
		deviceField1.setLabelString("Comment: ");
		getContentPane().add(deviceField1);
		deviceField1.setBounds(12,12,516,36);
		deviceField2.setNumCols(15);
		deviceField2.setTextOnly(true);
		deviceField2.setOffsetNid(2);
		deviceField2.setLabelString("Name: ");
		getContentPane().add(deviceField2);
		deviceField2.setBounds(12,60,228,36);
		deviceChoice1.setOffsetNid(5);
		{
			String[] tempString = new String[3];
			tempString[0] = "INTERNAL";
			tempString[1] = "EXTERNAL";
			tempString[2] = "EXT_REF_10MHz";
			deviceChoice1.setChoiceItems(tempString);
		}
		deviceChoice1.setLabelString("Clock Mode:");
		getContentPane().add(deviceChoice1);
		deviceChoice1.setBounds(12,108,216,36);
		deviceChoice2.setChoiceFloatValues(new float[] {(float)100.0,(float)200.0,(float)250.0,(float)400.0,(float)500.0,(float)1000.0,(float)2000.0,(float)2500.0,(float)4000.0,(float)5000.0,(float)10000.0,(float)20000.0,(float)25000.0,(float)40000.0,(float)50000.0,(float)100000.0,(float)200000.0,(float)250000.0,(float)400000.0,(float)500000.0,(float)1000000.0,(float)2000000.0,(float)2500000.0,(float)4000000.0,(float)5000000.0,(float)1.0E7,(float)2.0E7,(float)2.5E7,(float)4.0E7,(float)5.0E7,(float)1.0E8,(float)2.0E8,(float)2.5E8,(float)4.0E8,(float)5.0E8});
		deviceChoice2.setOffsetNid(12);
		{
			String[] tempString = new String[35];
			tempString[0] = "100";
			tempString[1] = "200";
			tempString[2] = "250";
			tempString[3] = "400";
			tempString[4] = "500";
			tempString[5] = "1E3";
			tempString[6] = "2E3";
			tempString[7] = "2.5E3";
			tempString[8] = "4E3";
			tempString[9] = "5E3";
			tempString[10] = "10E3";
			tempString[11] = "20E3";
			tempString[12] = "25E3";
			tempString[13] = "40E3";
			tempString[14] = "50E3";
			tempString[15] = "100E3";
			tempString[16] = "200E3";
			tempString[17] = "250E3";
			tempString[18] = "400E3";
			tempString[19] = "500E3";
			tempString[20] = "1E6";
			tempString[21] = "2E6";
			tempString[22] = "2.5E6";
			tempString[23] = "4E6";
			tempString[24] = "5E6";
			tempString[25] = "10E6";
			tempString[26] = "20E6";
			tempString[27] = "25E6";
			tempString[28] = "40E6";
			tempString[29] = "50E6";
			tempString[30] = "100E6";
			tempString[31] = "200E6";
			tempString[32] = "250E6";
			tempString[33] = "400E6";
			tempString[34] = "500E6";
			deviceChoice2.setChoiceItems(tempString);
		}
		deviceChoice2.setLabelString("Freq:");
		getContentPane().add(deviceChoice2);
		deviceChoice2.setBounds(228,108,120,36);
		deviceField4.setNumCols(20);
		deviceField4.setOffsetNid(11);
		deviceField4.setLabelString("Clock Source:");
		getContentPane().add(deviceField4);
		deviceField4.setBounds(0,156,336,36);
		deviceField5.setOffsetNid(4);
		deviceField5.setLabelString("Delay:");
		getContentPane().add(deviceField5);
		deviceField5.setBounds(348,156,180,36);
		deviceChoice3.setOffsetNid(6);
		{
			String[] tempString = new String[5];
			tempString[0] = "EXTERNAL";
			tempString[1] = "CH1";
			tempString[2] = "CH2";
			tempString[3] = "CH3";
			tempString[4] = "CH4";
			deviceChoice3.setChoiceItems(tempString);
		}
		deviceChoice3.setLabelString("Trig. Chan.");
		getContentPane().add(deviceChoice3);
		deviceChoice3.setBounds(0,204,180,36);
		deviceChoice4.setOffsetNid(8);
		{
			String[] tempString = new String[2];
			tempString[0] = "TRIG_DC";
			tempString[1] = "TRIG_AC";
			deviceChoice4.setChoiceItems(tempString);
		}
		deviceChoice4.setLabelString("Trig. Coupl.");
		getContentPane().add(deviceChoice4);
		deviceChoice4.setBounds(180,204,156,36);
		deviceChoice5.setOffsetNid(9);
		{
			String[] tempString = new String[2];
			tempString[0] = "POSITIVE";
			tempString[1] = "NEGATIVE";
			deviceChoice5.setChoiceItems(tempString);
		}
		deviceChoice5.setLabelString("Trig. Slope:");
		getContentPane().add(deviceChoice5);
		deviceChoice5.setBounds(336,204,180,36);
		deviceField6.setNumCols(20);
		deviceField6.setOffsetNid(7);
		deviceField6.setLabelString("Trig. Source");
		getContentPane().add(deviceField6);
		deviceField6.setBounds(12,264,312,36);
		deviceField7.setOffsetNid(10);
		deviceField7.setLabelString("Trig. Level");
		getContentPane().add(deviceField7);
		deviceField7.setBounds(324,264,204,36);
		getContentPane().add(JTabbedPane1);
		JTabbedPane1.setBounds(24,312,492,132);
		JPanel1.setLayout(new BorderLayout(0,0));
		JTabbedPane1.add(JPanel1);
		JPanel1.setBounds(2,24,487,105);
		JPanel1.setVisible(false);
		deviceChannel1.setLines(2);
		deviceChannel1.setOffsetNid(15);
		deviceChannel1.setLabelString("State");
		JPanel1.add(BorderLayout.CENTER, deviceChannel1);
		deviceField8.setNumCols(12);
		deviceField8.setOffsetNid(16);
		deviceField8.setLabelString("Start Time:");
		deviceChannel1.add(deviceField8);
		deviceField9.setNumCols(12);
		deviceField9.setOffsetNid(17);
		deviceField9.setLabelString("End Time:");
		deviceChannel1.add(deviceField9);
		deviceChoice6.setOffsetNid(20);
		{
			String[] tempString = new String[4];
			tempString[0] = "DC1M";
			tempString[1] = "AC1M";
			tempString[2] = "DC50";
			tempString[3] = "AC50";
			deviceChoice6.setChoiceItems(tempString);
		}
		deviceChoice6.setLabelString("Coupling:");
		deviceChannel1.add(deviceChoice6);
		deviceChoice7.setChoiceFloatValues(new float[] {(float)0.05,(float)0.1,(float)0.5,(float)1.0,(float)2.0,(float)5.0});
		deviceChoice7.setOffsetNid(21);
		{
			String[] tempString = new String[6];
			tempString[0] = "50E-3";
			tempString[1] = "100E-3";
			tempString[2] = "500E-3";
			tempString[3] = "1.";
			tempString[4] = "2.";
			tempString[5] = "5.";
			deviceChoice7.setChoiceItems(tempString);
		}
		deviceChoice7.setLabelString("Range");
		deviceChannel1.add(deviceChoice7);
		deviceField10.setOffsetNid(22);
		deviceField10.setLabelString("Offest:");
		deviceChannel1.add(deviceField10);
		JPanel2.setLayout(new BorderLayout(0,0));
		JTabbedPane1.add(JPanel2);
		JPanel2.setBounds(2,24,487,105);
		JPanel2.setVisible(false);
		deviceChannel2.setOffsetNid(24);
		deviceChannel2.setLabelString("State");
		JPanel2.add(BorderLayout.CENTER, deviceChannel2);
		deviceField11.setNumCols(12);
		deviceField11.setOffsetNid(25);
		deviceField11.setLabelString("Start Time:");
		deviceChannel2.add(deviceField11);
		deviceField12.setNumCols(12);
		deviceField12.setOffsetNid(26);
		deviceField12.setLabelString("End Time:");
		deviceChannel2.add(deviceField12);
		deviceChoice8.setOffsetNid(29);
		{
			String[] tempString = new String[4];
			tempString[0] = "DC1M";
			tempString[1] = "AC1M";
			tempString[2] = "DC50";
			tempString[3] = "AC50";
			deviceChoice8.setChoiceItems(tempString);
		}
		deviceChoice8.setLabelString("Coupling:");
		deviceChannel2.add(deviceChoice8);
		deviceChoice9.setChoiceFloatValues(new float[] {(float)0.05,(float)0.1,(float)0.5,(float)1.0,(float)2.0,(float)5.0});
		deviceChoice9.setOffsetNid(30);
		{
			String[] tempString = new String[6];
			tempString[0] = "50E-3";
			tempString[1] = "100E-3";
			tempString[2] = "500E-3";
			tempString[3] = "1.";
			tempString[4] = "2.";
			tempString[5] = "5.";
			deviceChoice9.setChoiceItems(tempString);
		}
		deviceChoice9.setLabelString("Range");
		deviceChannel2.add(deviceChoice9);
		deviceField13.setOffsetNid(31);
		deviceField13.setLabelString("Offest:");
		deviceChannel2.add(deviceField13);
		JPanel3.setLayout(new BorderLayout(0,0));
		JTabbedPane1.add(JPanel3);
		JPanel3.setBounds(2,24,487,105);
		JPanel3.setVisible(false);
		deviceChannel3.setOffsetNid(33);
		deviceChannel3.setLabelString("State");
		JPanel3.add(BorderLayout.CENTER, deviceChannel3);
		deviceField14.setNumCols(12);
		deviceField14.setOffsetNid(34);
		deviceField14.setLabelString("Start Time:");
		deviceChannel3.add(deviceField14);
		deviceField15.setNumCols(12);
		deviceField15.setOffsetNid(35);
		deviceField15.setLabelString("End Time:");
		deviceChannel3.add(deviceField15);
		deviceChoice10.setOffsetNid(38);
		{
			String[] tempString = new String[4];
			tempString[0] = "DC1M";
			tempString[1] = "AC1M";
			tempString[2] = "DC50";
			tempString[3] = "AC50";
			deviceChoice10.setChoiceItems(tempString);
		}
		deviceChoice10.setLabelString("Coupling:");
		deviceChannel3.add(deviceChoice10);
		deviceChoice11.setChoiceFloatValues(new float[] {(float)0.05,(float)0.1,(float)0.5,(float)1.0,(float)2.0,(float)5.0});
		deviceChoice11.setOffsetNid(39);
		{
			String[] tempString = new String[6];
			tempString[0] = "50E-3";
			tempString[1] = "100E-3";
			tempString[2] = "500E-3";
			tempString[3] = "1.";
			tempString[4] = "2.";
			tempString[5] = "5.";
			deviceChoice11.setChoiceItems(tempString);
		}
		deviceChoice11.setLabelString("Range");
		deviceChannel3.add(deviceChoice11);
		deviceField16.setOffsetNid(40);
		deviceField16.setLabelString("Offest:");
		deviceChannel3.add(deviceField16);
		JPanel4.setLayout(new BorderLayout(0,0));
		JTabbedPane1.add(JPanel4);
		JPanel4.setBounds(2,24,487,105);
		JPanel4.setVisible(false);
		deviceChannel4.setOffsetNid(42);
		deviceChannel4.setLabelString("State");
		JPanel4.add(BorderLayout.CENTER, deviceChannel4);
		deviceField17.setNumCols(12);
		deviceField17.setOffsetNid(43);
		deviceField17.setLabelString("Start Time:");
		deviceChannel4.add(deviceField17);
		deviceField18.setNumCols(12);
		deviceField18.setOffsetNid(44);
		deviceField18.setLabelString("End Time:");
		deviceChannel4.add(deviceField18);
		deviceChoice12.setOffsetNid(47);
		{
			String[] tempString = new String[4];
			tempString[0] = "DC1M";
			tempString[1] = "AC1M";
			tempString[2] = "DC50";
			tempString[3] = "AC50";
			deviceChoice12.setChoiceItems(tempString);
		}
		deviceChoice12.setLabelString("Coupling:");
		deviceChannel4.add(deviceChoice12);
		deviceChoice13.setChoiceFloatValues(new float[] {(float)0.05,(float)0.1,(float)0.5,(float)1.0,(float)2.0,(float)5.0});
		deviceChoice13.setOffsetNid(48);
		{
			String[] tempString = new String[6];
			tempString[0] = "50E-3";
			tempString[1] = "100E-3";
			tempString[2] = "500E-3";
			tempString[3] = "1.";
			tempString[4] = "2.";
			tempString[5] = "5.";
			deviceChoice13.setChoiceItems(tempString);
		}
		deviceChoice13.setLabelString("Range");
		deviceChannel4.add(deviceChoice13);
		deviceField19.setOffsetNid(49);
		deviceField19.setLabelString("Offest:");
		deviceChannel4.add(deviceField19);
		JTabbedPane1.setSelectedIndex(0);
		JTabbedPane1.setSelectedComponent(JPanel1);
		JTabbedPane1.setTitleAt(0,"Channel 1");
		JTabbedPane1.setTitleAt(1,"Channel 2");
		JTabbedPane1.setTitleAt(2,"Channel 3");
		JTabbedPane1.setTitleAt(3,"Channel 4");
		getContentPane().add(deviceButtons1);
		deviceButtons1.setBounds(132,456,281,40);
		deviceField3.setNumCols(15);
		deviceField3.setShowState(true);
		deviceField3.setTextOnly(true);
		deviceField3.setOffsetNid(1);
		deviceField3.setLabelString("IP addr.: ");
		getContentPane().add(deviceField3);
		deviceField3.setBounds(240,60,288,36);
		getContentPane().add(deviceDispatch1);
		deviceDispatch1.setBounds(372,108,131,40);
		//}}
	}

	public ADC265Setup()
	{
		this((Frame)null);
	}

	public ADC265Setup(String sTitle)
	{
		this();
		setTitle(sTitle);
	}

	public void setVisible(boolean b)
	{
		if (b)
			setLocation(50, 50);
		super.setVisible(b);
	}

	static public void main(String args[])
	{
		(new ADC265Setup()).setVisible(true);
	}

	public void addNotify()
	{
		// Record the size of the window prior to calling parents addNotify.
		Dimension size = getSize();

		super.addNotify();

		if (frameSizeAdjusted)
			return;
		frameSizeAdjusted = true;

		// Adjust size of frame according to the insets
		Insets insets = getInsets();
		setSize(insets.left + insets.right + size.width, insets.top + insets.bottom + size.height);
	}

	// Used by addNotify
	boolean frameSizeAdjusted = false;

	//{{DECLARE_CONTROLS
	DeviceField deviceField1 = new DeviceField();
	DeviceField deviceField2 = new DeviceField();
	DeviceChoice deviceChoice1 = new DeviceChoice();
	DeviceChoice deviceChoice2 = new DeviceChoice();
	DeviceField deviceField4 = new DeviceField();
	DeviceField deviceField5 = new DeviceField();
	DeviceChoice deviceChoice3 = new DeviceChoice();
	DeviceChoice deviceChoice4 = new DeviceChoice();
	DeviceChoice deviceChoice5 = new DeviceChoice();
	DeviceField deviceField6 = new DeviceField();
	DeviceField deviceField7 = new DeviceField();
	javax.swing.JTabbedPane JTabbedPane1 = new javax.swing.JTabbedPane();
	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	DeviceChannel deviceChannel1 = new DeviceChannel();
	DeviceField deviceField8 = new DeviceField();
	DeviceField deviceField9 = new DeviceField();
	DeviceChoice deviceChoice6 = new DeviceChoice();
	DeviceChoice deviceChoice7 = new DeviceChoice();
	DeviceField deviceField10 = new DeviceField();
	javax.swing.JPanel JPanel2 = new javax.swing.JPanel();
	DeviceChannel deviceChannel2 = new DeviceChannel();
	DeviceField deviceField11 = new DeviceField();
	DeviceField deviceField12 = new DeviceField();
	DeviceChoice deviceChoice8 = new DeviceChoice();
	DeviceChoice deviceChoice9 = new DeviceChoice();
	DeviceField deviceField13 = new DeviceField();
	javax.swing.JPanel JPanel3 = new javax.swing.JPanel();
	DeviceChannel deviceChannel3 = new DeviceChannel();
	DeviceField deviceField14 = new DeviceField();
	DeviceField deviceField15 = new DeviceField();
	DeviceChoice deviceChoice10 = new DeviceChoice();
	DeviceChoice deviceChoice11 = new DeviceChoice();
	DeviceField deviceField16 = new DeviceField();
	javax.swing.JPanel JPanel4 = new javax.swing.JPanel();
	DeviceChannel deviceChannel4 = new DeviceChannel();
	DeviceField deviceField17 = new DeviceField();
	DeviceField deviceField18 = new DeviceField();
	DeviceChoice deviceChoice12 = new DeviceChoice();
	DeviceChoice deviceChoice13 = new DeviceChoice();
	DeviceField deviceField19 = new DeviceField();
	DeviceButtons deviceButtons1 = new DeviceButtons();
	DeviceField deviceField3 = new DeviceField();
	DeviceDispatch deviceDispatch1 = new DeviceDispatch();
	//}}

}