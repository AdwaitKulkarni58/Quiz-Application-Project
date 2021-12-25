package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class QuizQuestionsTest {

    private QuizQuestions q;

    @BeforeEach
    public void runBefore() {
        q = new QuizQuestions();
    }

    @Test
    public void testToString() {
        Object o = new Object("xyz");
        assertEquals("xyz: ", o.toString());
    }

    @Test
    public void testGetScore() {
        int score = q.getScore();
        assertEquals(0, score);
        ArrayList<String> userAnswers = new ArrayList<>();
        ArrayList<String> correctAnswers = new ArrayList<>();
        userAnswers.add("c");
        userAnswers.add("b");
        userAnswers.add("c");
        correctAnswers.add("c");
        correctAnswers.add("b");
        correctAnswers.add("c");
        for (int i = 0; i < userAnswers.size(); i++) {
            if (userAnswers.get(i).equals(correctAnswers.get(i))) {
                score++;
            }
        }
        assertEquals(3, score);
    }

    @Test
    public void testEntireQuestionsList() {
        LinkedHashMap<String, String> lh = q.entireQuestionsList();
        assertEquals(7, lh.size());
        lh.put("My name", "xyz");
        lh.put("favorite pet", "dog");
        lh.put("favorite food", "pizza");
        lh.put("Favorite sport", "soccer");
        assertEquals(11, lh.size());
        lh.remove("My name");
        lh.remove("favorite pet");
        assertEquals(9, lh.size());
        lh.put("hobby", "music");
        assertEquals(10, lh.size());
    }

    @Test
    public void testStoreCorrectAnswers() {
        ArrayList<String> correctAnswers = q.storeCorrectAnswers();
        correctAnswers.add("a");
        correctAnswers.add("b");
        correctAnswers.add("c");
        correctAnswers.add("d");
        correctAnswers.add("e");
        assertEquals(12, correctAnswers.size());
        correctAnswers.remove("a");
        correctAnswers.remove("b");
        assertEquals(10, correctAnswers.size());
        correctAnswers.add("a");
        assertEquals(11, correctAnswers.size());
    }

    @Test
    public void testCompareAnswersAllCorrect() {
        ArrayList<String> artificialInputs = new ArrayList<>();
        artificialInputs.add("a");
        artificialInputs.add("a");
        artificialInputs.add("b");
        int score = q.compareAnswers(artificialInputs);
        assertEquals(3, score);
    }

    @Test
    public void testCompareAnswersAllWrong() {
        ArrayList<String> artificialInputs = new ArrayList<>();
        artificialInputs.add("d");
        artificialInputs.add("b");
        artificialInputs.add("c");
        int score = q.compareAnswers(artificialInputs);
        assertEquals(0, score);
    }

    @Test
    public void testCompareAnswersFirstCorrectRestWrong() {
        ArrayList<String> artificialInputs = new ArrayList<>();
        artificialInputs.add("a");
        artificialInputs.add("b");
        artificialInputs.add("c");
        int score = q.compareAnswers(artificialInputs);
        assertEquals(1, score);
    }

    @Test
    public void testCompareAnswersMiddleCorrectRestWrong() {
        ArrayList<String> artificialInputs = new ArrayList<>();
        artificialInputs.add("b");
        artificialInputs.add("a");
        artificialInputs.add("c");
        int score = q.compareAnswers(artificialInputs);
        assertEquals(1, score);
    }

    @Test
    public void testCompareAnswersLastCorrectRestWrong() {
        ArrayList<String> artificialInputs = new ArrayList<>();
        artificialInputs.add("c");
        artificialInputs.add("b");
        artificialInputs.add("b");
        int score = q.compareAnswers(artificialInputs);
        assertEquals(1, score);
    }

    @Test
    public void testCompareAnswersFirstAnswerWrong() {
        ArrayList<String> artificialInputs = new ArrayList<>();
        artificialInputs.add("b");
        artificialInputs.add("a");
        artificialInputs.add("b");
        int score = q.compareAnswers(artificialInputs);
        assertEquals(2, score);
    }

    @Test
    public void testCompareAnswersMiddleAnswerWrong() {
        ArrayList<String> artificialInputs = new ArrayList<>();
        artificialInputs.add("a");
        artificialInputs.add("b");
        artificialInputs.add("b");
        int score = q.compareAnswers(artificialInputs);
        assertEquals(2, score);
    }

    @Test
    public void testCompareAnswersLastAnswerWrong() {
        ArrayList<String> artificialInputs = new ArrayList<>();
        artificialInputs.add("a");
        artificialInputs.add("a");
        artificialInputs.add("c");
        int score = q.compareAnswers(artificialInputs);
        assertEquals(2, score);
    }

    @Test
    public void testCompareAnswersOtherOptionChosen() {
        ArrayList<String> artificialInputs = new ArrayList<>();
        artificialInputs.add("a");
        artificialInputs.add("a");
        artificialInputs.add("z");
        int score = q.compareAnswers(artificialInputs);
        assertEquals(2, score);
    }

    @Test
    public void testCompareAnswersNoOptionChosenFromList() {
        ArrayList<String> artificialInputs = new ArrayList<>();
        artificialInputs.add("r");
        artificialInputs.add("s");
        artificialInputs.add("t");
        int score = q.compareAnswers(artificialInputs);
        assertEquals(0, score);
    }
}
