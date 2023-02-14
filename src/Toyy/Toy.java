package Toyy;

public class Toy implements Toyface {
    private String name;
    private String color;
    private double price;
    private Quality quality;
    private static int numberOfToys = 0;

    public Toy(String name, String color, double price, Quality quality) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.quality = quality;
        numberOfToys++;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Color: " + color);
        System.out.println("Price: " + price);
        System.out.println("Quality: " + quality);
    }

    public double discount(double percent) {
        return price - (price * percent / 100);
    }

    public static int getNumberOfToys() {
        return numberOfToys;
    }
}
