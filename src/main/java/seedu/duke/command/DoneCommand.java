package seedu.duke.command;

import seedu.duke.task.TaskList;
import seedu.duke.task.Task;
import seedu.duke.task.Ui;
import seedu.duke.task.Storage;

public class DoneCommand extends Command {

    private int taskNoToBeChecked;

    public DoneCommand(int taskNoToBeChecked) {
        super(false);
        this.taskNoToBeChecked = taskNoToBeChecked;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.checkOffTask(taskNoToBeChecked);
        ui.showDoneMessage(task);
    }
}
