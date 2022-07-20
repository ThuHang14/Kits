package exercise5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();

        OrderC order = new OrderC(1, date, "Cus01");
        OrderC order2 = new OrderC(2, date, "Cus01");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(new OrderDetail(order.getIdOrder(), 1, 1, 10, 100));
        orderDetailList.add(new OrderDetail(order2.getIdOrder(), 1, 2, 30, 10));

        Purchase purchase = new Purchase(1, date, "9DK78");


        Supplier supplier = new Supplier("9DK78", "sup1", "Hai Duong", "0123456789");

        PurchaseDetail purchaseDetail = new PurchaseDetail(purchase.getIdPurchase(), orderDetailList.get(1).getItemID(), 1, 20, 95000);


        Customer customers = (new Customer("Cus01", "cus1", "Ha Noi", "0987654302"));

        Customer customers2 = (new Customer("Cus02", "cus2", "Ha Noi", "0987654302"));

        Map<String, ArrayList<OrderC>> mapOder = new HashMap<>();

        ArrayList<OrderC> customerArr = new ArrayList<>();
        customerArr.add(order2);
        customerArr.add(order);

        ArrayList<OrderC> customerArr2 = new ArrayList<>();
        customerArr.add(order2);
        customerArr.add(order);

        mapOder.put(customers.getIdSup(), customerArr);
        mapOder.put(customers2.getIdSup(), customerArr);


//        System.out.println(mapOder);

//        test
        System.out.println("tìm kiếm chi tiết hoá đơn theo mã hoá đơn : " + findOrderDetail(1, orderDetailList));
        findOrderMaxAmount(orderDetailList);
        findOrderMaxPrice(orderDetailList);
    }

    public static void findOrderMaxAmount(List<OrderDetail> orderDetailList){
        int id = orderDetailList.get(0).getIdOrder();
        int amount = orderDetailList.get(0).getAmount();
        for (OrderDetail s : orderDetailList
        ) {
            if (amount < s.getAmount()) {
                id = s.getIdOrder();
                amount = s.getAmount();
            }
        }
        System.out.println("hóa đơn có tổng số lượng lớn nhất : " + id + " - amount : " + amount);
        }

    public static void findOrderMaxPrice(List<OrderDetail> orderDetailList){
        int id = orderDetailList.get(0).getIdOrder();
        float price = orderDetailList.get(0).getPrice();
        for (OrderDetail s : orderDetailList
        ) {
            if (price < s.getPrice()) {
                id = s.getIdOrder();
                price = s.getAmount();
            }
        }
        System.out.println("hóa đơn có tổng tiền lớn nhất : " + id + " - price : " + price);
    }

    public static OrderDetail findOrderDetail(int id, List<OrderDetail> orderDetailList) {

        for (OrderDetail s : orderDetailList
        ) {
            if (s.getIdOrder() == id) {
                return s;
            }
        }
        return null;
    }
}
