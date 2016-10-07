/**
 * PROGRAM Percent.java
 * WRITTEN BY Stanford Mayfield JR
 * This program is going to display the commission
 * for a total amount of sales after the end user has
 * selected their type of sales commission.
 * This file will house methods
 */  
/**
 * The following Java code was utilized from:
 *Gaddis, T (2011)'Chapter 11, of Starting out with Java. Early Objects
 * 4th Edition' 11.6 Radio Buttons and Check Boxes Pearsib Education
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Percent extends JFrame
 {
    private JPanel panel;                  // A panel to hold components
    private JLabel messageLabel;           // A message to the user
    private JTextField sales;      // To hold user input
    private JRadioButton entryButton;      // Miles conversion button
    private JRadioButton salesButton;       // Feet conversion button
    private JRadioButton seniorButton;     // Inches conversion button
    private ButtonGroup radioButtonGroup;  // To group radio buttons
    private final int WINDOW_WIDTH = 500;  // Window width
    private final int WINDOW_HEIGHT = 300; // Window height

     /**
      * Constructor
      */
     public Percent()
     {
        // Call the JFrame constructor.
        super("Commission Percentage GUI");

        // Set the size of the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Build the panel.
        buildPanel();

        // Add the panel to the frame's content pane.
       add(panel);
        // Display the window.
     setVisible(true);
     }

     /**
     * The buildPanel method adds a label, text field, and
     * three radio buttons to a panel.
     */

     private void buildPanel()
     {
        // Create the label, text field, and radio buttons.
        messageLabel = new JLabel("Enter you Total Sales then select your"
                + "level of commission.");
        sales = new JTextField(10);
        entryButton = new JRadioButton("Entry Level Sales Agent");
        salesButton = new JRadioButton("Sales Agent");
       seniorButton = new JRadioButton("Senior Sales Agent");

        // Group the radio buttons.
        radioButtonGroup = new ButtonGroup();
       radioButtonGroup.add(entryButton);
        radioButtonGroup.add(salesButton);
        radioButtonGroup.add(seniorButton);

        // Add action listeners to the radio buttons.
        entryButton.addActionListener(new RadioButtonListener());
        salesButton.addActionListener(new RadioButtonListener());
        seniorButton.addActionListener(new RadioButtonListener());

        // Create a panel and add the components to it.
        panel = new JPanel();
        panel.add(messageLabel);
        panel.add(sales);
        panel.add(entryButton);
        panel.add(salesButton);
        panel.add(seniorButton);
     }
     /**
      * Private inner class that handles the event when
      * the user clicks one of the radio buttons.
     */

     private class RadioButtonListener implements ActionListener
     {
        public void actionPerformed(ActionEvent e)
        {
           String input;          // To hold input
           String convertTo = ""; // What we are converting to
           double result = 0.0;   // To hold the conversion

           // Get input from the text field.
           input = sales.getText();

           // Determine the button that was clicked and
           // perform the selected conversion.
           if (e.getSource() == entryButton)
           {
              convertTo = " dollars.";
            result = Double.parseDouble(input) * 0.055;
         }
           else if (e.getSource() == salesButton)
         {
             convertTo = " dollars.";
             result = Double.parseDouble(input) * 0.069;
           }
          else if (e.getSource() == seniorButton)
           {
             convertTo = " dollars.";
              result = Double.parseDouble(input) * 0.890;
          }
           // Display the converted distance.
           JOptionPane.showMessageDialog(null, input +
                   " commission is " + result + convertTo);
        }
     }
 }