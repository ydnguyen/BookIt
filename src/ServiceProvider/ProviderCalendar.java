package ServiceProvider;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import DataManagement.AppointmentDao;
import DataManagement.DataStore;

public class ProviderCalendar {

	public static void main(String args[]) {
		
		//getConsumerCalendar();
	}
	
	/*
	 * Takes a date array as argument. Returns true if no bookings are present at the same time slot.
	 */
	
	public boolean isValid(Appointment app)
	{
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sTime = sdf.format(date[0]);
		String eTime = sdf.format(date[1]);
		String checkDay = sTime.split(" ")[0];
		String checkStartTime = sTime.split(" ")[1];
		String checkEndTime = eTime.split(" ")[1];*/
		
		String checkDay = app.getDay();
		String sTime = app.getStartTime();
		String eTime = app.getEndTime();
		
		AppointmentDao ad = new AppointmentDao();
		
		ArrayList<String> al = ad.BookingTimes();
		
		Iterator<String> itr = al.iterator();
		
		while(itr.hasNext()) {
			String s = (String) itr.next();
	
			String[] str = s.split(" ");
			
			if(checkDay.equals(str[0])) {
				int startTimeDB = toMins(str[1]);
				int endTimeDB = toMins(str[2]);
				int start = toMins(sTime);
				int end = toMins(eTime);
				
				if((start > startTimeDB && start < endTimeDB) || (end > startTimeDB && end < endTimeDB)) {
					System.out.println("if(" +  startTimeDB + "<" +  start + " || " +  endTimeDB +  " > " +  end + ")");
					return false;
				}
			}	
		}
		
		return true;
	}

	/*
	 * Changes HH:MM to mins
	 */
	
	private static int toMins(String s) {
	    String[] hourMin = s.split(":");
	    int hour = Integer.parseInt(hourMin[0]);
	    int mins = Integer.parseInt(hourMin[1]);
	    int hoursInMins = hour * 60;
	    return hoursInMins + mins;
	}
	
	public void updateProvider()
	{

	}
	
	/*
	 * Returns a hashset of strings for a specific period of time.
	 */
	
	public static HashSet<String> getSPCalendar(String provider_id) {
		AppointmentDao ad = new AppointmentDao();
		
		ArrayList<String> al = AppointmentDao.recordsBetweenSP(provider_id);
		
		//System.out.println("consumer_id: " + consumer_id);
		
		System.out.println(al);
		
		HashSet<String> hs = new HashSet<>(al);
		
		System.out.println("HashSet: " + hs);
		
		return hs;
	}
}
