package seedu.duke.command;

import seedu.duke.task.TaskList;
import seedu.duke.task.Ui;
import seedu.duke.task.Storage;

public class ListCommand extends Command {

    public ListCommand() {
        super(false);
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks.getTaskList());
    }
}
