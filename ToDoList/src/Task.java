import java.util.Scanner;

public class Task {
    private String name;
    private String state;

    public Task(String name,String state){
        this.name = name;
        this.state = state;
    }
    public void saisir(Scanner sc){
        sc.nextLine();
        System.out.print("Saisie le nom: ");
        this.name = sc.nextLine();
        System.out.print("Saisie l'état: ");
        this.state = sc.nextLine();
    }
    public void afficher(){
        
        System.out.println("Task Name is: "+this.name+" | its State is: "+this.state);
        
    }
    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }
    public String getName(){
        return this.name;
    }
}
