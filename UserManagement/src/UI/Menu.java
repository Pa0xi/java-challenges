package UI;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public void show(){
        System.out.println(" ______________");
        System.out.println("|1. ADD USER   |");
        System.out.println("|2. DELETE USER|");
        System.out.println("|3. SHOW USERS |");
        System.out.println("|4. EXIT       |");
        System.out.println("|______________|");
        System.out.print("Ur choice: ");
    }
    public int inputId(){
    System.out.print("Enter the user id: ");
    int id = 0;
    while(true){
        try {
        id = Integer.parseInt(sc.nextLine());
        break;
    } catch (NumberFormatException e) {
        System.out.print("Id should be integer: ");
    }
    }
    return id;
    }
}
