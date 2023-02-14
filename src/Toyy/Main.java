package Toyy;

public class Main {
    public static void main(String[] args) {
        Toy toy1 = new Toy("Car", "Red", 15.0, Quality.High);
        Toy toy2 = new Toy("Doll", "Blue", 20.0, Quality.Low);
        Toy toy3 = new Toy("Ball", "Green", 10.0, Quality.Medium);

        toy1.display();
        System.out.println("Price after discount: " + toy1.discount(50));
        System.out.println();

        toy2.display();
        System.out.println("Price after discount: " + toy2.discount(50));
        System.out.println();

        toy3.display();
        System.out.println("Price after discount: " + toy3.discount(50));
        System.out.println();

        System.out.println("Number of toys: " + Toy.getNumberOfToys());
    }
}
