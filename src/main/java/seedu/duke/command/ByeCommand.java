package seedu.duke.command;

import seedu.duke.task.TaskList;
import seedu.duke.task.Ui;
import seedu.duke.task.Storage;

public class ByeCommand extends Command {

    /**
     * Public constructor that returns a command to the system to terminate when executed.
     */
    public ByeCommand() {
        super(true);
    }

    /**
     * Terminates the system.
     * @param tasks the task list system involved in the command execution.
     * @param ui the user interface system involved in the command execution.
     * @param storage the storage system involved in the command execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        storage.saveTasks((tasks.getTaskList()), ui);
        ui.showGoodbye();
    }
}
