package persistence;

import model.Object;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit test for Json
public class JsonTest {
    protected void checkObject(String answer, Object object) {
        assertEquals(answer, object.getAnswer());
    }
}
