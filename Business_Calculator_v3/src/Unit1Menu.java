
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Unit1Menu extends JPanel {
    private JList unit1List;
    private JLabel title;
    private JButton back;
    private JButton help;
    private JButton next;
    //private instance variables
    
    JPanel buttonPanel = new JPanel();
    //local variables
    
    public Unit1Menu() {
        setLayout(new BorderLayout());
        //layout setting
        
        unit1List = new JList();
        title = new JLabel("Unit 1 : Breakeven");
        back = new JButton("Back");
        back.setIcon(createIcon("images/Back24.gif"));
        help = new JButton("Help");
        help.setIcon(createIcon("images/Information24.gif"));
        next = new JButton("Next");
        next.setIcon(createIcon("images/Refresh24.gif"));
        //constuctors
        
        DefaultListModel unit1Model = new DefaultListModel();
        unit1Model.addElement(new Topic(1, "1. Unit Contribution"));
        unit1Model.addElement(new Topic(2, "2. Total Contribution"));
        unit1Model.addElement(new Topic(3, "3. Breakeven Point"));
        unit1Model.addElement(new Topic(4, "4. Margin of Safety"));
        unit1List.setModel(unit1Model);
        unit1List.setPreferredSize(new Dimension(200, 300));
        unit1List.setBorder(BorderFactory.createEtchedBorder());
        //setting up list
         
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(back, BorderLayout.WEST);
        buttonPanel.add(help, BorderLayout.CENTER);
        buttonPanel.add(next, BorderLayout.EAST);
        //button panel set up
        
        add(unit1List, BorderLayout.CENTER);
        add(title, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        //adding to panel
        
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Topic Topic = (Topic) unit1List.getSelectedValue();

                if(Topic == null) {
                    System.err.println("No topic selected");
                } else {
                    Unit1.unit1Event(Topic.getId());
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
        });//ActionListener for the help button. 
        //opens a new instance of help frame
    }
    
    private ImageIcon createIcon(String path) {
        URL url = getClass().getResource(path);
        
        if(url == null) {
            System.err.println("Unable to load image: " + path);
        }
        
        ImageIcon icon = new ImageIcon(url);
        return icon;
    }// Method to add images to the panel
    
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
    } //class to create identifiers for the unit1List
}