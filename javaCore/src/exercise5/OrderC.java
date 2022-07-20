package exercise5;

import java.util.Date;

public class OrderC {
   private int  IdOrder;

    private Date OrdDate;

    private String CustomerID;

    @Override
    public String toString() {
        return IdOrder + "- " + OrdDate + "- " + CustomerID;
    }

    public OrderC(int idOrder, Date ordDate, String customerID) {
        IdOrder = idOrder;
        OrdDate = ordDate;
        CustomerID = customerID;
    }

    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int idOrder) {
        IdOrder = idOrder;
    }

    public Date getOrdDate() {
        return OrdDate;
    }

    public void setOrdDate(Date ordDate) {
        OrdDate = ordDate;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }
}
