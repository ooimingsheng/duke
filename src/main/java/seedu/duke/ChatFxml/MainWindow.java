package seedu.duke.chatfxml;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import seedu.duke.Duke;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Image userPic = new Image(this.getClass().getClassLoader().getResourceAsStream("images/DaUser.png"));
    private Image dukePic = new Image(this.getClass().getClassLoader().getResourceAsStream("images/DaDuke.png"));
    private Duke duke = new Duke();

    /**
     * Initialize the main window for the chat between user and duke system.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog(duke.getWelcomeMessage(), dukePic)
        );
    }

    /** Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userPic),
                DialogBox.getDukeDialog(response, dukePic)
        );
        userInput.clear();
    }
}
