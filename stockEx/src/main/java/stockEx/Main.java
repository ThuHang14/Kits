/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stockEx; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
class PriceDesc implements Comparator<Order> { 
    @Override
    public int compare(Order o1, Order o2) {
        return o2.getPrice().compareTo(o1.getPrice());
    } 
}

public class Main {
     static String connectionUrl = "jdbc:sqlserver://Localhost:1433;"
                + "databaseName=sampleDB;user=sa;password=sa";
        // Declare the JDBC objects.     
     static   Connection conn = null;
     static { 
        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// buoc 1
            conn = DriverManager.getConnection(connectionUrl); // buoc 2  
        }
        catch(Exception e) {
            System.out.println(e.getMessage()); 
            System.exit(0);
        }
    }
    public static void main(String[] args) { 
        String[] lstStock = {"VIN","SSB", "SHB", "EIB", "MSB", "OCB", "FPT"};//
        String[] lstTrader = {"Trader_1","Trader_2", "Trader_SHB", "Trader_EIB", "Trader_MSB", "Trader_OCB", "Trader_FPT"};//
        Map<String, Stock> hm = new HashMap<>();
        for (String sId : lstStock) {
            Stock st = new Stock(sId);
            hm.put(sId, st);
        }

        Map<String, PriorityQueue<Order>> hm_st_Sellq = new HashMap<>();
        Map<String, PriorityQueue<Order>> hm_st_Buyq = new HashMap<>();

        for (String sIdStock : hm.keySet()) {
            hm_st_Sellq.put(sIdStock, new PriorityQueue<>());
            hm_st_Buyq.put(sIdStock, new PriorityQueue<>(new PriceDesc()));
        }
        ProcessOrder pOrd = new ProcessOrder();
  
        while (true) {
            // Lệnh mua, bán ngẫu nhiên
            int iIDStock = (int) Math.round(Math.random() * (lstStock.length - 1));
            int iIDTrader = (int) Math.round(Math.random() * (lstTrader.length - 1));
            double x = Math.random();
              int iAmount = (int) Math.round(Math.random() * 100);
            Float price = (float) Math.random() * 1000;
            Order ord;
            if (x < 0.5) {
                 ord= new Order(1, lstStock[iIDStock],lstTrader[iIDTrader], iAmount,price);
                PriorityQueue<Order> bQ = hm_st_Buyq.get(lstStock[iIDStock]);
                bQ.add(ord);
            } else {
                  ord = new Order(2, lstStock[iIDStock], lstTrader[iIDTrader], iAmount, price);
                PriorityQueue<Order> sellQ = hm_st_Sellq.get(lstStock[iIDStock]);
                sellQ.add(ord);
            }
          //
            pOrd.insert(conn, ord);
            
            // Khớp lệnh 
            Queue<Order> sQ = hm_st_Sellq.get(lstStock[iIDStock]);
            Queue<Order> bQ = hm_st_Buyq.get(lstStock[iIDStock]);
           
           //Tạo list chứa tất cả các transantion.
        List<Transaction> transantionList = new ArrayList<>();
        while(!bQ.isEmpty() && !sQ.isEmpty()) { 
            Order buyOrder = bQ.peek();
            Order sellOrder = sQ.peek();
            if(buyOrder.getPrice() >= sellOrder.getPrice()) {
                Transaction transantion = new Transaction();
                transantion.idStock = buyOrder.getsIDStock();
                transantion.idBuyer = buyOrder.getsIDTrader();
                transantion.idSeller = sellOrder.getsIDTrader();
                transantion.price = sellOrder.getPrice();
                if(buyOrder.getAmount() < sellOrder.getAmount()){
                    transantion.amount = buyOrder.getAmount();
                    //cập nhật lại số lượng của chứng khoán của queue
                    sellOrder.setAmount(sellOrder.getAmount() - buyOrder.getAmount());
                    bQ.poll();
                } else if (buyOrder.getAmount() > sellOrder.getAmount()){
                    transantion.amount = sellOrder.getAmount();
                    //cập nhật lại số lượng của chứng khoán của queue
                    buyOrder.setAmount(buyOrder.getAmount() - sellOrder.getAmount());
                    sQ.poll();
                } else {
                    transantion.amount = sellOrder.getAmount();
                    bQ.poll();
                    sQ.poll();
                }
                //
                
                //
                transantionList.add(transantion);
                System.out.println(transantion);
            } else {
                break;
            }

        }
          
        }
    }

}
