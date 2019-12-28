
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class AverageCost extends JPanel {
    
    private JLabel title;
    private JTextField textField1;
    private JTextField textField2;
    private JButton calculate;
    private JLabel outputLabel;
    private JLabel label1;
    private JLabel label2;
    private String outputDialogue;
    private double output;
    private JLabel formula;
    //private instance variables
    
    JPanel inputPanel = new JPanel();
    //local variables
    
    public AverageCost() {
            
        title = new JLabel("<html><h3>Average (Unit) Cost</h3></html>");
        outputDialogue = "Average Cost = £" + output + "0";
        outputLabel = new JLabel(outputDialogue);
        label1 = new JLabel("Total Costs:");
        label2 = new JLabel("No. of Products sold:");
        calculate = new JButton("Calculate");
        textField1 = new JTextField();
        textField2 = new JTextField();
        formula = new JLabel();
        formula.setIcon(createIcon("images/average costs.jpg"));
        //constructors
        
        label1.setPreferredSize(new Dimension(150, 20));
        label2.setPreferredSize(new Dimension(150, 20));
        //setting the size of the text fields
        
        inputPanel.setLayout(new GridLayout(2, 2, 50, 50));
        
        inputPanel.add(label1);
        inputPanel.add(textField1);
        inputPanel.add(label2);
        inputPanel.add(textField2);
        //adding the GridLayout to the inputPanel

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout
        
        ////////////////////////////////////title///////////////////////////////
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(1,1,1,1);
        gc.anchor = GridBagConstraints.LINE_START;        
        gc.weighty = 0.1;
        add(title, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0.1;
        add(formula, gc);
        
        //////////////////////////////inputPanel////////////////////////////////
        
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0.1;
        add(inputPanel, gc);
        
        //////////////////////////////outputLabel///////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0.1;
        add(outputLabel, gc);
        
        ////////////////////////////////calculate///////////////////////////////
        
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0.1;
        add(calculate, gc);
        
        /////////////////////////////end of GridBag/////////////////////////////
        
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String input1 = textField1.getText();
                String input2 = textField2.getText();
                
                if(input1.isEmpty() == true || input2.isEmpty() == true) {
                    System.err.println("Enter a value");
                } else {
                    double input1d = Double.parseDouble(textField1.getText());
                    double input2d = Double.parseDouble(textField2.getText());

                    output = Calculations.getAverageCost(input1d, input2d);
                    
                    if (output >= 0) {
                        outputDialogue = "Average Cost = £" + output;
                        outputLabel.setText(outputDialogue);
                    } else if (output < 0) {
                        output = Calculations.reverse(output);
                        outputDialogue = "Average Cost = -£" + output;
                        outputLabel.setText(outputDialogue);
                    }/* changes the outputLabel after comparing if 
                    it is positive or negative number*/
                }
            }
        });// ActionListener for the calculate button
    }
    
    private ImageIcon createIcon(String path) {
        URL url = getClass().getResource(path);
        
        if(url == null) {
            System.err.println("Unable to load image: " + path);
        }
        
        ImageIcon icon = new ImageIcon(url);
        return icon;
    }// method to add images to panel
}
