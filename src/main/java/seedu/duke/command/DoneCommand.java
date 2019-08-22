package seedu.duke.command;

import seedu.duke.task.TaskList;
import seedu.duke.task.Task;
import seedu.duke.task.Ui;
import seedu.duke.task.Storage;

public class DoneCommand extends Command {

    private int taskNoToBeChecked;

    /**
     * Public constructor that returns a command to the system to mark the task at taskNoToBeRemoved position
     * (one-based index) in the list as completed.
     * @param taskNoToBeChecked one-based index position of the task in the task list to be marked as completed.
     */
    public DoneCommand(int taskNoToBeChecked) {
        super(false);
        this.taskNoToBeChecked = taskNoToBeChecked;
    }

    /**
     * Marks the task at taskNoToBeRemoved position (one-based index) in the task list of the system as completed.
     * @param tasks the task list system involved in the command execution.
     * @param ui the user interface system involved in the command execution.
     * @param storage the storage system involved in the command execution.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.checkOffTask(taskNoToBeChecked);
        ui.showDoneMessage(task);
        super.resultMessage = ui.getDoneMessage(task);
    }
}
