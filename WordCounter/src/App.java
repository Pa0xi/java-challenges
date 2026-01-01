import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String phrase;
        HashMap<String,Integer> list = new HashMap<>();
        System.out.print("enter ur phrase: ");
        phrase = sc.nextLine();
        phrase = phrase.replaceAll("[^a-zA-Z ]", "");
        System.out.println();
        String[] phrases = (phrase.split(" "));

        

        int x=0;
        int target = 0;
        while (target < phrases.length ) {
            x = 0;
            for (String s : phrases) {
                if(s.equals(phrases[target])){
                    x++;
                    list.put(s, x);
                }
            }
            target++;
        }

        // for (String s : phrases) {
        //     found = false;
        //     x = 0;
        
        //     for(int i = 0 ; i < phrases.length ; i++){
        //         if(s == phrases[i]){
        //             x++;
        //             found = true;
        //         }
        //     }
        //     if (found) {
        //         list.put(s, x);
        //     }
            
        // }
            
            list.forEach((key,value)-> System.out.println("the word: \""+key+"\" is showed up: "+value+(value==1?" time":" times")));
            sc.close();
        
    }
}
