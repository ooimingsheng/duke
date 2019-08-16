package seedu.duke.command;

import seedu.duke.task.*;

public class AddCommand  extends Command {

    private String taskDescription;
    private String taskType;

    public AddCommand(String taskDescription, String taskType){
        super(false);
        this.taskDescription = taskDescription;
        this.taskType = taskType;
    }

    public AddCommand(String taskDescription){
        super(false);
        this.taskDescription = taskDescription;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = taskType != null ? tasks.addTask(taskDescription, taskType) : tasks.addTask(taskDescription);
        ui.showAddMessage(task, tasks);
    }
}
