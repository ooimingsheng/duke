package seedu.duke.command;

import seedu.duke.task.TaskList;
import seedu.duke.task.Ui;
import seedu.duke.task.Storage;

public class ByeCommand extends Command {

    public ByeCommand() {
        super(true);
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        storage.saveTasks((tasks.getTaskList()), ui);
        ui.showGoodbye();
    }
}
