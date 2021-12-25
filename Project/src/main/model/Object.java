/*
This class represents one object in the workroom and has methods
operating on that object like converting it to a string and entering
its value in the JSON file.
CITATION: This class makes use of the methods and structure
 of the Thingy class of the JsonSerializationDemo repository.
 The repository is the following one:
 https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents an object having an answer
public class Object implements Writable {
    private final String answer;

    // EFFECTS: constructs an object with an answer
    public Object(String answer) {
        this.answer = answer;
    }

    // EFFECTS: returns the answer of the question entered by the user.
    public String getAnswer() {
        return answer;
    }

    // EFFECTS: returns string representation of this object
    public String toString() {
        return answer + ": ";
    }

    // EFFECTS: creates a new JSON object, puts a key and its value, and returns it.
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("answer", answer);
        EventLog.getInstance().logEvent(new Event("Answer added to the json object."));
        return json;
    }
}