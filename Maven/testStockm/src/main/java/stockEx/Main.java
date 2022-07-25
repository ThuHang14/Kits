
package stockEx;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    //    link demo quá trình thêm dữ liệu vào database
//     https://github.com/ThuHang14/Blogs/blob/main/stock.md
    public static Connection connect() {
        String localHost = "localHost:3306";
        String data = "STOCK_db";
        String name = "root";
        String pass = "123";

        String url = "jdbc:mysql://" + localHost + "/" + data;

        Connection conn = null;
        try {
            conn = (Connection) DriverManager.getConnection(url, name, pass);
            System.out.println("success");
        } catch (SQLException e) {
            System.out.println("fail connect");
        }
        return conn;
    }


    public static void main(String[] args) {
//        kết nối với mySql
//        connect();

        //        Thêm dữ liệu vào từng bảng
        // initDataStock();
        //initDataTrader();
        //initDataOrder();
        //initDataTransactions();


//        Tính tổng số tiền giao dịch
        sumPriceTransaction();

//        Lấy danh sách cổ phiếu có số tiền giao dịch lớn nhất
        top3Stock();

//         Lấy ra danh sách cổ phiếu với tổng số tiền giao dịch tương ứng;
        stockPrice();
//            Lấy ra danh sách những người mua nhiều cố phiếu nhất
        top3Trader();


    }

    public static void top3Stock() {
        String query = "SELECT s.name,SUM(o.price) as sums \n" +
                "FROM `Orders` o\n" +
                "INNER JOIN Stock s ON s.id = o.id_Stock\n" +
                "GROUP BY s.name\n" +
                "ORDER BY sums DESC\n" +
                "LIMIT 3";

        try {
            Statement stm = connect().createStatement();
            ResultSet result = stm.executeQuery(query);
            System.out.println(" 3 cổ phiếu có số tiền giao dịch lớn nhất : ");
            while (result.next()) {
                String ds = "name :  " + result.getString("name") + " price :  " +
                        result.getString("sums");
                System.out.println(ds);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void top3Trader() {
        String query = "SELECT td.name, o.id_Trader, COUNT(t.amount) as counts\n" +
                "FROM `Transactions` t\n" +
                "INNER JOIN Orders o ON o.id = t.id_Order\n" +
                "INNER JOIN Trader td ON o.id_Trader = td.id\n" +
                "GROUP BY td.name ,o.id_Trader\n" +
                "ORDER bY counts DESC\n" +
                "LIMIT 3";

        try {
            Statement stm = connect().createStatement();
            ResultSet result = stm.executeQuery(query);
            System.out.println("3 người mua nhiều cố phiếu nhất : ");
            while (result.next()) {
                String ds = "name :  " + result.getString("name") + " id :  " +
                        result.getString("id_Trader") + " luot mua :  " +
                        result.getString("counts");
                System.out.println(ds);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void stockPrice() {
        String query = "SELECT  s.name , SUM(o.price) AS sumPrice\n" +
                "FROM `Orders` o \n" +
                "INNER JOIN Stock s ON o.id_Stock = s.id\n" +
                "WHERE o.types = 1 \n" +
                "GROUP BY  s.name ";

        try {
            Statement stm = connect().createStatement();
            ResultSet result = stm.executeQuery(query);
            System.out.println(" danh sách cổ phiếu với tổng số tiền giao dịch tương ứng : ");
            while (result.next()) {
                String ds = result.getString("name") + " " +
                        result.getString("sumPrice");
                System.out.println(ds);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void sumPriceTransaction() {
        String query = "SELECT sum(t.price) as sumTrans FROM `Transactions` t ";
        try {
            Statement stm = connect().createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                System.out.println("tổng số tiền giao dịch : " + result.getInt("sumTrans"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void sql(String query) {
        try {
            Statement stm = connect().createStatement();
            stm.executeUpdate(query);
            System.out.println("them thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initDataStock() {

        List<String> list = new ArrayList<>();
        list.add("INSERT INTO `Stock` (`id`, `name`) VALUES (NULL, 'FPT');");
        list.add("INSERT INTO `Stock` (`id`, `name`) VALUES (NULL, 'ETH');");
        list.add("INSERT INTO `Stock` (`id`, `name`) VALUES (NULL, 'UTC');");
        list.add("INSERT INTO `Stock` (`id`, `name`) VALUES (NULL, 'VNM');");

        for (String s : list
        ) {
            sql(s);
        }

    }

    public static void initDataTrader() {

        List<String> list = new ArrayList<>();
        list.add("INSERT INTO `Trader` (`id`, `name`) VALUES (NULL, 'TraderA');");
        list.add("INSERT INTO `Trader` (`id`, `name`) VALUES (NULL, 'TraderB');");
        list.add("INSERT INTO `Trader` (`id`, `name`) VALUES (NULL, 'TraderC');");

        for (String s : list
        ) {
            sql(s);
        }

    }

    public static void initDataOrder() {
        List<String> list = new ArrayList<>();
        list.add("insert into Orders (dates, amount, price, types, id_Trader, id_Stock) values ('2021-11-02', 5, 841, '1', 2, 2);");

        list.add("insert into Orders (dates, amount, price, types, id_Trader, id_Stock) values ('2021-11-15', 6, 189, '2', 3, 1);");
        list.add("insert into Orders (dates, amount, price, types, id_Trader, id_Stock) values ('2022-03-21', 7, 857, '1', 1, 3);");
        list.add("insert into Orders (dates, amount, price, types, id_Trader, id_Stock) values ('2021-09-21', 8, 877, '2', 2, 3);");
        list.add("insert into Orders (dates, amount, price, types, id_Trader, id_Stock) values ('2021-08-24', 9, 534, '2', 2, 1);");
        list.add("insert into Orders (dates, amount, price, types, id_Trader, id_Stock) values ('2022-02-08', 10, 600, '2', 3, 3);");
        list.add("insert into Orders (dates, amount, price, types, id_Trader, id_Stock) values ('2021-09-20', 11, 241, '2', 2, 3);");
        list.add("insert into Orders (dates, amount, price, types, id_Trader, id_Stock) values ('2022-01-02', 12, 749, '1', 2, 1);");
        list.add("insert into Orders (dates, amount, price, types, id_Trader, id_Stock) values ('2022-03-30', 13, 716, '1', 2, 2);");
        list.add("insert into Orders (dates, amount, price, types, id_Trader, id_Stock) values ('2022-01-10', 14, 886, '1', 1, 3);");
        list.add("insert into Orders (dates, amount, price, types, id_Trader, id_Stock) values ('2021-12-09', 15, 694, '2', 2, 2);");

        for (String s : list
        ) {
            sql(s);
        }

    }

    public static void initDataTransactions() {
        List<String> list = new ArrayList<>();
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2021-08-02', 1, 147, 10);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2022-02-16', 2, 318, 4);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2022-03-13', 3, 505, 10);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2021-10-24', 4, 556, 6);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2021-10-17', 5, 210, 9);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2022-01-19', 6, 315, 12);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2021-08-27', 7, 898, 12);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2021-09-01', 8, 601, 5);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2021-10-17', 9, 315, 12);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2022-02-18', 10, 479, 1);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2022-03-25', 11, 481, 10);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2022-02-08', 12, 303, 10);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2022-02-07', 13, 789, 12);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2022-06-03', 14, 145, 13);");
        list.add("insert into Transactions (dates, amount, price, id_Order) values ('2021-10-06', 15, 469, 5);");
        for (String s : list
        ) {
            sql(s);
        }

    }

}
