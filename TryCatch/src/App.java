import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int choice;
        while(!exit){
            choice = 0;
            double first = 0 ,second = 0;
            System.out.println("1. FOR ADD");
            System.out.println("2. FOR MINES");
            System.out.println("3. FOR MULTIPLICATION");
            System.out.println("4. FOR DIVISION");
            System.out.println("5. EXIT");
            System.out.print("Ur choice: ");
            try{
                choice = sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Choice should be int");
                sc.next();
                continue;
            }
            double[] nums;
            switch (choice) {
                case 1:
                    nums = getTwoNumbers(sc);
                    System.out.println(nums[0]+" + "+nums[1] +" = "+(nums[0]+nums[1]));
                    break;
                case 2:
                    
                    nums = getTwoNumbers(sc);
                    System.out.println(nums[0]+" - "+nums[1] +" = "+(nums[0]-nums[1]));
                    break;
                case 3:
                    nums = getTwoNumbers(sc);
                    System.out.println(nums[0]+" x "+nums[1] +" = "+(nums[0]*nums[1]));
                    break;
                case 4:
                    nums = getTwoNumbers(sc);
                    double result = 0;
                    result = nums[0]/nums[1];
                    if(nums[1]!=0){
                        System.out.println(first+" / "+second +" = "+result);
                    }else{
                        System.out.println("U can't devide by 0!!!");
                    }
                    break;
                case 5:
                    exit = true;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
        System.out.println("Good BYE !!!!");
        sc.close();
    }
    static double[] getTwoNumbers(Scanner sc)
    {
        double[] nums = new double[2];
        while (true){
            try {
                System.out.print("Ur first number: ");
                nums[0] = sc.nextDouble();
                System.out.print("Ur second number: ");
                nums[1] = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number!!!");
                sc.next();
            }
        }
        return nums;
        
        
    }
    
}
