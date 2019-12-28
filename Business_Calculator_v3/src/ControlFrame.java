import java.awt.CardLayout;
import javax.swing.*;

public class ControlFrame extends JFrame {
    
    private WelcomeScreen welcomeScreen;
    private Unit1 unit1;
    private Unit2 unit2;
    private Unit3 unit3;
    private Unit4 unit4;
    private Unit5 unit5;
    //private instance variables
    
    static CardLayout cl = new CardLayout();
    static JPanel panelCont = new JPanel();
    //local variables
    
    public ControlFrame() {
        super("Business Calculator // ver 3");
        
        welcomeScreen = new WelcomeScreen();
        unit1 = new Unit1();
        unit2 = new Unit2();
        unit3 = new Unit3();
        unit4 = new Unit4();
        unit5 = new Unit5();
        //contructors
        
        panelCont.setLayout(cl);
        panelCont.add(welcomeScreen, "0");
        panelCont.add(unit1, "1");
        panelCont.add(unit2, "2");
        panelCont.add(unit3, "3");
        panelCont.add(unit4, "4");
        panelCont.add(unit5, "5");
        cl.show(panelCont, "0");
        add(panelCont);
        //setting up the CardLayout
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setResizable(false);
        //visibilty of the frame
        //what happens if the window is closed
        //size of the frame
        //sets the frame to not be resizable
    }
    
    public static void back() {
        cl.show(panelCont, "0");
    }// Reponds to the back button ActionListener 
        //changes the panel back to WelcomeScreen
    
    public static void startEvent(int unitOption) {
        
        switch(unitOption){
            case 1:
                cl.show(panelCont, "1");
                break;
            case 2:
                cl.show(panelCont, "2");
                break;
            case 3:
                cl.show(panelCont, "3");
                break;
            case 4:
                cl.show(panelCont, "4");
                break;
            case 5:
                cl.show(panelCont, "5");
                break;
        }
    }/* Responds to the ActionListener in the WelcomeScreen class which changes 
    the CardLayout depending on the what integer is passed into it*/
}