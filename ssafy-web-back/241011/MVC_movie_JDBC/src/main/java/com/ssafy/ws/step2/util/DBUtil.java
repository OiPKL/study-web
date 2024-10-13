package com.ssafy.ws.step2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	// 1. db 변경
	private final String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";
	// 2. username 변경
	private final String username = "root";
	private final String password = "ssafy";
	private final String driverName = "com.mysql.cj.jdbc.Driver";

	// 3. 싱글턴
    private static DBUtil instance = new DBUtil();
    
    public static DBUtil getInstance() {
    	return instance;
    }
    // -----

    private DBUtil() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
    	return DriverManager.getConnection(url, username, password);
    }

    public void close(AutoCloseable... closeables) {
        for (AutoCloseable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}