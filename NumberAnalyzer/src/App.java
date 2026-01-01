import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int value=0;
        int sum = 0;
        System.out.print("Enter an integer value: ");
        value = sc.nextInt();
        int temp = Math.abs(value);
        // String s = String.valueOf(value);
        // char[] digits = s.toCharArray();

        if(value % 2 == 0){
            System.out.println(value + " is an even number.");
        }else {
            System.out.println(value + " is an odd number.");
        }
        if(value == 0){
            System.out.println("The number is zero.");
        }else if(value > 0){
            System.out.println("The number is positive.");
        }else{
            System.out.println("The number is negative.");
        }
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        // for(int i = 0; i < digits.length; i++){
        //     if(digits[i] == '-') {
        //         i++;
        //     }
        //     String stringValue = String.valueOf(digits[i]);
        //     sum += Integer.parseInt(stringValue);
        // }

        System.out.println("The sum of the digits is: " + sum);
        sc.close();
    }
}
