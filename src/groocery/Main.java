package groocery;

public class Main {
    public static void main(String[] args) {


        Employee employee = new Employee(1, "haitham", 934.3, "java");
        employee.printInformation();
        System.out.println("sa;re in yars"+employee.getSalaryInYear());

        Product product=new Product(1,99,"apil","fwakh",33);
        product.printInformation();

    }
}