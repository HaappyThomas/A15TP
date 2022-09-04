package ca.qc.bdeb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * C'est une classe singleton pour la connection au MySQL sur AlwaysData
 * @author Thomas Wang
 *
 */
public class ConnectionAlwaysData {
	private String url = "jdbc:mysql://mysql-thomaswang.alwaysdata.net:3306/thomaswang_a15_tp?useSSL=false";
	private String user = "278692_a15_tp";
	private String pwd = "xyz098!!";
	
	private static Connection connect;

	private ConnectionAlwaysData() {
		try {
			connect = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getInstance() {
		if(null == connect) {
			new ConnectionAlwaysData();
		}
		return connect;
	}
	
	
	
}
