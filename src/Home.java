/**This class draws the home page for the gui.
 * 
 * @author Daniel Grimm
 * @version 0.1
 */

 //imports
 import java.awt.*;
 import javax.swing.*;

 public class Home {

    //Pass in the file as a string or as a file?
    public static void initializeGui() {

    }

    public static void drawGui(String[] args) {
        JFrame frame = new JFrame("Budget");
        frame.setSize(500, 500);
        frame.setLocation(300, 200);
        final JTextArea text = new JTextArea(10, 40);
        frame.getContentPane().add(BorderLayout.CENTER, text);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

 }