import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        reverArray(numbers);
        
        System.out.println("Reversed array: " + Arrays.toString(numbers));
        
        System.out.print("what number do you want to find the index of? ");
        int target = sc.nextInt();
        
        searchNumber(numbers, target);
        sc.close();
    }
    public static void reverArray(int[] numbers){
        int left = 0;
        int right = numbers.length - 1;
    
            while(left < right){
                int temp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = temp;
                left++;
                right--;
            }
    }
    public static void searchNumber(int[] numbers,int target){
        boolean found = false;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == target){
                found = true;
                System.out.println("The index of " + target + " is: " + i);
                break;
            }
        }
        if(!found){
            System.out.println(target + " is not in the array.");
        }
    }
}
