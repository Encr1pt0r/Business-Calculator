
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Unit2Menu extends JPanel {
    private JList unit2List;
    private JLabel title;
    private JButton back;
    private JButton help;
    private JButton next;
    //private instance variables
    
    JPanel buttonPanel = new JPanel();
    //local variables
    
    public Unit2Menu() {
        setLayout(new BorderLayout());
        
        unit2List = new JList();
        title = new JLabel("Unit 2 : Markets");
        back = new JButton("Back");
        back.setIcon(createIcon("images/Back24.gif"));
        help = new JButton("Help");
        help.setIcon(createIcon("images/Information24.gif"));
        next = new JButton("Next");
        next.setIcon(createIcon("images/Refresh24.gif"));
        //contructors
        
        DefaultListModel unit2Model = new DefaultListModel();
        unit2Model.addElement(new Unit2Menu.Topic(1, "1. PED"));
        unit2Model.addElement(new Unit2Menu.Topic(2, "2. IED"));
        unit2Model.addElement(new Unit2Menu.Topic(3, "3. Percentage Change"));
        unit2List.setModel(unit2Model);
        unit2List.setPreferredSize(new Dimension(200, 300));
        unit2List.setBorder(BorderFactory.createEtchedBorder());
        //setting up list
        
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(back, BorderLayout.WEST);
        buttonPanel.add(help, BorderLayout.CENTER);
        buttonPanel.add(next, BorderLayout.EAST);
        //button panel set up
        
        add(unit2List, BorderLayout.CENTER);
        add(title, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        //adding to panel
        
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Unit2Menu.Topic Topic = 
                        (Unit2Menu.Topic) unit2List.getSelectedValue();

                if(Topic == null) {
                    System.err.println("No topic selected");
                } else {
                    Unit2.unit2Event(Topic.getId());
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
    }// method for adding images to the panel
    
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