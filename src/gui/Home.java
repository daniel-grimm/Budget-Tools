/**This class draws the home page for the gui.
 * 
 * @author Daniel Grimm
 * @version 0.1
 */

 package gui;

 //imports
 import java.awt.*;
 import javax.swing.*;

 public class Home {

    public static void drawGui(String[] args) {
        JFrame frame = new JFrame("Home");
        frame.setSize(250, 250);
        frame.setLocation(300, 200);
        final JTextArea text = new JTextArea(10, 40);
        frame.getContentPane().add(BorderLayout.CENTER, text);
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        drawGui(args);
    }

 }