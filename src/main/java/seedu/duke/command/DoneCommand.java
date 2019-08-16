package seedu.duke.command;

import seedu.duke.task.*;

public class DoneCommand extends Command {

    private int taskNoToBeChecked;

    public DoneCommand(int taskNoToBeChecked){
        super(false);
        this.taskNoToBeChecked = taskNoToBeChecked;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.checkOffTask(taskNoToBeChecked);
        ui.showDoneMessage(task);
    }
}
