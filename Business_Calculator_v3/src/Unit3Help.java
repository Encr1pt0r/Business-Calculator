
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Unit3Help extends JPanel {
    
    private JButton choose;
    private JComboBox menu;
    private JLabel title;
    private JLabel formula;
    private JLabel label;
    private String text;
    private JButton back;
    private JPanel unit1Help = new JPanel();
    private JPanel revenuePanel = new JPanel();
    private JPanel totCostPanel = new JPanel(); 
    private JPanel profitPanel = new JPanel();
    private JPanel averagePanel = new JPanel(); 
    private JPanel capPanel = new JPanel(); 
    // private instanse variables
    
    CardLayout cl = new CardLayout();
    JPanel clCont = new JPanel();
    //local variables
    
    public Unit3Help() {
        
        choose = new JButton("Select");
        choose.setIcon(createIcon("images/Forward24.gif"));
        title = new JLabel("<html><h3>Unit 3 : Choose a Calculation</h3></html>");
        menu = new JComboBox();
        //contructors
        
        DefaultComboBoxModel menuModel = new DefaultComboBoxModel();
        menuModel.addElement(new UnitHelp3(1, "Sales Revenue"));
        menuModel.addElement(new UnitHelp3(2, "Total Costs"));
        menuModel.addElement(new UnitHelp3(3, "Profit"));
        menuModel.addElement(new UnitHelp3(4, "Average Cost"));
        menuModel.addElement(new UnitHelp3(5, "Capacity Utilisation"));
        menu.setModel(menuModel);
        //default model of the JComboBox
        
        unit1Help.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(75,0,0,0);
        //setting up the GridBagLayout
        
        ////////////////////////////////////title///////////////////////////////
        
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
        unit1Help.add(choose, gc);
        
        /////////////////////////////end of GridBag/////////////////////////////
        
        clCont.setLayout(cl);
        clCont.add(unit1Help, "0");
        clCont.add(revenuePanel, "1");
        clCont.add(totCostPanel, "2");
        clCont.add(profitPanel, "3");
        clCont.add(averagePanel, "4");
        clCont.add(capPanel, "5");
        cl.show(clCont, "0");
        add(clCont);
        // Setting up the CardLayout
        
        revenueCont();
        totCostCont();
        profitCont();
        averageCont();
        capCont();
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
            case 4:
                cl.show(clCont, "4");
                break;
            case 5:
                cl.show(clCont, "5");
                break;
        }
    }// Method that is run when choose button ActionListener is run
    
    void back() {
        cl.show(clCont, "0");
    } // Method that is run when back button ActionListener is triggered
    
    void revenueCont() {
        
        title = new JLabel("<html><h3>Sales Revenue</h3></html>");
        text = "<html>"
                + "<p>Sales revenue is the total money gained from selling a product "
                + "without it being taken away by costs."
                + "<br>It can be measured within a specific time period such as a day, month or year."
                + "<br>But, it can be calculated for a specific product "
                + "when a business has a wide product range.</p>"
                + "<p>Sales revenue can also be called total revenue.</p>"
                + "<center><br>The formula to calculate sales revenue is below:</center>"
                + "</html>";
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/sales revenue.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //Contructors
        
        revenuePanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START; 
        gc.weighty = 0.5;
        revenuePanel.add(title, gc);
        
        ///////////////////////////////////Label////////////////////////////////
        
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.weighty = 0.5;
        revenuePanel.add(label, gc);
        
        /////////////////////////////////formula////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.5;
        revenuePanel.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 0.5;
        revenuePanel.add(back, gc);
        
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener
    }
    
    void totCostCont() {
        
        title = new JLabel("<html><h3>Total Costs</h3></html>");
        text = "<html>"
                + "<p>Total costs is all the costs that is needed to be paid by the business. "
                + "<br>Costs that a business has to pay are split into two catagories.</p>"
                + "<ul>"
                + "<li>Variable costs (costs that change depending on the no. of products made)</li>"
                + "<li>Fixed costs (costs that are always the same e.g. rent)</li>"
                + "<li>Semi-Variable costs (costs that display both elements of the costs mentioned above)</li>"
                + "</ul>"
                + "<p>Total Costs is the addition of these costs.</p> "
                + "<center><br>The formula to calculate total costs is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/total costs.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        totCostPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.LINE_START;
        totCostPanel.add(title, gc);
        
        //////////////////////////////////Label/////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.CENTER;
        totCostPanel.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.4;
        gc.anchor = GridBagConstraints.CENTER;
        totCostPanel.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 0.4;
        totCostPanel.add(back, gc);
                
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener
    }
    
    void profitCont() {
        
        title = new JLabel("<html><h3>Profit/Loss</h3></html>");
        text = "<html>"
                + "<p>Profit/loss used by businesses to find out if they are either "
                + "making a profit or loss by selling their products.</p>"
                + "<p>If the profit is a positive number then they are making a profit (gaining money)"
                + "<br>If the answer is a negative number, then they are making a loss (losing money).</p>"
                + "<center><br>The formula to calculate breakeven point is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/profit.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        profitPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_START;
        profitPanel.add(title, gc);
        
        /////////////////////////////////Label//////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.CENTER;
        profitPanel.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.6;
        gc.anchor = GridBagConstraints.CENTER;
        profitPanel.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 10;
        profitPanel.add(back, gc);
                
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener 
    }
    
    void averageCont() {
        
        title = new JLabel("<html><h3>Average (Unit) Cost</h3></html>");
        text = "<html>"
                + "<p>Average costs (AKA unit costs) measures the costs "
                + "to make each unit of production.</p>"
                + "<p>e.g. A business has £400 total costs and has sold 100 products"
                + "<br>(400 / 100 = 4) so the business pays £4 per unit to make one product.</p>"
                + "<center><br>The formula to calculate average costs is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/average costs.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        averagePanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_START;
        averagePanel.add(title, gc);
        
        /////////////////////////////////Label//////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.CENTER;
        averagePanel.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.6;
        gc.anchor = GridBagConstraints.CENTER;
        averagePanel.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 10;
        averagePanel.add(back, gc);
                
        /////////////////////////////end of GridBag/////////////////////////////
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });//back button actionListener 
    }
    
    void capCont() {
        
        title = new JLabel("<html><h3>Capacity Utilisation</h3></html>");
        text = "<html>"
                + "<p>Capacity utilisation is a percentage calculated by businesses "
                + "to find how effectively they use their resources.</p>"
                + "<p>They can use it to for example see how full a resturant is at a given time."
                + "<br>This can be used to find the right times they should cook excess "
                + "amounts of food to feed all that will come.</p>"
                + "<p>It is calculated by dividing the maximum possible capacity "
                + "by the current capacity and then multiplying it by 100.</p>"
                + "<center><br>The formula to calculate capacity utilisation is below:</center>"
                + "</html>";
        
        label = new JLabel(text);
        formula = new JLabel();
        formula.setIcon(createIcon("images/capacity utilisation.jpg"));
        back = new JButton("back");
        back.setIcon(createIcon("images/Back24.gif"));
        //consturctors
        
        capPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        //setting up the GridBagLayout

        //////////////////////////////////Title/////////////////////////////////
        
        gc.gridy = 0;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_START;
        capPanel.add(title, gc);
        
        /////////////////////////////////Label//////////////////////////////////
        
        gc.gridy = 1;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.CENTER;
        capPanel.add(label, gc);
        
        ////////////////////////////////formula/////////////////////////////////
        
        gc.gridy = 2;
        gc.weighty = 0.6;
        gc.anchor = GridBagConstraints.CENTER;
        capPanel.add(formula, gc);
        
        /////////////////////////////////back///////////////////////////////////
        
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weighty = 10;
        capPanel.add(back, gc);
                
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

class UnitHelp3 {
    private String text;
    private int id;

    public UnitHelp3(int id, String text) {
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