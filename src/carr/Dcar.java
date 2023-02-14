package carr;

import java.util.Date;

public class Dcar extends Car {
    private int doors;
    public Dcar(int id, String corp, String color, Date ind_date, String type, int doors) {
        super(id, corp, color, ind_date, type);
        this.doors = doors;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

}
