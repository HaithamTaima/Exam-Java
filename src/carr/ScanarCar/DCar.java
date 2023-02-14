package carr.ScanarCar;

import java.util.Date;

public class DCar extends Car {
    int numDoors;

    public DCar(int id, String corp, String color, Date indDate, TypeCar typeCar, int numDoors) {
        super(id, corp, color, indDate, typeCar);
        this.numDoors = numDoors;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s %-15s %-15s %-15s",
                "id: " + super.getId(),
                "corp: " + super.getCorp(),
                "color: " + super.getColor(),
                "indDate: " + super.getIndDate(),
                "typeCar: " + super.getTypeCar(),
                "doors: " + numDoors
        );
    }

}
