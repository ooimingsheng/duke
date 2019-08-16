package seedu.duke.task;

import java.util.Scanner;
import java.util.List;

public class Ui {

    private Scanner scanner;
    private static final String INDENT = "     ";
    private static final String SMALL_INDENT = "  ";

    /**
     * Public constructor that returns a user interface to recieve input and return appropriate output.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Print loading error.
     */
    public void showLoadingError() {
        System.out.println(INDENT + "No task data found.");
    }

    /**
     * Print saving error.
     */
    public void showSavingError() {
        System.out.println(INDENT + "Task data could not be saved.");
    }

    /**
     * Print saving error.
     * @param errorMessage the error message to be printed.
     */
    public void showError(String errorMessage) {
        System.out.println(INDENT + errorMessage);
    }

    /**
     * Print welcome message.
     */
    public void showWelcome() {
        System.out.println(INDENT + "Hello! I'm Duke");
        System.out.println(INDENT + "What can I do for you?");
    }

    /**
     * Print goodbye message.
     */
    public void showGoodbye() {
        System.out.println(INDENT + "Bye. Hope to see you again soon!");
    }

    /**
     * Print all tasks in the task list.
     * @param  taskList the list of tasks to be printed.
     */
    public void showTaskList(List<Task> taskList) {
        System.out.println(INDENT + "Here are the tasks in your list:");
        int counter = 1;
        for (Task task : taskList) {
            System.out.println(INDENT + counter + "." + task);
            counter++;
        }
    }

    /**
     * Print out a message to state that the task has been completed.
     * @param task the task that has been completed.
     */
    public void showDoneMessage(Task task) {
        System.out.println(INDENT + "Nice! I've marked this task as done:");
        System.out.println(INDENT + SMALL_INDENT + task);
    }

    /**
     * Print out a message to state that the task has been added to the task list.
     * @param task the task that has been added.
     * @param taskList the task list that the task has been added to.
     */
    public void showAddMessage(Task task, TaskList taskList)  {
        System.out.println(INDENT + "Got it. I've added this task:");
        System.out.println(INDENT + SMALL_INDENT + task);
        System.out.println(INDENT + "Now you have " + taskList.getTaskListSize() + " tasks in the list.");
    }

    /**
     * Print out a message to state that the task has been deleted from the task list.
     * @param task the task that has been deleted.
     * @param taskList the task list that the task has been deleted from.
     */
    public void showDeleteMessage(Task task, TaskList taskList) {
        System.out.println(INDENT + "Noted. I've removed this task:");
        System.out.println(INDENT + SMALL_INDENT + task);
        System.out.println(INDENT + "Now you have " + taskList.getTaskListSize() + " tasks in the list.");
    }

    /**
     * Read next line of input and return it as a string.
     * @return next line of input as a string.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Print a line.
     */
    public void showLine() {
        System.out.println("    ____________________________________________________________");
    }
}
