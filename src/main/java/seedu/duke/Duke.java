package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.Parser;
import seedu.duke.task.TaskList;
import seedu.duke.task.Ui;
import seedu.duke.task.Storage;
import seedu.duke.task.DukeException;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private static final String filePath = ".\\data\\duke.txt";
    private boolean isSystemRunning;

    /**
     * Public constructor that returns a duke reminder system with a particular storage filepath.
     */
    public Duke() {
        isSystemRunning = true;
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Initiates the duke reminder system and parses commands to update the reminder list.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } catch (Exception e) {
                ui.showError("Your command is meanning occurred.");
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Get welcome message.
     */
    public String getWelcomeMessage() {
        return ui.getWelcome();
    }

    /**
     * Parse message.
     * @param message inputted to duke system.
     */
    public String getResponse(String message) {
        if (isSystemRunning) {
            try {
                Command c = Parser.parse(message);
                c.execute(tasks, ui, storage);
                isSystemRunning = !c.isExit();
                return c.getResultOfCommand();
            } catch (DukeException e) {
                return ui.getError(e.getMessage());
            }
        } else {
            return "System has already shut down.";
        }
    }

    /**
     * The main class to initialize and drive the program.
     *
     * @param args parameters recieved from the command line
     */
    public static void main(String[] args) {
        new Duke().run();
    }
}

