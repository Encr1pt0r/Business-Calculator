
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class AcidTest extends JPanel {
    
    private JLabel title;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton calculate;
    private JLabel outputLabel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private String outputDialogue;
    private double output;
    private JLabel formula;
    //private instance variables
    
    JPanel inputPanel = new JPanel();
    //local variables
    
    public AcidTest() {
            
        title = new JLabel("<html><h3>Acid Test Ratio</h3></html>");
        outputDialogue = "Acid Test Ratio = " + output + " : 1";
        outputLabel = new JLabel(outputDialogue);
        label1 = new JLabel("Current Assets:");
        label2 = new JLabel("Inventories (Stock):");
        label3 = new JLabel("Current Liabilites");
        calculate = new JButton("Calculate");
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        formula = new JLabel();
        formula.setIcon(createIcon("images/acid test ratio.jpg"));
        //constructors
        
        label1.setPreferredSize(new Dimension(150, 20));
        label2.setPreferredSize(new Dimension(150, 20));
        //setting the size of the text fields
        
        inputPanel.setLayout(new GridLayout(3, 3, 50, 40));
        inputPanel.add(label1);
        inputPanel.add(textField1);
        inputPanel.add(label2);
        inputPanel.add(textField2);
        inputPanel.add(label3);
        inputPanel.add(textField3);
        //adding the GridLayout to the inputPanel

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout
        
        ////////////////////////////////////title///////////////////////////////
        
        gc.gridx = 1;
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
        gc.insets = new Insets(1,1,1,1);
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
                String input3 = textField3.getText();
                
                if(input1.isEmpty() == true || input2.isEmpty() == true 
                        || input3.isEmpty() == true) {
                    System.err.println("Enter a value");
                } else {
                    double input1d = Double.parseDouble(textField1.getText());
                    double input2d = Double.parseDouble(textField2.getText());
                    double input3d = Double.parseDouble(textField3.getText());

                    output = Calculations.getAcidTest(input1d, input2d, input3d);
                    //calls the getAcidTest method in Calculations class
                    
                    outputDialogue = "Acid Test Ratio = " + output + " : 1";
                    outputLabel.setText(outputDialogue);
                    // Changes text in outputLabel
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
    } // method for adding images to the panel
}
