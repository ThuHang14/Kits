package exercise5;

public class OrderDetail {
   private int  IdOrder;

    private int IdDetail;

    private int ItemID;

    private int Amount;

    private float Price;

    public OrderDetail() {

    }

    @Override
    public String toString() {
        return IdDetail + "-" +IdDetail+"-"+ItemID+"-"+Amount+"-"+Price;
    }

    public OrderDetail(int idOrder, int idDetail, int itemID, int amount, float price) {
        IdOrder = idOrder;
        IdDetail = idDetail;
        ItemID = itemID;
        Amount = amount;
        Price = price;
    }

    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int idOrder) {
        IdOrder = idOrder;
    }

    public int getIdDetail() {
        return IdDetail;
    }

    public void setIdDetail(int idDetail) {
        IdDetail = idDetail;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }
}
