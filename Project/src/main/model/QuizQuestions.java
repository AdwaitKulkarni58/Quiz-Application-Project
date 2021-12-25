/*
  This class contains information about the quiz questions
  including the questions and their corresponding answers.
  It uses different data types to store the answers of the
  user as well as the correct answers and provides this
  data to the Quiz class.
  It has the options to view questions and select answers
  and view the score at the end.
 */

package model;

import java.util.*;

public class QuizQuestions {

    int score;
    Map<String, String> questionsAndAnswers;

    // REQUIRES: the map data structure, specifically the field named questionsAndAnswers
    // MODIFIES: nothing
    // EFFECTS: creates a new linked hashmap by the name questionsAndAnswers
    public QuizQuestions() {
        questionsAndAnswers = new LinkedHashMap<>();
    }

    // REQUIRES: the score
    // MODIFIES: nothing
    // EFFECTS: returns the user score.
    public int getScore() {
        return score;
    }

    // REQUIRES: nothing
    // MODIFIES: this and questionsAndAnswers
    // EFFECTS: adds the questions and answers to the linked list in an ordered format
    public LinkedHashMap<String, String> entireQuestionsList() {
        questionsAndAnswers.put("Purpose of spinning jenny in the Industrial Revolution ",
                "\na)A device for making cloth\nb)A device for storing energy\nc)A steam engine\nd)A water pump\n\n");
        questionsAndAnswers.put("A city NOT founded by the Romans ", "\na)Alexandria\nb)Berlin\nc)London\nd)None\n\n");
        questionsAndAnswers.put("Number of wives Henry VIII had ", "\na)1\nb)6\nc)3\nd)2\n");
        questionsAndAnswers.put("Country of origin of Zoroastrianism ", "\na)Brazil\nb)Egypt\nc)Persia\nd)India\n\n");
        questionsAndAnswers.put("The person who captured Moscow for the last time in history ",
                "\na)No one\nb)Hitler\nc)Napoleon\nd)Ogedei Khan\n\n");
        questionsAndAnswers.put("First time the Winter Olympics were held in ",
                "\na)1896\nb)1900\nc)1888\nd)1924\n\n");
        questionsAndAnswers.put("Number of chapters in the Olympic Charter ", "\na)5\nb)6\nc)7\nd)8\n\n");
        EventLog.getInstance().logEvent(new Event("Added questions and answers."));
        return (LinkedHashMap<String, String>) questionsAndAnswers;
    }

    // REQUIRES: nothing
    // MODIFIES: this
    // EFFECTS: adds the correct answers of all the questions to
    // a linked list and returns that list.
    public ArrayList<String> storeCorrectAnswers() {
        ArrayList<String> correctAnswers = new ArrayList<>();
        correctAnswers.add("a");
        correctAnswers.add("a");
        correctAnswers.add("b");
        correctAnswers.add("c");
        correctAnswers.add("c");
        correctAnswers.add("d");
        correctAnswers.add("b");
        EventLog.getInstance().logEvent(new Event("Added all correct answers."));
        return correctAnswers;
    }

    // REQUIRES: storeCorrectAnswers and askQuestionsOneByOne is not empty
    // MODIFIES: nothing
    // EFFECTS: stores the answers obtained from storeCorrectAnswers and
    // askQuestionsOneByOne into 2 new linked lists and compares both of
    // them. Whenever the answer at a particular index in both the lists
    // is the same, the score of the user is incremented by 1 and the
    // total score is returned at the end of the method.
    public int compareAnswers(ArrayList<String> userAnswers) {
        ArrayList<String> correctAnswers = storeCorrectAnswers();
        int score = 0;
        for (int i = 0; i < userAnswers.size(); i++) {
            if (userAnswers.get(i).equals(correctAnswers.get(i))) {
                score++;
            }
        }
        return score;
    }
}
