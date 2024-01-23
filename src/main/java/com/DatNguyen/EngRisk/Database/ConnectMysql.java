package com.DatNguyen.EngRisk.Database;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectMysql {
    private static String url = "jdbc:mysql://localhost:3306/ENGRISK";
    private static String username = "root";
    private static String password = "28102004";
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}


