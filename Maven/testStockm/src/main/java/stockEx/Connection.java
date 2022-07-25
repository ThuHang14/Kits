package stockEx;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    String localHost = "locahost:3306";
    String data = "STOCK_db";
    String name = "root";
    String pass = "123";

    String url = "jdbc:mysql://"+localHost+"/"+data;

    public Connection connect(){
        Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection(url,name,pass);
            System.out.println("success");
        } catch (SQLException e) {
            System.out.println("fail connect");
        }
        return connection;
    }

}
