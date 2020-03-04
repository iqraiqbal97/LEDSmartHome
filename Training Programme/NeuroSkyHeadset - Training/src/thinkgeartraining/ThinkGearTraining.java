package thinkgeartraining;

import processing.core.PApplet;
import neurosky.*;
import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

import org.json.*;

public class ThinkGearTraining extends PApplet 
{
	//Declaring an ArrayList to store the Integer type value
	ArrayList<Integer> myArray = new ArrayList<Integer>();
	
	//Variables
	public ThinkGearSocket neuroSocket;
	public int attention=0;
	public int meditation=0;
	public Object eegEventMethod = null;
	public Object rawEvent = null;
	
	//Main method
	public static void main(String _args[]) 
	{
		PApplet.main(new String[] { thinkgeartraining.ThinkGearTraining.class.getName() });
	}
	
	public void setup() 
	{
	  ThinkGearSocket neuroSocket = new ThinkGearSocket(this);
	  try {
		//Start Neurosky head set
	    neuroSocket.start();
	  } 
	  catch (Exception e) 
	  {
		//If there are any connectivity issues with the head set 
	    println("Is ThinkGear running??");
	  }
	}

	//Method called after setup()
	public void start() 
	{
		
////////////////////(1)CALIBERATING READINGS - CALMING MIND DOWN(1)///////////////////
		
		System.out.println("Relax your mind and count backwards from 10");
			
		//For Loop implemented - i = 10 therefore if i is greater than 0 it will decrease by 1 each time
		for(int i = 10; i > 0; i--)
		{
		  //Print out the value of i
	      System.out.println(i);
	      try {
	    	//Loop occurs after every 1 second
			TimeUnit.SECONDS.sleep(1);
	      	}
	      	catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	      	}		
	    }
		
		/////RECALLING LIGHT ON AVERAGE READING/////
		System.out.println("Now think about turning a light ON ");
		
		try {
			//Allows the user to read instruction 
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
//////////////////////////////////////////////////////////////////////////////////////

		
////////////////////(2)CALIBERATING READINGS - CALMING MIND DOWN(2)///////////////////
		
//		System.out.println("Relax your mind and count backwards from 10 again");
//		for(int i = 10; i > 0; i--)
//		{
//	      System.out.println(i);
//	      try {
//			TimeUnit.SECONDS.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//	    }
//		
//		/////RECALLING LIGHT ON AVERAGE READING/////
//		System.out.println("Now think about turning a light OFF ");
//		
//		try {
//			TimeUnit.SECONDS.sleep(3);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//////////////////////////////////////////////////////////////////////////////////////
	
	}
	
	public static float findSum(ArrayList<Integer> array) 
	{
		//Float variable - decimal and whole integer
	    float sum = 0;

	    //i = 0 
	    //array.size allows me to find actual size in the array list
	    
	    for(int i = 0; i < array.size(); i++)
	    {
	    	//Add the values and store in sum
	    	sum = sum + array.get(i);	
	    }
	    
	    //Divide sum by number of values (size of array)
	    sum = sum/array.size();
	    
	    //Print out average value
	    System.out.println("line 101: " + sum);
	    
	    return sum;
	}
    
	public void attentionEvent(int attentionLevel) 
	{
		
//	System.out.println("Print and collect Attetnion data for 60 seconds");		

	  //Print out attention value
	  println("Attention Level: " + attentionLevel);
	  attention = attentionLevel;
	  
	  //Do not carry the method if the attention value is 0 - as this affects the average results 
	  if(attentionLevel != 0)
	  {
		  //pushes the attention value into the array list
		  myArray.add(attentionLevel);
		 
		  //call method
		  findSum(myArray);	 
	  }
	 
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Methods called to prevent error message occurring in console
	//The same method can be easily implemented for other data readings however due to my target audience i decided to only implement attention
	
	public void meditationEvent(int meditationLevel) 
	{
//	  println("Meditation Level: " + meditationLevel);
//	  meditation = meditationLevel;
	}

	public void blinkEvent(int blinkStrength) 
	{
//	  println("blinkStrength: " + blinkStrength);
	}

	void rawEvent(int[] raw) 
	{
//	  println("rawEvent Level: " + raw);
	}	
	
	public void eegEvent(int delta, int theta, int low_alpha, int high_alpha, int low_beta, int high_beta, int low_gamma, int mid_gamma) 
	{
//		System.out.println("eegEvent");
	}	
	
	public static void poorSignalEvent(int sig) 
	{
//		System.out.println("SignalEvent " + sig);
	}

	//Stop neuroksy head set
	public void stop() 
	{
	  neuroSocket.stop();
	  super.stop();
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//Regulate brain reading - think of an exercise
	//Get data from head set
	//Find the average 
	//Use a configuration file to store the average data for on and off 
	
}

