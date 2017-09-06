package ServiceProvider;

import java.util.Date;

import DataManagement.AppointmentDao;
import DataManagement.ServiceProviderDao;

public class ServiceProvider {

	String first_name;
	String last_name;
	String myUsername;
	String myPassword;
	String myAddress;
	String myPhone;
	String myEmail;
	String business;
	//ProviderCalendar myCalendar;
	int consumer_id;
	String[] parts;
	
	
	public static void main(String args[]) {
		
	}
	
	public ServiceProvider() {
		parts = new String[8];
	}
	
	public int addSignupDetails(String str) {
		
		parts = str.split(" ");
		
		ServiceProviderDao provider = new ServiceProviderDao();
		
		provider.addProvider(parts);
		
		return ServiceProviderDao.provider_id;
	}
	
	
	public int book(String s) {
		
		AppointmentDao ad = new AppointmentDao();
		
		Appointment app = new Appointment(s);
		
		String consumer_id = ServiceProviderDao.getConsumerID(app.getConsumer());
		
		String[] str = {app.getProvider(), consumer_id, app.getDay(), app.getStartTime(), app.getEndTime()};
		
		return  ad.addAppointment(str);
	}
	
	public boolean cancel(String appointment_id) {
		
		AppointmentDao ad = new AppointmentDao();
		
		return ad.removeAppointment(appointment_id);
		
	}
}
