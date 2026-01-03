package service;
import java.util.List;
import java.util.Scanner;

import model.Task;
public class TaskService {
    List<Task> tasks;

    public TaskService( List<Task> tasks){
        this.tasks = tasks;
    }
    public void addTask(Scanner sc){
        Task task = new Task();
        boolean found = false;
        task.saisir(sc);
        for (Task t3 : tasks) {
            if ((task.getName()).equalsIgnoreCase(t3.getName())) {
                found = true;
                break;
            }
        }
        if(found){
            System.out.println("Task with this name: "+task.getName()+" Already exist!!!");
        }else{
            tasks.add(task);
            System.out.println("Task created successfully !!!");
        }
    }

    public void deleteTask(Scanner sc){
        String TaskName;
        String delete;
        boolean found = false;
        if (tasks.size() != 0) {
            System.out.print("Enter ur task name: ");
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
    }

    public void getAllUsers(){
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
    }

    public void editUser(Scanner sc){
        boolean found = false;
        String TaskName;
        String NewState;
        if (tasks.size() != 0) {
            System.out.print("Enter ur task name: ");
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
    }
}
