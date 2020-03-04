import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.eclipse.paho.client.mqttv3.*;

import mqtt.utils.Utils;

public class SubscribeCallback implements MqttCallback 
{
	//This class uses the data sent to the subscriber - the callback gets called when the message arrives
	
	//Creating an instance of the Class “LED” - now referred to l
	LED l = new LED();
    public static final String headsetID = "103"; 

    public static String sensorServerURL = "http://localhost:NeuroSkyHeadset - Server/SensorServerDB";
    
    @Override
    public void connectionLost(Throwable cause) 
    {
        //This is called when the connection is lost. We could reconnect here.
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception //The code that gets executed everytime 
    {
        System.out.println("Message arrived. Topic: " + topic + "  Message: " + message.toString()); //Recieve this message string 
        
        // Switch light to on if message is "on"
        if (message.toString().equals("on")) 
        {
	        l.turnOnLight(true);
        } else {
        	//If the message is anything other than "on" - The method turnoffLight is called
    	    l.turnOffLight(false);
        }
        
        //send the sensor data object to the server 
        if ((1+"/LWT").equals(topic)) 
        {
            System.err.println("Sensor gone!"); //In-case the sensor is disconnected - print sensor gone
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) 
    {
        //no-op
    }
    
}
