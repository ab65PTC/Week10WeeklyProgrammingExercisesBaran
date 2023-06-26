import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDorm extends JFrame implements ActionListener {
    private JCheckBox privateRoomCheckbox;
    private JCheckBox internetCheckbox;
    private JCheckBox cableTvCheckbox;
    private JCheckBox microwaveCheckbox;
    private JCheckBox refrigeratorCheckbox;
    private JTextArea optionsTextArea;

    public JDorm() {
        setTitle("Dormitory Room Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        privateRoomCheckbox = new JCheckBox("Private Room");
        internetCheckbox = new JCheckBox("Internet Connection");
        cableTvCheckbox = new JCheckBox("Cable TV Connection");
        microwaveCheckbox = new JCheckBox("Microwave");
        refrigeratorCheckbox = new JCheckBox("Refrigerator");

        privateRoomCheckbox.addActionListener(this);
        internetCheckbox.addActionListener(this);
        cableTvCheckbox.addActionListener(this);
        microwaveCheckbox.addActionListener(this);
        refrigeratorCheckbox.addActionListener(this);

        add(privateRoomCheckbox);
        add(internetCheckbox);
        add(cableTvCheckbox);
        add(microwaveCheckbox);
        add(refrigeratorCheckbox);

        optionsTextArea = new JTextArea(10, 30);
        optionsTextArea.setEditable(false);
        add(new JScrollPane(optionsTextArea));

        updateOptionsTextArea();

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JDorm::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateOptionsTextArea();
    }

    private void updateOptionsTextArea() {
        optionsTextArea.setText("Options:\n");

        if (!privateRoomCheckbox.isSelected()) {
            optionsTextArea.append("- Private Room\n");
        }

        if (!internetCheckbox.isSelected()) {
            optionsTextArea.append("- Internet Connection\n");
        }

        if (!cableTvCheckbox.isSelected()) {
            optionsTextArea.append("- Cable TV Connection\n");
        }

        if (!microwaveCheckbox.isSelected()) {
            optionsTextArea.append("- Microwave\n");
        }

        if (!refrigeratorCheckbox.isSelected()) {
            optionsTextArea.append("- Refrigerator\n");
        }
    }
}
