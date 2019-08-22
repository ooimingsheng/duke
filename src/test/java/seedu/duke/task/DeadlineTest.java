package seedu.duke.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeadlineTest {

    @Test
    public void testStringConversion() {
        assertEquals("[D][\u2718] return book (by: Sunday)",
                     new Deadline("return book", "Sunday").toString());
        assertEquals("[D][\u2713] return book (by: Sunday)",
                     new Deadline("return book", true, "Sunday").toString());
    }

    @Test
    public void testGetDeadline() {
        assertEquals("Friday",
                new Deadline("return book", "Friday").getDeadline());
        assertEquals("Later",
                new Deadline("returnsssss book", true, "Later").getDeadline());
    }
}