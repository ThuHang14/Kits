package exercise6;

import java.util.Comparator;

public class Transaction{ // implements Comparator<Transaction>
    private Customer trader;
    private Integer year;
    private String prodName;
    private Integer amount;

    public Transaction(Customer t, int y, String name, int v) {
        trader = t;
        year = y;
        prodName = name;
        amount = v;
    }

    public Customer getCustomer() {
        return trader;
    }

    public void setCustomer(Customer trader) {
        this.trader = trader;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return trader.toString() + " Transaction (Year: " + year
                + ", ProdName: " + getProdName() + ", Amount: " + getAmount() + ")";
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

//    @Override
//    public int compare(Transaction o1, Transaction o2) {
//        return o1.getYear().compareTo(o2.getYear());
//    }

}
