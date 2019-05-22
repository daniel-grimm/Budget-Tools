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

 package src;

import java.io.File;                    //For file I/O
import java.io.FileNotFoundException;   //File I/O
import java.io.IOException;             //File I/O
import java.util.Scanner;               //For reading in from files
import gui.*;                           //Make this program into a gui
import cli.*;                           //CLI output of the program

public class Main {

    /**Closes sytem resources and prints runtime information.
     * 
     * @param file
     * @param startTime
     */
    private static void endProgram(Scanner file, long startTime) {
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
    private static void run(String[] args) {
        //Timer
        long startTime = System.currentTimeMillis();

        //Get the input text file
        String inputFile = null;
        
        //No file
        try {
            inputFile = args[0];
        } catch (Exception e) {
            System.out.println("No file provided, program exiting.");
            System.exit(0);
        }

        //initialize variables for later
        Scanner file = null;
        File inFile = null;

        //File not found
        try {
            inFile = new File(inputFile);
            file = new Scanner(inFile);
        } catch (FileNotFoundException fnfe) {
            System.out.println("File " + inputFile + " not found.");
            System.exit(0);
        }

        System.out.println("Reading from file " + inFile.getAbsolutePath() + "\n");

        //File not formatted correctly.
        try {
            Bios.displayInfo(file);
        } catch (IOException e) {
            System.out.println("Bad input.");
            System.exit(0);
        }

        Home.drawGui(args);

        //Display program statistics
        endProgram(file, startTime);
    }
    
    public static void main(String[] args) {
        run(args);
    }
}