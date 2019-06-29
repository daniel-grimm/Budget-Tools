/**This class draws the gui version of the budget tool.
 * 
 * @author Daniel Grimm
 * @version 0.1
 */

 import java.io.File;
 import java.io.IOException;

class Gui {


    private File outputFile = new File("output.html");

    private void endHTMLFile() {
        
    }

    public void writeResultToFile(String input) {
        

    }

    public void drawResults(File file) {
        Runtime displayResults = Runtime.getRuntime();
        try {
            Process exec = displayResults.exec("firefox " + file.getAbsolutePath());
        } catch(IOException ioe) {
            System.err.println("Unknown error. Exiting.");
            System.exit(1);
        }
        
    }
}
