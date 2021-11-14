package practiceDB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetadataDemo {
	// variables don't need to be static!!
	String dbUserName = "signalt_user1";
	String dbPassword = "trpass@2020";

	// jdbc:mysql://ipaddress:port//db name
	String dbUrl = "jdbc:mysql://66.113.163.71:3306/signalt_classicmodels?serverTimezone=UTC";

	//@Test
	public void dbMetaData() throws SQLException {
		// creating a connection to the database
		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		DatabaseMetaData dbMetaData =conn.getMetaData();
		//in metadata has more information we can get ex.
		String driverName = dbMetaData.getDriverName();
		// Since we use mysql driver name must be mysql
		System.out.println("Driver name is "+driverName);
		String dbVersion = dbMetaData.getDatabaseProductVersion();
		System.out.println("DB Product Version is "+dbVersion);
		System.out.println("Product Name is "+ dbMetaData.getDatabaseProductName());
		System.out.println("User Name is "+dbMetaData.getUserName());
	}
	
	// I want to display all the information about the employee whose employeeNumber = 1056
	@Test
	public void rsMetaData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM employees WHERE employeeNumber = 1056;");
		
		// get information about ResultSet table
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int columnCount = rsMetaData.getColumnCount();
		System.out.println(columnCount);
		
		// get the name of first column
		String columnName1= rsMetaData.getColumnName(1);
		System.out.println("1. Column name is "+columnName1);
		
		System.out.println("-----Print all column names using for loop-----");
		
		for(int i= 1; i<=columnCount;i++) {
			
			System.out.println(rsMetaData.getColumnName(i));
		}
		
		
		//closing connection and other objects . if you leave open you will encounter memory problem
		st.close();
		rs.close();
		conn.close();
		
		
		
		
		
	}
	
	
	
	
	
	
}
