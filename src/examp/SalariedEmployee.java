package examp;

import java.util.Date;

public class SalariedEmployee extends Employee {
    double baseSalary;
    DepartmentType departmentType;
    double attendancePercentage;

    public SalariedEmployee(long id, String fullName, Date birthDate, String email, boolean gender, double baseSalary,
                            DepartmentType departmentType, double attendancePercentage) {
        super(id, fullName, birthDate, email, gender);
        this.baseSalary = baseSalary;
        this.departmentType = departmentType;
        this.attendancePercentage = attendancePercentage;
    }

    public void addBonus() {
        switch (departmentType) {
            case Management: {
                baseSalary += baseSalary * 0.02;
                break;
            }
            case Employees: {
                baseSalary += baseSalary * 0.05;
                break;
            }
            case Services: {
                baseSalary += baseSalary * 0.10;
                break;
            }
        }
    }

    public void deduct() {
        baseSalary = baseSalary * (1 - (attendancePercentage * 0.01));
    }

    @Override
    String info() {
        return super.fullName + " | " + super.id + " | " + super.birthDate + " | " + super.gender + " | "
                + computeSalary() + " | " + attendancePercentage;
    }

    @Override
    double computeSalary() {
        return baseSalary;
    }
}
