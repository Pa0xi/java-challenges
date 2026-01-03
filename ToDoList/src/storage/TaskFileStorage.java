package storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.*;
public class TaskFileStorage {
    String filePath;
    
    public TaskFileStorage(String filePath){
        this.filePath = filePath;
    }

    public List<Task> loadUsers(){
        List<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return tasks;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length == 2){
                    String name = parts[0];
                    String state = parts[1];
                    
                    tasks.add(new Task(name,state));
                }
            }
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        
        return tasks;
    }

    public void saveUsers(List<Task> tasks){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task2 : tasks) {
                writer.write(task2.getName()+","+task2.getState());
                writer.newLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }
}
