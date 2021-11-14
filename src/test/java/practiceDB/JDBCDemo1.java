package practiceDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {

	static String dbUserName = "signalt_user1";
	static String dbPassword = "trpass@2020";

	// jdbc:mysql://ipaddress:port//db name
	static String dbUrl = "jdbc:mysql://66.113.163.71:3306/signalt_LibraryMgmt?serverTimezone=UTC";

	public static void main(String[] args) throws SQLException {
		// creating a connection to the database
		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		System.out.println("DB connection is successful");

		// creating a statement import java.sql.Statement
		Statement st = conn.createStatement();
		// executing a query
		ResultSet rs = st.executeQuery("SELECT * FROM book");
		// getting values from ResultSet
		rs.next(); // first row is shown. pointer is here now
		System.out.println("-------");
		// first way to get result
		String bookName1 = rs.getString("BookName");// giving coloumn name
		System.out.println("1 row book name is " + bookName1);
		// second way to get result
		rs.next(); // now we are at 2nd row
		String bookName2 = rs.getString(2);
		System.out.println("2 row book name is " + bookName2);
		rs.next();
		String bookName3 = rs.getString("BookName");
		System.out.println("3 row book name is " + bookName3);
		// third way to get result, three way is true !!!
		rs.next();// now we are at 4d row
		String bookName4 = rs.getObject("BookName").toString();
		System.out.println("4 row book name is " + bookName4);
		System.out.println("------getting values with while loop--------");
		while (rs.next())// Note: now we are at 5. row it will start from Java bookName
		{
			String bookName = rs.getObject("BookName").toString();
			System.out.println(bookName);
		}

		// closing connection and other objects . if you leave open you will encounter
		// memory problem
		st.close();
		rs.close();
		conn.close();

	}
}
