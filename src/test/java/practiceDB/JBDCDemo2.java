package practiceDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JBDCDemo2 {
	// Retrieve all the book category names and store them in ArrayList
	// Print the ArrayList in console
	static String dbUserName = "signalt_user1";
	static String dbPassword = "trpass@2020";

	// jdbc:mysql://ipaddress:port//db name
	static String dbUrl = "jdbc:mysql://66.113.163.71:3306/signalt_LibraryMgmt?serverTimezone=UTC";

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM bookcategory;");

		List<String> categoryNames = new ArrayList<>();
		while (rs.next()) {
			categoryNames.add(rs.getObject("BookCategoryName").toString());
		}
		System.out.println(categoryNames);
		System.out.println("--- all printed one by one------");

		for (String str : categoryNames) {
			System.out.println(str);
		}

		// closing connection and other objects . if you leave open you will encounter
		// memory problem
		st.close();
		rs.close();
		conn.close();

	}

}
