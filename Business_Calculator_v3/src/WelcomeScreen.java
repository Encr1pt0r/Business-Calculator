
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class WelcomeScreen extends JPanel{
    private JLabel title;
    private JButton start;
    private JComboBox menu;
    //private instance variables
    
    public WelcomeScreen() {
        start = new JButton("Start");
        start.setIcon(createIcon("images/Forward24.gif"));
        title = new JLabel();
        title.setIcon(createIcon("images/logo.jpg"));
        menu = new JComboBox();
        //contructors
        
        setBackground(Color.white);
        //sets the background colour
    
        DefaultComboBoxModel menuModel = new DefaultComboBoxModel();
        menuModel.addElement(new Unit(1, "Unit 1 : Breakeven"));
        menuModel.addElement(new Unit(2, "Unit 2 : Markets"));
        menuModel.addElement(new Unit(3, "Unit 3 : Sales, Revenue and Costs"));
        menuModel.addElement(new Unit(4, "Unit 4 : Interpretation of Financial Statements"));
        menuModel.addElement(new Unit(5, "Unit 5 : Ratio Anaylsis"));
        menu.setModel(menuModel);
        //default model of the JComboBox
       
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout
        
        ////////////////////////////////////title///////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.1;
        add(title, gc);
        
        ////////////////////////////////////menu////////////////////////////////
       
        gc.gridy = 1;
        gc.weighty = 0.1;
        add(menu, gc);
        
        ///////////////////////////////////start////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.1;
        add(start, gc);
        
        /////////////////////////////end of GridBag/////////////////////////////
        
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               Unit Unit = (Unit) menu.getSelectedItem();
               ControlFrame.startEvent(Unit.getId());
            }
        });//start button actionlistener
       
   } 
    
    private ImageIcon createIcon(String path) {
        URL url = getClass().getResource(path);
        
        if(url == null) {
            System.err.println("Unable to load image: " + path);
        }
        
        ImageIcon icon = new ImageIcon(url);
        return icon;
    } // Method that adds images to the panel
    
    class Unit {
        private String text;
        private int id;

        public Unit(int id, String text) {
            this.id = id;
            this.text = text;
        }

        public String toString() {
            return text;
        }

        public int getId() {
            return id;
        }
    } //method to create identifiers for the unit1List
}