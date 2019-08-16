package duke.command;

import duke.task.*;

public class DeleteCommand extends Command {

    private int taskNoToBeRemoved;

    public DeleteCommand(int taskNoToBeRemoved){
        super(false);
        this.taskNoToBeRemoved = taskNoToBeRemoved;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.removeTask(taskNoToBeRemoved);
        ui.showDeleteMessage(task, tasks);
    }
}
