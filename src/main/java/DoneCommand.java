public class DoneCommand extends Command {

    int taskNoToBeChecked;

    public DoneCommand(int taskNoToBeChecked){
        super(false);
        this.taskNoToBeChecked = taskNoToBeChecked;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.checkOffTask(taskNoToBeChecked);
        ui.showDoneMessage(task);
    }
}
