
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class Unit5Menu extends JPanel {
    private JList unit5List;
    private JLabel title;
    private JButton back;
    private JButton help;
    private JButton next;
    //private instance variables
    
    JPanel buttonPanel = new JPanel();
    //local variables
    
    public Unit5Menu() {
        setLayout(new BorderLayout());
        //layout setting
        
        unit5List = new JList();
        title = new JLabel("Unit 5 : Ratio Analysis");
        back = new JButton("Back");
        back.setIcon(createIcon("images/Back24.gif"));
        help = new JButton("Help");
        help.setIcon(createIcon("images/Information24.gif"));
        next = new JButton("Next");
        next.setIcon(createIcon("images/Refresh24.gif"));
        //constuctors
        
        DefaultListModel unit5Model = new DefaultListModel();
        unit5Model.addElement(new Unit5Menu.Topic(1, "1. Gearing Ratio"));
        unit5Model.addElement(new Unit5Menu.Topic(2, "2. Current Ratio"));
        unit5Model.addElement(new Unit5Menu.Topic(3, "3. Acid Test Ratio"));
        unit5Model.addElement(new Unit5Menu.Topic(4, "4. ROCE"));
        unit5List.setModel(unit5Model);
        unit5List.setPreferredSize(new Dimension(200, 300));
        unit5List.setBorder(BorderFactory.createEtchedBorder());
        //setting up list
         
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(back, BorderLayout.WEST);
        buttonPanel.add(help, BorderLayout.CENTER);
        buttonPanel.add(next, BorderLayout.EAST);
        //button panel set up
        
        add(unit5List, BorderLayout.CENTER);
        add(title, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        //adding to panel
        
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Unit5Menu.Topic Topic = (Unit5Menu.Topic) unit5List.getSelectedValue();

                if(Topic == null) {
                    System.err.println("No topic selected");
                } else {
                    Unit5.unit5Event(Topic.getId());
                }
            }
        });//ActionListener for the next button
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControlFrame.back();
            }
        });//ActionListener for the back button
        
        help.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                Help user = new Help();
            }
        });//ActionListener for the help button
        
    }    
    
    private ImageIcon createIcon(String path) {
        URL url = getClass().getResource(path);
        
        if(url == null) {
            System.err.println("Unable to load image: " + path);
        }
        
        ImageIcon icon = new ImageIcon(url);
        return icon;
    } // adds images to the panel
    
    class Topic {
        private String text;
        private int id;

        public Topic(int id, String text) {
            this.id = id;
            this.text = text;
        }

        public String toString() {
            return text;
        }

        public int getId() {
            return id;
        }
    } //method to create identifiers for the unit1List
}


