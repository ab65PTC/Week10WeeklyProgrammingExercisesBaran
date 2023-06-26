import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPhotoFrame extends JFrame implements ActionListener {
    private JCheckBox onePersonCheckbox;
    private JCheckBox twoOrMoreSubjectsCheckbox;
    private JCheckBox petCheckbox;
    private JCheckBox inStudioCheckbox;
    private JCheckBox onLocationCheckbox;
    private JLabel priceLabel;

    public JPhotoFrame() {
        setTitle("Paula's Portraits");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel subjectLabel = new JLabel("Select Portrait Subject:");
        add(subjectLabel);

        onePersonCheckbox = new JCheckBox("One Person - $40");
        twoOrMoreSubjectsCheckbox = new JCheckBox("Two or More Subjects - $75");
        petCheckbox = new JCheckBox("Pet - $95");

        ButtonGroup subjectGroup = new ButtonGroup();
        subjectGroup.add(onePersonCheckbox);
        subjectGroup.add(twoOrMoreSubjectsCheckbox);
        subjectGroup.add(petCheckbox);

        onePersonCheckbox.addActionListener(this);
        twoOrMoreSubjectsCheckbox.addActionListener(this);
        petCheckbox.addActionListener(this);

        add(onePersonCheckbox);
        add(twoOrMoreSubjectsCheckbox);
        add(petCheckbox);

        JLabel locationLabel = new JLabel("Select Session Location:");
        add(locationLabel);

        inStudioCheckbox = new JCheckBox("In-Studio - $0");
        onLocationCheckbox = new JCheckBox("On Location - $90");

        ButtonGroup locationGroup = new ButtonGroup();
        locationGroup.add(inStudioCheckbox);
        locationGroup.add(onLocationCheckbox);

        inStudioCheckbox.addActionListener(this);
        onLocationCheckbox.addActionListener(this);

        add(inStudioCheckbox);
        add(onLocationCheckbox);

        priceLabel = new JLabel("Price: $40");
        add(priceLabel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JPhotoFrame::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int basePrice = 40;

        if (twoOrMoreSubjectsCheckbox.isSelected()) {
            basePrice = 75;
        } else if (petCheckbox.isSelected()) {
            basePrice = 95;
        }

        int locationFee = 0;
        if (onLocationCheckbox.isSelected()) {
            locationFee = 90;
        }

        int totalPrice = basePrice + locationFee;
        priceLabel.setText("Price: $" + totalPrice);
    }
}
