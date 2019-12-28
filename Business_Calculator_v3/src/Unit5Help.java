
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Unit5Help extends JPanel {
    
    private JButton choose;
    private JComboBox menu;
    private JLabel title;
    private JLabel formula;
    private JLabel label;
    private String text;
    private JButton back;
    private JPanel unit5Help = new JPanel();
    private JPanel gearingPanel = new JPanel();
    private JPanel currentPanel = new JPanel(); 
    private JPanel acidPanel = new JPanel();
    private JPanel rocePanel = new JPanel(); 
    // private instanse variables
    
    CardLayout cl = new CardLayout();
    JPanel clCont = new JPanel();
    //local variables
    
    public Unit5Help() {
        
        choose = new JButton("Select");
        choose.setIcon(createIcon("images/Forward24.gif"));
        title = new JLabel("<html><h3>Unit 5 : Choose a Calculation</h3></html>");
        menu = new JComboBox();
        //contructors
        
        DefaultComboBoxModel menuModel = new DefaultComboBoxModel();
        menuModel.addElement(new UnitHelp5(1, "Gearing Ratio"));
        menuModel.addElement(new UnitHelp5(2, "Current Ratio"));
        menuModel.addElement(new UnitHelp5(3, "Acid Test Ratio"));
        menuModel.addElement(new UnitHelp5(4, "ROCE"));
        menu.setModel(menuModel);
        //default model of the JComboBox
        
        unit5Help.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,0);
        //setting up the GridBagLayout
        
        ////////////////////////////////////title///////////////////////////////
        
        gc.anchor = GridBagConstraints.CENTER; 
        gc.gridy = 0;
        gc.weighty = 0.5;
        unit5Help.add(title, gc);
        
        ////////////////////////////////////menu////////////////////////////////

        gc.anchor = GridBagConstraints.CENTER; 
        gc.gridy = 1;
        gc.weighty = 0.5;
        unit5Help.add(menu, gc);
        
        ///////////////////////////////////start////////////////////////////////

        gc.anchor = GridBagConstraints.CENTER;         
        gc.gridy = 2;
        gc.weighty = 0.5;
        unit5Help.add(choose, gc);
        
        /////////////////////////////end of GridBag/////////////////////////////
        
        clCont.setLayout(cl);
        clCont.add(unit5Help, "0");
        clCont.add(gearingPanel, "1");
        clCont.add(currentPanel, "2");
        clCont.add(acidPanel, "3");
        clCont.add(rocePanel, "4");
        cl.show(clCont, "0");
        add(clCont);
        // Setting up the CardLayout
        
        gearingCont();
        currentCont();
        acidCont();
        roceCont();
        //methods to add componets to CardLayout cards
        
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                UnitHelp5 Unit = (UnitHelp5) menu.getSelectedItem();
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
            case 4:
                cl.show(clCont, "4");
                break;
        }
    } // an integer is passed into the method and CardLayout is changed depending on the integer passed
    
    void back() {
        cl.show(clCont, "0");
    }
    
    void gearingCont() {
        
        title = new JLabel("<html><h3>Gearing Ratio</h3></html>");
        text = "<html>"
                + "<p>Gearing ratio measures the percentage of capital "
                + "(money that is from the original investors) is in the company.</p>"
                + "<p>The higher the gearing ratio the better it is for the business "
                + "since it shows that they have no long-term debts "
                + "<br>which would be favourable to investors.</p>"
                + "<p>However, having a really high gearing can raise concerns since investors may think "
                + "<br>the business is not able to handle long-term debt.</p> "
                + "<center><br>The formula to calculate gearing ratio is below:</center>"
                + "</html>";
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/gearing ratio.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //Contructors
        
        gearingPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START; 
        gc.weighty = 0.5;
        gearingPanel.add(title, gc);
        
        ///////////////////////////////////Label////////////////////////////////
        
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0.5;
        gearingPanel.add(label, gc);
        
        /////////////////////////////////formula////////////////////////////////
        
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0.5;
        gearingPanel.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 0.5;
        gearingPanel.add(back, gc);
        
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener
    }
    
    void currentCont() {
        
        title = new JLabel("<html><h3>Current Ratio</h3></html>");
        text = "<html>"
                + "<p>Current ratio is a liquidity ratio that measures the "
                + "current assets and liabilites of a business.</p>"
                + "<p>This is done by dividing these two things to create current ratio.</p>"
                + "<ul>"
                + "<li>Current assets (something in the business that can be changed into mony in the next 12 months e.g. stock)</li>"
                + "<li>Current liabilites (money that must be paid back in 12 months e.g. short-term loans)</li>"
                + "</ul>"
                + "<p>Its interpreted as a ratio measuring per £ of costs they how much they have of their profit to pay the costs."
                + "<br>e.g. Abel sells clothes he has £42.50 worth of assets and £36.70 worth of liabilities. (42.5 / 36.7 = 1.16) "
                + "<br>So Abel has 1.16 : 1 current ratio which means that he has £1.16 per £ of costs.</p> "
                + "<center><br>The formula to calculate current ratio is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/current ratio.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        currentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.LINE_START;
        currentPanel.add(title, gc);
        
        //////////////////////////////////Label/////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.CENTER;
        currentPanel.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.CENTER;
        currentPanel.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 0.4;
        currentPanel.add(back, gc);
                
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener
    }
    
    void acidCont() {
        
        title = new JLabel("<html><h3>Acid Test Ratio</h3></html>");
        text = "<html>"
                + "<p>Acid Test ratio is a liquidity ratio that measures the "
                + "current assets and liabilites of a business. "
                + "<br>However, it does not measure the inventories (stock) of the business</p>"
                + "<p>This is good for businesses that do not have very liquid stock (will take time to turn into cash)"
                + "<br>Acid test ratio uses these three things to calculate it.</p>"
                + "<ul>"
                + "<li>Current assets (something in the business that can be changed into mony in the next 12 months e.g. stock)</li>"
                + "<li>Current liabilites (money that must be paid back in 12 months e.g. short-term loans)</li>"
                + "<li>Inventories (stock) which either can be sold or still raw materials</li>"
                + "</ul>"
                + "e.g. James sells clothes he has £42.50 worth of assets and £36.70 worth of liabilities "
                + "and his stock is £15. <br>((42.5 - 15) / 36.7 = 0.74) So James has 0.74 : 1 current ratio which means that he has £0.74 per £ of costs.</p> "
                + "<center><br>The formula to calculate acid test ratio is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/acid test ratio.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        acidPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_START;
        acidPanel.add(title, gc);
        
        /////////////////////////////////Label//////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.CENTER;
        acidPanel.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.6;
        gc.anchor = GridBagConstraints.CENTER;
        acidPanel.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 10;
        acidPanel.add(back, gc);
                
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener 
    }
    
    void roceCont() {
        
        title = new JLabel("<html><h3>ROCE (Return on Capital Employed)</h3></html>");
        text = "<html>"
                + "<p>ROCE (Return on Capital Employed) is a ratio used to compare the profit "
                + "<br>made over its capital (money that is from the original investors).</p>"
                + "<p>This is good for a business to know because the money that has been orginally invested "
                + "<br>into the company has been returned by though the businesses profit.</p>"
                + "<p>ROCE can be calculated by dividing operating profit "
                + "and capital employed then multiply it by 100.</p>"
                + "<center><br>The formula to calculate ROCE is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/roce.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        rocePanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_START;
        rocePanel.add(title, gc);
        
        /////////////////////////////////Label//////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.CENTER;
        rocePanel.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.6;
        gc.anchor = GridBagConstraints.CENTER;
        rocePanel.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 10;
        rocePanel.add(back, gc);
                
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
    } // mthod that adds images to the panel
}

class UnitHelp5 {
    private String text;
    private int id;

    public UnitHelp5(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString() {
        return text;
    }

    public int getId() {
        return id;
    }
} // add identifiers to the Unit5Help
