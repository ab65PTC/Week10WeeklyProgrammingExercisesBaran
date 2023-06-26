import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JInsurance extends JFrame implements ActionListener {
    private JCheckBox hmoCheckbox;
    private JCheckBox ppoCheckbox;
    private JCheckBox dentalCheckbox;
    private JCheckBox visionCheckbox;
    private JTextField priceTextField;

    public JInsurance() {
        setTitle("Insurance Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        hmoCheckbox = new JCheckBox("HMO");
        ppoCheckbox = new JCheckBox("PPO");
        dentalCheckbox = new JCheckBox("Dental");
        visionCheckbox = new JCheckBox("Vision");

        ButtonGroup insuranceGroup = new ButtonGroup();
        insuranceGroup.add(hmoCheckbox);
        insuranceGroup.add(ppoCheckbox);

        hmoCheckbox.addActionListener(this);
        ppoCheckbox.addActionListener(this);
        dentalCheckbox.addActionListener(this);
        visionCheckbox.addActionListener(this);

        add(hmoCheckbox);
        add(ppoCheckbox);
        add(dentalCheckbox);
        add(visionCheckbox);

        priceTextField = new JTextField(10);
        priceTextField.setEditable(false);
        add(priceTextField);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JInsurance::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int totalCost = 0;

        if (hmoCheckbox.isSelected()) {
            totalCost += 200;
        } else if (ppoCheckbox.isSelected()) {
            totalCost += 600;
        }

        if (dentalCheckbox.isSelected()) {
            totalCost += 75;
        }

        if (visionCheckbox.isSelected()) {
            totalCost += 20;
        }

        if (totalCost == 0) {
            priceTextField.setText("");
        } else {
            priceTextField.setText("Price: $" + totalCost + " per month");
        }
    }
}
