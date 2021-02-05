
package bd.com.dipti.accounting.model;

public class Product {
    private int pid;
    private String name;
    private double price;
    private int quantity;
    private String vendorName;

    public int getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }


    public Product(int pid, String name, double price, int quantity, String vendorName) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.vendorName = vendorName;
    }

    


}


