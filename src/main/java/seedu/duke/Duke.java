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

    /**
     * Public constructor that returns a duke reminder system with a particular storage filepath.
     * @param filePath the file path to load and store task data.
     */
    public Duke(String filePath) {
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
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * The main class to initialize and drive the program.
     * @param args parameters recieved from the command line
     */
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Ooi Ming Sheng\\Desktop\\CS2103\\Individual project\\duke\\data\\duke.txt";
        new Duke(filePath).run();
    }
}

