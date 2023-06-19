import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JTVDownload2 extends JFrame implements ActionListener {
    private String[] showList = {"Breaking Bad", "Stranger Things", "The Office", "Game of Thrones", "Friends"};
    private String[] synopsisList = {"A high school chemistry teacher starts cooking meth to provide for his family after he is diagnosed with cancer.",
        "When a young boy disappears, his mother, a police chief, and his friends must confront terrifying supernatural forces to get him back.",
        "The everyday lives of office employees in the Scranton, Pennsylvania branch of the fictional Dunder Mifflin Paper Company.",
        "Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.",
        "The misadventures of a group of friends as they navigate the pitfalls of work, life, and love in Manhattan."};
    private JComboBox<String> showComboBox = new JComboBox<>(showList);
    private JTextArea synopsisTextArea = new JTextArea(5, 20);

    public JTVDownload2() {
        setTitle("TV Show Selector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel comboPanel = new JPanel();
        comboPanel.add(new JLabel("Select a TV Show:"));
        comboPanel.add(showComboBox);
        comboPanel.add(new JLabel("or enter a show name:"));
        JTextField showTextField = new JTextField(10);
        comboPanel.add(showTextField);
        add(comboPanel, BorderLayout.NORTH);
        showComboBox.addActionListener(this);
        showTextField.addActionListener(this);
        JPanel synopsisPanel = new JPanel();
        synopsisPanel.add(new JLabel("Synopsis:"));
        synopsisPanel.add(synopsisTextArea);
        synopsisTextArea.setLineWrap(true);
        synopsisTextArea.setWrapStyleWord(true);
        synopsisTextArea.setEditable(false);
        add(synopsisPanel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String selectedShow = "";
        if (e.getSource() == showComboBox) {
            selectedShow = (String)showComboBox.getSelectedItem();
        } else {
            JTextField showTextField = (JTextField)e.getSource();
            selectedShow = showTextField.getText();
        }
        int index = -1;
        for (int i = 0; i < showList.length; i++) {
            if (selectedShow.equalsIgnoreCase(showList[i])) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Sorry, " + selectedShow + " is not available for download.");
        } else {
            synopsisTextArea.setText(synopsisList[index]);
        }
    }

    public static void main(String[] args) {
        new JTVDownload2();
    }
}
