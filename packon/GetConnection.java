package packon;

import java.sql.*;
public class GetConnection {
	static Connection cn=null;
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/deynamicwebproject";
	static String user="root";
	static String pass="Bindumadhavi@99";
	public static Connection getCn() throws Exception{
		Class.forName(driver);
		cn=DriverManager.getConnection(url, user, pass);
		return cn;
	}
}
