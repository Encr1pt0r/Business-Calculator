
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Unit4Help extends JPanel {
    
    private JButton choose;
    private JComboBox menu;
    private JLabel title;
    private JLabel formula;
    private JLabel label;
    private String text;
    private JButton back;
    private JPanel unit1Help = new JPanel();
    private JPanel grossCont = new JPanel();
    private JPanel operatingCont = new JPanel(); 
    private JPanel netCont = new JPanel();
    // private instanse variables
    
    CardLayout cl = new CardLayout();
    JPanel clCont = new JPanel();
    //local variables
    
    public Unit4Help() {
        
        choose = new JButton("Select");
        choose.setIcon(createIcon("images/Forward24.gif"));
        title = new JLabel("<html><h3>Unit 4 : Choose a Calculation</h3></html>");
        menu = new JComboBox();
        //contructors
        
        DefaultComboBoxModel menuModel = new DefaultComboBoxModel();
        menuModel.addElement(new UnitHelp3(1, "Gross Profit"));
        menuModel.addElement(new UnitHelp3(2, "Operating Profit"));
        menuModel.addElement(new UnitHelp3(3, "Net Profit"));
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

        gc.anchor = GridBagConstraints.CENTER; 
        gc.gridy = 1;
        gc.weighty = 0.5;
        unit1Help.add(menu, gc);
        
        ///////////////////////////////////start////////////////////////////////

        gc.anchor = GridBagConstraints.CENTER;         
        gc.gridy = 2;
        gc.weighty = 0.5;
        unit1Help.add(choose, gc);
        
        /////////////////////////////end of GridBag/////////////////////////////
        
        clCont.setLayout(cl);
        clCont.add(unit1Help, "0");
        clCont.add(grossCont, "1");
        clCont.add(operatingCont, "2");
        clCont.add(netCont, "3");
        cl.show(clCont, "0");
        add(clCont);
        // Setting up CardLayout
        
        grossCont();
        operatingCont();
        netCont();
        //methods to add componets to CardLayout cards
        
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                UnitHelp3 Unit = (UnitHelp3) menu.getSelectedItem();
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
    }// Method that run when the choose button ActionListener is triggered
    
    void back() {
        cl.show(clCont, "0");
    } // Method that changes the CardLayout when the back button is pressed
    
    void grossCont() {
        
        title = new JLabel("<html><h3>Gross Profit</h3></html>");
        text = "<html>"
                + "<p>Gross profit is the difference between revenue and cost of sales."
                + "<br>This is the earnings of a business without paying costs that "
                + "manage the business as a whole such as wages and bills.</p>"
                + "<p></p>"
                + "<ul>"
                + "<li>Revenue is calculated by multipying the price if the "
                + "product and the quantity of sales of the product</li>"
                + "<li>Cost of sales are direct costs of a business "
                + "e.g. the price made to create the product</li>"
                + "<li>Gross profit is the profit made by a business "
                + "after direct costs are deducted</li>"
                + "</ul>"
                + "<center><br>The formula to calculate gross profit is below:</center>"
                + "</html>";
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/gross profit.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //Contructors
        
        grossCont.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START; 
        gc.weighty = 0.5;
        grossCont.add(title, gc);
        
        ///////////////////////////////////Label////////////////////////////////
        
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0.5;
        grossCont.add(label, gc);
        
        /////////////////////////////////formula////////////////////////////////
        
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0.5;
        grossCont.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 0.5;
        grossCont.add(back, gc);
        
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener
    }
    
    void operatingCont() {
        
        title = new JLabel("<html><h3>Operating Profit</h3></html>");
        text = "<html>"
                + "<p>Operating profit is the difference between the gross "
                + "profit and the operating expenses of a business.</p>"
                + "<p>Operating expenses are things like:</p>"
                + "<ul>"
                + "<li>Wages</li>"
                + "<li>Bills</li>"
                + "<li>Accountancy fees</li>"
                + "</ul>"
                + "<center><br>The formula to calculate operating profit is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/operating profit.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        operatingCont.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.LINE_START;
        operatingCont.add(title, gc);
        
        //////////////////////////////////Label/////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.CENTER;
        operatingCont.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.CENTER;
        operatingCont.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 0.4;
        operatingCont.add(back, gc);
                
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener
    }
    
    void netCont() {
        
        title = new JLabel("<html><h3>Net Profit</h3></html>");
        text = "<html>"
                + "<p>Net profit is the profit made by the business in the year."
                + "<br>This is different to operating costs since it is not covering "
                + "essential costs but one off payments, tax and interest</p>"
                + "<p>These are things like:</p>"
                + "<ul>"
                + "<li>Investments</li>"
                + "<li>Stakeholder equity (dividends)</li>"
                + "<li>Tax fees</li>"
                + "</ul>"
                + "<center><br>The formula to calculate net profit is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/net profit.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        netCont.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_START;
        netCont.add(title, gc);
        
        /////////////////////////////////Label//////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.CENTER;
        netCont.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.6;
        gc.anchor = GridBagConstraints.CENTER;
        netCont.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 10;
        netCont.add(back, gc);
                
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
    } // Method that adds images to the panel
}

class UnitHelp4 {
    private String text;
    private int id;

    public UnitHelp4(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString() {
        return text;
    }

    public int getId() {
        return id;
    }
} // class that adds identifiers to the default model