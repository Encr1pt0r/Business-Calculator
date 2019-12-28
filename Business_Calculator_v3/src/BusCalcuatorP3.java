
import javax.swing.SwingUtilities;

public class BusCalcuatorP3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                ControlFrame controlFrame = new ControlFrame();
            }
        });
    } //main method with intial thread
}
