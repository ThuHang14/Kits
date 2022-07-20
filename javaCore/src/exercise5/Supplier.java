package exercise5;

public class Supplier {
    private String IdSup;

    private String Name;

    private String  Address;

    private String  Tel;

    @Override
    public String toString() {
        return IdSup+"-"+Name+"-"+Address+"-"+Tel;
    }

    public Supplier(String idSup, String name, String address, String tel) {
        IdSup = idSup;
        Name = name;
        Address = address;
        Tel = tel;
    }

    public String getIdSup() {
        return IdSup;
    }

    public void setIdSup(String idSup) {
        IdSup = idSup;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }
}
