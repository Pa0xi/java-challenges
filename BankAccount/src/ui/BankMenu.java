package ui;
import java.util.*;

import inputhandle.InputHandle;
import model.Account;
public class BankMenu {
    public BankMenu(){}

    public int login(Scanner sc){
        int mainChoice = 0;
        System.out.println("1. Login");
        System.out.println("2. Create account");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        try {
            mainChoice = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("Error try again: ");
        } 
        return mainChoice;
    }

    public int choic(Account ConnectedAccount,Scanner sc){
        System.out.println("Welcome, " + ConnectedAccount.getownerName());
        System.out.println("1. Deposit\n2. Withdraw\n3. Display Info\n4. Exit");
        System.out.print("Choose an option: ");
        int choice = InputHandle.integerInput(sc);
        return choice;
    }
}
