import java.util.List;

abstract class Command {

    String[] params;
    String action;
    boolean isExit;

    protected Command(boolean isExit) {
        this.isExit = isExit;
    }

    public boolean isExit() {
        return isExit;
    }

    abstract public void execute(TaskList tasks, Ui ui, Storage storage);
}
