package seedu.duke.command;

import seedu.duke.task.TaskList;
import seedu.duke.task.Task;
import seedu.duke.task.Ui;
import seedu.duke.task.Storage;

public class DeleteCommand extends Command {

    private int taskNoToBeRemoved;

    public DeleteCommand(int taskNoToBeRemoved) {
        super(false);
        this.taskNoToBeRemoved = taskNoToBeRemoved;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.removeTask(taskNoToBeRemoved);
        ui.showDeleteMessage(task, tasks);
    }
}
