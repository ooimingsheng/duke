package seedu.duke.task;

public class ToDo extends Task {

    /**
     * Public constructor that returns a uncompleted task.
     * @param description the description of the task.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Public constructor that returns a uncompleted task.
     * @param description the description of the task.
     * @param isDone whether the task has been completed.
     */
    public ToDo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
