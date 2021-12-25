/*
This class creates a collection of objects and has different
methods for operating on those objects like getting their names,
adding them to the workroom, calculating total objects, converting them
to JSON format, namely JSONObject and JSONArray.
CITATION: This class makes use of the methods and structure
 of the WorkRoom class of the JsonSerializationDemo repository.
 The repository is the following one:
 https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a workroom having a collection of objects
public class WorkRoom implements Writable {
    private final String name;
    private final List<Object> objects;

    // EFFECTS: constructs workroom with a name and empty list of objects
    public WorkRoom(String name) {
        this.name = name;
        objects = new ArrayList<>();
    }

    // EFFECTS: returns the name of the workroom
    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: adds an object to this workroom
    public void addObject(Object object) {
        objects.add(object);
        EventLog.getInstance().logEvent(new Event("Added a JSON object"));
    }

    // EFFECTS: returns an unmodifiable list of objects in this workroom
    public List<Object> getObjects() {
        return Collections.unmodifiableList(objects);
    }

    // EFFECTS: returns number of objects in this workroom
    public int numObjects() {
        return objects.size();
    }

    // EFFECTS: creates a new JSON object and puts a name key and an objects
    // JSON array and returns it.
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("objects", objectsToJson());
        EventLog.getInstance().logEvent(new Event("Created new JSON object."));
        return json;
    }

    // EFFECTS: returns objects in this workroom as a JSON array
    private JSONArray objectsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Object o : objects) {
            jsonArray.put(o.toJson());
        }
        EventLog.getInstance().logEvent(new Event("Objects were returned as an array."));
        return jsonArray;
    }
}

