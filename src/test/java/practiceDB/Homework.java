package practiceDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utils.ConfigsReader;
import utils.Constants;

public class Homework {
	String dbUserName ="signalt_user1";
	String password ="trpass@2020";
	String dbUrl ="jdbc:mysql://66.113.163.71:3306/signalt_classicmodels?serverTimezone=UTC";
	
	@Test
	public void getConnected() throws SQLException {
		
		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, password);
		
		// write an sql statement
		
		Statement st = conn.createStatement();
		
		// execute a query
		
		ResultSet rs = st.executeQuery("SELECT * FROM customers WHERE customerNumber =124;");
		
		// get the ResultSet structure
		
		ResultSetMetaData rsMD = rs.getMetaData();
		
		//number of fields
		int colCount = rsMD.getColumnCount();
		// print metadata cols
		// get particular column name
		//rsMD.getColumnName(1);
		
		List<String> al = new ArrayList<>();
		
		for(int i=1;i<=colCount;i++) {
			
			String columnName = rsMD.getColumnName(i);
			al.add(columnName);
			
			System.out.println(rsMD.getColumnName(i));
		}
		
		System.out.println("----------------");
		System.out.println(al);
		
		
		// Get the data from Result Set
		String customerNumber;
		String customerName;
		
		// Get one data there is two way
		// rs.getString("columnName"); or rs.getInt("columnName"); or index we can use
		// rs.getObject("columnName").toString;
		System.out.println("-------------------looping---------");
		//looping
		while(rs.next()) {
			String customernumber = rs.getString("customerNumber");
			String customername = rs.getString("customerName");
			System.out.println(customernumber+" "+customername);
			
		}
		
		
		rs.close();
		st.close();
		conn.close();
		
		
		
		
		
		
	}
	
}
