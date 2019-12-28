
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Unit3 extends JPanel {
    
    private Unit3Menu unit3Menu;
    private SalesRevenue salesRevenue;
    private TotalCost totalCost;
    private Profit profit;
    private AverageCost averageCost;
    private CapacityUtilisation capacityUtilisation;
    private JSplitPane unit3SplitPane;
    //Private instance variables
    
    static CardLayout unit3Cl = new CardLayout();
    static JPanel unit3Cont = new JPanel();
    //local variables
    
    public Unit3() {
        setLayout(new BorderLayout());
        
        unit3Menu = new Unit3Menu();
        salesRevenue = new SalesRevenue();
        totalCost = new TotalCost();
        profit = new Profit();
        averageCost = new AverageCost();
        capacityUtilisation = new CapacityUtilisation();
        unit3SplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, unit3Menu, unit3Cont);
        //constructors

        unit3Cont.setLayout(unit3Cl);
        unit3Cont.add(salesRevenue, "0");
        unit3Cont.add(totalCost, "1");
        unit3Cont.add(profit, "2");
        unit3Cont.add(averageCost, "3");
        unit3Cont.add(capacityUtilisation, "4");
        //CardLayout for the topics
        
        add(unit3SplitPane, BorderLayout.CENTER);    
        // Adding JSplitPane into the panel
    }
    
    public static void unit3Event(int topic) {
        switch (topic) {
            case 1:
                unit3Cl.show(unit3Cont, "0");
                break;
            case 2:
                unit3Cl.show(unit3Cont, "1");
                break;
            case 3:
                unit3Cl.show(unit3Cont, "2");
                break;
            case 4:
                unit3Cl.show(unit3Cont, "3");
                break;
            case 5:
                unit3Cl.show(unit3Cont, "4");
                break;
            default:
                System.err.println("Choose a topic");
                break;
        }
    }// Method that is run when the ActionListener in Unit3Menu is triggered
}

