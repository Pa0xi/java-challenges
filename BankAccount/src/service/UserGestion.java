package service;
import model.Account;
import java.util.*;

import inputhandle.InputHandle;

public class UserGestion {
    List<Account> accounts;
    InputHandle inputHandle = new InputHandle();

    public UserGestion(List<Account> accounts){
        this.accounts = accounts;
    }

    public void addAccount(Scanner sc){
        boolean found = false;
        System.out.print("Enter Ur name: ");
        String nameTemp;
        String name ;
        while (true) {
            found = false;
            nameTemp = sc.nextLine();
            for (Account account : accounts) {
                if(nameTemp.equals(account.getownerName())){
                    found = true;
                }
            }
            if(found){
                System.out.println("User with this name: "+nameTemp+" Already exist!!");
                System.out.print("Try again: ");
            }else{
                name = nameTemp;
                break;
            }
        }
        if (!found) {
            System.out.print("Enter ur password: ");
            int password = InputHandle.integerInput(sc);
            Account account = new Account(name,0,password);
            accounts.add(account);
        }else{
            System.out.println("eror");
        }
        
    }

    public Account login(Scanner sc){
        System.out.print("Enter owner name: ");
        boolean found = false;
        boolean authenticated = false;
        Account ConnectedAccount = null;
        String ownerName = sc.nextLine();
            for(Account account : accounts) {
                found = false;
                authenticated  = false;
                if(account.getownerName().equals(ownerName)) {
                    found = true;
                    authenticated = false;
                    int attempts = 3;
                    int password;
                    while (attempts != 0 ) {
                        attempts--;
                        System.out.print("Enter password:");
                        password = InputHandle.integerInput(sc);
                        if(account.checkPassword(password)) {
                            ConnectedAccount = account;
                            authenticated = true;
                            break;
                        }else if(attempts > 0 ) {
                            System.out.println("Incorrect password try again.");
                            authenticated = false;
                        }
                    }
                    if(attempts <= 0){
                        System.out.println("Ur attempts run out try tomorrow!!!");
                    }
                }
            }
            if (!found) {
                System.out.println("No user match this name!!");
            }
            return ConnectedAccount;
        }
}
