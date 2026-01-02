package Service;
import model.User;
import java.util.*;
public class UserService {
    private final List<User> users;
    Scanner sc = new Scanner(System.in);

    public UserService(List<User> users){
        this.users = users;
    }

    public void addUser(){
        
        User user = new User();
        user.saisir(sc);
        boolean found = false;
        for (User user2 : users) {
            if (user2.getId()== user.getId()) {
                found = true;
            }
            if (!found) {
                users.add(user);
                System.out.println("User added succefully!!");
            }else{
                System.out.println("User with this ID already exixst!!!");
            }
            break;
        }
        
    }

    

    public void deleteUser(int id){
        boolean found = false;
        User user = new User();
        for (int i = 0 ; i < users.size(); i++) {
            if ((users.get(i)).checkId(id)) {
                found = true;
                user = users.get(i);
            }
        }
            if (!found) {
                System.out.println("No User exixst with this ID !!!");
            }else{
                users.remove(user);
                System.out.println("User deleted succefully!!");
            }
        
    }

    public void getAllUsers(){
        if(users.size()!= 0){
            for (User user : users) {
                System.out.println(user.afficher());
            }
        }else{
            System.out.println("There is no User !!!");
        }
    }
    
}
