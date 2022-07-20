package exercise5;

import java.util.Date;

public class Purchase {
   private int IdPurchase;

    private Date purDate;

    private String SupplierID ;

    @Override
    public String toString() {
        return IdPurchase+"-"+purDate+"-"+SupplierID;
    }

    public Purchase(int idPurchase, Date purDate, String supplierID) {
        IdPurchase = idPurchase;
        this.purDate = purDate;
        SupplierID = supplierID;
    }

    public int getIdPurchase() {
        return IdPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        IdPurchase = idPurchase;
    }

    public Date getPurDate() {
        return purDate;
    }

    public void setPurDate(Date purDate) {
        this.purDate = purDate;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String supplierID) {
        SupplierID = supplierID;
    }
}
