
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;


public class Unit3Menu extends JPanel {
    private JList unit3List;
    private JLabel title;
    private JButton back;
    private JButton help;
    private JButton next;
    //private instance variables
    
    JPanel buttonPanel = new JPanel();
    //local variables
    
    public Unit3Menu() {
        setLayout(new BorderLayout());
        //layout setting
        
        unit3List = new JList();
        title = new JLabel("Unit 3 : Sales, Revenue and Costs");
        back = new JButton("Back");
        back.setIcon(createIcon("images/Back24.gif"));
        help = new JButton("Help");
        help.setIcon(createIcon("images/Information24.gif"));
        next = new JButton("Next");
        next.setIcon(createIcon("images/Refresh24.gif"));
        //constuctors
        
        DefaultListModel unit3Model = new DefaultListModel();
        unit3Model.addElement(new Unit3Menu.Topic(1, "1. Sales Revenue"));
        unit3Model.addElement(new Unit3Menu.Topic(2, "2. Total Cost"));
        unit3Model.addElement(new Unit3Menu.Topic(3, "3. Profit"));
        unit3Model.addElement(new Unit3Menu.Topic(4, "4. Average Cost"));
        unit3Model.addElement(new Unit3Menu.Topic(5, "5. Capacity Utilisation"));
        unit3List.setModel(unit3Model);
        unit3List.setPreferredSize(new Dimension(200, 300));
        unit3List.setBorder(BorderFactory.createEtchedBorder());
        //setting up list
         
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(back, BorderLayout.WEST);
        buttonPanel.add(help, BorderLayout.CENTER);
        buttonPanel.add(next, BorderLayout.EAST);
        //button panel set up
        
        add(unit3List, BorderLayout.CENTER);
        add(title, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        //adding to panel
        
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Unit3Menu.Topic Topic = (Unit3Menu.Topic) unit3List.getSelectedValue();

                if(Topic == null) {
                    System.err.println("No topic selected");
                } else {
                    Unit3.unit3Event(Topic.getId());
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
    } // Method that adds images to the panel
    
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
    } //method to create identifiers for the unit3List
}
