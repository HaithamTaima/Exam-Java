package groocery;

public class Product {
    private int id;
    private double price;
    private String name;
    private String type;
    private  int quantity;

    public Product(int id, double price, String name, String type, int quantity) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void printInformation() {
        System.out.println("رقم المنتج: " + id);
        System.out.println("اسم المنتج: " + name);
        System.out.println("نوع المنتج: " + type);
        System.out.println("سعر المنتج: " + price);
        System.out.println("كمية المنتج: " + quantity);


    }
}
