package seedu.duke.task;

public class DukeException extends Exception {

    /**
     * Public constructor that returns a duke exception with a message.
     * @param msg the error message.
     */
    public DukeException(String msg) {
        super(msg);
    }

    /**
     * Public constructor that returns a duke exception.
     */
    public DukeException() {
        super();
    }
}
