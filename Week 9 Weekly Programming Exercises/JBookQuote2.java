import javax.swing.*;
import java.awt.event.*;

public class JBookQuote2 extends JFrame implements ActionListener {

    JButton button = new JButton("Click to see book title");

    public JBookQuote2() {
        super("My Favorite Book Quote");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new java.awt.FlowLayout());
        JLabel label = new JLabel("It is a truth universally acknowledged, that a single man in possession of a good fortune, must be in want of a wife.");
        add(label);
        add(button);
        button.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "The quote is from the book Pride and Prejudice by Jane Austen.");
    }

    public static void main(String[] args) {
        JBookQuote2 frame = new JBookQuote2();
    }
}
