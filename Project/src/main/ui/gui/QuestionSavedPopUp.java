/*
this class represents a popup window after the user enters his/her answer to each question on the quiz and clicks the
button to go to the next question. The popup window displays a message informing the user that his/her answer to the
current question has been saved and a button to close the window.
 */

package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionSavedPopUp extends JFrame implements ActionListener {
    private static final int XCoordinate = 1600;
    private static final int YCoordinate = 500;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    private final JFrame frame;
    private final JPanel panel;

    // REQUIRES: nothing
    // MODIFIES: this
    // EFFECTS: constructs a new frame of dimensions WIDTH * HEIGHT at the XCoordinate, YCoordinate position with a
    // title and a panel for displaying a label and an OK button.
    public QuestionSavedPopUp() {
        super("Question Saved alert");
        panel = new JPanel();
        frame = new JFrame();
        frame.setTitle("Saved!");
        frame.getContentPane().setBackground(new Color(100, 175, 250));
        frame.setBounds(XCoordinate, YCoordinate, WIDTH, HEIGHT);
        frame.setResizable(true);
    }

    // REQUIRES: the panel, frame, and a button from the class fields.
    // MODIFIES: this
    // EFFECTS: creates a new frame with a message informing the user that his/her answer has been saved and a button
    // to close the window.
    public void displayPopUpWindow() {
        JLabel label = new JLabel("Your answers were saved!");
        JButton button = new JButton("OK");
        panel.add(label);
        panel.add(button);
        frame.add(panel);
        panel.setBackground(new Color(110, 200, 250));
        button.setActionCommand("OkButton");
        button.addActionListener(this);
        frame.setVisible(true);
    }

    // REQUIRES: the action command of the ok button from the displayPopUpWindow method.
    // MODIFIES: this
    // EFFECTS: if the user clicks the Ok button, then the program terminates.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("OkButton")) {
            frame.setVisible(false);
        }
    }
}
