
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Unit2 extends JPanel {
    
    private JSplitPane unit2SplitPane;
    private Unit2Menu unit2Menu;
    private PED ped;
    private IED ied;
    private PercentChange percentChange;
    //Private instance variables
    
    static CardLayout unit2Cl = new CardLayout();
    static JPanel unit2Cont = new JPanel();
    //local variables
    
    public Unit2() {
        setLayout(new BorderLayout());
        
        unit2Menu = new Unit2Menu();
        ped = new PED();
        ied = new IED();
        percentChange = new PercentChange();
        unit2SplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, unit2Menu, unit2Cont);
        //constructors
        
        unit2Cont.setLayout(unit2Cl);
        unit2Cont.add(ped, "0");
        unit2Cont.add(ied, "1");
        unit2Cont.add(percentChange, "2");
        //CardLayout for the topics
        
        add(unit2SplitPane, BorderLayout.CENTER);
        // Adds the SplitPane to the panel
    }
    
    public static void unit2Event(int topic) {
        switch (topic) {
            case 1:
                unit2Cl.show(unit2Cont, "0");
                break;
            case 2:
                unit2Cl.show(unit2Cont, "1");
                break;
            case 3:
                unit2Cl.show(unit2Cont, "2");
                break;
            default:
                System.out.println("Choose a topic");
                break;
        }
    }// Receives an integer that changes the panel from Unit2Menu
}
