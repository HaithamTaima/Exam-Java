package groocery;

import java.util.ArrayList;

public class Grocery {
    String name;
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();

    public Grocery() {
        this.name = name;
        this.employees = employees;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }



    //() printAllEmployees وهي دالة تقوم بطباعة جميع خصائص الموظفين في القسم
    public void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getId() + " " + employee.getFullName() + " " + employee.getSalary() + " " + employee.getJobTitle());
        }
    }





    //() totalSalary وهو دالة مرجعة يقوم بحساب جميع رواتب الموظفين في البقالة.
int totalSalary() {
    int total = 0;
    for (Employee e : employees) {
        total += e.getSalary();
    }
    return total;
}

// totalCapitalValue و ھو )رأس المال( و دالة مرجعة يقوم بحساب جميع أسعار المنتجات X( الكمية( في البقالة.

    int totalCapitalValue() {
        int total = 0;
        for (Product p : products) {
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }



    //() printAllEmployees وهي دالة تقوم بطباعة جميع خصائص الموظفين في البقالة.
//    public void printAllEmployeesB() {
//        for (Employee employee : employees) {
//            System.out.println("______employee.toString()____");
//            System.out.println(employee.toString());
//        }
//    }


// دالة (product groocery.Product(addProduct إلضافة منتج جديد
void addProduct(Product product) {
    products.add(product);
}
//دالة (id int (removeProduct إلزالة المنتج من القسم ويقوم بإرجاع true في حال قام بحذفه وارجاع false في حال لم يعثر عمى رقم المنتج
//في البقالة
boolean removeProduct(int id) {
    for (Product p : products) {
        if (p.getId() == id) {
            products.remove(p);
            return true;
        }
    }
    return false;
}
    //دالة count لطباعة عدد المنتجات في البقالة.
    void count() {

        System.out.println("Number of products:"+products.size());
    }

    //دالة ()getAlmostEndQuantity لطباعة المنتج الذي سيوشك عمى االنتهاء من البقالة ، حيث ان اذا كان المنتج كميته اقل من 10 في البقالة
    //يقوم بطباعته
    void getAlmostEndQuantity() {
        System.out.println("----------------------");
        System.out.println("المنتج كميته اقل من 10 في البقالة");
        for (Product p : products) {
            if (p.getQuantity() < 10) {
                p.printInformation();
            }
        }
        System.out.println("----------------------");
    }


}
