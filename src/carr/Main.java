package carr;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Dcar> cars = new ArrayList<>();
        Dcar car1 = new Dcar(1, "Toyota", "Red", "2015/10/01", "مالكي", 4);
        Dcar car2 = new Dcar(2, "Honda", "Blue", "2015/12/01", "عمومي", 2);
        Dcar car3 = new Dcar(3, "Nissan", "Green", "2016/02/01", "تجاري", 6);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // دالة تعدل بيانات عدد البواب للسيارة
        modifyDoors(cars, 1, 6);

        // دالة حساب عدد السيارات
        totalCars(cars);

        // دالة تطبع جميع البيانات على الشاشة
        printAllCars(cars);

        //ادخال بيانات سيارة مع التحقق من التاريــخ و الــنـوع
        inputData(cars);

        int totalCars = totalCars(cars);
        System.out.println("Total cars: " + totalCars);


        // دالة تطبع جميع البيانات على الشاشة
        printAllCars(cars);

    }



    //ادخال بيانات سياؤة مع التحقق من التاريــخ و الــنـوع
    public static void inputData(ArrayList<Dcar> cars) {
        while (true) {



            System.out.print("Enter car ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter car corporation: ");
            String corp = sc.nextLine();
            System.out.print("Enter car color: ");
            String color = sc.nextLine();
            System.out.print("Enter car production date (yyyy/MM/dd): ");
            String ind_date = sc.nextLine();

            // دالة تشخص تاريخ الانتاج المدخل بحيث يكون اقل من تاريخ اليوم
            LocalDate today = LocalDate.now();
            LocalDate carIndDate = LocalDate.parse(ind_date);

            if (carIndDate.isBefore(today)) {
                System.out.println("The production date " + ind_date + " is valid.");
            } else {
                System.out.println("The production date " + ind_date + " must be before today.");
            }


            System.out.print("Enter car type (مالكي, عمومي, تجاري): ");
            String type = sc.nextLine();

            // هذه  تقوم بفحص صحة نوع السيارة حسب القيم المدخلة
            if (type.equals("مالكي") || type.equals("عمومي") || type.equals("تجاري")) {
                System.out.println("Valid car type: " + type);
            } else {
                System.out.println("Invalid car type. Must be either 'مالكي', 'عمومي', or 'تجاري'.");
            }

            System.out.print("Enter number of doors: ");
            int doors = sc.nextInt();
            Dcar car = new Dcar(id, corp, color, ind_date, type, doors);
            cars.add(car);
            System.out.print("Do you want to add another car? (yes/no): ");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("no")) {
                break;
            }
        }
    }


    // هذه الدالة تقوم بطباعة جميع البيانات لجميع السيارات في المصفوفة.
    public static void printAllCars(ArrayList<Dcar> list) {
        for (Dcar car : list) {
            System.out.println("ID: " + car.getId());
            System.out.println("Corp: " + car.getCorp());
            System.out.println("Color: " + car.getColor());
            System.out.println("Production Date: " + car.getInd_date());
            System.out.println("Type: " + car.getType());
            System.out.println("Doors: " + car.getDoors());
            System.out.println("-------------------");
        }
    }


    // دالة حساب عدد السيارات
    public static int totalCars(ArrayList<Dcar> cars) {
        int count = 0;
        for (Car car : cars) {
            count++;
        }
        System.out.println("Total number of cars: " + count);
        return count;
    }
    // دالة تعدل بيانات عدد البواب للسيارة
    public static void modifyDoors(ArrayList<Dcar> dcarList, int id, int doors) {
        for (Dcar dcar : dcarList) {
            if (dcar.getId() == id) {
                dcar.setDoors(doors);
            }
        }
    }

//------------------------------------------------------------------
//   // هذه  تقوم بفحص صحة نوع السيارة حسب القيم المدخلة
//public void setType(String type) {
//    if (type.equals("مالكي") || type.equals("عمومي") || type.equals("تجاري")) {
//        this.type = type;
//    } else {
//        System.out.println("Invalid car type. Must be either 'مالكي', 'عمومي', or 'تجاري'.");
//    }
//}
//------------------------------------------------------------------
//    دالة تشخص تاريخ الانتاج المدخل بحيث يكون اقل من تاريخ اليوم
//    public void checkIndDate(String indDate) {
//        LocalDate today = LocalDate.now();
//        LocalDate carIndDate = LocalDate.parse(indDate);
//        if (carIndDate.isBefore(today)) {
//            System.out.println("The production date " + indDate + " is valid.");
//        } else {
//            System.out.println("The production date " + indDate + " must be before today.");
//        }
}