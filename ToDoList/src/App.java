import java.util.ArrayList;
import java.util.Scanner;
import model.Task;
import ui.Menu;
import service.*;
import storage.TaskFileStorage;


public class App {
    public static void main(String[] args) throws Exception {
        String filePath = "src\\Task.txt";
        TaskFileStorage storage = new TaskFileStorage(filePath);
        ArrayList<Task> tasks = new ArrayList<>(storage.loadUsers());
        TaskService service = new TaskService(tasks);
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to to-do List");
        boolean exit = false;
        int choice = 0;
        while(!exit){
            menu.showMenu();
            choice = inputInt(sc);
            switch (choice) {
                case 1:
                    service.addTask(sc);
                    break;
                case 2:
                    service.deleteTask(sc);
                    break;
                case 3:
                    service.getAllUsers();
                    break;
                case 4:
                    service.editUser(sc);
                    break;
                case 5:
                    exit = true;
                    
                    storage.saveUsers(tasks);
                    break;
                default:
                    System.out.println("invalid input !!");
                    break;
            }
        }
        System.out.println("GOOD BYE !!!");
    }
    public static int inputInt(Scanner sc){
        int number = 0;
        while(true){
            try {
                number = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.print("Please try a number: ");
            }
        }
        return number;
    }
}
