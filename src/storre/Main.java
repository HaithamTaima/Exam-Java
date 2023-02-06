package storre;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 3. انشاء كائن من نوع store
        Store store = new Store();
        store.setStore_id(1);
        store.setStore_location("usa");
        store.setStore_tel(1235667778);
        store.setProduct_arr(new ArrayList<>());





        // 1. انشاء كائنات من نوع product (عدد 2 او اكثر)
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();



        // 2. ادخال بيانات الكائنات السايفة عند طريق دالة setter
        product1.setProduct_id(1);
        product1.setProduct_name("Laptop ");
        product1.setPrice(10.0);
        product1.setQuantity(100);


        product2.setProduct_id(2);
        product2.setProduct_name("Smartphone");
        product2.setPrice(10.0);
        product2.setQuantity(100);

        product3.setProduct_id(3);
        product3.setProduct_name("fleer");
        product3.setPrice(10.0);
        product3.setQuantity(100);


        // 4. استدعاء الدالة Add_product() من خلال الكائن الذي تم انشاؤه في الخطوة (3) و تمرير كائنات الــ product التي تم انشاؤها في الخطوة (1) له
        store.Add_product(product1);
        store.Add_product(product2);
        store.Add_product(product3);


        // طباعة بيانات المخزن
        store.print_store();

//دالة اضافة على كمية مونتج معين
        store.supply(product1,1);

    // طباعة بيانات المنتجات الموجودة في المخزن
        for (Product p : store.getProduct_arr()) {
            p.print_product();
        }
//دالة تطبع عدد المنتجات في المخزن
        store.count();
        store.print_store();
        product1.print_product();



    }
}
