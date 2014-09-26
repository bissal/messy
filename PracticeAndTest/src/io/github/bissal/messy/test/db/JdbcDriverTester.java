package io.github.bissal.messy.test.db;

public class JdbcDriverTester {
	
	public void execute()
	{		
		try
		{
			String className = "oracle.jdbc.driver.OracleDriver";
			Class driverObject = Class.forName(className);
			System.out.println("driverObject=" + driverObject);
			System.out.println("your installation of JDBC Driver OK.");
			
		} catch (Exception e) {
			// your installation of JDBC Driver Failed
			System.out.println("Failed: JDBC Driver Error: " + e.getMessage());
		}
	}
}
