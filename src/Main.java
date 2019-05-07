/**Automatically creates a budget from an input file.
 * 
 * @author Daniel Grimm
 * @version 0.0
 */

import java.io.*;           //For file I/O
import java.util.Scanner;   //For reading in from files

public class Main {

    public static void endProgram() {
        //
    }

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

        String title = null;
        int grossIncome = -1;
        int taxBracket = -1;
        int tithe = -1;
        int rent = -1;

        try {
            title = file.nextLine();
            grossIncome = file.nextInt();
            taxBracket = file.nextInt();
            tithe = file.nextInt();
            rent = file.nextInt();
            
        } catch (Exception e) {
            System.out.println("Bad input from file " + inputFile);
            System.exit(0);
        }

        System.out.println(title);
        System.out.println("Gross income:\t$" + grossIncome);
        System.out.println("Tax rate:\t" + taxBracket + "%");
        System.out.println("Tithe rate:\t" + tithe + "%");
        System.out.println("Rent:\t\t$" + rent);
        
        //End of program, close resources
        file.close();
        long endTime = System.currentTimeMillis();
        long runtime = endTime - startTime;
        runtime /= 1000;
        System.out.println("\n\tRun time: " + runtime + " seconds");
    }
    
    public static void main(String[] args) {
        run(args);
    }
}