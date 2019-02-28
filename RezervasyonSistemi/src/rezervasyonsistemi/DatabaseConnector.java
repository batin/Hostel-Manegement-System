/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezervasyonsistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	
	public Connection connection = null;

	
	public DatabaseConnector() {
		String url = "jdbc:mysql://" + DatabaseInfo.getHost() + ":" + DatabaseInfo.getPort() + "/" + DatabaseInfo.getName() + "?useUnicode=true&characterEncoding=utf8&verifyServerCertificate=false&useSSL=true";
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("Driver is loaded.");
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver is not found.");
			System.exit(0);
		}
		
		try {
			connection = DriverManager.getConnection(url, DatabaseInfo.getUsername(), DatabaseInfo.getPassword());
			System.out.println("Connection is successful.");
		} catch (SQLException ex) {
			System.out.println("Connection is failed.");
			System.exit(0);
		}
	}
	public Connection getConnection() {
		return this.connection;
	}
        
        
}