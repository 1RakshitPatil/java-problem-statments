package exp_3;
import java.util.*;

class Product {
    protected int productId;
    protected String name;
    protected double price;

    void input(Scanner sc) {
        System.out.print("Enter Product ID: ");
        productId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Product Name: ");
        name = sc.nextLine();
        System.out.print("Enter Product Price: ");
        price = sc.nextDouble();
    }

    void display() {
        System.out.println("\n--- Product Details ---");
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + name);
        System.out.println("Product Price: " + price);
    }

    void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid discount percentage!");
            return;
        }
        price -= price * percent / 100;
        System.out.println("Price after base discount: " + price);
    }
}

// Electronics subclass
class Electronics extends Product {
    private int warrantyPeriod;
    public int additionalewarenty;
    
    void input(Scanner sc) {
        super.input(sc);
        System.out.print("Enter Warranty Period (in months): ");
        warrantyPeriod = sc.nextInt();
        System.out.print("enter how much additional discount u want to apply on the product");
        additionalewarenty=sc.nextInt();
    }

    
    void applyDiscount(double percent) {
        super.applyDiscount(percent);

        // Additional 5% electronics discount
//        double additionalDiscount = 5;
        price -= price * additionalewarenty/ 100;

        System.out.println("Price after electronics discount: " + price);
    }

    void displayWarranty() {
        System.out.println("Warranty Period: " + warrantyPeriod + " months");
    }
}

// Clothing subclass
class Clothing extends Product {
    private String size;
    public int additionalcwarenty;
    @Override
    void input(Scanner sc) {
        super.input(sc);
        sc.nextLine();
        System.out.print("Enter Size (Small, Medium, Large): ");
        size = sc.nextLine();
    }

    @Override
    void applyDiscount(double percent) {
        super.applyDiscount(percent);

        if (size.equalsIgnoreCase("Medium")) {
          
            System.out.println("Additional dicount .");
        }

        System.out.println("Final price: " + price);
    }

    void displaySize() {
        System.out.println("Clothing Size: " + size);
    }
}

// Groceries subclass
class Groceries extends Product {
    private String expiryDate;

    @Override
    void input(Scanner sc) {
        super.input(sc);
        sc.nextLine();
        System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
        expiryDate = sc.nextLine();
    }

    @Override
    void applyDiscount(double percent) {
        super.applyDiscount(percent);

        // Example: Extra 5% if expiry is near
        if (expiryDate.equals("2026-03-01")) {
            price -= price * 5 / 100;
            System.out.println("Additional 5% discount for near expiry applied.");
        }

        System.out.println("Final price: " + price);
    }

    void displayExpiryDate() {
        System.out.println("Expiry Date: " + expiryDate);
    }
}

// Main class
public class exp_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Choose Product Category:\n1) Electronics\n2) Clothing\n3) Groceries\nEnter choice: ");
        int productType = sc.nextInt();

        Product p = null;

        switch (productType) {
            case 1:
                p = new Electronics();
                break;
            case 2:
                p = new Clothing();
                break;
            case 3:
                p = new Groceries();
                break;
            default:
                System.out.println("Invalid category!");
                System.exit(0);
        }

        p.input(sc);
        p.display();

        System.out.print("\nEnter discount percentage: ");
        double discount = sc.nextDouble();

        p.applyDiscount(discount);
        p.display();

        // Show category specific details
        if (p instanceof Electronics) {
            ((Electronics) p).displayWarranty();
        } else if (p instanceof Clothing) {
            ((Clothing) p).displaySize();
        } else if (p instanceof Groceries) {
            ((Groceries) p).displayExpiryDate();
        }

        sc.close();
    }
}


