package seedu.duke.task;

public class Event extends Task {

    private String at;

    /**
     * Public constructor that returns a uncompleted task with a venue.
     * @param description the description of the task.
     * @param at the venue of the event task.
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Public constructor that returns a uncompleted task with a venue.
     * @param description the description of the task.
     * @param isDone whether the task has been completed.
     * @param at the venue of the event task.
     */
    public Event(String description, boolean isDone, String at) {
        super(description, isDone);
        this.at = at;
    }

    /**
     * Returns the event venue of the task.
     * @return the event venue of the task.
     */
    public String getEventVenue() {
        return at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
