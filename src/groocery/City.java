package groocery;

public class City {
    String name;
    Grocery[] groceries;
    void getAllGroceryByEmployeeName(String name) {
        for(int i = 0; i < groceries.length; i++) {
            for(int j = 0; j < groceries[i].employees.length; j++) {
                if(groceries[i].employees[j].getFullName().equals(name)) {
                    System.out.println(groceries[i].name);
                    break;
                }
            }
        }
    }

}
