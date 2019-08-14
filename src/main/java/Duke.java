import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println(
                "Hello! I'm Duke" + "\n"
                + "What can I do for you?" + "\n"
        );

        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        ToDoList toDoList = new ToDoList();

        while(shouldContinue) {
            String input = scanner.nextLine();
            if(input.equals("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                shouldContinue = false;
            } else if(input.equals("list")){
                toDoList.listItems();
            } else {
                toDoList.addItem(input);
            }
        }
    }
}
