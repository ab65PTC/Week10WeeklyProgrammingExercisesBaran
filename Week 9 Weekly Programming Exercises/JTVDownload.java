import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTVDownload extends JFrame implements ActionListener {
    // Components for the frame
    private JLabel titleLabel;
    private JTextArea synopsisArea;
    private JComboBox<String> showComboBox;
    
    // Constructor
    public JTVDownload() {
        // Set up the frame
        super("TV Show Downloads");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Add the title label
        titleLabel = new JLabel("Select a TV Show to Watch:");
        add(titleLabel, BorderLayout.NORTH);
        
        // Add the combo box for the TV shows
        String[] shows = {"Breaking Bad", "Game of Thrones", "The Office", "Stranger Things", "The Crown"};
        showComboBox = new JComboBox<>(shows);
        showComboBox.addActionListener(this);
        add(showComboBox, BorderLayout.CENTER);
        
        // Add the synopsis area
        synopsisArea = new JTextArea(10, 30);
        synopsisArea.setLineWrap(true);
        synopsisArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(synopsisArea);
        add(scrollPane, BorderLayout.SOUTH);
        
        // Display the frame
        setVisible(true);
    }
    
    // Action listener method
    public void actionPerformed(ActionEvent e) {
        // Get the selected TV show
        String show = (String) showComboBox.getSelectedItem();
        
        // Display the synopsis for the selected show
        switch (show) {
            case "Breaking Bad":
                synopsisArea.setText("A high school chemistry teacher turns to a life of crime to provide for his family's future.");
                break;
            case "Game of Thrones":
                synopsisArea.setText("Nine noble families fight for control over the mythical lands of Westeros.");
                break;
            case "The Office":
                synopsisArea.setText("A mockumentary on a group of typical office workers, where the workday consists of ego clashes, inappropriate behavior, and tedium.");
                break;
            case "Stranger Things":
                synopsisArea.setText("When a young boy disappears, his mother, a police chief, and his friends must confront terrifying supernatural forces in order to get him back.");
                break;
            case "The Crown":
                synopsisArea.setText("Follows the political rivalries and romance of Queen Elizabeth II's reign and the events that shaped the second half of the twentieth century.");
                break;
            default:
                synopsisArea.setText("Please select a TV show from the list.");
        }
    }
    
    // Main method
    public static void main(String[] args) {
        new JTVDownload();
    }
}
