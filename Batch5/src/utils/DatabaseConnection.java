package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;
public class DatabaseConnection {
private static Connection conn=null;
public static Connection getConnection() {
	
	try
	{
		
	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String username="system";
	String password="Kk9951340#";
	DriverManager.registerDriver(new OracleDriver());
	conn=DriverManager.getConnection(url, username, password);

}
catch(SQLException e) {
	e.printStackTrace();
}
return conn;
}
public static void closeConnection() {
	try {
		conn.close();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
}
}
