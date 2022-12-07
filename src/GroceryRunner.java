import java.util.Scanner;
public class GroceryRunner {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        Grocery grocery = new Grocery();
        System.out.println("What's your name?");
        String name = scan.nextLine();
        Grocery nameUser = new Grocery(name);
        System.out.println(nameUser);
        grocery.groceryIntro();
        System.out.println("What do you want to buy? Enter one of the three things we have or enter nothing");
        String userWants = scan.nextLine();
        grocery.whatUserWants(userWants);
        grocery.anythingElse();
        grocery.totalToString();
        grocery.specialEvent();
    }
}

