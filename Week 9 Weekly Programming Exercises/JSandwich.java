import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JSandwich extends JFrame implements ActionListener {
    
    private JLabel mainLabel, priceLabel, breadLabel;
    private JList<String> mainList;
    private JComboBox<String> breadComboBox;
    private JButton calculateButton;
    private double price;
    
    private String[] mainOptions = {"Ham ($5.00)", "Turkey ($5.50)", "Roast Beef ($6.00)"};
    private double[] mainPrices = {5.00, 5.50, 6.00};
    private String[] breadOptions = {"White", "Wheat", "Rye"};
    private double[] breadPrices = {0.00, 0.00, 0.50};
    
    public JSandwich() {
        super("Sublime Sandwich Shop");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));
        
        mainLabel = new JLabel("Choose a main ingredient:");
        add(mainLabel);
        
        mainList = new JList<>(mainOptions);
        add(new JScrollPane(mainList));
        
        breadLabel = new JLabel("Choose a bread type:");
        add(breadLabel);
        
        breadComboBox = new JComboBox<>(breadOptions);
        add(breadComboBox);
        
        calculateButton = new JButton("Calculate Price");
        calculateButton.addActionListener(this);
        add(calculateButton);
        
        priceLabel = new JLabel("");
        add(priceLabel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        int mainIndex = mainList.getSelectedIndex();
        int breadIndex = breadComboBox.getSelectedIndex();
        if (mainIndex >= 0 && breadIndex >= 0) {
            double mainPrice = mainPrices[mainIndex];
            double breadPrice = breadPrices[breadIndex];
            price = mainPrice + breadPrice;
            priceLabel.setText(String.format("Price: $%.2f", price));
        } else {
            priceLabel.setText("Please select a main ingredient and a bread type.");
        }
    }
    
    public static void main(String[] args) {
        new JSandwich();
    }
    
}
