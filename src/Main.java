/**Automatically creates a budget from an input file.
 * 
 * @author Daniel Grimm
 * @version 0.0
 */

import java.io.File;                    //For file I/O
import java.io.FileNotFoundException;   //File I/O
import java.util.ArrayList;             //Flexible data
import java.util.Scanner;               //For reading in from files

public class Main {

    public static void displayInfo() {
        //
    }

    /**Prints the content of the input file to the console.
     * 
     * @param title
     * @param grossIncome
     * @param taxBracket
     * @param tithe
     * @param rent
     * @param food
     * @param gas
     */
    public static void printFile(String title, int grossIncome, int taxBracket, int tithe, int rent, int food, int gas) {
        //Print the contents of the input file
        System.out.println(title);
        System.out.println("Gross income:\t$" + grossIncome);
        System.out.println("Tax rate:\t" + taxBracket + "%");
        System.out.println("Tithe rate:\t" + tithe + "%");
        System.out.println("Rent:\t\t$" + rent);
        System.out.println("Food:\t\t$" + food + " per week");
        System.out.println("Gas:\t\t$" + gas + " per week");
    }

    /**Prints the cost of expenses for the month to the console
     * 
     * @param grossIncome
     * @param taxBracket
     * @param tithe
     * @param rent
     * @param food
     * @param gas
     */
    public static void printExpenses(int grossIncome, int taxBracket, int tithe, int rent, int food, int gas) {
        //Print expenses
        double total = (double) grossIncome;
        System.out.println();
        System.out.println("Expenses");

        //Print taxes
        System.out.println("Tax: $" + total + " - $" + (Calculator.percentOf(total, (double) taxBracket)));
        total -= (Calculator.percentOf((double) total, (double) taxBracket));
        System.out.println("\t$" + total);

        //Print Tithe
        System.out.println("\nTithe: $" + total + " - $" + Calculator.percentOf((double) grossIncome, (double) tithe));
        total -= Calculator.percentOf((double) grossIncome, (double) tithe);
        System.out.println("\t$" + total);

        //Print Rent
        System.out.println("\nRent: $" + total + " - $" + rent);
        total -= rent;
        System.out.println("\t$" + total);

        //Print Food
        System.out.println("\nFood: $" + total + " - $" + (food * 4));
        total -= food;
        System.out.println("\t$" + total);

        //Print Gas
        System.out.println("\nGas: $" + total + " - $" + (gas * 4));
        total -= gas;
        System.out.println("\t$" + total);
    }

    public static void printSubscriptions() {
        //
    }
    
    /**Closes sytem resources and prints runtime information.
     * 
     * @param file
     * @param startTime
     */
    public static void endProgram(Scanner file, long startTime) {
        //End of program, close resources
        file.close();
        long endTime = System.currentTimeMillis();
        long runtime = endTime - startTime;
        //runtime /= 1000; //Convert to seconds
        System.out.println("\nRun time: " + runtime + " milliseconds");
    }

    /**Runs the main program.
     * 
     * @param args
     */
    public static void run(String[] args) {
        //Timer
        long startTime = System.currentTimeMillis();

        //Get the input text file
        String inputFile = null;
        
        try {
            inputFile = args[0];
        } catch (Exception e) {
            System.out.println("No file provided, program exiting.");
            System.exit(0);
        }

        System.out.println("Reading from file " + inputFile + "\n");
        Scanner file = null;

        try {
            file = new Scanner(new File(inputFile));
        } catch (FileNotFoundException fnfe) {
            System.out.println("File " + inputFile + " not found.");
            System.exit(0);
        }

        //Variables to read from the input file
        String title = null;
        int grossIncome = -1;
        int taxBracket = -1;
        int tithe = -1;
        int rent = -1;
        int food = -1;
        int gas = -1;

        try {
            //Read in values 
            title = file.nextLine();
            grossIncome = file.nextInt();
            taxBracket = file.nextInt();
            tithe = file.nextInt();
            rent = file.nextInt();
            food = file.nextInt();
            gas = file.nextInt();
            
        } catch (Exception e) {
            System.out.println("Bad input from file " + inputFile);
            System.exit(0);
        }

        printFile(title, grossIncome, taxBracket, tithe, rent, food, gas);

        printExpenses(grossIncome, taxBracket, tithe, rent, food, gas);

        printSubscriptions();

        endProgram(file, startTime);
    }
    
    public static void main(String[] args) {
        run(args);
    }
}