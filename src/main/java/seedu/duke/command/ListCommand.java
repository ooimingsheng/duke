package seedu.duke.command;

import seedu.duke.task.TaskList;
import seedu.duke.task.Ui;
import seedu.duke.task.Storage;

public class ListCommand extends Command {

    /**
     * Public constructor that returns a command to the system to list all the tasks in the system.
     */
    public ListCommand() {
        super(false);
    }

    /*
     * List all the tasks in the system.
     * @param tasks the task list system involved in the command execution.
     * @param ui the user interface system involved in the command execution.
     * @param storage the storage system involved in the command execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks.getTaskList());
    }
}
