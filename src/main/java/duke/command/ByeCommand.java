package duke.command;

import duke.task.*;

public class ByeCommand extends Command {

    public ByeCommand(){
        super(true);
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        storage.saveTasks((tasks.getTaskList()));
        ui.showGoodbye();
    }
}
