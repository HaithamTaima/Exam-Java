package groocery;

public class Grocery {
    String name;
    Employee[] employees;
    Product[] products;
//() printAllEmployees وهي دالة تقوم بطباعة جميع خصائص الموظفين في القسم
    void printAllEmployees() {
        for (int i = 0; i < employees.length; i++) {
            employees[i].printInformation();
        }
    }
//() totalSalary وهو دالة مرجعة يقوم بحساب جميع رواتب الموظفين في البقالة.
    int totalSalary() {
        int total = 0;
        for (int i = 0; i < employees.length; i++) {
            total += employees[i].getSalaryInYear();
        }
        return total;
    }
// totalCapitalValue و ھو )رأس المال( و دالة مرجعة يقوم بحساب جميع أسعار المنتجات X( الكمية( في البقالة.
    int totalCapitalValue() {
        int total = 0;
        for(int i = 0; i < products.length; i++) {
            total +=products[i].getPrice()*products[i].getQuantity();
        }
        return total;
    }

// دالة (product groocery.Product(addProduct إلضافة منتج جديد
    void addProduct(Product product){
        Product[] newProducts = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            newProducts[i] = products[i];
        }
        newProducts[products.length] = product;
        products = newProducts;
    }
//دالة (id int (removeProduct إلزالة المنتج من القسم ويقوم بإرجاع true في حال قام بحذفه وارجاع false في حال لم يعثر عمى رقم المنتج
//في البقالة
    boolean removeProduct(int id) {
        for(int i = 0; i < products.length; i++) {
            if(products[i].getId() == id) {
                Product[] newProducts = new Product[products.length - 1];
                for(int j = 0; j < i; j++) {
                    newProducts[j] = products[j];
                }
                for(int j = i + 1; j < products.length; j++) {
                    newProducts[j-1] = products[j];
                }
                products = newProducts;
                return true;
            }
        }
        return false;
    }

    //دالة count لطباعة عدد المنتجات في البقالة.
    int count() {
        return products.length;
    }

    //دالة ()getAlmostEndQuantity لطباعة المنتج الذي سيوشك عمى االنتهاء من البقالة ، حيث ان اذا كان المنتج كميته اقل من 10 في البقالة
    //يقوم بطباعته
    void getAlmostEndQuantity() {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getQuantity() < 10) {
                products[i].printInformation();
            }
        }


    }
}
