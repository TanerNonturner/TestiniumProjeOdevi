package practiceDB;

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

import org.junit.Test;

import utils.ConfigsReader;
import utils.Constants;

public class StoringData {
	
	//@Test
	public void getAndStoreData() throws SQLException {
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
				
		Connection conn = DriverManager.getConnection(ConfigsReader.getProperty("dbUrl"), ConfigsReader.getProperty("dbUsername"),ConfigsReader.getProperty("dbPassword"));
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT  employeeNumber, lastName, firstName, email FROM employees LIMIT 5;");
		rs.next();
		
		List<Map<String,String>> listOfData = new ArrayList<>();
		
		
		
		Map<String,String> mapData;
		
		while(rs.next()) {
			
			 mapData=	new LinkedHashMap<>();// we want  to get a new map every time when changes to new row;
			 mapData.put("empolye number", rs.getString("employeeNumber"));
			 mapData.put("last name", rs.getString("lastName"));
			 mapData.put("first name", rs.getString("firstName"));
			 mapData.put("email", rs.getString("email"));
			 
			 listOfData.add(mapData);
			 
					
		}
		
		System.out.println(listOfData);
		
		
		conn.close();
		rs.close();
		st.close();
		
		
		
	}
	
	
	@Test
	public void retrieveAndStoreEnhanced() throws SQLException {
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		
		Connection conn = DriverManager.getConnection(ConfigsReader.getProperty("dbUrl"), 
						  ConfigsReader.getProperty("dbUsername"),ConfigsReader.getProperty("dbPassword"));
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM signalt_classicmodels.customers WHERE customerNumber<131;");
		//we don't know any information about the data how many cols etc..
		ResultSetMetaData rsMD = rs.getMetaData();
		int colCount = rsMD.getColumnCount();
		List<Map<String,String>> listOfData = new ArrayList<>();
		Map<String,String>  mapData ;
		while(rs.next()) {
			mapData = new LinkedHashMap();
			
			for(int i= 1; i<= colCount;i++) {
				
				mapData.put(rsMD.getColumnName(i),rs.getString(i));
				
			}
			
			listOfData.add(mapData);
		}
		
		System.out.println(listOfData);
		conn.close();
		rs.close();
		st.close();
	}
	
	
	

}
