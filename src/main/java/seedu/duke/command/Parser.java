package seedu.duke.command;

import seedu.duke.task.DukeException;

public class Parser {

    /**
     * Parser has a private constructor to prevent the object from being created directly.
     */
    private Parser() {
    }

    /**
     * Returns the appropriate command depending on the string inputted to the system.
     * @param input the input string read by the system.
     * @return the command the system needs to execute according to the input received by the system.
     */
    public static Command parse(String input) throws DukeException {
        int taskNo;
        String taskType;
        String taskDescription;
        String[] params = input.split(" ", 2);
        String action = params[0];

        switch (action) {
        case "blah":
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        case "bye":
            return new ByeCommand();
        case "list":
            return new ListCommand();
        case "delete":
            taskNo = Integer.parseInt(params[1]);
            return new DeleteCommand(taskNo);
        case "done":
            taskNo = Integer.parseInt(params[1]);
            return new DoneCommand(taskNo);
        case "todo":
        case "deadline":
        case "event":
            taskType = params[0];
            if (params.length <= 1) {
                throw new DukeException("☹ OOPS!!! The description of a " + taskType + " cannot be empty.");
            }
            taskDescription = params[1];
            return new AddCommand(taskDescription, taskType);
        default:
            return new AddCommand(input);
        }
    }
}
