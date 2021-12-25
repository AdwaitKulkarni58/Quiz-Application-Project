/*
This is the entry point of the program, from where
the program starts to run. It creates an object of
the QuizQuestions class and calls the QuizQuestion class
methods on that object in order to run the program.
 */

package ui;

import ui.gui.WelcomeWindow;

// runs the application
public class Main {
    public static void main(String[] args) {
        new WelcomeWindow();
    }
}
