
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Unit2Help extends JPanel {
    
    private JButton choose;
    private JComboBox menu;
    private JLabel title;
    private JLabel formula;
    private JLabel label;
    private String text;
    private JButton back;
    private JPanel unit1Help = new JPanel();
    private JPanel PEDCont = new JPanel();
    private JPanel IEDCont = new JPanel(); 
    private JPanel PercentCont = new JPanel();
    // private instanse variables
    
    CardLayout cl = new CardLayout();
    JPanel clCont = new JPanel();
    //local variables
    
    public Unit2Help() {
        
        choose = new JButton("Select");
        choose.setIcon(createIcon("images/Forward24.gif"));
        title = new JLabel("<html><h3>Unit 2 : Choose a Calculation</h3></html>");
        menu = new JComboBox();
        //contructors
        
        DefaultComboBoxModel menuModel = new DefaultComboBoxModel();
        menuModel.addElement(new UnitHelp2(1, "PED"));
        menuModel.addElement(new UnitHelp2(2, "IED"));
        menuModel.addElement(new UnitHelp2(3, "Percentage Change"));
        menu.setModel(menuModel);
        //default model of the JComboBox
        
        unit1Help.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(75,0,0,0);
        //setting up the GridBagLayout
        
        ////////////////////////////////////title///////////////////////////////
        
        gc.anchor = GridBagConstraints.CENTER; 
        gc.gridy = 0;
        gc.weighty = 0.5;
        unit1Help.add(title, gc);
        
        ////////////////////////////////////menu////////////////////////////////

        gc.gridy = 1;
        gc.weighty = 0.5;
        unit1Help.add(menu, gc);
        
        ///////////////////////////////////start////////////////////////////////

        gc.gridy = 2;
        gc.weighty = 0.5;
        unit1Help.add(choose, gc);
        
        /////////////////////////////end of GridBag/////////////////////////////
        
        clCont.setLayout(cl);
        clCont.add(unit1Help, "0");
        clCont.add(PEDCont, "1");
        clCont.add(IEDCont, "2");
        clCont.add(PercentCont, "3");
        cl.show(clCont, "0");
        add(clCont);
        // Setting up the CardLayout
        
        PEDCont();
        IEDCont();
        percentCont();
        // Methods to add componets to CardLayout cards
        
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                UnitHelp2 Unit = (UnitHelp2) menu.getSelectedItem();
                chooseEvent(Unit.getId());
           }
        });//actionlistener for choose button
    }
    
    void chooseEvent(int unitOption) {
        
        switch(unitOption){
            case 1:
                cl.show(clCont, "1");
                break;
            case 2:
                cl.show(clCont, "2");
                break;
            case 3:
                cl.show(clCont, "3");
                break;
        }
    } // Method that is called the changes the panels depending
    
    void back() {
        cl.show(clCont, "0");
    }
    
    void PEDCont() {
        
        title = new JLabel("<html><h3>PED : (Price Elasticity of Demand)</h3></html>");
        text = "<html>"
                + "<p>PED (price elasicity of demand) measures change in demand "
                + "in response to changes in the price of a product.<br></p>"
                + "<p>Things that affect PED:</p>"
                + "<ul>"
                + "<li>Competition of the same product (pricing strategies)</li>"
                + "<li>Premium branding (people are willing to pay more for a branded product)</li>"
                + "<li>Proportion of income spent on a product</li>"
                + "</ul>"
                + "<center><br>The formula to calculate PED is below:</center>"
                + "</html>";
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/ped.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //Contructors
        
        PEDCont.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START; 
        gc.weighty = 0.5;
        PEDCont.add(title, gc);
        
        ///////////////////////////////////Label////////////////////////////////
        
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0.5;
        PEDCont.add(label, gc);
        
        /////////////////////////////////formula////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.5;
        PEDCont.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 0.5;
        PEDCont.add(back, gc);
        
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener
    }
    
    void IEDCont() {
        
        title = new JLabel("<html><h3>IED : (Income Elasticity of Demand)</h3></html>");
        text = "<html>"
                + "<p>IED (price elasicity of demand) measures change in demand "
                + "in response to changes in the income of the person.<br></p>"
                + "<p>Things that affect IED:</p>"
                + "<ul>"
                + "<li>Nessesity of the product (people are more likely to buy "
                + "basic goods rather than luxuries)</li>"
                + "<li>Premium branding (people are willing to pay more for a branded product)</li>"
                + "</ul>"
                + "<center><br>The formula to calculate IED is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/ied.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        IEDCont.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.LINE_START;
        IEDCont.add(title, gc);
        
        //////////////////////////////////Label/////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.CENTER;
        IEDCont.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.4;
        IEDCont.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 0.4;
        IEDCont.add(back, gc);
                
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener
    }
    
    void percentCont() {
        
        title = new JLabel("<html><h3>Percentage Change</h3></html>");
        text = "<html>"
                + "<p>Percentage change is not really a business calculation for "
                + "but it is important to do certain <br>business calculations "
                + "such as PED (price elasticity of demand).</p>"
                + "<p>It takes the difference of the two numbers and then turns "
                + "it into a percentage by dividing "
                + "it by <br>the first number and multiplying it by 100.</p>"
                + "<center><br>The formula to calculate breakeven point is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/percent change.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        PercentCont.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_START;
        PercentCont.add(title, gc);
        
        /////////////////////////////////Label//////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.CENTER;
        PercentCont.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.6;
        PercentCont.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 10;
        PercentCont.add(back, gc);
                
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener 
    }
        
    private ImageIcon createIcon(String path) {
        URL url = getClass().getResource(path);
        
        if(url == null) {
            System.err.println("Unable to load image: " + path);
        }
        
        ImageIcon icon = new ImageIcon(url);
        return icon;
    } // Method for adding images to the panel
}

class UnitHelp2 {
    private String text;
    private int id;

    public UnitHelp2(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString() {
        return text;
    }

    public int getId() {
        return id;
    }
} // class the adds identifiers into the default model