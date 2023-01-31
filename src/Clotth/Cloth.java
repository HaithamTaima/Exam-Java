package Clotth;

public class Cloth {
    private String model;
    private int id;
    private String color;
    private double price;
    private int quantity;
    private ClothSize size;

    public Cloth(String model, int id, String color, double price, int quantity, ClothSize size) {
        this.model = model;
        this.id = id;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
    }

    public double totalPrice() {
        double total = price * quantity;
        if (quantity > 10) {
            total -= total * 0.02;
        }
        return total;
    }

    public void printDetails() {
        System.out.println("Model: " + model);
        System.out.println("ID: " + id);
        System.out.println("Color: " + color);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Size: " + size);
        System.out.println("Total Price: " + totalPrice());
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ClothSize getSize() {
        return size;
    }

    public void setSize(ClothSize size) {
        this.size = size;
    }
}
