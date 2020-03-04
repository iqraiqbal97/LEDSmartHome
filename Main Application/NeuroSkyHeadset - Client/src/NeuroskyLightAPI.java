import neurosky.ThinkGearSocket;
import processing.core.PApplet;
import thinkgeardemo.ThinkGearDemo;
import java.util.*;
import java.net.ConnectException;
import com.phidget22.DigitalOutput;
import com.phidget22.DigitalOutputBase;
import com.phidget22.PhidgetBase;
import com.phidget22.PhidgetException;
import com.phidget22.RFID;

//Java API
public class NeuroskyLightAPI 
{	
	//testing method
	public static void print()

	{
		System.out.println("testing");
	}
	
	//Method called to connect Neurosky Headset and hidget kit
	public static void connectDevices() throws PhidgetException
	{
		ThinkGearSocket.class.getName();
		ThinkGearSocket neuroSocket = null;
		try {
			neuroSocket.start();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RFID phid = new RFID();
		phid.open();
	}

	//Method called to connect to phidget RFID board and LED only
	private static void open() throws PhidgetException 
	{
		// TODO Auto-generated method stub
		RFID phid = new RFID();
		DigitalOutput digOut = new DigitalOutput();
		digOut.setChannel(1);
		digOut.open();
		phid.open(5); // wait 5 seconds for device to respond
	}

	//Method called to connect to Neurosky Headset only
	public static void connectNeuroskyHeadset()
	{
		ThinkGearSocket neuroSocket = null;
		try {
			neuroSocket.start();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Method to get phidget data
	public void getPhidgetInfo()throws PhidgetException
	{
		RFID phid = new RFID();
		phid.getDeviceName();
		phid.getDeviceSerialNumber();
		phid.getDeviceVersion();
	}

	//Method to get Neurosky attention data
	public static void getNeuroskyAttentionData(int attentionLevel)
	{
		ThinkGearSocket neuroSocket = null;
		int attention=0;
		
	    try {
			neuroSocket.start();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PApplet.main(new String[] { thinkgeardemo.ThinkGearDemo.class.getName() });

		System.out.println("Attention Level: " + attentionLevel);
		attention = attentionLevel;	
	}

	//Method to get Neurosky meditation data
	public static void getNeuroskyMeditationData(int meditationLevel) 
	{
		ThinkGearSocket neuroSocket = null;
		int meditation=0;
		
	    try {
			neuroSocket.start();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		meditation = meditationLevel;	
	}
	
	//Method to turn light on
	public static void turnOnLight(boolean lightState) throws PhidgetException
	{
		// method to set state of digital out for light to on
		if (lightState==true) {
			
	        try {
	        	System.out.println("LIGHT ON");
	        	PhidgetBase digOut = null;
				digOut.setChannel(0);
	        	((DigitalOutputBase) digOut).setState(true);
				
			} catch (PhidgetException e) 
	        {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//Method to turn light off
	public static void turnOffLight(boolean lightState) throws PhidgetException
	{
		if (lightState==false) 
		{
			try {
	        	System.out.println("LIGHT OFF");
	        	PhidgetBase digOut = null;
				digOut.setChannel(0);
	        	((DigitalOutputBase) digOut).setState(false);
			} catch (PhidgetException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}	
	}

	//Method to disconnect phidget kit
	public static void disconnectPhidgetKit() throws PhidgetException
	{
		PhidgetBase phid = null;
		phid.close();
	}
	
	//Method to disconnect neurosky head set
	public static void disconnectNeuroskyHeadset()
	{
		ThinkGearSocket neuroSocket = null;
		neuroSocket.stop();
	}

}


