/*
This class represents the actual quiz where the user is asked 7 questions where each question contains 4 answer choices
and the user can enter his/her answer in the provided text field. The class contains seven methods for dealing with
seven questions. Each function displays one question on the screen along with the answer options and an area to enter
the answer. After each question, a button for displaying the next question is displayed and when the user clicks that
button, a popup window displaying a message appears. The class has a method for listening to action events and
handling those events. The class contains methods to save the user answer to the workroom class and add that
answer to the Object class from where it is added to the JSON file in the data package. Lastly, the class contains a
method that displays an image in a new frame after the user has answered all the questions.
Credit for music used in this project: "Music: www.bensound.com"
 */

package ui.gui;

import model.*;
import model.Object;
import persistence.JsonWriter;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class QuestionWindow extends JFrame implements ActionListener {

    private static final int XCoordinate = 100;
    private static final int YCoordinate = 50;
    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;
    private final JFrame frame;
    private final WorkRoom workroom;
    private final JsonWriter jsonWriter;
    private final JTextField textField;
    QuizQuestions quizQuestions;
    QuestionSavedPopUp questionSavedPopUp;
    DisplayCorrectAnswerMessage displayCorrectAnswerMessage;
    DisplayWrongAnswerMessage displayWrongAnswerMessage;

    // REQUIRES: the quizquestions json file from the data package and the workroom from the WorkRoom class.
    // MODIFIES: nothing
    // EFFECTS: constructs a new frame and sets up the required fields for displaying the questions
    // and saving and loading the answers to those questions. Throws a FileNotFound exception if the quizquestions json
    // file is not found in the data package. Sets up the music file to play as long as the welcome window is being
    // displayed.
    public QuestionWindow() throws FileNotFoundException {
        textField = new JTextField(10);
        frame = new JFrame();
        frame.setTitle("Quiz Application");
        frame.getContentPane().setBackground(new Color(200, 230, 2));
        jsonWriter = new JsonWriter("./data/quizquestions.json");
        workroom = new WorkRoom("Adwait's WorkRoom");
        try {
            AudioClip clip = Applet.newAudioClip(new URL("file:./data/bensound-ukulele.wav"));
            clip.play();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        quizQuestions = new QuizQuestions();
        closeWindow();
        displayQuestionsOnScreen();
    }

    // REQUIRES: the class fields for setting up the position and dimensions of the frame.
    // MODIFIES: this
    // EFFECTS: sets the position and dimensions of the frame and gives it a layout of flow layout. Calls the
    // displayFirstQuestion method to display the first question on the screen.
    public void displayQuestionsOnScreen() {
        displayFirstQuestion();
        frame.setBounds(XCoordinate + 20, YCoordinate + 20, WIDTH, HEIGHT);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

    // REQUIRES: the textField class constant for displaying the text area for the user to enter his/her answer and a
    // frame for displaying the question and its answer options.
    // MODIFIES: this
    // EFFECTS: displays the first question on the screen and its corresponding answer options and a text area to
    // enter the answer. Also has a button to navigate to the next question.
    public void displayFirstQuestion() {
        textField.setText("");
        frame.add(new JLabel("Purpose of spinning jenny in the Industrial Revolution "));
        JLabel label1 = new JLabel("A) A device for making cloth");
        JLabel label2 = new JLabel("B) A device for storing energy");
        JLabel label3 = new JLabel("C) A steam engine");
        JLabel label4 = new JLabel("D) A water pump");
        textField.setActionCommand("textField");
        textField.addActionListener(this);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(textField);
        frame.setVisible(true);
        JButton button = new JButton("Next Question");
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.setActionCommand("button1");
        button.addActionListener(this);
    }

    // REQUIRES: the textField class constant for displaying the text area for the user to enter his/her answer and a
    // frame for displaying the question and its answer options.
    // MODIFIES: this
    // EFFECTS: displays the second question on the screen and its corresponding answer options and a text area to
    // enter the answer. Also has a button to navigate to the next question.
    public void displaySecondQuestion() {
        textField.setText("");
        frame.add(new JLabel("A city NOT founded by the Romans "));
        JLabel label1 = new JLabel("A) Alexandria");
        JLabel label2 = new JLabel("B) Berlin");
        JLabel label3 = new JLabel("C) London");
        JLabel label4 = new JLabel("D) None");
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(textField);
        frame.setVisible(true);
        saveWorkRoom();
        JButton button = new JButton("Next Question");
        frame.add(button);
        button.setActionCommand("button2");
        button.addActionListener(this);
    }

    // REQUIRES: the textField class constant for displaying the text area for the user to enter his/her answer and a
    // frame for displaying the question and its answer options.
    // MODIFIES: this
    // EFFECTS: displays the fourth question on the screen and its corresponding answer options and a text area to
    // enter the answer. Also has a button to navigate to the next question.
    public void displayThirdQuestion() {
        textField.setText("");
        frame.add(new JLabel("Number of wives Henry VIII had "));
        JLabel label1 = new JLabel("A) 1");
        JLabel label2 = new JLabel("B) 6");
        JLabel label3 = new JLabel("C) 3");
        JLabel label4 = new JLabel("D) 2");
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(textField);
        frame.setVisible(true);
        JButton button = new JButton("Next Question");
        frame.add(button);
        button.setActionCommand("button3");
        button.addActionListener(this);
    }


    // REQUIRES: the textField class constant for displaying the text area for the user to enter his/her answer and a
    // frame for displaying the question and its answer options.
    // MODIFIES: this
    // EFFECTS: displays the third question on the screen and its corresponding answer options and a text area to
    // enter the answer. Also has a button to navigate to the next question.
    public void displayFourthQuestion() {
        textField.setText("");
        frame.add(new JLabel("Country of origin of Zoroastrianism "));
        JLabel label1 = new JLabel("A) Brazil");
        JLabel label2 = new JLabel("B) Egypt");
        JLabel label3 = new JLabel("C) Persia");
        JLabel label4 = new JLabel("D) India");
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(textField);
        frame.setVisible(true);
        JButton button = new JButton("Next Question");
        frame.add(button);
        button.setActionCommand("button4");
        button.addActionListener(this);
    }

    // REQUIRES: the textField class constant for displaying the text area for the user to enter his/her answer and a
    // frame for displaying the question and its answer options.
    // MODIFIES: this
    // EFFECTS: displays the fifth question on the screen and its corresponding answer options and a text area to
    // enter the answer. Also has a button to navigate to the next question.
    public void displayFifthQuestion() {
        textField.setText("");
        frame.add(new JLabel("The person who captured Moscow for the last time in history "));
        JLabel label1 = new JLabel("A) No one");
        JLabel label2 = new JLabel("B) Hitler");
        JLabel label3 = new JLabel("C) Napoleon");
        JLabel label4 = new JLabel("D) Ogedei Khan");
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(textField);
        frame.setVisible(true);
        JButton button = new JButton("Next Question");
        frame.add(button);
        button.setActionCommand("button5");
        button.addActionListener(this);
    }

    // REQUIRES: the textField class constant for displaying the text area for the user to enter his/her answer and a
    // frame for displaying the question and its answer options.
    // MODIFIES: this
    // EFFECTS: displays the sixth question on the screen and its corresponding answer options and a text area to
    // enter the answer. Also has a button to navigate to the next question.
    public void displaySixthQuestion() {
        textField.setText("");
        frame.add(new JLabel("First time the Winter Olympics were held in "));
        JLabel label1 = new JLabel("A) 1896");
        JLabel label2 = new JLabel("B) 1900");
        JLabel label3 = new JLabel("C) 1888");
        JLabel label4 = new JLabel("D) 1924");
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(textField);
        frame.setVisible(true);
        JButton button = new JButton("Next Question");
        frame.add(button);
        button.setActionCommand("button6");
        button.addActionListener(this);
    }

    // REQUIRES: the textField class constant for displaying the text area for the user to enter his/her answer and a
    // frame for displaying the question and its answer options.
    // MODIFIES: this
    // EFFECTS: displays the seventh question on the screen and its corresponding answer options and a text area to
    // enter the answer. Also has a button to end the quiz.
    public void displaySeventhQuestion() {
        textField.setText("");
        frame.add(new JLabel("Number of chapters in the Olympic Charter "));
        JLabel label1 = new JLabel("A) 5");
        JLabel label2 = new JLabel("B) 6");
        JLabel label3 = new JLabel("C) 7");
        JLabel label4 = new JLabel("D) 8");
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(textField);
        frame.setVisible(true);
        JButton button = new JButton("End Quiz");
        frame.add(button);
        button.setActionCommand("button7");
        button.addActionListener(this);
    }

    // REQUIRES: jsonWriter and workRoom objects to write the user answers to the json file.
    // MODIFIES: workRoom
    // EFFECTS: jsonWriter object opens the json file and writes the answers object to it and closes the file. Throws
    // a FileNotFound exception if the json file is not found.
    public void saveWorkRoom() {
        try {
            jsonWriter.open();
            jsonWriter.write(workroom);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // REQUIRES: the Quiz_Over_Image from the data package
    // MODIFIES: this
    // EFFECTS: after the user clicks the end quiz button, an image is displayed in a separate frame and the program
    // terminates after closing that frame. The music file in the data folder plays as long as the image is being
    // displayed on the screen. As soon as the user closes the window, the printLog method from the PrintLog class
    // is called and the logged events are displayed on the console.
    public void displayQuizEndImage() {
        JButton button = new JButton("Print Log");
        button.setActionCommand("log");
        button.addActionListener(this);
        frame.getContentPane().setBackground(new Color(230, 230, 20));
        JLabel endQuiz = new JLabel(new ImageIcon("./data/Quiz_Over_Image.png"));
        frame.add(endQuiz);
        frame.add(button);
        frame.setBounds(XCoordinate - 90, YCoordinate - 50, WIDTH + 600, HEIGHT + 500);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                PrintLog printLog = new PrintLog();
                printLog.printLog(EventLog.getInstance());
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // REQUIRES: nothing
    // MODIFIES: this
    // EFFECTS: sets an action listener for the entire window and as soon as the user closes the window, calls the
    // printLog method from the PrintLog class and displays the events on the console.
    public void closeWindow() {
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                PrintLog printLog = new PrintLog();
                printLog.printLog(EventLog.getInstance());
            }
        });
    }

    // REQUIRES: the action command for each of the buttons of the questions displayed.
    // MODIFIES: this and workRoom
    // EFFECTS: as soon as the user selects the option to go to the next question, the answer to this question is saved
    // in the added to the answer object and the object is added to the workRoom. After this action, a popup window
    // with a message informing the user whether his/her answer was correct or wrong and the method displaying the
    // next question is called.
    // NOTE: For the last question, all the above actions are carried out except for displaying the next question as the
    // quiz ends after seven questions. A method that portrays a picture of the same is called and a popup showing that
    // all the answers were saved is shown.
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    @Override
    public void actionPerformed(ActionEvent e) {
        questionSavedPopUp = new QuestionSavedPopUp();
        displayCorrectAnswerMessage = new DisplayCorrectAnswerMessage();
        displayWrongAnswerMessage = new DisplayWrongAnswerMessage();
        if (e.getActionCommand().equals("button1")) {
            String response = textField.getText();
            workroom.addObject(new Object(response));
            saveWorkRoom();
            if (response.equals(quizQuestions.storeCorrectAnswers().get(0))) {
                displayCorrectAnswerMessage.displayWindow();
            } else {
                displayWrongAnswerMessage.displayWindow();
            }
            displaySecondQuestion();
        } else if (e.getActionCommand().equals("button2")) {
            String response = textField.getText();
            workroom.addObject(new Object(response));
            saveWorkRoom();
            if (response.equals(quizQuestions.storeCorrectAnswers().get(1))) {
                displayCorrectAnswerMessage.displayWindow();
            } else {
                displayWrongAnswerMessage.displayWindow();
            }
            displayThirdQuestion();
        } else if (e.getActionCommand().equals("button3")) {
            String response = textField.getText();
            workroom.addObject(new Object(response));
            saveWorkRoom();
            if (response.equals(quizQuestions.storeCorrectAnswers().get(2))) {
                displayCorrectAnswerMessage.displayWindow();
            } else {
                displayWrongAnswerMessage.displayWindow();
            }
            displayFourthQuestion();
        } else if (e.getActionCommand().equals("button4")) {
            String response = textField.getText();
            workroom.addObject(new Object(response));
            saveWorkRoom();
            if (response.equals(quizQuestions.storeCorrectAnswers().get(3))) {
                displayCorrectAnswerMessage.displayWindow();
            } else {
                displayWrongAnswerMessage.displayWindow();
            }
            displayFifthQuestion();
        } else if (e.getActionCommand().equals("button5")) {
            String response = textField.getText();
            workroom.addObject(new Object(response));
            saveWorkRoom();
            if (response.equals(quizQuestions.storeCorrectAnswers().get(4))) {
                displayCorrectAnswerMessage.displayWindow();
            } else {
                displayWrongAnswerMessage.displayWindow();
            }
            displaySixthQuestion();
        } else if (e.getActionCommand().equals("button6")) {
            String response = textField.getText();
            workroom.addObject(new Object(response));
            saveWorkRoom();
            if (response.equals(quizQuestions.storeCorrectAnswers().get(5))) {
                displayCorrectAnswerMessage.displayWindow();
            } else {
                displayWrongAnswerMessage.displayWindow();
            }
            displaySeventhQuestion();
        } else if (e.getActionCommand().equals("button7")) {
            String response = textField.getText();
            workroom.addObject(new Object(response));
            saveWorkRoom();
            if (response.equals(quizQuestions.storeCorrectAnswers().get(6))) {
                displayCorrectAnswerMessage.displayWindow();
            } else {
                displayWrongAnswerMessage.displayWindow();
            }
            frame.setVisible(false);
            questionSavedPopUp.displayPopUpWindow();
            displayQuizEndImage();
        } else if (e.getActionCommand().equals("log")) {
            frame.setVisible(false);
            PrintLog printLog = new PrintLog();
            printLog.printLog(EventLog.getInstance());
            System.exit(1);
        }
    }
}