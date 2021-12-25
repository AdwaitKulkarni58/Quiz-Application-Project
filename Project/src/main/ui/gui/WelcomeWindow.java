/*
This class represents the welcome window that is first displayed when the user
runs the application and this window is displayed every time the application is run.
This window contains an image to welcome the user to the application, and it has three
buttons in addition to it. These buttons give the user the option to either load the data from the previous
attempt or not as well as the option to start the quiz directly without selecting either of the above two buttons
in which case the data will not be loaded.
Credit for music used in this project: "Music: www.bensound.com"
 */

package ui.gui;

import ui.Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WelcomeWindow extends JFrame implements ActionListener {
    private static final int XCoordinate = 300;
    private static final int YCoordinate = 300;
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private final JPanel panel;
    private final JFrame frame;
    Quiz quiz;
    YesButtonForSavingData yesButtonForSavingData;
    NoButtonForNotSavingData noButtonForNotSavingData;
    StartQuizButton startQuizButton;

    // REQUIRES: the welcome to the quiz image from the data folder
    // MODIFIES: nothing
    // EFFECTS: constructs a new frame with a title, a width and a height, adds an image as a background image and a
    // music file as a background score.
    // Sets the layout as a flow layout and calls the setWelcomeComponents method.
    public WelcomeWindow() {
        super("Quiz Application");
        yesButtonForSavingData = new YesButtonForSavingData();
        noButtonForNotSavingData = new NoButtonForNotSavingData();
        startQuizButton = new StartQuizButton();
        JLabel background = new JLabel(new ImageIcon("./data/Quiz_Application_Image.jpg"));
        panel = new JPanel();
        frame = new JFrame();
        frame.setTitle("Welcome!");
        background.setLayout(new FlowLayout());
        panel.add(background);
        frame.add(panel);
        frame.getContentPane().setBackground(new Color(40, 196, 222));
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(true);
        setWelcomeComponents();
    }

    // REQUIRES: the values of the class fields representing the position and dimensions of the frame.
    // MODIFIES: nothing
    // EFFECTS: creates a label asking the user a question and provides the user with 3 buttons in order to provide
    // the appropriate answer. The method also adds action listeners to the buttons and as soon as the user clicks on
    // a particular button, a different function is called.
    public void setWelcomeComponents() {
        panel.add(new JLabel("Do you want to load your previous data?\n\n\n"));
        JButton button1 = yesButtonForSavingData.addYesButton();
        panel.add(button1);
        JButton button2 = noButtonForNotSavingData.addNoButton();
        panel.add(button2);
        JButton button3 = startQuizButton.addStartButton();
        panel.add(button3);
        frame.add(panel);
        button1.setActionCommand("button1");
        button1.addActionListener(this);
        button2.setActionCommand("button2");
        button2.addActionListener(this);
        button3.setActionCommand("button3");
        button3.addActionListener(this);
        button1.setBounds(XCoordinate / 2, YCoordinate / 2, WIDTH / 2, HEIGHT / 2);
        button2.setBounds(XCoordinate / 2, YCoordinate / 2, WIDTH / 2, HEIGHT / 2);
        frame.setBounds(XCoordinate / 2 + 20, YCoordinate / 2 + 20, WIDTH, HEIGHT);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // REQUIRES: the action command from the 3 buttons in the setWelcomeComponents method.
    // MODIFIES: this
    // EFFECTS: if the user selects the option to load the data from the setWelcomeComponents function, the quiz class
    // is called and a new frame displaying the user's answers in the previous attempt of the quiz is shown. IF the
    // user selects the option to not load the data, a frame saying the same is displayed. If the user selects the
    // option to start the quiz directly, the questions are displayed from the QuestionWindow class and the welcome
    // window is hidden.
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("button1")) {
            JFrame frame = new JFrame();
            frame.setTitle("Data Loaded!");
            JPanel panel = new JPanel();
            panel.add(new JLabel("Your data was loaded!"));
            try {
                quiz = new Quiz();
            } catch (FileNotFoundException ex) {
                System.out.println("The file was not found");
            }
            ArrayList<JLabel> labels = quiz.displayLoadedAnswers();
            for (JLabel label : labels) {
                panel.add(label);
            }
            frame.add(panel);
            frame.setLayout(new FlowLayout());
            frame.getContentPane().setBackground(new Color(40, 196, 222));
            frame.setVisible(true);
            frame.setBounds(XCoordinate, YCoordinate, WIDTH, HEIGHT);
        }
        if (e.getActionCommand().equals("button2")) {
            JFrame frame = new JFrame();
            frame.setTitle("Not Loaded!");
            JPanel panel = new JPanel();
            panel.add(new JLabel("Your data will not be loaded!"));
            frame.add(panel);
            frame.setLayout(new FlowLayout());
            frame.getContentPane().setBackground(new Color(40, 196, 222));
            frame.setVisible(true);
            frame.setBounds(XCoordinate, YCoordinate, WIDTH - 500, HEIGHT - 300);
        }
        if (e.getActionCommand().equals("button3")) {
            try {
                new QuestionWindow();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            frame.setLayout(new FlowLayout());
            frame.setVisible(false);
            frame.setBounds(XCoordinate, YCoordinate, WIDTH, HEIGHT);
        }
    }
}
