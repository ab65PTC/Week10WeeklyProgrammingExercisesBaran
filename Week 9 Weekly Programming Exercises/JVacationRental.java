import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JVacationRental extends JFrame implements ActionListener {
    private JRadioButton parksideBtn, poolsideBtn, lakesideBtn;
    private JRadioButton oneBedroomBtn, twoBedroomBtn, threeBedroomBtn;
    private JCheckBox mealsCheckBox;
    private JLabel totalPriceLabel;
    private JButton calculateBtn;
    private int totalPrice;

    public JVacationRental() {
        super("Lambert's Vacation Rentals");
        setLayout(new FlowLayout());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        parksideBtn = new JRadioButton("Parkside", true);
        poolsideBtn = new JRadioButton("Poolside", false);
        lakesideBtn = new JRadioButton("Lakeside", false);
        oneBedroomBtn = new JRadioButton("1 bedroom", true);
        twoBedroomBtn = new JRadioButton("2 bedrooms", false);
        threeBedroomBtn = new JRadioButton("3 bedrooms", false);
        mealsCheckBox = new JCheckBox("Meals included?");
        calculateBtn = new JButton("Calculate total");

        ButtonGroup locationGroup = new ButtonGroup();
        locationGroup.add(parksideBtn);
        locationGroup.add(poolsideBtn);
        locationGroup.add(lakesideBtn);

        ButtonGroup bedroomGroup = new ButtonGroup();
        bedroomGroup.add(oneBedroomBtn);
        bedroomGroup.add(twoBedroomBtn);
        bedroomGroup.add(threeBedroomBtn);

        totalPriceLabel = new JLabel("Total price: $0");

        add(new JLabel("Select a location:"));
        add(parksideBtn);
        add(poolsideBtn);
        add(lakesideBtn);

        add(new JLabel("Select the number of bedrooms:"));
        add(oneBedroomBtn);
        add(twoBedroomBtn);
        add(threeBedroomBtn);

        add(mealsCheckBox);

        add(calculateBtn);
        add(totalPriceLabel);

        calculateBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        totalPrice = 0;

        if (parksideBtn.isSelected()) {
            totalPrice += 600;
        } else if (poolsideBtn.isSelected()) {
            totalPrice += 750;
        } else {
            totalPrice += 825;
        }

        if (twoBedroomBtn.isSelected()) {
            totalPrice += 75;
        } else if (threeBedroomBtn.isSelected()) {
            totalPrice += 150;
        }

        if (mealsCheckBox.isSelected()) {
            totalPrice += 200;
        }

        totalPriceLabel.setText("Total price: $" + totalPrice);
    }

    public static void main(String[] args) {
        new JVacationRental();
    }
}
