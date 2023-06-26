import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LastManStanding extends JFrame implements ActionListener {
    private List<JCheckBox> checkBoxes;
    private JButton playButton;

    public LastManStanding() {
        setTitle("Last Man Standing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        checkBoxes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            JCheckBox checkBox = new JCheckBox("Box " + (i + 1));
            checkBoxes.add(checkBox);
            add(checkBox);
        }

        playButton = new JButton("Play");
        playButton.addActionListener(this);
        add(playButton);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LastManStanding::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        playButton.setEnabled(false);

        // Player's turn
        int playerSelected = 0;
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                playerSelected++;
                checkBox.setSelected(false);
                checkBox.setEnabled(false);
            }
        }

        // Check if player's selection is valid
        if (playerSelected < 1 || playerSelected > 3) {
            JOptionPane.showMessageDialog(this, "Invalid selection! Please choose 1 to 3 boxes.");
            playButton.setEnabled(true);
            for (JCheckBox checkBox : checkBoxes) {
                if (!checkBox.isEnabled()) {
                    checkBox.setEnabled(true);
                }
            }
            return;
        }

        // Check if player won
        if (getRemainingCount() == 0) {
            displayWinner("Player");
            return;
        }

        // Computer's turn
        int computerSelected = new Random().nextInt(3) + 1;
        int selectedCount = 0;
        for (JCheckBox checkBox : checkBoxes) {
            if (selectedCount < computerSelected && checkBox.isEnabled()) {
                checkBox.setSelected(true);
                checkBox.setEnabled(false);
                selectedCount++;
                checkBox.setSelected(false);
            }
        }

        // Check if computer won
        if (getRemainingCount() == 0) {
            displayWinner("Computer");
            return;
        }

        playButton.setEnabled(true);
    }

    private int getRemainingCount() {
        int count = 0;
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isEnabled()) {
                count++;
            }
        }
        return count;
    }

    private void displayWinner(String winner) {
        JOptionPane.showMessageDialog(this, winner + " wins! Game Over.");
        for (JCheckBox checkBox : checkBoxes) {
            checkBox.setEnabled(false);
        }
        playButton.setEnabled(false);
    }
}
