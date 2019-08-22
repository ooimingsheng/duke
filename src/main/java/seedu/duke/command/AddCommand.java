package seedu.duke.command;

import seedu.duke.task.TaskList;
import seedu.duke.task.Task;
import seedu.duke.task.Ui;
import seedu.duke.task.Storage;

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
     * Public constructor that returns a command to the system to add a "To Do" reminder when executed.
     * @param taskDescription the description of the task.
     */
    public AddCommand(String taskDescription) {
        super(false);
        this.taskDescription = taskDescription;
    }

    /**
     * Adds a task to the system.
     * @param tasks the task list system involved in the command execution.
     * @param ui the user interface system involved in the command execution.
     * @param storage the storage system involved in the command execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = taskType != null ? tasks.addTask(taskDescription, taskType) : tasks.addTask(taskDescription);
        ui.showAddMessage(task, tasks);
        super.resultMessage = ui.getAddMessage(task, tasks);
    }
}
