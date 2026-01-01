import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double number = sc.nextDouble();
        System.out.print("how many multiples you want to see ? ");
        int multiples = sc.nextInt();
        System.out.println("================================");
        printTable(number, multiples);
        sc.close();
    }
    public static void printTable(double number, int multiples){
        System.out.println("Multiplication table of " + number + ":");
        for(int i =0 ; i<multiples;i++){
            System.out.printf("%.2f x %d = %.2f%n",number,i,(number*i));
        }
    }
}
