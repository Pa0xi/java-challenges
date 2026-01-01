import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        System.out.println("***Welcome to User Management***");
        boolean exit = false;
        while (!exit) {
            int choice = 0;
            System.out.println("=======================");
            System.out.println("1. ADD USER");
            System.out.println("2. DELETE USER");
            System.out.println("3. SHOW USERS");
            System.out.println("4. EXIT");
            System.out.print("Ur choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Please Enter An Integer!!!");
                
            }
            boolean found = false;
            switch (choice) {
                case 1:
                    found = false;
                    User user = new User();
                    user.saisir(sc);
                    for (User u : users) {
                        if (u.getId() == user.getId()) {
                            found = true;
                        }
                    }
                    if (!found) {
                        users.add(user);
                        System.out.println("User created successfully!!!");
                    }else{
                        System.out.println("We have user with this ID: "+user.getId());
                    }
                    break;
                case 2:
                    if (users.size() != 0) {
                        System.out.print("Enter the user id: ");
                        int id = 0;
                        while(true){
                            try {
                            id = Integer.parseInt(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Id should be integer");
                        }
                        }
                        for (int i = 0 ; i < users.size(); i++) {
                            if(id == (users.get(i)).getId()){
                                found = true;
                                users.remove(i);
                                System.out.println("User deleted successsfully !");
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("No user found for id: "+id);
                        }
                    }else{
                        System.out.println("There is no User !!!");
                    }
                    break;
                case 3:
                    if (users.size() != 0) {
                        for (User u3 : users) {
                            System.out.println(u3.afficher());
                        }
                    }else{
                        System.out.println("There is no User !!!");
                    }
                    break;
                case 4:
                    exit = true;
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
