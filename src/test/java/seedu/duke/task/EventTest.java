package seedu.duke.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EventTest {
    @Test
    public void testStringConversion() {
        assertEquals("[E][\u2718] party (at: my house)",
                new Event("party", "my house").toString());
        assertEquals("[E][\u2713] party (at: my house)",
                new Event("party", true, "my house").toString());
    }

    @Test
    public void testGetVenue() {
        assertEquals("tonight",
                new Event("return book", "tonight").getEventVenue());
        assertEquals("CC",
                new Event("returnsssss book", true, "CC").getEventVenue());
    }
}