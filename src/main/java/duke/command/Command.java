package duke.command;

import duke.task.*;

public class Command {

    protected String[] params;
    protected String action;
    protected boolean isExit;

    private Command() {}

    protected Command(boolean isExit) {
        this.isExit = isExit;
    }

    public boolean isExit() {
        return isExit;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {}
}
