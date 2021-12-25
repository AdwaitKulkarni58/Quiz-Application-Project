/*
This class represents a frame that informs the user that his/her answer was wrong.
The frame has a message saying the same and a button that closes the message window.
 */

package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayWrongAnswerMessage extends JFrame implements ActionListener {

    private static final int XCoordinate = 1300;
    private static final int YCoordinate = 300;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 200;
    private final JPanel panel;
    private final JDialog dialog;

    // REQUIRES: the panel and dialog from the class fields
    // MODIFIES: nothing
    // EFFECTS: sets up a dialog with a title "Wrong Answer" and adds a panel with specific coordinates
    // and specific dimensions to it.
    public DisplayWrongAnswerMessage() {
        super("Wrong Answer");
        panel = new JPanel();
        dialog = new JDialog();
        dialog.setTitle("Wrong!");
        dialog.add(panel);
        dialog.setBounds(XCoordinate, YCoordinate, WIDTH, HEIGHT);
    }

    // REQUIRES: panel, dialog
    // MODIFIES: this
    // EFFECTS: Adds a new JLabel and button to the panel with a background color and sets up an action listener for
    // the button.
    public void displayWindow() {
        panel.add(new JLabel("Wrong Answer!"));
        JButton button = new JButton("Ok");
        panel.add(button);
        dialog.add(panel);
        button.setActionCommand("OK");
        button.addActionListener(this);
        panel.setBackground(new Color(110, 200, 250));
        dialog.setVisible(true);
    }

    // REQUIRES: action command from the displayWindow method
    // MODIFIES: this
    // EFFECTS: makes the visibility of the dialog hidden after the user has clicked on the OK button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("OK")) {
            dialog.setVisible(false);
        }
    }
}
