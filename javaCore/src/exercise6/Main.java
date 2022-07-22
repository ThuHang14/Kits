package exercise6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Customer> lstCust = new ArrayList<>();
        lstCust.add(new Customer("customerA", "addressA"));
        lstCust.add(new Customer("customerB", "addressB"));
        lstCust.add(new Customer("customerC", "addressC"));
        lstCust.add(new Customer("customerD", "addressC"));
        lstCust.add(new Customer("customerE", "addressA"));


        List<Transaction> lstTrans = new ArrayList<>();
        lstTrans.add(new Transaction(lstCust.get(0), 2021, "Ao", 12));
        lstTrans.add(new Transaction(lstCust.get(0), 2022, "Quan", 1));
        lstTrans.add(new Transaction(lstCust.get(1), 2021, "Noi", 2));
        lstTrans.add(new Transaction(lstCust.get(1), 2020, "Chao", 14));
        lstTrans.add(new Transaction(lstCust.get(2), 2021, "Mu", 300));
        lstTrans.add(new Transaction(lstCust.get(2), 2019, "Quan", 5));
        lstTrans.add(new Transaction(lstCust.get(3), 2019, "Quan", 5));

//        2.1
        System.out.println(searchTransactionYearSorted(lstTrans));
//        2.2
        System.out.println("list address : " + getAddress(lstCust));
//2.5
        System.out.println(checkAddress(lstCust, "address"));
        //2.6
        getMaxAmount(lstTrans);
//2.7
        System.out.println("tổng số lượng trong các giao dịch của các khách hàng ở một địa chỉ");
        sumTransactionsByAddress(lstTrans, "addressC");
        //2.8
        getMinAmount(lstTrans);
    }

    public static List<Transaction> searchTransactionYearSorted(List<Transaction> listTransaction) {
        List<Transaction> listTrans = new ArrayList<>();
        for (Transaction s : listTransaction
        ) {
            if (s.getYear() == 2021) {
                listTrans.add(s);
            }
        }

        Collections.sort(listTrans, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o1.getAmount().compareTo(o2.getAmount());
            }
        });
        return listTrans;
    }

    public static Set<String> getAddress(List<Customer> listCustomer) {
//        2.4
        Collections.sort(listCustomer, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
//2.2
        Set<String> listTrans = new HashSet<>();
        List<String> listAddress = new ArrayList<>();
        for (Customer s : listCustomer
        ) {
            if (!listTrans.add(s.getCity())) {
                listAddress.add(s.getCity());
            }
        }
//        System.out.println(listAddress);
//2.2.1
        for (String city : listAddress
        ) {
            System.out.print(city + " : ");
            listCustomer.stream().filter(s -> s.getCity().equals(city)).forEach(s -> System.out.print(s.getName() + " "));
            System.out.println();
        }
        return listTrans;
    }

    //2.5
    public static boolean checkAddress(List<Customer> customerList, String address) {
        int count = (int) customerList.stream().filter(s -> s.getCity().equals(address)).count();
        return count > 0;
    }

    //2.6
    public static void getMaxAmount(List<Transaction> transactions) {
        System.out.println(transactions.stream().max((a, b) -> a.getAmount() - b.getAmount()));
    }

    //2.7
    public static void sumTransactionsByAddress(List<Transaction> transactionList, String address) {

        Set<String> transactionList2 = new HashSet<>();

        for (Transaction t : transactionList
        ) {
            if (t.getCustomer().getCity().equals(address)) {
                transactionList2.add(t.getCustomer().getName());
            }
        }

        for (String s : transactionList2
        ) {
            System.out.println(s);

            int count = (int) transactionList.stream().filter(f -> f.getCustomer().getName().equals(s))
                    .filter(f2 -> f2.getCustomer().getCity().equals(address)).count();
            System.out.println("tổng số lượng các giao dịch : " + count);

            transactionList.stream().filter(f -> f.getCustomer().getName().equals(s))
                    .filter(f2 -> f2.getCustomer().getCity().equals(address))
                    .forEach(e -> System.out.println(e.getAmount()));

        }


    }

    //2.8
    public static void getMinAmount(List<Transaction> transactions) {
        System.out.println(transactions.stream().min((a, b) -> a.getAmount() - b.getAmount()));
    }
}
