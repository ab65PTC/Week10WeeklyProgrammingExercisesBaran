import javax.swing.*;

public class JBookQuote extends JFrame {
    
    public JBookQuote() {
        super("My Favorite Book Quote");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        
        JLabel quoteLabel = new JLabel("<html><center>"
            + "It was the best of times, it was the worst of times,<br>"
            + "it was the age of wisdom, it was the age of foolishness,<br>"
            + "it was the epoch of belief, it was the epoch of incredulity,<br>"
            + "it was the season of Light, it was the season of Darkness,<br>"
            + "it was the spring of hope, it was the winter of despair,<br>"
            + "we had everything before us, we had nothing before us,<br>"
            + "we were all going direct to Heaven, we were all going direct<br>"
            + "the other way – in short, the period was so far like the present<br>"
            + "period, that some of its noisiest authorities insisted on its<br>"
            + "being received, for good or for evil, in the superlative degree<br>"
            + "of comparison only."
            + "</center></html>");
        
        add(quoteLabel);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new JBookQuote();
    }
    
}
