package org.example.ultils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCconnection {
    private String driver;
    private String host;
    private String port;
    private String db;
    private String user;
    private String pass;

    private Connection conn;

    public DBCconnection() {
        super();
        this.driver = "mysql";
        this.host = "localhost";
        this.port = "8080";
        this.db = "Employee";
        this.user = "root";
        this.pass = "123";
        this.conn = null;

    }

    public void connectDB() {
        try {
            this.conn = DriverManager.getConnection("jdbc:" + this.driver + "://" + this.host + ":" + this.port + "/" + this.db, this.user, this.pass);
        } catch (SQLException e) {
            System.out.println("ket noi that bai");
            throw new RuntimeException(e);
        }
    }

    public void disConnectDb() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

}
