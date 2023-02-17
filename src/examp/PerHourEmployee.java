package examp;

import java.util.Date;

public class PerHourEmployee extends Employee {
    double hours;
    double hourPrice;

    public PerHourEmployee(long id, String fullName, Date birthDate, String email, boolean gender, double hours,
                           double hourPrice) {
        super(id, fullName, birthDate, email, gender);
        this.hours = hours;
        this.hourPrice = hourPrice;
    }

    @Override
    String info() {
        return super.fullName + " | " + super.id + " | " + super.birthDate + " | " + super.gender + " | "
                + computeSalary();
    }

    @Override
    double computeSalary() {
        return hours * hourPrice;
    }
}
