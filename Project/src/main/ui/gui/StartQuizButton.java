/*
This class represents the start button that is displayed on the welcome window everytime the application
is run. It has one method to add the button to the welcome window frame.
 */

package ui.gui;

import javax.swing.*;

public class StartQuizButton {
    private final JButton button;

    // constructs a new button and assigns it to a variable.
    public StartQuizButton() {
        button = new JButton();
    }

    // REQUIRES: the button class field
    // MODIFIES: this
    // EFFECTS: sets the text of the button and returns that button to be used in the welcome window class.
    public JButton addStartButton() {
        button.setText("Start");
        return button;
    }
}
