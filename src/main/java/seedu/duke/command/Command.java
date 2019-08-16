package seedu.duke.command;

import seedu.duke.task.TaskList;
import seedu.duke.task.Ui;
import seedu.duke.task.Storage;

public class Command {

    protected String[] params;
    protected String action;
    protected boolean isExit;

    /**
     * Command has a private constructor to prevent the object from being created directly.
     */
    private Command() {
    }

    protected Command(boolean isExit) {
        this.isExit = isExit;
    }

    public boolean isExit() {
        return isExit;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
    }
}
