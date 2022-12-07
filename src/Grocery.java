import java.util.Scanner;
import java.util.*;
/**
 * The Grocery class represents the price of groceries, array lists and has a string name
 */

public class Grocery {
    private double applePrice;
    private double avoPrice;
    private double tomatoPrice;
    private List<String> shoppingCart = new ArrayList<>();
    private List<Integer> numOfItems = new ArrayList<>();
    private String name;

    /**
     * Constructor for Grocery class. This initializes the price of each grocery and name
     */
    public Grocery(){
        applePrice = 0.99;
        avoPrice = 1.10;
        tomatoPrice = 0.5;
        name = "";
    }

    /**
     * Constructor for Grocery class.
     *
     * @param name represents the name that the user inputted
     */
    public Grocery(String name){
        this.name = name;
    }

    /**
     * toString method for the Grocery class. This method will return a String greeting the
     * user using the name they inputted
     *
     * @return returns a String in a properly formatted sentence con
     */
    public String toString(){
        return "Hello, " + name + "!";
    }

    /**
     * The groceryInto method will introduce the user to the grocery store and the clerk, Alexa.
     * Alexa will ask the user if they want to see what the store has
     */
    public void groceryIntro(){
        Scanner scan = new Scanner(System.in);
        System.out.println("-----Welcome to the Grocery Store!-----");
        System.out.println("I'm the clerk. My name is Alexa.");
        System.out.println("Do you want to see what we have here? (y/n)");
        String userInput = scan.nextLine();
        if(userInput.equals("y")){
            System.out.println("We have apples (0.99 cents ea), avocados (1.10 ea), and tomatoes (0.50 ea)");
        }else if(userInput.equals("n")){
            System.out.println("You're an L. I'm going to show it anyway.");
            System.out.println("We have apples (0.99 cents ea), avocados (1.10 ea), and tomatoes (0.50 ea)");
        }else{
            System.out.println("What you inputted isn't y or n. Rerun the program and answer correctly.");
            System.exit(0);
        }
    }

    /**
     * The whatUserWants method will ask the user what they want and uses while loops to make sure the user inputs a valid input
     *
     * @param userWants represents the user's input of what grocery they want from the store
     */
    public void whatUserWants(String userWants){
        Scanner scan = new Scanner(System.in);
        int count_of_userWants = 1;
        int count_of_items = 1;
        if(userWants.equals("nothing")){
            System.out.println("Alexa kicked you out the store :)");
            System.exit(0);
        }

        //checks if userWants is a valid input
        while (!userWants.equals("apples") && !userWants.equals("avocados") && !userWants.equals("tomatoes")) {
            System.out.println("What you inputted is not apples, avocados, or tomatoes and you can't enter nothing this time! Enter a valid input");
            userWants = scan.nextLine();
            if (count_of_userWants > 2 && !userWants.equals("apples") && !userWants.equals("avocados") && !userWants.equals("tomatoes")) {
                System.out.println("Alexa kicked you out the store :)");
                System.exit(0);
            }
            count_of_userWants++;
        }
        //puts userWants into a list
        shoppingCart.add(userWants);

        System.out.println("How many do you want?");
        int howManyUserWants = scan.nextInt();

        //checks if user entered a negative number
        while (howManyUserWants < 1) {
            System.out.println("How am I supposed to give you that??? Choose a number greater than zero");
            howManyUserWants = scan.nextInt();
            if (count_of_items > 2 && howManyUserWants < 1) {
                System.out.println("Alexa kicked you out the store :)");
                System.exit(0);
            }
            count_of_items++;
        }
        //puts the amount in a list
        numOfItems.add(howManyUserWants);
    }

    /**
     * The anythingElse method will ask the user if there is anything else the user wants, but the user is unable to put in anything else they want
     */
    public void anythingElse(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to buy anything else? (y/n)");
        String wantAnythingElse = scan.nextLine();
        if(wantAnythingElse.equals("y")){
            System.out.println("I don't like you so you can't buy anything else");
        }else if(wantAnythingElse.equals("n")){
            System.out.println("Great!");
        }else{
            System.out.println("You entered an invalid input, so I'm just going to take that as a no");
        }
    }

    /**
     * The Calculate method will calculate the price of the item the user wants multiplied how many the user wants
     *
     * @return returns a double of the user's total
     */
    public double Calculate(){
        //calculates the user's total price
        if((shoppingCart.get(0)).equals("apples")){
            return (double)Math.round(applePrice * numOfItems.get(0) * 100)/100;
        }else if((shoppingCart.get(0)).equals("avocados")){
            return (double)Math.round(avoPrice * numOfItems.get(0) * 100)/100;
        }else{
            return (double)Math.round(tomatoPrice * numOfItems.get(0) * 100)/100;
        }
    }

    /**
     * The totalToString method prints a string that tells the user what their total is
     */
    public void totalToString(){
        System.out.println("Your total is: $" + Calculate() + "\n" + "There's a special event today!");
    }

    /**
     * The specialEvent method takes user input and checks if the number they inputted is equal to Alexa's number
     * and if it is, the user gets their groceries for free
     */
    public void specialEvent(){
        //uses Math.random() for a chance to get free groceries
        Scanner scan = new Scanner(System.in);
        System.out.println("I will choose a number between 1 and 10." + "\n" + "If you guess that number, you will get your groceries for free!" + "\n" + "Your guess: ");
        int alexasChoice = (int)(Math.random() * 10) + 1;
        int usersChoice = scan.nextInt();
        System.out.println("My choice was " + alexasChoice);
        if(usersChoice == alexasChoice){
            System.out.println("Congrats! You get your groceries for free!");
        }else{
            System.out.println("HA! You didn't get your groceries for free!");
        }
    }
}

