package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
	
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
	private static List<Map<String,String>> listData;
	// we want to use this just saying getConnection because of this. it is static!!!
	public static void getConnection()  {
		//get the info from .properties file
		// get connection with it
		
		
		try {
			ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
			conn = DriverManager.getConnection(ConfigsReader.getProperty("dbUrl"), ConfigsReader.getProperty("dbUsername"), ConfigsReader.getProperty("dbPassword"));
		} catch (SQLException e) {
			System.out.println("Couldn't connect to the database");
			e.printStackTrace();
		}
		
	}
	
	public static List<Map<String,String>> storeDataFromDB(String sqlQuery) {
		
		try {
			//getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sqlQuery);
			ResultSetMetaData rsMD = rs.getMetaData();
			listData = new ArrayList<>();
			
			while(rs.next()) {
				Map<String,String> mapData= new LinkedHashMap<>();
				
				for(int i=1; i<=rsMD.getColumnCount();i++) {
					mapData.put(rsMD.getColumnName(i), rs.getString(i));
				}
				
				listData.add(mapData); 
			
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return listData;
	}
	
	
	
	
	
	
	public static void closeConnection() {
	try {
		
	
		if(rs!=null) {
			rs.close();
		}
		if(st!=null) {
			st.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	

	}
	
	
	
	
	
	
	
	

}
