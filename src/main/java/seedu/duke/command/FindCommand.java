package seedu.duke.command;

import seedu.duke.task.Task;
import seedu.duke.task.TaskList;
import seedu.duke.task.Ui;
import seedu.duke.task.Storage;

import java.util.List;

public class FindCommand extends Command {

    private String substring;

    /**
     * Public constructor that returns a command to find tasks with descriptions that contain the substring.
     * @param substring the substring to be searched in the list of task descriptions.
     */
    public FindCommand(String substring) {
        super(false);
        this.substring = substring;
    }

    /**
     * Prints a list of tasks that contain the substring in their task descriptions.
     * @param tasks the task list system involved in the command execution.
     * @param ui the user interface system involved in the command execution.
     * @param storage the storage system involved in the command execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        List<Task> taskList = tasks.findTasks(substring);
        ui.showTaskList(taskList);
        super.resultMessage = ui.getTaskList(taskList);
    }
}
