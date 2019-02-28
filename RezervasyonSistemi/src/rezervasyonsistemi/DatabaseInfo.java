/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezervasyonsistemi;
public class DatabaseInfo {

	private static final String username = "root";
	private static final String password = "root";
	private static final String name = "OTEL";
	private static final String host = "localhost";
	private static final int port = 8889;

	/* getters */
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	public static String getName() {
		return name;
	}
	public static String getHost() {
		return host;
	}
	public static int getPort() {
		return port;
	}	
}