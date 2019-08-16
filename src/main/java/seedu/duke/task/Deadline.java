package seedu.duke.task;

public class Deadline extends Task {

    private String by;

    /**
     * Public constructor that returns a uncompleted task with a deadline.
     * @param description the description of the task.
     * @param by the deadline of the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = DukeDateFormatter.convertStringToDateIfPossible(by);
    }

    /**
     * Public constructor that returns a task with a deadline.
     * @param description the description of the task.
     * @param isDone whether the task has been completed.
     * @param by the deadline of the task.
     */
    public Deadline(String description, boolean isDone, String by) {
        super(description, isDone);
        this.by = by;
    }

    /**
     * Returns the deadline of the task.
     * @return the deadline of the task.
     */
    public String getDeadline() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}