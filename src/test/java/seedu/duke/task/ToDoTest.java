package seedu.duke.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ToDoTest {

    @Test
    public void testStringConversion() {
        assertEquals("[T][\u2718] return book",
                new ToDo("return book").toString());
        assertEquals("[T][\u2713] return book",
                new ToDo("return book", true).toString());
        assertEquals("[T][\u2718] return book",
                new ToDo("return book", false).toString());
    }

}