public class Accounts {
    private String ownerName;
    private double Balance;
    private int password;

    public Accounts(String ownerName, double initialBalance, int password) {
        this.ownerName = ownerName;
        this.Balance = initialBalance;
        this.password = password;
    }
    

    public String getownerName() {
        return ownerName;
    }
    public double getBalance() {
        return Balance;
    }
    public boolean checkPassword(int input) {
        return password == input;
    }

    public void deposit(double amount){
        if(amount > 0){
            Balance += amount;
        }else{
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= Balance){
            Balance -= amount;
        }else if(amount > Balance){
            System.out.println("Insufficient funds for withdrawal.");
        }else{
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void displayInfo(){
        System.out.println("Owner: " + ownerName + ", Balance: $" + Balance);
    }
}
