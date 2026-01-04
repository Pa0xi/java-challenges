package service;
import java.util.Scanner;

import inputhandle.InputHandle;
import model.Account;
public class AccountGestion {
    public AccountGestion(){}

    public void deposit(Account ConnectedAccount,Scanner sc){
        System.out.print("Enter ur deposit amount: ");
        double depositAmount = InputHandle.doubleInput(sc);
        ConnectedAccount.deposit(depositAmount);
    }

    public void withdraw(Account ConnectedAccount,Scanner sc){
        System.out.print("Enter ur withdraw amount: ");
        double withdrawAmount = InputHandle.doubleInput(sc);
        ConnectedAccount.withdraw(withdrawAmount);
    }
}
