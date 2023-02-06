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



    void addEmployee(Employee employee) {
        employees.add(employee);
    }

    void removeEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id == id) {
                employees.remove(i);
                break;
            }
        }
    }

    void printAllEmployees() {
        for (Employee employee : employees) {
            employee.printInformation();
            System.out.println("------------------------------");
        }
    }
    int count() {
        return employees.size();
    }

    public int getTotalSalaryInDepartment() {
        int total = 0;
        for (Employee employee : employees) {
            total += employee.SalaryAllowance()+employee.getPrice();
        }
        total += totalSalaryInDepartment;
        return total;
    }

}
