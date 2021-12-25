/*
This interface contains a method named toJson that returns the
JSONObject that is given to it.
CITATION: This class makes use of the methods, fields, and structure
 of the Writable interface of the JsonSerializationDemo repository.
 The repository is the following one:
 https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

package persistence;

import org.json.JSONObject;

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
