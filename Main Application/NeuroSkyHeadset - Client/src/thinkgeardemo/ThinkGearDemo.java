//A DEMO USED TO ACCESS DATA READINGS
//Contain basic methods from the API

package thinkgeardemo;

import neurosky.ThinkGearSocket;
import processing.core.PApplet;

public class ThinkGearDemo extends PApplet 
{
	public ThinkGearSocket neuroSocket;
	public int attention=0;
	public int meditation=0;
	public Object eegEventMethod = null;
	public Object rawEventMethod = null;
	
	public void setup() 
	{
		 ThinkGearSocket neuroSocket = new ThinkGearSocket(this);
		  try {
		    neuroSocket.start();
		  } 
		  catch (Exception e) 
		  {
		    println("Is ThinkGear running??");
		  }  
	}
	
	public static void main(String _args[]) 
	{
		PApplet.main(new String[] { thinkgeardemo.ThinkGearDemo.class.getName() });
	}

	public void attentionEvent(int attentionLevel) 
	{
	  println("Attention Level: " + attentionLevel);
	  attention = attentionLevel;
	}

	public void meditationEvent(int meditationLevel) 
	{
	  println("Meditation Level: " + meditationLevel);
	  meditation = meditationLevel;
	}

	public void blinkEvent(int blinkStrength) 
	{
	  println("blinkStrength: " + blinkStrength);
	}

	void rawEvent(int[] raw) 
	{
	}	

	public void poorSignalEvent()
	{
	}

	void eegEvent(int[] raw) 
	{
	}	
	
	public void stop() 
	{
	  neuroSocket.stop();
	  super.stop();
	}
	
	public int getAttention()
	{
		return this.attention;
	}
	
	public int getMeditation()
	{
		return this.meditation;
	}
	
}
