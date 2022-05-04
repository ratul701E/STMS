package database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBMan {
	public static Statement stmt;
	static {
		initial_db();
	}
	
	private static void initial_db() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/STMS", "root", "adminratulratul88@");
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt = statement;
		} catch (Exception e) {
			System.out.println("Failed to connect with database. Please contact with admin.\nErros:\n");
			System.out.println(e);
		}
	}
}