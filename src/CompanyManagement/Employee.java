package CompanyManagement;

public class Employee {
    int id;
    private  String fullName;
    private String jobName;

    private  double price;

    private  int childrenNumber;

    public Employee(int id, String fullName, String jobName, double price, int childrenNumber) {
        this.id = id;
        this.fullName = fullName;
        this.jobName = jobName;
        this.price = price;
        this.childrenNumber = childrenNumber;
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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public double salaryInYear(){
        return  price*12;
    }

    public double SalaryAllowance(){
        double allowance = childrenNumber * 10;
        return price+allowance;
    }
    public void printInformation() {
        System.out.println("ID: " + this.id);
        System.out.println("Full Name: " + this.fullName);
        System.out.println("Job Name: " + this.jobName);
        System.out.println("Salary: " + this.price);
        System.out.println("Number of Children: " + this.childrenNumber);
        salaryInYear();
        SalaryAllowance();
    }
}
