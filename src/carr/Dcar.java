package carr;

public class Dcar extends Car {
    private int doors;
    public Dcar(int id, String corp, String color, String ind_date, String type, int doors) {
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
