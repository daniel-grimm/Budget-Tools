package com.dgrimm.app;

/**This class saves the output of the program to an HTML file and
 * displays it in Firefox.
 * 
 * @author Daniel Grimm
 */

 //imports
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.io.PrintWriter;
 import java.io.UnsupportedEncodingException;

class SaveToHTML {

    // The output file for the program
    private static File outputFile = new File("budget.html");

    /**This method writes data to an output file.
     * 
     * @param name
     * @param data
     */
    public static void writeData(String name, String data, String result) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(outputFile, "UTF-8");
            pw.println("    <tr>");
            pw.println("      <td>" + name + "</td>");
            pw.println("      <td>" + data + "</td>");
            pw.println("    </tr>");
            pw.println("    <tr colspan=\"2\">" + result + "</tr>");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        pw.close();
    }

    /**
     * 
     */
    private static void endFile() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(outputFile, "UTF-8");
            pw.println("  </table>");
            pw.println("</body>");
            pw.println("</html>");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        pw.close();
    }

    /**
     * 
     */
    public static void drawResults() {
        endFile();
        Runtime displayResults = Runtime.getRuntime();
        try {
            Process exec = displayResults.exec("firefox " + outputFile.getAbsolutePath());
            exec.pid();
        } catch(IOException ioe) {
            System.err.println("Unknown error. Exiting.");
            System.exit(1);
        }
        
    }
}
