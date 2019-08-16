package seedu.duke.task;

import java.util.Scanner;
import java.util.List;

public class Ui {

    private Scanner scanner;
    private static final String INDENT = "     ";
    private static final String SMALL_INDENT = "  ";

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public void showLoadingError() {
        System.out.println(INDENT + "No task data found.");
    }

    public void showSavingError() {
        System.out.println(INDENT + "Task data could not be saved.");
    }

    public void showError(String errorMessage) {
        System.out.println(INDENT + errorMessage);
    }

    public void showWelcome() {
        System.out.println(INDENT + "Hello! I'm Duke");
        System.out.println(INDENT + "What can I do for you?");
    }

    public void showGoodbye() {
        System.out.println(INDENT + "Bye. Hope to see you again soon!");
    }

    public void showTaskList(List<Task> taskList) {
        System.out.println(INDENT + "Here are the tasks in your list:");
        int counter = 1;
        for (Task task : taskList) {
            System.out.println(INDENT + counter + "." + task);
            counter++;
        }
    }

    public void showDoneMessage(Task task) {
        System.out.println(INDENT + "Nice! I've marked this task as done:");
        System.out.println(INDENT + SMALL_INDENT + task);
    }

    public void showAddMessage(Task task, TaskList taskList)  {
        System.out.println(INDENT + "Got it. I've added this task:");
        System.out.println(INDENT + SMALL_INDENT + task);
        System.out.println(INDENT + "Now you have " + taskList.getTaskListSize() + " tasks in the list.");
    }

    public void showDeleteMessage(Task task, TaskList taskList) {
        System.out.println(INDENT + "Noted. I've removed this task:");
        System.out.println(INDENT + SMALL_INDENT + task);
        System.out.println(INDENT + "Now you have " + taskList.getTaskListSize() + " tasks in the list.");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLine() {
        System.out.println("    ____________________________________________________________");
    }
}
