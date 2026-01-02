package Storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserFileStorage {
    private final String filePath;

    public UserFileStorage(String filePath){
        this.filePath = filePath;
    }

    public List<User> loadUsers(){
        List<User> users = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return users;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length == 3){
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String email = parts[2];
                    
                    users.add(new User(id,name,email));
                }
            }
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        
        return users;
    }

    public void saveUser(List<User> users){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : users) {
                writer.write(user.getId() + "," + user.getName() + "," + user.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving users: " + e.getMessage());
        }
    }
}
