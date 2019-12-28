
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Unit1Help extends JPanel {
    
    private JButton choose;
    private JComboBox menu;
    private JLabel title;
    private JLabel formula;
    private JLabel label;
    private String text;
    private JButton back;
    private JPanel unit1Help = new JPanel();
    private JPanel unitContPanel = new JPanel();
    private JPanel totContPanel = new JPanel(); 
    private JPanel breakPanel = new JPanel();
    private JPanel marginPanel = new JPanel(); 
    // private instanse variables
    
    CardLayout cl = new CardLayout();
    JPanel clCont = new JPanel();
    //local variables
    
    public Unit1Help() {
        
        choose = new JButton("Select");
        choose.setIcon(createIcon("images/Forward24.gif"));
        title = new JLabel("<html><h3>Unit 1 : Choose a Calculation</h3></html>");
        menu = new JComboBox();
        //contructors
        
        DefaultComboBoxModel menuModel = new DefaultComboBoxModel();
        menuModel.addElement(new UnitHelp1(1, "Unit Contribution"));
        menuModel.addElement(new UnitHelp1(2, "Total Contribution"));
        menuModel.addElement(new UnitHelp1(3, "Breakeven Point"));
        menuModel.addElement(new UnitHelp1(4, "Margin of Safety"));
        menu.setModel(menuModel);
        //default model of the JComboBox
        
        unit1Help.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(75,0,0,0);
        //setting up the GridBagLayout
        
        ////////////////////////////////////title///////////////////////////////
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.CENTER; 
        unit1Help.add(title, gc);
        
        ////////////////////////////////////menu////////////////////////////////

        gc.gridy = 1;
        gc.weighty = 0.5;
        unit1Help.add(menu, gc);
        
        ///////////////////////////////////start////////////////////////////////

        gc.gridy = 2;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.CENTER;  
        unit1Help.add(choose, gc);
        
        /////////////////////////////end of GridBag/////////////////////////////
        
        clCont.setLayout(cl);
        clCont.add(unit1Help, "0");
        clCont.add(unitContPanel, "1");
        clCont.add(totContPanel, "2");
        clCont.add(breakPanel, "3");
        clCont.add(marginPanel, "4");
        cl.show(clCont, "0");
        add(clCont);
        // Setting up the CardLayout
        
        unitCont();
        totCont();
        breakCont();
        marginCont();
        //methods are run to add the componets to the panels before they are run 
        
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                UnitHelp1 Unit = (UnitHelp1) menu.getSelectedItem();
                chooseEvent(Unit.getId());
           }
        });//ActionListener for choose button
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
    }// Method that is called when chos button ActionListener is triggered
    
    void back() {
        cl.show(clCont, "0");
    } // Method that is run when the back button is pressed 
    
    void unitCont() {
        
        title = new JLabel("<html><h3>Unit Contibution</h3></html>");
        text = "<html>"
                + "<p>Contribution is the difference in the price of the product "
                + "and the cost that it took to create the product.</p>"
                + "<p>e.g. Dave buys a car for £850 and sells it for £1000 "
                + "(1000 - 850 = 150) contribution is £150.</p>"
                + "<p>Unit Contribution calculates how much contribution per product.</p> "
                + "<center><br>The formula to calculate unit contribution is below:</center>"
                + "</html>";
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/unit contribution.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //Contructors
        
        unitContPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START; 
        gc.weighty = 0.5;
        unitContPanel.add(title, gc);
        
        ///////////////////////////////////Label////////////////////////////////
        
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0.5;
        unitContPanel.add(label, gc);
        
        /////////////////////////////////formula////////////////////////////////
        
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0.5;
        unitContPanel.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 0.5;
        unitContPanel.add(back, gc);
        
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button ActionListener
    }
    
    void totCont() {
        
        title = new JLabel("<html><h3>Total Contibution</h3></html>");
        text = "<html>"
                + "<p>Contribution is the difference in the price of the product "
                + "and the cost that it took to create the product.</p>"
                + "<p>e.g. Dave has contribution of £150 from selling his car, "
                + "he sells 5 more cars at the same prices making <br>(150 x 5 = 750). "
                + "So totally, he has £750 contribution</p>"
                + "<p>Total Contribution calculates contribution "
                + "for all the products sold.</p> "
                + "<center><br>The formula to calculate total contribution is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/total contribution.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        totContPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.LINE_START;
        totContPanel.add(title, gc);
        
        //////////////////////////////////Label/////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.CENTER;
        totContPanel.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.CENTER;
        totContPanel.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 0.4;
        totContPanel.add(back, gc);
                
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener
    }
    
    void breakCont() {
        
        title = new JLabel("<html><h3>Breakeven Point</h3></html>");
        text = "<html>"
                + "<p>Breakeven is a term used in business to describe when a "
                + "business is nether making a profit or a loss.</p>"
                + "<p>A business can find out if they know their fixed costs and "
                + "contribution the amount of products needed to be sold "
                + "<br>to breakeven with their product or with their yearly earnings.</p>"
                + "<p>e.g. Jack makes benches, his fixed costs are £60,000 "
                + "and his contribution is £60.</p>"
                + "<p>(60,000 / 60 = 1000) so Jack needs 1000 benches to breakeven.</p>"
                + "<center><br>The formula to calculate breakeven point is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/breakeven point.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        breakPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_START;
        breakPanel.add(title, gc);
        
        /////////////////////////////////Label//////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.CENTER;
        breakPanel.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.6;
        gc.anchor = GridBagConstraints.CENTER;
        breakPanel.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 10;
        breakPanel.add(back, gc);
                
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener 
    }
    
    void marginCont() {
        
        title = new JLabel("<html><h3>Margin of Safety</h3></html>");
        text = "<html>"
                + "<p>Margin of safety is used by businesses to find out if they "
                + "are making a profit how money <br>they will have to lose before"
                + " they start making a loss.</p>"
                + "<p>A business can find out margin of safety if they know their"
                + " breakeven point the difference between <br>the current level "
                + "of output (revenue) and their breakeven point to calculate margin of safety.</p>"
                + "<p>e.g. Cindy fixes cars, she makes £10,000 in a year "
                + "and her breakeven point is £9000. </p>"
                + "<p>(10,000 - 9000 = 1000) So Cindy's margin of safety is £1000.</p>"
                + "<center><br>The formula to calculate margin of safety is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/margin of safety.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        marginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_START;
        marginPanel.add(title, gc);
        
        /////////////////////////////////Label//////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.CENTER;
        marginPanel.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.6;
        gc.anchor = GridBagConstraints.CENTER;
        marginPanel.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 10;
        marginPanel.add(back, gc);
                
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
    } // Method the is used to add images to the panel
}

class UnitHelp1 {
    private String text;
    private int id;

    public UnitHelp1(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString() {
        return text;
    }

    public int getId() {
        return id;
    }
} // class used to add identifiers to the default model