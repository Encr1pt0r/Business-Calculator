
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Unit5 extends JPanel {
    private Unit5Menu unit5Menu;
    private Gearing gearing;
    private CurrentRatio currentRatio;
    private AcidTest acidTest;
    private ROCE roce;
    private JSplitPane unit5SplitPane;
    //Private instance variables
    
    static CardLayout unit5Cl = new CardLayout();
    static JPanel unit5Cont = new JPanel();
    //local variables
    
    public Unit5() {
        setLayout(new BorderLayout());
        
        unit5Menu = new Unit5Menu();
        gearing = new Gearing();
        currentRatio = new CurrentRatio();
        acidTest = new AcidTest();
        roce = new ROCE();
        unit5SplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, unit5Menu, unit5Cont);
        //constructors

        unit5Cont.setLayout(unit5Cl);
        unit5Cont.add(gearing, "0");
        unit5Cont.add(currentRatio, "1");
        unit5Cont.add(acidTest, "2");
        unit5Cont.add(roce, "3");
        //CardLayout for the topics
        
        add(unit5SplitPane, BorderLayout.CENTER);
        // adds the JSplitPane to the panel
    }
    
    public static void unit5Event(int topic) {
        
        switch (topic) {
            case 1:
                unit5Cl.show(unit5Cont, "0");
                break;
            case 2:
                unit5Cl.show(unit5Cont, "1");
                break;
            case 3:
                unit5Cl.show(unit5Cont, "2");
                break;
            case 4:
                unit5Cl.show(unit5Cont, "3");
                break;
            default:
                System.out.println("Choose a topic");
                break;
        }
    } // receives an integer that changes CardLayout from Unit5Menu
}
