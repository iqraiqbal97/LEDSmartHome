//import org.eclipse.paho.client.mqttv3.*;

//MQTT allows the data to be published 

import org.eclipse.paho.client.mqttv3.*;

public class Publisher 
{
    //public static final String BROKER_URL = "tcp://iot.eclipse.org:1883";
    public static final String BROKER_URL = "tcp://broker.mqttdashboard.com:1883";

    public static final String light = "103"; // change this to be your student-id
    
    public static final String TOPIC_LED = light + "/LED";

    private MqttClient client;

    public Publisher() 
    {
        try {
            client = new MqttClient(BROKER_URL, light);
            // create mqtt session
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            options.setWill(client.getTopic(light + "/LWT"), "I'm gone :(".getBytes(), 0, false);
            client.connect(options);
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Specific publishing methods for particular phidgets
    public void publishLED() throws MqttException 
    {
        final MqttTopic ledTopic = client.getTopic(TOPIC_LED);
        final String led = "";
        ledTopic.publish(new MqttMessage(led.getBytes()));
        System.out.println("Published data. Topic: " + ledTopic.getName() + " Message: " + led);
    }

    // More generic publishing methods - avoids having to name every one
    public void publishSensor1(String headsetId, float headsetId2) throws MqttException 
    {
        final MqttTopic mqttTopic = client.getTopic(TOPIC_LED + headsetId);
        final String sensor = headsetId2 + "";
        System.out.println("publishing via generic publishsensor");
        mqttTopic.publish(new MqttMessage(sensor.getBytes()));
        System.out.println("Published data. Topic: " + mqttTopic.getName() + " Message: " + sensor);
    }
    
    public void publishSensor(String headsetId, String sensorValue) throws MqttException 
    {
    // same as string publisher, just convert int to String
      publishSensor(String.valueOf(sensorValue), headsetId);
    }
    
    public void publishSensor(float headsetId, String sensorValue) throws MqttException 
    {
    // same as string publisher, just convert float to String
      publishSensor1(String.valueOf(sensorValue), headsetId);
    }

}

