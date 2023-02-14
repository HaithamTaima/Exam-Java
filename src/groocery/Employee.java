package groocery;

public class Employee {
    private int id;
    private String fullName;
    private double salary;
    private String jobTitle;

    Employee(){

    }

    public Employee(int id, String fullName, double salary, String jobTitle) {
        this.id = id;
        this.fullName = fullName;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void printInformation(){
       System.out.println("ID: " + id);
       System.out.println("Full Name: " + fullName);
       System.out.println("Salary: " + salary);
       System.out.println("Job Title: " + jobTitle);

    }


    public double getSalaryInYear(){
        return  salary*12;
    }




}
