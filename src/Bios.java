/**This class contains the cli format of the Budget Tools program.
 * 
 * @since May 21st, 2019
 * @version 0.0
 */

import java.io.File;                    //For file I/O
import java.io.FileNotFoundException;   //File I/O
import java.io.IOException;             //File I/O
import java.util.ArrayList;             //Flexible data
import java.util.Scanner;               //For reading in from files

 public class Bios {
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

    /**This method prints out the final results of the program.
     * 
     * @param grossIncome
     * @param total
     */
    private static void finalOutput(double grossIncome, double total) {
        //Print out total statistics
        System.out.println("Extra money: $" + total + "\n");
        double expenses = Math.round(grossIncome - total);
        System.out.println("Total expenses: $" + expenses + "\n");

        System.out.println("Expenses per week: $" + (expenses / 4) + "\n");
        System.out.println("Spending money per week: $" + (total / 4) + "\n");
    }

    /**This method prints the results of the file to the console.
     * The first four lines of the input file are expected to be:
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
    private static void printData(String title, ArrayList<String> expenses, ArrayList<Double> cost) {
        System.out.println("\n" + title);
        System.out.println("\nGenerating Budget:\n");

        double total = cost.get(0).doubleValue();
        double grossIncome = total;

        //Print monthly
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

        finalOutput(grossIncome, total);
        //Print out meta statistics
        // System.out.println("Extra money: $" + total + "\n");
        // System.out.println("Total expenses: $" + Math.round(grossIncome - total) + "\n");
    }
    
 }