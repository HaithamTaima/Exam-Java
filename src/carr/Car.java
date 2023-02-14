package carr;

import java.util.Date;

class Car {
    private int id;
    private String corp;
    private String color;
    private Date ind_date;
    private String type;

    public Car(int id, String corp, String color, Date indDate, String type) {
        this.id = id;
        this.corp = corp;
        this.color = color;
        this.ind_date = ind_date;
        this.type = type;
    }



    // دالة setId لتعيين رقم السيارة
    public void setId(int id) {
        this.id = id;
    }

    // دالة getId للحصول على رقم السيارة
    public int getId() {
        return id;
    }

    // دالة setCorp لتعيين الشركة المصنعة
    public void setCorp(String corp) {
        this.corp = corp;
    }

    // دالة getCorp للحصول على الشركة المصنعة
    public String getCorp() {
        return corp;
    }

    // دالة setColor لتعيين لون السيارة
    public void setColor(String color) {
        this.color = color;
    }

    // دالة getColor للحصول على لون السيارة
    public String getColor() {
        return color;
    }

    // دالة setInd_date لتعيين تاريخ الانتاج
    public void setInd_date(Date ind_date) {
        if (ind_date.before(new Date())) {
            this.ind_date = ind_date;
        } else {
            System.out.println("Invalid production date. Must be before today's date.");
        }
    }

    // دالة getInd_date للحصول على تاريخ الانتاج
    public Date getInd_date() {
        return ind_date;
    }

    // دالة setType لتعيين نوع السيارة
    public void setType(String type) {
        if (type.equals("مالكي") || type.equals("عمومي") || type.equals("تجاري")) {
            this.type = type;
        } else {
            System.out.println("Invalid car type. Must be either 'مالكي', 'عمومي', or 'تجاري'.");
        }
    }

    // دالة getType للحصول على نوع السيارة
    public String getType() {
        return type;
    }
}

