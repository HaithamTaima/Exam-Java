package examp;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        SalariedEmployee salariedEmployee1 = new SalariedEmployee(12313, "ahmad emad", new Date(),
                "ahmad@gmail.com", true, 1000, DepartmentType.Employees, 80);
        SalariedEmployee salariedEmployee2 = new SalariedEmployee(3423, "mohamad emad", new Date(),
                "mohamad@gmail.com", true, 2000, DepartmentType.Management, 95);
        SalariedEmployee salariedEmployee3 = new SalariedEmployee(54366, "amr emad", new Date(),
                "amr@gmail.com", true, 3000, DepartmentType.Services, 60);

        PerHourEmployee perHourEmployee1 = new PerHourEmployee(2345, "aya emad", new Date(),
                "amr@gmail.com", true, 20, 10);

        PerHourEmployee perHourEmployee2 = new PerHourEmployee(678678, "nour emad", new Date(),
                "amr@gmail.com", true, 15, 8);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(salariedEmployee1);
        employees.add(salariedEmployee2);
        employees.add(salariedEmployee3);
        employees.add(perHourEmployee1);
        employees.add(perHourEmployee2);

        for (Employee emp : employees) {
            System.out.println(emp.info());
        }
    }
}