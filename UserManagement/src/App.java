import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import Storage.UserFileStorage;
import UI.Menu;
import model.User;
import Service.UserService;;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String filePath = "UserManagement\\src\\Users.txt";
        Menu menu = new Menu();
        UserFileStorage storage = new UserFileStorage(filePath);
        ArrayList<User> users = new ArrayList<>(storage.loadUsers());
        UserService service = new UserService(users);
        System.out.println("***Welcome to User Management***");
        boolean exit = false;
        while (!exit) {
            int choice = 0;
            menu.show();
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Please Enter An Integer!!!");
                
            }
            switch (choice) {
                case 1:
                    service.addUser();
                    break;
                case 2:
                    if (users.size() != 0) {
                    service.deleteUser(menu.inputId());
                    }else{
                        System.out.println("There is no User !!!");
                    }
                    break;
                case 3:
                    service.getAllUsers();
                    break;
                case 4:
                    exit = true;
                    storage.saveUser(users);
                    System.out.println("Exiting User Management System...");
                    break;
                default:
                    System.out.println("Invalid input(1.2.3.4)!!!!");
                    break;
            }
        }

        sc.close();
    }
}
