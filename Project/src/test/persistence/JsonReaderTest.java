package persistence;

import model.Object;
import model.WorkRoom;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Unit test for JsonReader
public class JsonReaderTest extends JsonTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            WorkRoom wr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoomWithNoValues() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoomWithNoValues.json");
        try {
            WorkRoom wr = reader.read();
            List<Object> objects = wr.getObjects();
            assertEquals(1, wr.numObjects());
            checkObject("", objects.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            WorkRoom wr = reader.read();
            assertEquals("a", wr.getName());
            List<Object> objects = wr.getObjects();
            assertEquals(2, objects.size());
            checkObject("a", objects.get(0));
            checkObject("b", objects.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
