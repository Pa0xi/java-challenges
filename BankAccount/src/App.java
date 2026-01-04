import java.util.*;
import ui.BankMenu;
import model.Account;
import service.AccountGestion;
import service.UserGestion;
import storage.InfoSave;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            InfoSave infoSave = new InfoSave("src\\Users.txt");
            BankMenu menu = new BankMenu();
            ArrayList<Account> accountsList = new ArrayList<>(infoSave.loadUsers());
            UserGestion userGestion = new UserGestion(accountsList);
            AccountGestion accountGestion = new AccountGestion();
            boolean exit = false;
            boolean globalExit = false;
            System.out.println("Welcome to the Banking System");
            while (!globalExit) {
                Account ConnectedAccount = null;
                exit = false;
                int mainChoice = menu.login(sc);
                if(mainChoice == 1){
                    ConnectedAccount = userGestion.login(sc);
            if(ConnectedAccount != null) {
                while(!exit){
                    int choice = menu.choic(ConnectedAccount, sc);
                    switch(choice){
                        case 1:
                            accountGestion.deposit(ConnectedAccount, sc);
                            break;
                        case 2:
                            accountGestion.withdraw(ConnectedAccount, sc);
                            break;
                        case 3:
                            ConnectedAccount.displayInfo();
                            break;
                        case 4:
                                exit = true;
                            break;
                        default:
                            System.out.println("Enter a number between(1-4)!!!");
                            break;
                            }
                    }
                }
                }else if(mainChoice == 2){
                    userGestion.addAccount(sc);
                }
                else if(mainChoice == 3){
                    globalExit = true;
                }else{
                    System.out.println("Try a 1 or 2 or 3!!");
                    continue;
                }
                        }
                            System.out.println("Exiting the system.");
                            infoSave.saveUser(accountsList);
            
        }catch(Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
        
}

}
