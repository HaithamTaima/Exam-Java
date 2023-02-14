package Clotth;

public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart();
            // إنشاء كائنات من كلاس Cloth
        Cloth cloth1 = new Cloth("Levis", 1, "أزرق", 20, 15, ClothSize.xl);
        Cloth cloth2 = new Cloth("Nike", 2, "أسود", 30, 5, ClothSize.medium);
        Cloth cloth3 = new Cloth("Adidas", 3, "أحمر", 25, 10, ClothSize.small);


        // إضافة المنتجات إلى السلة
        cart.addToCart(cloth1);
        cart.addToCart(cloth2);
        cart.addToCart(cloth3);


        // الحصول على إجمالي سعر المنتجات في السلة
        System.out.println("إجمالي سعر المنتجات في السلة: " + cart.totalPriceValue());


        // طباعة جميع المنتجات في السلة
        System.out.println("##########################");
        cart.printAllInCart();
        System.out.println("##########################");





            // حذف منتج من السلة
        boolean result = cart.removeFromCart(2);
        if (result == true) {
            System.out.println("تم حذف المنتج من السلة.");
        } else {
            System.out.println("لم يتم العثور على المنتج في السلة.");
        }

        // طباعة جميع المنتجات في السلة بعد حذف منتج
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("المنتجات في السلة بعد حذف");
        cart.printAllInCart();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        // الحصول على عدد المنتجات في السلة
        System.out.println("عدد المنتجات في السلة: " + cart.count());


    }
}
