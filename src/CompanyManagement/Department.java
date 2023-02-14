package CompanyManagement;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Employee>employees= new ArrayList<Employee>();
    int totalSalaryInDepartment = 0;


    Employee employee=new  Employee(1,"fdsfsd","fsdfsd",23,3);
    public Department(String name, ArrayList<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }


//دالة addEmployee employee Employee لإضافة موظف جديد
    void addEmployee(Employee employee) {
        employees.add(employee);
    }


    //دالة (removeEmployee(byID id : Int لإزالة الموظف من القسم
    void removeEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id == id) {
                employees.remove(i);
                break;
            }
        }
    }

    //printAllEmployees وهي دالة تقوم بطباعة جميع خصائص الموظفين في القسم
    void printAllEmployees() {
        for (Employee employee : employees) {
            employee.printInformation();
            System.out.println("------------------------------");
        }
    }

    //دالة count لطباعة عدد الموظفين في الق
    int count() {
        return employees.size();
    }


    //totalSalaryInDepartmen وهي دالة تقوم بإرجاع حساب جميع رواتب الموظفين مع العلاوة في القسم
    public int getTotalSalaryInDepartment() {
        int total = 0;
        for (Employee employee : employees) {
            total += employee.SalaryAllowance()+employee.getPrice();
        }
        total += totalSalaryInDepartment;
        return total;
    }

}
