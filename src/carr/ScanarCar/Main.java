package carr.ScanarCar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static Scanner scanner;
    public static ArrayList<DCar> carArrayList;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        carArrayList = new ArrayList<>();
        mainScreen();
    }

    public static void mainScreen() {
        System.out.println("\n1 - ادخال بيانات");
        System.out.println("2 - حساب عدد السيارات");
        System.out.println("3 - تعديل عدد ابواب السيارات");
        System.out.println("4 - عرض جميع البيانات");
        System.out.println("5- خروج من البرنامج");
        System.out.println("دخل خيارك");

        int input = scanner.nextInt();
        switch (input) {
            case 1: {
                storeCar();
                break;
            }
            case 2: {
                numCar();
                break;
            }
            case 3: {
                editNumDoors();
                break;
            }
            case 4: {
                showAllCars();
                break;
            }
            case 5:{
             // انهاء البرنامج توقيفه من المنيو الثانية تعت التعديل
            Main.existFromApp();
            break;
            }
        }
    }

    public static void storeCar() {
        System.out.println("ادخا عدد السيارة المراد ادخالها");
        int carCont = scanner.nextInt();
        for (int i = 0; i < carCont ; i++)
        {
            System.out.println("ادخل بيانات السيارة رقم :" + (i + 1));

            System.out.println("رقم السيارة");
            int id = scanner.nextInt();

            System.out.println("الشركة المصنعة");
            String crop = scanner.next();

            System.out.println("لون السيارة");
            String color = scanner.next();

            System.out.println("تاريخ الانتاج");
            Date indDate;
            while (true) {
                String date = scanner.next();
                try {
                    indDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                    boolean result = indDate.before(new Date());
                    if (result) {
                        break;
                    } else {
                        System.out.println("ادخل التاريخ صالح مرة اخرى");
                    }
                } catch (ParseException e) {
                    System.out.println("ادخل التاريخ صالح مرة اخرى");
                }
            }

            System.out.println("نوع السيارة");
            TypeCar typeCar;
            label:
            while (true) {
                String type = scanner.next();
                switch (type) {
                    case "ملاكي":
                        typeCar = TypeCar.M;
                        break label;
                    case "عمومي":
                        typeCar = TypeCar.A;
                        break label;
                    case "تجاري":
                        typeCar = TypeCar.T;
                        break label;
                    default:
                        System.out.println("ادخل نوع السيارة مرة اخري (ملاكي او عمومي او تجاري)");
                        break;
                }
            }

            System.out.println("عدد ابواب السيارة");
            int numDoors = scanner.nextInt();

            carArrayList.add(new DCar(id, crop, color, indDate, typeCar, numDoors));
        }
        mainScreen();
    }

    public static void numCar() {
        System.out.println("عدد السيارات = " + carArrayList.size());

        mainScreen();
    }

    public static void editNumDoors() {
        System.out.println("رقم السيارة");
        int id = scanner.nextInt();

        System.out.println("عدد ابواب السيارة");
        int numDoors = scanner.nextInt();

        for (DCar dCar : carArrayList) {
            if (dCar.getId() == id) {
                dCar.setNumDoors(numDoors);
                break;
            }
        }
        mainScreen();
    }

    public static void showAllCars() {
        for (DCar dCar : carArrayList) {
            System.out.println(dCar.toString());
        }

        mainScreen();
    }

    public static void existFromApp(){
        System.exit(0);
    }
}