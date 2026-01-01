import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        double[] grades = new double[5];
            
        for(int i = 0; i < 5; i++){
            System.out.print("Enter ur "+(i+1)+" grade: ");
            double grade = sc.nextDouble();
            grades[i]=(grade);
        }
            
        System.out.println("Max grade: " + getMax(grades));
        System.out.println("Min grade: " + getMin(grades));
        System.out.println("Sum of grades: " + getSum(grades));
        
        System.out.println("Average grade: " + calculateAverage(grades));
        sc.close();
    }
    public static double getMax(double[] grades){
        double max = grades[0];
        for(int i = 0; i < grades.length; i++){
            if(grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }
    public static double getMin(double[] grades){
        double min = grades[0];
        for(int i = 0; i < grades.length; i++){
            if(grades[i] < min) {
                min = grades[i];
            }
        }
        return min;
    }
    public static double calculateAverage(double[] grades){
        double sum = 0;
        for(int i = 0; i < grades.length; i++){
            sum += grades[i];
        }
        double average = sum/grades.length;
        return average;
    }

    public static double getSum(double[] grades){
        double sum = 0;
        for(int i = 0; i < grades.length; i++){
            sum += grades[i];
        }
        return sum;
    }
}
