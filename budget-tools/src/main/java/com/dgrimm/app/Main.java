package com.dgrimm.app;

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
 */

import java.io.File;                    //For file I/O
//import java.io.FileNotFoundException;   //File I/O
import java.io.IOException;             //File I/O
import java.net.URI;                    //For getting file from the Internet
import java.util.Scanner;               //For reading in from files

public class Main {

    /**Closes the system resources and prints runtime information
     * 
     * @param startTime
     */
    private static void endProgram(long startTime) {
        long endTime = System.currentTimeMillis();
        long runtime = endTime - startTime;
        //runtime /= 1000; //Convert to seconds
        System.out.println("\nRun time: " + runtime + " milliseconds");
    }

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

    private static File promptInputFile() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Where is your input file located?");
        String input = userInput.nextLine();
        return new File("");
    }

    /**Runs the main program.
     * 
     * @param args
     */
    private static void run(String[] args) {
        //Timer
        long startTime = System.currentTimeMillis();

        File input = promptInputFile();

        Scanner file = null;

        //File not found
        try {
            file = new Scanner(input);
        } catch (Exception e) {
            System.out.println("File " + file + " not found.");
            endProgram(startTime);
            System.exit(0);
        }

        //File not formatted correctly.
        try {
            Bios.displayInfo(file);
        } catch (IOException e) {
            System.out.println("Bad input.");
            System.exit(0);
        }

        /** ---------------- Run Output in Firefox ------------------ */
        //Runtime cmd = new Runtime();
        //cmd.exec("firefox " + outputFile);

        //Display program statistics
        endProgram(file, startTime);
    }
    
    public static void main(String[] args) {
        run(args);
    }
}
