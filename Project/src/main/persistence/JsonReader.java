/*
 This class is used to read data in the workroom and converts it
 to a string. It parses the workroom for objects and adds them to the
 JSON object.
 CITATION: This class makes use of the methods, fields, and structure
 of the JsonReader class of the JsonSerializationDemo repository.
 The repository is the following one:
 https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */

package persistence;

import model.Object;
import model.WorkRoom;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorkRoom read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private WorkRoom parseWorkRoom(JSONObject jsonObject) {
        String answer = jsonObject.getJSONArray("objects").getJSONObject(0).getString("answer");
        WorkRoom wr = new WorkRoom(answer);
        addObjects(wr, jsonObject);
        return wr;
    }

    // MODIFIES: wr
    // EFFECTS: parses objects from JSON object and adds them to workroom
    private void addObjects(WorkRoom wr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("objects");
        for (java.lang.Object json : jsonArray) {
            JSONObject nextObject = (JSONObject) json;
            addObject(wr, nextObject);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses object from JSON object and adds it to workroom
    private void addObject(WorkRoom wr, JSONObject jsonObject) {
        String answer = jsonObject.getString("answer");
        Object object = new Object(answer);
        wr.addObject(object);
    }
}