package Clotth;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Cloth> clothes = new ArrayList<Cloth>();

    public double totalPriceValue() {
        double total = 0;
        for (Cloth cloth : clothes) {
            total += cloth.totalPrice();
        }
        return total;
    }

    public void printAllInCart() {
        for (Cloth cloth : clothes) {
            cloth.printDetails();
        }
        System.out.println("Total Value: " + totalPriceValue());
    }

    public void addToCart(Cloth cloth) {
        clothes.add(cloth);
    }

    public boolean removeFromCart(int id) {
        for (Cloth cloth : clothes) {
            if (cloth.getId() == id) {
                clothes.remove(cloth);
                return true;
            }
        }
        return false;
    }

    public int count() {
        return clothes.size();
    }
}
