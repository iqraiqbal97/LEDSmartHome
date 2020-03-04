public class SensorData 
//Parameters of the SensorData class
//Setting names for the different variables in the class
	
{
	String headsetID;
	String attention;
	String mediation;
	String blinkStrength;
	String sensorValue;
	String sensorDate;

	
	public SensorData(String headsetID,String attention,String mediation,String blinkStrength,String sensorValue,String sensorDate) 
		{
			super();
			this.headsetID = headsetID;
			this.attention = attention;
			this.mediation = mediation;
			this.blinkStrength = blinkStrength;
			this.sensorValue = sensorValue;
			this.sensorDate = sensorDate;
		}

	// Constructors depending on which parameters are known
	public SensorData(String headsetID,String attention,String mediation,String blinkStrength) 
		{
			super();
			this.headsetID = headsetID;
			this.attention = attention;
			this.mediation = mediation;
			this.blinkStrength = blinkStrength;
			this.sensorDate = "unknown";
		}
	
	public SensorData(String headsetID, String sensorValue) 
	{
		super();
		this.headsetID = headsetID;
		this.sensorValue = sensorValue;
		this.sensorDate = "unknown";
	}


	public String getheadsetID()
    {
        return headsetID;
    }
    public void setheadsetID(String headsetID)
    {
        this.headsetID = headsetID;
    }

	public int getSensorAttention() 
		{
			return getSensorAttention();
		}
	public void setSensorAttention(String string) 
		{
			this.attention = string;
		}
	
	public int getSensorMediation() 
		{
			return getSensorMediation();
		}
	public void setSensorMediation(String mediation) 
		{
			this.mediation = mediation;
		}
	
	public int getblinkStrength()
	{
		return getblinkStrength();
	}
	
	public void setblinkStrength(String blinkStrength)
	{
		this.blinkStrength = blinkStrength;
	}
	
	public String getSensorValue() 
	{
		return sensorValue;
	}
	
	public void setSensorValue(String sensorValue) 
		{
			this.sensorValue = sensorValue;
		}
	
	public String getSensorDate() 
		{
			return sensorDate;
		}
	
	public void setSensorDate(String sensorValue) 
		{
			this.sensorDate = sensorValue;
		}
	
	@Override
	public String toString() 
		{
			return "SensorData "
					+ "[headsetID=" + headsetID
					+ ", attention=" + attention 
					+ ", mediation=" + mediation 
					+ ", blinkStrength=" + blinkStrength
					+ ", sensorValue=" + sensorValue
					+ ", sensorDate=" + sensorDate +"]";
		}
}



