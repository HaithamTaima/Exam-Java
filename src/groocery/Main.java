package groocery;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


//إنشاء عنصر من كلاس Grocery
        Grocery grocery = new Grocery();
        //إعطاء اسم للمحل الأسواق
        grocery.setName("Supermarket");
        grocery.setEmployees(new ArrayList<>());
        grocery.setProducts(new ArrayList<>());

        //إنشاء عناصر من كلاس Employee
        Employee employee1 = new Employee(1,"John jhait", 30.0, "haipr mol");
        Employee employee2 = new Employee(2,"John jhait", 30.0, "haipr mol");
        //إضافة الموظفين إلى قائمة الموظفين في المحل
        grocery.getEmployees().add(employee1);
        grocery.getEmployees().add(employee2);



        //إنشاء عناصر من كلاس Product
        Product product1 = new Product(1,20,"orang","vegtpol",50);
        Product product2 = new Product(2,20,"orang","vegtpol",50);
        //إضافة المنتجات إلى قائمة المنتجات في المحل
        grocery.getProducts().add(product1);
        grocery.getProducts().add(product2);


        //طباعة إجمالي الراتب لكل الموظفين
        System.out.println("Total salary of all employees: " + grocery.totalSalary());


        //إضافة منتج جديد
        Product product3 = new Product(3,20,"orhhang","vegtpol",5);
        grocery.addProduct(product3);



        //إزالة منتج
        boolean result = grocery.removeProduct(2);
        if (result) {
            System.out.println("Product removed successfully");
        } else {
            System.out.println("Product not found");
        }

        //عدد المنتجات
        grocery.count();

        //الحصول على المنتج ذو الكمية قريبة من النهاية
        grocery.getAlmostEndQuantity();

        // دالة لطباعة كل خصائص الموظف ()printInformation.
        System.out.println("دالة لطباعة كل خصائص الموظف رقم 2");
        employee2.printInformation();
        System.out.println("-------------");
        // دالة مرجعة يقوم بحساب راتبه السنوي ()getSalaryInYear
        System.out.println("Employee 1 salary in a year: " + employee1.getSalaryInYear());
        System.out.println("-------------");
        // دالة لطباعة كل خصائص المنتج ()printInformation.
        product1.printInformation();

        //() printAllEmployees وهي دالة تقوم بطباعة جميع خصائص الموظفين في البقالة.
        System.out.println("-----all--------");
        grocery.printAllEmployees();


        //جميع رواتب الموظفين في البقالة
        System.out.println("-------------");
        System.out.println("جميع رواتب الموظفين في البقالة: " + grocery.totalSalary());

// totalCapitalValue و ھو )رأس المال( و دالة مرجعة يقوم بحساب جميع أسعار المنتجات X( الكمية( في البقالة.
        System.out.println("-------------");
        System.out.println("بحساب جميع أسعار المنتجات " +grocery.totalCapitalValue());


//*******************************************************************************************


        City city = new City("New York");


        Grocery grocery2 = new Grocery();
        grocery2.setName("Grocery 2");
        Employee employee3 = new Employee(3,"Haitham Taima", 550.4, "jolden");
        grocery2.getEmployees().add(employee3);
        city.getGroceries().add(grocery2);

        Grocery grocery3 = new Grocery();
        grocery3.setName("Grocery 3");
        Employee employee4 = new Employee(4,"adood goop", 550.4, "jolden");
        grocery3.getEmployees().add(employee4);
        city.getGroceries().add(grocery3);




       //دالة  يقوم بطباعة جميع أسماء البقاالت وذلك عمى حسب اسم الموظف .دخال قيم لها وتنفيذ دوالها قم بتمثيل جميع البيانات المذكور
        city.getGroceries().add(grocery);

        city.getAllGroceryByEmployeeName("adood goop");

    }



}