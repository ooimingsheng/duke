package seedu.duke.command;

import seedu.duke.task.*;

import java.security.DigestException;

public class AddCommand extends Command {

    private String taskDescription;
    private String taskType;

    /**
     * Public constructor that returns a command to the system to add a reminder when executed.
     * @param taskDescription the description of the task.
     * @param taskType the type of task to be added to the record.
     */
    public AddCommand(String taskDescription, String taskType) {
        super(false);
        this.taskDescription = taskDescription;
        this.taskType = taskType;
    }

    /**
     * Adds a task to the system.
     * @param tasks the task list system involved in the command execution.
     * @param ui the user interface system involved in the command execution.
     * @param storage the storage system involved in the command execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task = tasks.addTask(taskDescription, taskType);
        ui.showAddMessage(task, tasks);
        super.resultMessage = ui.getAddMessage(task, tasks);
    }
}
