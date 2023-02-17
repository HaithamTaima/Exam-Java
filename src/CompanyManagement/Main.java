package CompanyManagement;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Department department = new Department("IT", employees);

        Employee employee1 = new Employee(1, "هيثم", "Software Engineer", 5000, 2);
        Employee employee2 = new Employee(2, "محمد", "Product Manager", 6000, 1);

        department.addEmployee(employee1);
        department.addEmployee(employee2);
        employees.add(new Employee(3, "جعفر", "Developer", 4000, 1));



        System.out.println("Total salary in the department: " + department.getTotalSalaryInDepartment());


        department.removeEmployee(1);

        department.printAllEmployees();

         department.count();



    }


}
