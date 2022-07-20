package exercise5;

public class PurchaseDetail {
    private int IdPurchase;
    private int IdDetail;
    private int ItemID;
    private int Amount;
    private float Price;

    @Override
    public String toString() {
        return IdPurchase+"-" +IdDetail+"-"+ItemID+"-"+Amount+"-"+Price;
    }

    public PurchaseDetail(int idPurchase, int idDetail, int itemID, int amount, float price) {
        IdPurchase = idPurchase;
        IdDetail = idDetail;
        ItemID = itemID;
        Amount = amount;
        Price = price;
    }

    public int getIdPurchase() {
        return IdPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        IdPurchase = idPurchase;
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
