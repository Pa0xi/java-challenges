import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            Accounts account1 = new Accounts("Mouaad", 1000, 1234);
            Accounts account2 = new Accounts("Doha", 500,1234);
            ArrayList<Accounts> accountsList = new ArrayList<>();
            Accounts ConnectedAccount = null;
            boolean found = false;
            boolean authenticated = false;
            boolean exit = false;
            boolean globalExit = false;
            accountsList.add(account1);
            accountsList.add(account2);
            System.out.println("Welcome to the Banking System");
            while (!globalExit) {
                found = false;
                authenticated = false;
                ConnectedAccount = null;
                exit = false;

                System.out.println("1. Login");
                System.out.println("2. Exit");
                System.out.print("Choose an option: ");
                int mainChoice = 0;
                try {
                    mainChoice = sc.nextInt();
                } catch (Exception e) {
                    System.out.print("Error try again: ");
                    sc.next();
                }
                sc.nextLine(); 
                if(mainChoice == 1){
                    System.out.print("Enter owner name: ");
            String ownerName = sc.nextLine();
            for(Accounts account : accountsList) {
                if(account.getownerName().equals(ownerName)) {
                    found = true;
                    System.out.print("Enter password:");
                    int password = sc.nextInt();
                    if(account.checkPassword(password)) {
                        ConnectedAccount = account;
                        authenticated = true;
                        break;
                    }else {
                        System.out.println("Incorrect password.");
                        authenticated = false;
                    }
                }
                
            }
            
            if(found && authenticated) {
                while(!exit){
                    System.out.println("Welcome, " + ConnectedAccount.getownerName());
                    System.out.println("1. Deposit\n2. Withdraw\n3. Display Info\n4. Exit");
                    System.out.print("Choose an option: ");
                    int choice = sc.nextInt();
                    switch(choice){
                        case 1:
                            System.out.print("Enter ur deposit amount: ");
                            double depositAmount = sc.nextDouble();
                            ConnectedAccount.deposit(depositAmount);
                            break;
                            case 2:
                                System.out.print("Enter ur withdraw amount: ");
                                double withdrawAmount = sc.nextDouble();
                                ConnectedAccount.withdraw(withdrawAmount);
                                break;
                                case 3:
                                    ConnectedAccount.displayInfo();
                                    break;
                                    case 4:
                                        exit = true;
                                        break;
                                    }
                                }
                            }else if (!found) {
                                System.out.println("Account not found.");
                            }
                            
                }else if(mainChoice == 2){
                    globalExit = true;
                }else{
                    System.out.println("Invalid option. Please try again.");
                    continue;
                }
                        }
                            System.out.println("Exiting the system.");
            
        }catch(Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
}
}
