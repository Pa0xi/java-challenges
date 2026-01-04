package storage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
public class InfoSave {
    String filePath;

    public InfoSave(String filePath){
        this.filePath = filePath;
    }

    public List<Account> loadUsers(){
        List<Account> userAccounts = new ArrayList<>();
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            while ((line = reader.readLine())!= null) {
                String[] arrayStrings = line.split(",");
                // string,double,int
                String name = arrayStrings[0];
                double balance = Double.parseDouble(arrayStrings[1]);
                int password = Integer.parseInt(arrayStrings[2]);
                userAccounts.add(new Account(name, balance, password));
            }
        }catch (IOException | NumberFormatException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        return userAccounts;
    }

    public void saveUser(List<Account> accounts){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)) ){
            for (Account account : accounts) {
                writer.write(account.getownerName()+","+account.getBalance()+","+account.getPassword());
                writer.newLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }
}
