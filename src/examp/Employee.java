package examp;

import java.util.Date;

abstract class Employee {
    long id;
    String fullName;
    Date birthDate;
    String email;
    boolean gender;

    public Employee(long id, String fullName, Date birthDate, String email, boolean gender) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.email = email;
        this.gender = gender;
    }

    abstract String info();

    abstract double computeSalary();
}
