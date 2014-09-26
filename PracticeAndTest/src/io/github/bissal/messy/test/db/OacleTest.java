package io.github.bissal.messy.test.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OacleTest {
	private String url;
	private String username;
	private String password;
	
	private String sql;
	
	private Connection	con;
	private Statement	stmt;
	private ResultSet	rs;
	
	
	public void connect() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		url = "jdbc:oracle:thin:@172.10.13.20:1521:mashuptest";
		username = "mimashup";
		password = "mimashup";
		
		sql = "CREATE TABLE books (id NUMBER(11), title VARCHAR2(64))";
		
		con = DriverManager.getConnection(url, username, password);
		stmt = con.createStatement();
//		stmt.execute(sql);
		
		rs = stmt.executeQuery("select object_name from user_objects where object_type = 'TABLE'");
				
		while (rs.next())
		{
			String tableName = rs.getString(1);
			System.out.println("tableName=" + tableName);
	    }		
	}
	
	public void close() throws SQLException
	{
		con.close();
		stmt.close();
		rs.close();
	}
}
