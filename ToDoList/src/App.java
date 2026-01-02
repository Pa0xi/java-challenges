import java.util.ArrayList;
import java.util.InputMismatchException;

import java.util.Scanner;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;


public class App {
    public static void main(String[] args) throws Exception {
        String filePath = "src\\Task.txt";
        ArrayList<Task> tasks = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader(filePath));
        
        String readStrings;
        String[] readArray;
        while ((readStrings = buffer.readLine()) != null) {
                readArray = readStrings.split(",");
                tasks.add(new Task(readArray[0], readArray[1]));
            }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to to-do List");
        boolean exit = false;
        int choice = 0;
        while(!exit){
            boolean found = false;
            String TaskName = null;
            String NewState = null; 
            
            choice = 0;
            String delete="";
            System.out.println("====================");
            System.out.println("1. ADD TASK");
            System.out.println("2. DELETE TASK");
            System.out.println("3. SHOW TASKS");
            System.out.println("4. EDIT TASK'S STATE");
            System.out.println("5. EXIT");
            System.out.println("====================");
            System.out.print("Ur choice: ");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Please enter a number !!!");
                sc.next();
            }
            switch (choice) {
                case 1:
                    System.out.println("===============");
                    Task task = new Task(null, null);
                    task.saisir(sc);
                    for (Task t3 : tasks) {
                        if ((task.getName()).equalsIgnoreCase(t3.getName())) {
                            found = true;
                        }
                    }
                    if(found){
                        System.out.println("Task with this name: "+task.getName()+" Already exist!!!");
                    }else{
                        tasks.add(task);
                        System.out.println("Task created successfully !!!");
                    }
                    break;
                case 2:
                    if (tasks.size() != 0) {
                        System.out.print("Enter ur task name: ");
                        sc.nextLine();
                        TaskName = sc.nextLine();
                    for (int i = 0; i < tasks.size(); i++) {
                        if (TaskName.equalsIgnoreCase(tasks.get(i).getName())) {
                            found = true;
                            System.out.print("U really want to delete it(y/n): ");
                            delete = sc.nextLine();
                            if(delete.startsWith("Y")||delete.startsWith("y")){
                                tasks.remove(i);
                                System.out.println("Task deleted successfully");
                                break;
                            }else{
                                System.out.println("U good");
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("no task match this name: "+ TaskName);
                    }
                    }else{
                        System.out.println("No Task !!!!");
                    }
                    break;
                case 3:
                    if (tasks.size() != 0) {
                        System.out.println("There"+(tasks.size()==1?" is":" are")+": "+tasks.size()+(tasks.size()==1?" task":" tasks"));
                        System.out.println("==================================");
                        for (Task t : tasks) {
                            t.afficher();
                        }
                        System.out.println("==================================");
                    }else{
                        System.out.println("No task !!!!");
                    }
                    break;
                case 4:
                    if (tasks.size() != 0) {
                        System.out.print("Enter ur task name: ");
                        sc.nextLine();
                        TaskName = sc.nextLine();
                    for (Task t2 : tasks) {
                        if (TaskName.equalsIgnoreCase(t2.getName())) {
                            System.out.print("Enter ur new state: ");
                            NewState = sc.nextLine();
                            t2.setState(NewState);
                            System.out.println("Task edited successfully");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("no task match this name: "+ TaskName);
                    }
                    }else{
                        System.out.println("No Task !!!!");
                    }
                    break;
                case 5:
                    exit = true;
                    try (FileWriter writer = new FileWriter(filePath)) {
                            
                            while((readStrings = buffer.readLine()) == null) {
                                for (Task task2 : tasks) {
                                    writer.write(task2.getName()+","+task2.getState());
                                    writer.write("\n");
                                }
                                break;
                            }
                        
                        } catch (Exception e) {
                            System.err.println("err ");
                        }
                    break;
                default:
                    System.out.println("invalid input !!");
                    break;
            }
        }
        System.out.println("GOOD BYE !!!");
        buffer.close();
    }
}
