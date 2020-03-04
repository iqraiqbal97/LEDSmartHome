import java.net.ConnectException;

import com.phidget22.DigitalOutput;
import com.phidget22.PhidgetException;
import com.phidget22.RFID;

import neurosky.ThinkGearSocket;
import processing.core.PApplet;
import thinkgeardemo.ThinkGearDemo;

import java.util.Scanner;

//Public allows it can be accessed from every where
public class HeadsetAndLED extends PApplet
{
	//Method main - ran first
	public static void main(String _args[]) 
	{
		try {
			//Creating an instance of the Class “HeadsetAndLED” - now referred to l
			HeadsetAndLED l = new HeadsetAndLED();

			//Creating an instance of ThinkGearSocket - now referred to neuorsocket
			ThinkGearSocket neuroSocket = new ThinkGearSocket(l);

			//start neurosky headset
			neuroSocket.start();
		}
		catch (PhidgetException pe) {
			//Print out if error occurred when connecting to phidget kit
			System.err.println("Problem with the phidgets!");
			pe.printStackTrace();
		}
		catch (ConnectException ce) {
			//Print out if error occurred when connecting to phidget kit
			System.err.println("Problem with the headset!");
			ce.printStackTrace();
		}
	}

	//Creating instances for RFID reader/Digital LED/Headset
	RFID phid = new RFID();
	DigitalOutput digOut = new DigitalOutput();
	public ThinkGearDemo demo = new ThinkGearDemo();
	public ThinkGearSocket neuroSocket;

	//Global variables
	public int attention;
	public int meditation;
	public int blinkEvent;
	public Object eegEventMethod = null;
	public Object rawEventMethod = null;

	public HeadsetAndLED() throws PhidgetException 
	{
		//DEFAULTS SYSTEM ERROR CHECK - manually set attention level
		//		attention = 65;

		System.out.println("Connecting Devices");

		//		meditationEvent(meditation);
		//    	blinkEvent(blinkEvent);

		//		DEBUG print message
		//		System.out.println("Line 52: " + attention);

		//Set the DigitalOutput channel (0 or 1 on RFID board)
		digOut.setChannel(1);

		//Open for writing
		digOut.open();

		//Open and start detecting rfid cards
		phid.open(10); // wait 5 seconds for device to respond

		//Display info on currently connected devices
		System.out.println("Device Name " + phid.getDeviceName());
		System.out.println("Serial Number " + phid.getDeviceSerialNumber());
		System.out.println("Device Version " + phid.getDeviceVersion());

		phid.setAntennaEnabled(true);

		//Close phidget RFID connection
		//phid.close();
	};

	//The main methods of AttentionEvent/MeditationEvent/BlinkEvent taken from the API

	public void attentionEvent(int attentionLevel) 
	{
		System.out.println("Attention Level:" + attention);
		attention = attentionLevel;	

		//If statement - depending on the unique condition which is altered 
		//The main aspects is the condition is compared against the attention level
		if (attention >30 && attention <67) 
		{
			//If the condition is true the method below is called
			//(Light turns on) - boolean is true
			turnOnLight(true);
		} else { 
			//If the condition is false the method below is called
			//(Light turns off) - boolean is false
			turnOnLight(false);
		}
	}

	public void meditationEvent(int meditationLevel) 
	{
		System.out.println("Meditation Level: " + meditationLevel);
		meditation = meditationLevel;

		//		if (meditation >= 20) {
		//			turnOnLight(true);
		//		} else { 
		//			turnOnLight(false);
		//		}
	}

	public void blinkEvent(int blinkStrength) 
	{
		System.out.println("blinkStrength: " + blinkStrength);

		//		if (blinkStrength >= 100) {
		//			turnOnLight(true);
		//		} else { 
		//			turnOnLight(false);
		//		}
	}

	private void turnOnLight(boolean lightState)
	{
		// method to set state of digital out for light to on or off

		if (lightState == true) {
			try {
				System.out.println("LIGHT ON");
				digOut.setChannel(0);
				digOut.setState(true);

			} catch (PhidgetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try { 
				System.out.println("LIGHT OFF");
				digOut.setState(false);
				digOut.setChannel(0);

			} catch (PhidgetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}  

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Methods called to prevent error message occurring in console
	public static void poorSignalEvent(int sig) 
	{
		//System.out.println("SignalEvent " + sig);
	}

	public void rawEvent(int[] raw)
	{
		//System.out.println("rawEvent");
	}

	public void eegEvent(int delta, int theta, int low_alpha, int high_alpha, int low_beta, int high_beta, int low_gamma, int mid_gamma) 
	{
		//System.out.println("eegEvent");
	}	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	//Method to stop the Neurosky head set connection
	public void stop() 
	{
		neuroSocket.stop();
	}

}

