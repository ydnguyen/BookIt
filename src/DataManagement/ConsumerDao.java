package DataManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;

public class ConsumerDao {

	public static int consumer_id;
	
	public static void main(String args[]) {
		
		System.out.println(randomConsumerIDGenerator());
	}
	
	
	public static HashSet<Integer> getConsumerList() {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		HashSet<Integer> hs = new HashSet<>();
		
		String sqlQuery = "SELECT * FROM CONSUMER";
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
				hs.add(Integer.parseInt(rs.getString("consumer_ID"))); 
			}
		   } catch (SQLException e) {
				e.printStackTrace();
		}
	
		System.out.println(hs);
	
		return hs;
}


	public static int randomConsumerIDGenerator() {
	
		Random rand = new Random();
		int max = 9999;
		int min = 1000;
		int consumerID;
		HashSet<Integer> hs = getConsumerList();
	
		while(true) {
			int rn = rand.nextInt((max - min) + 1) + min;
		
			if(!hs.contains(rn)) {
				consumerID = rn;
				break;
			}
		}
	
		return consumerID;
	}
	
	
	public static String getProviderID(String business) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String p_id = "";
		
		conn = DataStore.getConnection();
		
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("Select * from SERVICE_PROVIDER where business_name='" + business +"'");
			if(rs.next()) {
				p_id = rs.getString("provider_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p_id;
		
	}
	
	public static String getConsumerName(String consumer_id) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String fName = "";
		String lName = "";
		String Name = "";
		
		conn = DataStore.getConnection();
		
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("Select * from CONSUMER where consumer_ID='" + consumer_id +"'");
			if(rs.next()) {
				fName = rs.getString("first_name");
				lName = rs.getString("last_name");
				Name = fName + "_" + lName;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Name;
		
	}


	
	public void addConsumer(String[] consumer) {
		
		Connection conn = null;
		Statement st = null;
		consumer_id = randomConsumerIDGenerator(); 
		
		
		String sqlQuery = "INSERT INTO CONSUMER (consumer_ID, first_name, last_name, username, "
				+ "password, address, phone, email)"
				+ " VALUES (" 
				+ consumer_id + "," 
				+ "'" + consumer[0] + "'," 
				+ "'" + consumer[1] + "'," 
				+ "'" + consumer[2] + "',"
				+ "'" + consumer[3] + "'," 
				+ "'" + consumer[4] + "'," 
				+ "'" + consumer[5] + "'," 
				+ "'" + consumer[6] + "')";
		
		System.out.println(sqlQuery);
	
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
	
	
	public static String verifyConsumer(String[] str) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String passwd = "";
		conn = DataStore.getConnection();
		String id = "";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("Select * from CONSUMER where username='" + str[0] +"'");
			if(rs.next()) {
				passwd = rs.getString("password");
				id = rs.getString("consumer_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(passwd.equals(str[1])) {
			return id;
		}
		else {
			return "";
		}
	}
}

