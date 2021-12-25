/*
This class represents the no button that is displayed on the welcome window everytime the application
is run to allow the user to not load his/her previous data.
It has one method to add the button to the welcome window frame.
 */

package ui.gui;

import javax.swing.*;

public class NoButtonForNotSavingData {
    private final JButton button;

    // constructs a new button and assigns it to a variable.
    public NoButtonForNotSavingData() {
        button = new JButton();
    }

    // REQUIRES: the button class field
    // MODIFIES: this
    // EFFECTS: sets the text of the button and returns that button to be used in the welcome window class.
    public JButton addNoButton() {
        button.setText("No");
        return button;
    }
}
