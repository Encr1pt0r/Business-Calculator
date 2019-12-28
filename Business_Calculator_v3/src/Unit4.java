
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Unit4 extends JPanel {
    private Unit4Menu unit4Menu;
    private GrossProfit grossProfit;
    private OperatingProfit operatingProfit;
    private NetProfit netProfit;
    private JSplitPane unit4SplitPane;
    //Private instance variables
    
    static CardLayout unit4Cl = new CardLayout();
    static JPanel unit4Cont = new JPanel();
    //local variables
    
    public Unit4() {
        setLayout(new BorderLayout());
        
        unit4Menu = new Unit4Menu();
        grossProfit = new GrossProfit();
        operatingProfit = new OperatingProfit();
        netProfit = new NetProfit();
        unit4SplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, unit4Menu, unit4Cont);
        //constructors

        unit4Cont.setLayout(unit4Cl);
        unit4Cont.add(grossProfit, "0");
        unit4Cont.add(operatingProfit, "1");
        unit4Cont.add(netProfit, "2");
        //CardLayout for the topics
        
        add(unit4SplitPane, BorderLayout.CENTER);
    }    
    
    public static void unit4Event(int topic) {
        switch (topic) {
            case 1:
                unit4Cl.show(unit4Cont, "0");
                break;
            case 2:
                unit4Cl.show(unit4Cont, "1");
                break;
            case 3:
                unit4Cl.show(unit4Cont, "2");
                break;
            default:
                System.out.println("Choose a topic");
                break;
        }
    } // Method that changes the panel based on Unit4Menu selection
}
