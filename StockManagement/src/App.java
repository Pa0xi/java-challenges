import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        boolean found = false;
        boolean exit = false;
        int id;
        products.add(new Product(1, "Laptop", 1200.00));
        products.add(new Product(2, "Smartphone", 800.00));
        products.add(new Product(3, "Tablet", 400.00));
        while(!exit){
            found = false;
            System.out.println();
            System.out.println("==============================");
            System.out.println("Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Apply discount");
            System.out.println("4. Apply PUT UP");
            System.out.println("5. Delete product");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.print("Invalid Input!!!");
                sc.next();
            }
            switch(choice){
                case 1:
                    System.out.println("==============================");
                    System.out.print("Enter product ID: ");
                    id = sc.nextInt();
                    for(int i=0;i<products.size();i++){
                        if(products.get(i).getId() == id){
                            found = true;
                            System.out.println("=====================================");
                            System.out.println("Product ID already exists. Try again.");
                            System.out.println("=====================================");
                            i--;
                            break;
                            
                        }
                    }
                    if(!found){
                        System.out.print("Enter product name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter product price: ");
                        double price = sc.nextDouble();
                        products.add(new Product(id, name, price));
                        System.out.println("==========================");
                        System.out.println("Product added successfully.");
                        System.out.println("==========================");
                    }
                    break;
                case 2:
                    System.out.println("==============================");
                    if(products.size() != 0){
                        for(Product p : products){
                        System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice());
                    }
                    }else{
                        System.out.println("No product found");
                    }
                    System.out.println("==============================");
                    break;
                case 3:
                    System.out.print("Enter product ID to apply discount: ");
                    id = sc.nextInt();
                    for(Product p : products){
                        if(p.getId() == id){
                            found = true;
                            System.out.print("Enter discount percentage: ");
                            double percentage = sc.nextDouble();
                            p.discount(percentage);
                            System.out.println("===========================================");
                            System.out.println("Discount applied. New price for product " + p.getName()+": "+ p.getPrice());
                            System.out.println("===========================================");
                        }
                    }
                    if(!found){
                        System.out.println("=====================");
                        System.out.println("Product ID not found.");
                        System.out.println("=====================");
                    }
                    break;
                case 4:
                        System.out.print("Enter product ID to apply PUT UP: ");
                        id = sc.nextInt();
                        for(Product p : products){
                            if(p.getId() == id){
                            found = true;
                            System.out.print("Enter PUT UP percentage: ");
                            double percentage = sc.nextDouble();
                            p.putUp(percentage);
                            System.out.println("===========================================");
                            System.out.println("PUT UP applied. New price for product " + p.getName()+": "+ p.getPrice());
                            System.out.println("===========================================");
                        }
                    }
                    if(!found){
                        System.out.println("=====================");
                        System.out.println("Product ID not found.");
                        System.out.println("=====================");
                    }
                    break;
                case 5:
                    System.out.print("Enter the product's ID: ");
                    id = sc.nextInt();
                    for (int i = 0 ; i < products.size() ; i++ ) {
                        if((products.get(i)).getId() == id){
                            found = true;
                            products.remove(products.get(i));
                            System.out.println("=========================");
                            System.out.println("Product removed succefuly");
                            System.out.println("=========================");
                            break;
                        }
                        if (!found) {
                            System.out.println("=====================");
                            System.out.println("Product ID not found.");
                            System.out.println("=====================");
                        }
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("=================");
                    System.out.println("invalid input !!!");
                    System.out.println("=================");
                    break;
            }
        }
        

        sc.close();
    }

}
