
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class UnitContribution extends JPanel {
    
    private JLabel title;
    private JTextField price;
    private JTextField variableCosts;
    private JButton calculate;
    private JLabel outputLabel;
    private JLabel priceLabel;
    private JLabel variableLabel;
    private String outputDialogue;
    private double output;
    private JLabel formula;
    //private instance variables
    
    JPanel inputPanel = new JPanel();
    //local variables
    
    public UnitContribution() {
        setLayout(new BorderLayout());
            
        title = new JLabel("<html><h3>Unit Contribution</h3></html>");
        outputDialogue = "Unit Contribution = £" + output + "0";
        outputLabel = new JLabel(outputDialogue);
        priceLabel = new JLabel("Product Selling Price:");
        variableLabel = new JLabel("Variable Costs:");
        calculate = new JButton("Calculate");
        price = new JTextField();
        variableCosts = new JTextField();
        formula = new JLabel();
        formula.setIcon(createIcon("images/unit contribution.jpg"));
        //constructors
        
        price.setPreferredSize(new Dimension(150, 20));
        variableCosts.setPreferredSize(new Dimension(150, 20));
        //setting the size of the text fields
        
        inputPanel.setLayout(new GridLayout(2, 2, 50, 50));
        
        inputPanel.add(priceLabel);
        inputPanel.add(price);
        inputPanel.add(variableLabel);
        inputPanel.add(variableCosts);
        //adding the GridLayout to the inputPanel

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout
        
        ////////////////////////////////////title///////////////////////////////
        
        gc.gridy = 0;
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
                
                String pInput = price.getText();
                String vInput = variableCosts.getText();
                
                if(pInput.isEmpty() == true || vInput.isEmpty() == true) {
                    System.err.println("Enter a value");
                } else {
                    double priceInput = Double.parseDouble(price.getText());
                    double variableInput = Double.parseDouble(variableCosts.getText());

                    output = Calculations.getUnitContribution(priceInput, variableInput);
                    // Method in Calculations class is called
                    
                    if (output >= 0) {
                        outputDialogue = "Unit Contribution = £" + output;
                        outputLabel.setText(outputDialogue);
                    } else if (output < 0) {
                        output = Calculations.reverse(output);
                        outputDialogue = "Unit Contribution = -£" + output;
                        outputLabel.setText(outputDialogue);
                    } // changes outputLabel depending on its sign (+ or -)
                }
            }
        });// ActionListener for calculate button
    }
    
    private ImageIcon createIcon(String path) {
        URL url = getClass().getResource(path);
        
        if(url == null) {
            System.err.println("Unable to load image: " + path);
        }
        
        ImageIcon icon = new ImageIcon(url);
        return icon;
    } // method that add images to the panel   
}
