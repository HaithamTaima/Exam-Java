package groocery;

import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Grocery> groceries;

    public City(String name, ArrayList<Grocery> groceries) {
        this.name = name;
        this.groceries = groceries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }

    public void setGroceries(ArrayList<Grocery> groceries) {
        this.groceries = groceries;
    }

    public City(String name) {
        this.name = name;
        this.groceries = new ArrayList<Grocery>();
    }


    public void getAllGroceryByEmployeeName(String name) {

        for (Grocery grocery : this.groceries) {
            for (Employee employee : grocery.getEmployees()) {
                if (employee.getFullName().equals(name)) {
                    System.out.println(grocery.getName());
                }
            }
        }
        System.out.println("Grocery Stores for Employee " + name + " in " + this.name + ":");
    }

}
