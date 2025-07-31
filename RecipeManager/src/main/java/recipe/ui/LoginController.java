package recipe.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML private TextField nameField;
    @FXML private Button loginButton;

    private RecipeApp app;

    public void setApp(RecipeApp app) {
        this.app = app;
    }

    @FXML
    private void initialize() {
        loginButton.setOnAction(e -> handleLogin());
    }

    private void handleLogin() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Name cannot be empty.");
            alert.showAndWait();
            return;
        }

        // This method must be defined in RecipeApp if you're calling it
        // For now we'll just simulate a message
        System.out.println("Login successful for: " + name);
    }
}
