
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import mqtt.utils.Utils;

public class Subscriber 
{
	//This class listens to the topic (RFID) and allows data to be listen from RFIDServo and motorServo

    //public static final String BROKER_URL = "tcp://iot.eclipse.org:1883";
    public static final String BROKER_URL = "tcp://broker.mqttdashboard.com:1883";

    public static final String light = "103"; // change this to be your student-id
    
    public static final String TOPIC_LED = light + "/LED";

    //We have to generate a unique Client id.
    String clientId = Utils.getMacAddress() + "-sub";
    private MqttClient mqttClient;

    public Subscriber() 
    {
        try {
            mqttClient = new MqttClient(BROKER_URL, clientId);

        	} catch (MqttException e) 
        		{
		            e.printStackTrace();
		            System.exit(1);
        		}
    }

    public void start() 
    {
        try {
	            mqttClient.setCallback(new SubscribeCallback()); 
	            //defines a method to do when this particular message arrive - class called subscribe call back
	            mqttClient.connect();
	
	            //Subscribe to all subtopics of home
	            //Set top and ask client to subscribe to that topic - only subscribing to RFID
	            final String topic = light + "/LED"; 
	           
	            mqttClient.subscribe(topic);
	
	            System.out.println("Subscriber is now listening to "+topic);

        	} catch (MqttException e) 
		        {
		            e.printStackTrace();
		            System.exit(1);
		        }
    }

    public static void main(String... args) 
    {
        final Subscriber subscriber = new Subscriber();
        subscriber.start();
    }

}


