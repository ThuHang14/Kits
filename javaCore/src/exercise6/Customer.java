package exercise6;

public class Customer {
    private String name;
    private String address;

    public Customer(String n, String c) {
        name = n;
        address = c;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return address;
    }

    public void setCity(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return " " + name + "  " + address;
    }
}
