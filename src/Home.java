/**This class draws the gui version of the budget tool.
 * 
 * @author Daniel Grimm
 * @version 0.1
 */

 //imports
 import java.awt.*;
 import javax.swing.*;

 public class Home {

    private static final int INIT_LENGTH = 500;
    private static final int INIT_WIDTH = 500;

    public static JTextArea text = new JTextArea(INIT_LENGTH, INIT_WIDTH);
    private static JFrame frame = new JFrame("Budget");

    //Pass in the file as a string or as a file?
    private static void initializeGui(String[] args) {
        //JFrame frame = new JFrame("Budget");
        frame.setSize(INIT_LENGTH, INIT_WIDTH);
        frame.setLocation(300, 200);
        final JTextArea title = new JTextArea(INIT_LENGTH, INIT_WIDTH);
        title.append("Hello World");
        frame.getContentPane().add(BorderLayout.CENTER, title);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**This method updates the gui with the new information.
     * 
     */
    public static void updateGui() {
        frame.update(frame.getGraphics());
    }

    /**This method draws the gui displaying the output of the program.
     * 
     * @param args
     */
    public static void drawGui(String[] args) {
        initializeGui(args);
    }

 }