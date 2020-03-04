import com.phidget22.DigitalOutput;
import com.phidget22.PhidgetException;
import com.phidget22.RFID;

public class LED 
{
    
	//Creating a new variable called RFID and DigitalOutput
   	RFID phid;
    DigitalOutput digOut;
    
    //Creating a publisher variable
    Publisher pub = new Publisher();
    
	public static void main(String[] args) throws PhidgetException 
	{
		//Instantiating class
        new LED();
    }

    public LED()
    {
     try {
			phid = new RFID();
			digOut  = new DigitalOutput();
	    	// set the DigitalOutput channel (0 or 1 on RFID boa rd)
	    	digOut.setChannel(1);
	    	// open for writing
	    	digOut.open(2000);
	    	
	        // Open and start detecting rfid cards
	        phid.open(5000); // wait 5 seconds for device to respond
	
	        // Display info on currently connected devices
	        System.out.println("Device Name " + phid.getDeviceName());
	        System.out.println("Serial Number" + phid.getDeviceSerialNumber());
	        System.out.println("Device Version " + phid.getDeviceVersion());
	    	
	        phid.setAntennaEnabled(true);
     	} catch (Exception e) {
     	}
    }

	public void turnOnLight(boolean lightState)
	{
		// method to set state of digital out for light to on
		if (lightState==true) {
	
	        try {
	        	System.out.println("LIGHT ON");
	        	digOut.setChannel(0);
	        	digOut.setState(true);
				
			} catch (PhidgetException e) 
	        {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void turnOffLight(boolean lightState) 
	{
		// method to set state of digital out for light to off
		if (lightState==false) 
		{
			try {
	        	System.out.println("LIGHT OFF");
	        	digOut.setChannel(0);
	        	digOut.setState(false);
			} catch (PhidgetException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}	
	}
	
    private void pause(int secs)
    {
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }


}