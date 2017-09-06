package ServiceProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {

	private String provider;
	private String consumer;

	private String sTime;

	private String eTime;

	private String day;
	
	
	public Appointment(String str)
	{
		String[] s = str.split(" ");
		this.provider = s[0];
		this.consumer = s[1];
		this.day = s[2];
		this.sTime = s[3];
		this.eTime = s[4];
	}
	
	public String getProvider() {
		return provider;
	}
	
	public String getConsumer() {
		return consumer;
	}
	
	public String getDay() {
		return day;
	}
	
	public String getStartTime() {
		return sTime;
	}
	
	public String getEndTime() {
		return eTime;
	}
}
 
