package carr.ScanarCar;

import java.util.Date;

public class Car {
    private int id;
    private String corp;
    private String color;
    private Date indDate;
    private TypeCar typeCar;

    public Car(int id, String corp, String color, Date indDate, TypeCar typeCar) {
        this.id = id;
        this.corp = corp;
        this.color = color;
        this.indDate = indDate;
        this.typeCar = typeCar;
    }

    public Date getIndDate() {
        return indDate;
    }

    public void setIndDate(Date indDate) {
        this.indDate = indDate;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;

    }

    public TypeCar getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(TypeCar typeCar) {
        this.typeCar = typeCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", corp='" + corp + '\'' +
                ", color='" + color + '\'' +
                ", indDate=" + indDate +
                ", typeCar=" + typeCar +
                '}';
    }
}
