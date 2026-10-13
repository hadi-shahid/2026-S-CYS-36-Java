import java.util.Scanner;

class Product {

    private String name;
    private int price;
    private int quantity;

    static int totalProduct = 0;
    static Scanner sc = new Scanner(System.in);


    public Product() {
        name = "Unknown";
        price = 0;
        quantity = 0;
        counter();
    }


    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        counter();
    }

    public void getData() {
        System.out.print("Enter product name: ");
        name = sc.nextLine();

        System.out.print("Enter product's price: ");
        price = sc.nextInt();
        if (price < 0) {
            System.out.println("Price can not be Negative.");
            price = 0;
        }

        System.out.print("Enter quantity: ");
        quantity = sc.nextInt();
        if (quantity < 0) {
            System.out.println("Quantity can not be Negative.");
            quantity = 0;
        }
        sc.nextLine();
    }


    public static void counter() {
        totalProduct++;
    }


    public static int countProduct() {
        return totalProduct;
    }
    public void displayData() {
        System.out.println("Name: " + name + ", Price: " + price + ", Quantity: " + quantity);
    }
}

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = Product.sc;
        System.out.println("Number of products that you want to add : ");
        int n =sc.nextInt();
        sc.nextLine();
        if (n<0){
            System.out.println("Number is negative.");
        }
        Product[] list = new Product[n];
        for (int i=0;i<n;i++){
            System.out.println("Product " + (i + 1) );
            list[i] =new Product();
            list[i].getData();


        }
        System.out.println("Products list");
        for (int i = 0;i<n ; i++){
            list[i].displayData();
        }

        System.out.println("Total products bought : " + Product.countProduct());
    }
}