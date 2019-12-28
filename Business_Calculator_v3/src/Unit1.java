
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.*;

public class Unit1 extends JPanel {
    private Unit1Menu unit1Menu;
    private UnitContribution contribution;
    private TotalContribution totContribution;
    private BreakevenPoint breakevenPoint;
    private MarginOfSafety marginOfSafety;
    private JSplitPane unit1SplitPane;
    //Private instance variables
    
    static CardLayout unit1Cl = new CardLayout();
    static JPanel unit1Cont = new JPanel();
    //local variables
    
    public Unit1() {
        setLayout(new BorderLayout());
        
        unit1Menu = new Unit1Menu();
        contribution = new UnitContribution();
        totContribution = new TotalContribution();
        breakevenPoint = new BreakevenPoint();
        marginOfSafety = new MarginOfSafety();
        unit1SplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, unit1Menu, unit1Cont);
        //constructors

        unit1Cont.setLayout(unit1Cl);
        unit1Cont.add(contribution, "0");
        unit1Cont.add(totContribution, "1");
        unit1Cont.add(breakevenPoint, "2");
        unit1Cont.add(marginOfSafety, "3");
        //CardLayout for the topics
        
        add(unit1SplitPane, BorderLayout.CENTER);
        // JSplitPane is added to the panel
    }
    
    public static void unit1Event(int topic) {
        
        switch (topic) {
            case 1:
                unit1Cl.show(unit1Cont, "0");
                break;
            case 2:
                unit1Cl.show(unit1Cont, "1");
                break;
            case 3:
                unit1Cl.show(unit1Cont, "2");
                break;
            case 4:
                unit1Cl.show(unit1Cont, "3");
                break;
            default:
                System.err.println("Choose a topic");
                break;
        }
    }// Responds to ActionListener in the Unit1Menu class
}
