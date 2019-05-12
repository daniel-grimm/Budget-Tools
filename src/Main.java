/**Automatically creates a budget from an input file.
 * 
 * This program accepts a txt file as a data input. The file is expected to have to
 * following structure:
 * 
 * Title
 * Monthly_Income Integer_Value
 * Tax_Bracket Tax_Bracket_Percent
 * Tithe Percent_Value
 * Savings_Percent Percent_Value
 * Monthly_Expense Double_Value
 * Monthly_Expense Double_Value
 * ...
 * end
 * 
 * For good design, put your re-occurring payments at the top of the list and
 * one-off purchases at the bottom
 * 
 * @author Daniel Grimm
 * @version 0.1
 */

import java.io.File;                    //For file I/O
import java.io.FileNotFoundException;   //File I/O
import java.io.IOException;             //File I/O
import java.util.ArrayList;             //Flexible data
import java.util.Scanner;               //For reading in from files

public class Main {

    /**Prints the contents of the file and expenses to the console
     * 
     * @param file
     */
    public static void displayInfo(Scanner file) throws IOException {
        ArrayList<String> expenses = new ArrayList<String>();   //Title of each expense
        ArrayList<Double> costs = new ArrayList<Double>();      //Cost of each expense (Cost per month)
        String title = file.nextLine();
        String name = file.next();
        Double cost;
        while (!name.equals("end")) {
            cost = new Double(file.next());
            expenses.add(name);
            costs.add(cost);
            name = file.next();
        }

        printData(title, expenses, costs);
    }

    /**Displays the deductions for monthly expenses that are deducted by percent.
     * 
     * @param expense
     * @param percent
     * @param grossIncome
     * @param total
     * @return
     */
    private static double printPercents(String expense, double percent, double grossIncome, double total) {
        System.out.println(expense + ": " + percent + "%");
        double minusValue = Calculator.percentOf(grossIncome, percent);
        System.out.print("\t$" + total + " - $" + minusValue);
        total -= minusValue;
        System.out.println(" = $" + total + "\n");
        return total;
    }

    /**This method prints the results of the file to the console.
     * The first four lines are expected to be:
     * Monthly Income
     * Tax Percent
     * Tithe Percent
     * Investment/Savings Percent.
     * 
     * Deviation from this will result in erroneous output.
     * 
     * @param title
     * @param expenses
     * @param cost
     */
    public static void printData(String title, ArrayList<String> expenses, ArrayList<Double> cost) {
        System.out.println("\n" + title);
        System.out.println("\nGenerating Budget:\n");

        double total = cost.get(0).doubleValue();
        double grossIncome = total;

        System.out.println(expenses.get(0) + ": $" + cost.get(0) + "\n");

        //Print tax deductions
        total = printPercents(expenses.get(1), cost.get(1), grossIncome, total);

        //Print tithe deductions
        total = printPercents(expenses.get(2), cost.get(2), grossIncome, total);

        //Print investments/savings deductions
        total = printPercents(expenses.get(3), cost.get(3), grossIncome, total);

        //Subtract everything that is not a percent deduction
        for (int i = 4; i < expenses.size(); i++) {
            System.out.println(expenses.get(i) + ": $" + cost.get(i));
            System.out.print("\t$" + total + " - $" + cost.get(i));
            total -= cost.get(i);
            System.out.println(" = $" + total + "\n");
        }

        System.out.println("Extra money: $" + total);
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

        try {
            displayInfo(file);
        } catch (IOException e) {
            System.out.println("Bad input.");
            System.exit(0);
        }

        endProgram(file, startTime);
    }
    
    public static void main(String[] args) {
        run(args);
    }
}