import java.util.*;

public class User {
//users (id, name, email);
    private int id;
    String name,email;

    public User(){
        
    }

    public User(int id,String name,String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId(){
        return this.id;
    }

    public boolean checkId(int input){
        return this.id == input;
    }

    public void saisir(Scanner sc){
        System.out.print("Ur id: ");
        while (true) {
            try {
            this.id = Integer.parseInt(sc.nextLine());
            break;
        } catch (NumberFormatException e) {
            System.out.println("Try an integer");
        }
        }
        System.out.print("Ur name: ");
        this.name = sc.nextLine();
        System.out.print("Ur email: ");
        this.email = sc.nextLine();
    }

    public String afficher(){
        return  "The id is: "+this.id+" | Name is: "+this.name+" | The email is: "+this.email;
    }
}
