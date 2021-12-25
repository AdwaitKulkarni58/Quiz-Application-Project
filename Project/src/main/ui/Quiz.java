/*
This class contains information about data that
is to be displayed on the screen and data that is to
be collected from the user by means of the scanner class.
It has methods to display different types of messages based
on the score obtained by the user and also gives the user
the option to play the quiz again.
 */

package ui;

import model.QuizQuestions;
import model.Object;
import model.WorkRoom;
import persistence.JsonReader;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Quiz {
    private static final String JSON_STORE = "./data/quizquestions.json";
    private WorkRoom workRoom;
    private final JsonReader jsonReader;
    QuizQuestions quizQuestions;

    // REQUIRES: nothing
    // MODIFIES: nothing
    // EFFECTS: prints out the statement in the displayGreeting method
    public Quiz() throws FileNotFoundException {
        workRoom = new WorkRoom("Adwait's WorkRoom");
        jsonReader = new JsonReader(JSON_STORE);
        quizQuestions = new QuizQuestions();
        displayLoadedAnswers();
    }

    // REQUIRES: nothing
    // MODIFIES: nothing
    // EFFECTS: prints out a greeting message for the user.
    public ArrayList<JLabel> displayLoadedAnswers() {
        ArrayList<JLabel> loadedAnswers = new ArrayList<>();
        loadWorkRoom();
        List<Object> objects = workRoom.getObjects();
        for (Object o : objects) {
            JLabel label = new JLabel(Arrays.toString(o.toString().split(": ")) + "\n");
            loadedAnswers.add(label);
        }
        return loadedAnswers;
    }

    // MODIFIES: this
    // EFFECTS: loads the workroom from the file
    public void loadWorkRoom() {
        try {
            workRoom = jsonReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
