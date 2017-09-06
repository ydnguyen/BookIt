package DataManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;

public class ServiceProviderDao {
	
	public static int provider_id;
	
	public static void main(String args[]) {
		
		String[] str = new String[2];
		
		str[0] = "testUser";
		str[1] = "test123";
		
		
		verifyProvider(str);
		
	}
	
	
	public static String getConsumerID(String consumer) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String c_id = "";
		
		conn = DataStore.getConnection();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("Select * from CONSUMER where username='" + consumer +"'");
			if(rs.next()) {
				c_id = rs.getString("consumer_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c_id;
		
	}
	
	
	
	public static String getProviderName(String provider_id) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String bName = "";
		
		conn = DataStore.getConnection();
		
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("Select * from SERVICE_PROVIDER where provider_ID='" + provider_id +"'");
			if(rs.next()) {
				bName = rs.getString("business_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bName;
		
	}
	
	
	public static HashSet<Integer> getSPList() {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		HashSet<Integer> hs = new HashSet<>();
		
		String sqlQuery = "SELECT * FROM SERVICE_PROVIDER";
		conn = DataStore.getConnection();
	
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sqlQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	
		try {
			while (rs.next()) {
				hs.add(Integer.parseInt(rs.getString("provider_ID"))); 
			}
		   } catch (SQLException e) {
				e.printStackTrace();
		}
	
		System.out.println(hs);
	
		return hs;
}


	public static int randomProviderIDGenerator() {
	
		Random rand = new Random();
		int max = 9999;
		int min = 1000;
		int providerID;
		HashSet<Integer> hs = getSPList();
	
		while(true) {
			int rn = rand.nextInt((max - min) + 1) + min;
		
			if(!hs.contains(rn)) {
				providerID = rn;
				break;
			}
		}
	
		return providerID;
	}
	
	
	
	public  void addProvider(String[] provider) {
		
		Connection conn = null;
		Statement st = null;
		provider_id = randomProviderIDGenerator();
		
		System.out.println("provider_id: " + provider_id);
		
		String sqlQuery = "INSERT INTO SERVICE_PROVIDER (provider_ID, username, "
				+ "password, address, phone, email,service_type,business_name)"
				+ " VALUES (" 
				+ provider_id + "," 
				+ "'" + provider[0] + "'," 
				+ "'" + provider[1] + "'," 
				+ "'" + provider[2] + "',"
				+ "'" + provider[3] + "',"
				+ "'" + provider[4] + "',"
				+ "'" + provider[5] + "',"		
				+ "'" + provider[6] + "')";
		
		System.out.println("Execute: " + sqlQuery);
	
		conn = DataStore.getConnection();
				
		try {
			st = conn.prepareStatement(sqlQuery);
			st.executeUpdate(sqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String verifyProvider(String[] str) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String passwd = "";
		conn = DataStore.getConnection();
		
		String id = "";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("Select * from SERVICE_PROVIDER where username='" + str[0] +"'");
			if(rs.next()) {
				passwd = rs.getString("password");
				id = rs.getString("provider_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("password for sayantan31:" + passwd);
		
		if(passwd.equals(str[1])) {
			System.out.println("You're logged in");
			return id;
		}
		else {
			System.out.println("Wrong username/password!");
			return "";
		}
	}
	
}
