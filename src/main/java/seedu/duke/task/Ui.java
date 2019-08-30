package seedu.duke.task;

import java.util.Scanner;
import java.util.List;

public class Ui {

    private Scanner scanner;
    private static final String INDENT = "     ";
    private static final String SMALL_INDENT = "  ";
    private static final String LOADING_ERROR_MESSAGE = "No task data found.";
    private static final String SAVING_ERROR_MESSAGE = "Task data could not be saved.";
    private static final String HELLO_MESSAGE = "Hello! I'm Duke";
    private static final String REQUEST_FOR_INPUT_MESSAGE = "What can I do for you?";
    private static final String BYE_MESSAGE = "Bye. Hope to see you again soon!";
    private static final String SHOW_LIST_MESSAGE = "Here are the tasks in your list:";
    private static final String DONE_MESSAGE = "Nice! I've marked this task as done:";
    private static final String ADDED_MESSAGE = "Got it. I've added this task:";
    private static final String DELETE_MESSAGE = "Noted. I've removed this task:";

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
        System.out.println(INDENT + LOADING_ERROR_MESSAGE);
    }

    /**
     * Get loading error.
     */
    public String getLoadingError() {
        return LOADING_ERROR_MESSAGE;
    }

    /**
     * Print saving error message.
     */
    public void showSavingError() {
        System.out.println(INDENT + SAVING_ERROR_MESSAGE);
    }

    /**
     * Get saving error message.
     */
    public String getSavingError() {
        return SAVING_ERROR_MESSAGE;
    }

    /**
     * Print error message.
     * @param errorMessage the error message to be printed.
     */
    public void showError(String errorMessage) {
        System.out.println(INDENT + errorMessage);
    }

    /**
     * Get error message.
     */
    public String getError(String errorMessage) {
        return errorMessage;
    }

    /**
     * Print welcome message.
     */
    public void showWelcome() {
        System.out.println(INDENT + HELLO_MESSAGE);
        System.out.println(INDENT + REQUEST_FOR_INPUT_MESSAGE);
    }

    /**
     * Get welcome message.
     */
    public String getWelcome() {
        return HELLO_MESSAGE + "\n" + REQUEST_FOR_INPUT_MESSAGE;
    }

    /**
     * Print goodbye message.
     */
    public void showGoodbye() {
        System.out.println(INDENT + BYE_MESSAGE);
    }

    /**
     * Get goodbye message.
     */
    public String getGoodbye() {
        return BYE_MESSAGE;
    }

    /**
     * Print all tasks in the task list.
     * @param  taskList the list of tasks to be printed.
     */
    public void showTaskList(List<Task> taskList) {
        System.out.println(INDENT + SHOW_LIST_MESSAGE);
        int counter = 1;
        for (Task task : taskList) {
            System.out.println(INDENT + counter + "." + task);
            counter++;
        }
    }

    /**
     * Get all tasks in the task list in a message form.
     * @param  taskList the list of tasks to be printed.
     */
    public String getTaskList(List<Task> taskList) {
        String taskListMessage = SHOW_LIST_MESSAGE;
        int counter = 1;
        for (Task task : taskList) {
            taskListMessage += "\n" + counter + "." + task;
            counter++;
        }
        return taskListMessage;
    }

    /**
     * Print out a message to state that the task has been completed.
     * @param task the task that has been completed.
     */
    public void showDoneMessage(Task task) {
        System.out.println(INDENT + DONE_MESSAGE);
        System.out.println(INDENT + SMALL_INDENT + task);
    }

    /**
     * Get done message.
     */
    public String getDoneMessage(Task task) {
        return DONE_MESSAGE + "\n" + SMALL_INDENT + task;
    }

    private String totakTasksMessage(TaskList taskList) {
        return "Now you have " + taskList.getTaskListSize() + " tasks in the list.";
    }

    /**
     * Print out a message to state that the task has been added to the task list.
     * @param task the task that has been added.
     * @param taskList the task list that the task has been added to.
     */
    public void showAddMessage(Task task, TaskList taskList)  {
        System.out.println(INDENT + ADDED_MESSAGE);
        System.out.println(INDENT + SMALL_INDENT + task);
        System.out.println(INDENT + totakTasksMessage(taskList));
    }

    /**
     * Get message stating that the task has been added to the task list.
     * @param task the task that has been added.
     * @param taskList the task list that the task has been added to.
     */
    public String getAddMessage(Task task, TaskList taskList)  {
        return ADDED_MESSAGE + "\n" + SMALL_INDENT +  task + "\n" + totakTasksMessage(taskList);
    }

    /**
     * Print out a message to state that the task has been deleted from the task list.
     * @param task the task that has been deleted.
     * @param taskList the task list that the task has been deleted from.
     */
    public void showDeleteMessage(Task task, TaskList taskList) {
        System.out.println(INDENT + DELETE_MESSAGE);
        System.out.println(INDENT + SMALL_INDENT + task);
        System.out.println(INDENT + totakTasksMessage(taskList));
    }

    /**
     * Get message to state that the task has been deleted from the task list.
     * @param task the task that has been deleted.
     * @param taskList the task list that the task has been deleted from.
     */
    public String getDeleteMessage(Task task, TaskList taskList)  {
        return DELETE_MESSAGE + "\n" + SMALL_INDENT +  task + "\n" + totakTasksMessage(taskList);
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
