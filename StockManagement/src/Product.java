public class Product {
    private final int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    
    public void discount(double percentage) {
        if(percentage < 0 || percentage > 100) {
            System.out.println("Percentage must be between 0 and 100");
        }else{
            price -= price * (percentage / 100);
        }
    }
    public void putUp(double percentage) {
        if(percentage <= 0 ) {
            System.out.println("Percentage must be positif");
        }else{
            price += price * (percentage / 100);
        }
    }
}
