package seedu.duke.command;

import seedu.duke.task.TaskList;
import seedu.duke.task.Task;
import seedu.duke.task.Ui;
import seedu.duke.task.Storage;

public class DeleteCommand extends Command {

    private int taskNoToBeRemoved;

    /**
     * Public constructor that returns a command to the system to delete the task at taskNoToBeRemoved position
     * (one-based index) in the list.
     * @param taskNoToBeRemoved the one-based index position of the task in the task list to be deleted
     */
    public DeleteCommand(int taskNoToBeRemoved) {
        super(false);
        this.taskNoToBeRemoved = taskNoToBeRemoved;
    }

    /*
     * Delete the task at taskNoToBeRemoved position (one-based index) in the task list of the system.
     * @param tasks the task list system involved in the command execution.
     * @param ui the user interface system involved in the command execution.
     * @param storage the storage system involved in the command execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        assert taskNoToBeRemoved >= 0 && taskNoToBeRemoved < tasks.getTaskList().size();
        Task task = tasks.removeTask(taskNoToBeRemoved);
        ui.showDeleteMessage(task, tasks);
        super.resultMessage = ui.getDeleteMessage(task, tasks);
    }
}
