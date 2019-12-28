
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Help extends JFrame {
    
    private JTabbedPane helpPane;
    private Unit1Help unit1;
    private Unit2Help unit2;
    private Unit3Help unit3;
    private Unit4Help unit4;
    private Unit5Help unit5;
    // private instance variables

    public Help() {
        super("Business Calculator Help");
        //title
        
        setLayout(new BorderLayout());
        //setting the layout
        
        helpPane = new JTabbedPane();
        unit1 = new Unit1Help();
        unit2 = new Unit2Help();
        unit3 = new Unit3Help();
        unit4 = new Unit4Help();
        unit5 = new Unit5Help();
        //constructors
        
        helpPane.add("Unit 1", unit1);
        helpPane.add("Unit 2", unit2);
        helpPane.add("Unit 3", unit3);
        helpPane.add("Unit 4", unit4);
        helpPane.add("Unit 5", unit5);
        
        add(helpPane, BorderLayout.CENTER);
        //adding to the frame
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 450);
        setResizable(false);
        //visibilty of the frame
        //what happens if the window is closed
        //size of the frame
        //sets the frame to not be resizable
    }
}

