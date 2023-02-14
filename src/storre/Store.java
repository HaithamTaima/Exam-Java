package storre;

import java.util.ArrayList;

public class Store {
    // خصائص المخزن
    private int store_id;
    private String store_location;
    private int store_tel;
    private ArrayList<Product> product_arr;


    // دوال getter و setter لكل من رقم المخزن و عنوانه و هاتفه و product_arr
    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getStore_location() {
        return store_location;
    }

    public void setStore_location(String store_location) {
        this.store_location = store_location;
    }

    public int getStore_tel() {
        return store_tel;
    }

    public void setStore_tel(int store_tel) {
        this.store_tel = store_tel;
    }

    public ArrayList<Product> getProduct_arr() {
        return product_arr;
    }

    public void setProduct_arr(ArrayList<Product> product_arr) {
        this.product_arr = product_arr;
    }

    // دالة إضافة Add_product() تأخذ مدخل من نوع Product و تقوم باضافته على المصفوفة product_arr
    public void Add_product(Product product) {
        product_arr.add(product);
    }

    // دالة زيادة كمية supply() تأخذ مدخلين الأول من نوع product و الثاني من نوع عدد صحيح و تقوم بزيادة كمية المنتج بمقدار العدد المدخل
    public void supply(Product product, int quantity) {
        for (Product p : product_arr) {
            if (p.getProduct_id() == product.getProduct_id()) {
                p.setQuantity(p.getQuantity() + quantity);
                break;
            }
        }
    }

    // دالة count() تقوم بطباعة عدد المنتجات في المخزن
    public void count() {
        System.out.println("Number of products in the store: " + product_arr.size());
        System.out.println("-------");
    }
    public void print_store(){
        System.out.println("Store ID: "+getStore_id());
        System.out.println("Store Location: "+getStore_location());
        System.out.println("Store Tel: "+getStore_tel());
        System.out.println("Products in the store: ");
        System.out.println("------------- ");
//        for(int i=0;i<product_arr.size();i++){
//            System.out.println("-/----");
//            System.out.println("Product ID: "+product_arr.get(i).getProduct_id());
//            System.out.println("Product Name: "+product_arr.get(i).getProduct_name());
//            System.out.println("Product Price: "+product_arr.get(i).getPrice());
//            System.out.println("Product Quantity: "+product_arr.get(i).getQuantity());
//            System.out.println("================================================= ");
//        }
    }
}
