package seedu.duke.command;

import seedu.duke.task.DukeException;
import seedu.duke.task.TaskList;
import seedu.duke.task.Ui;
import seedu.duke.task.Storage;

abstract public class Command {

    protected String[] params;
    protected String action;
    protected String resultMessage;
    protected boolean isExit;

    /**
     * Public constructor that returns a command to the system.
     * @param isExit whether the system should terminate after the current command.
     */
    protected Command(boolean isExit) {
        this.isExit = isExit;
    }

    /**
     * Returns whether the system should terminate after the current command.
     * @return whether the system should terminate after the current command.
     */
    public boolean isExit() {
        return isExit;
    }

    /**
     * Does nothing.
     * @param tasks the task list system involved in the command execution.
     * @param ui the user interface system involved in the command execution.
     * @param storage the storage system involved in the command execution.
     */
    abstract public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /**
     * Returns the result of executing the command or the empty string if the command has not been executed.
     */
    public String getResultOfCommand() {
        return resultMessage;
    }
}
