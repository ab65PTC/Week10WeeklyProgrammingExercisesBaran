import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCapitals extends JFrame implements ActionListener {
    private JComboBox<String> countryComboBox;
    private JLabel capitalLabel;

    public JCapitals() {
        setTitle("Country Capitals");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        String[] countries = {"Australia", "Brazil", "Canada", "Germany", "India", "Japan", "United States"};

        countryComboBox = new JComboBox<>(countries);
        countryComboBox.addActionListener(this);
        add(countryComboBox);

        capitalLabel = new JLabel();
        add(capitalLabel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JCapitals::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
        String selectedCountry = (String) comboBox.getSelectedItem();

        String capital;
        switch (selectedCountry) {
            case "Australia":
                capital = "Canberra";
                break;
            case "Brazil":
                capital = "Brasília";
                break;
            case "Canada":
                capital = "Ottawa";
                break;
            case "Germany":
                capital = "Berlin";
                break;
            case "India":
                capital = "New Delhi";
                break;
            case "Japan":
                capital = "Tokyo";
                break;
            case "United States":
                capital = "Washington, D.C.";
                break;
            default:
                capital = "Unknown";
                break;
        }

        capitalLabel.setText("Capital: " + capital);
    }
}
