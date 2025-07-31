package recipe.ui;

import java.util.List;
import java.util.Optional;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import recipe.controller.RecipeController;
import recipe.model.Recipe;

public class MainController {
    @FXML private TableView<Recipe> recipeTable;
    @FXML private TableColumn<Recipe, String> titleColumn;
    @FXML private TableColumn<Recipe, String> authorColumn;
    @FXML private TextArea recipeDetails;

    private final RecipeController controller = new RecipeController();
    private final ObservableList<Recipe> recipeData = FXCollections.observableArrayList();
    private String currentUser = "Anonymous";

    @FXML
    public void initialize() {
        titleColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTitle()));
        authorColumn.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getAuthor()));

        recipeTable.setItems(recipeData);
        recipeTable.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldVal, newVal) -> showRecipeDetails(newVal)
        );

        login();
        refreshRecipeList();
    }

    private void login() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Login");
        dialog.setHeaderText("Enter your name:");
        dialog.setContentText("Name:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> {
            if (!name.trim().isEmpty()) {
                currentUser = name.trim();
            }
        });
    }

    private void refreshRecipeList() {
        recipeData.clear();
        recipeData.addAll(controller.getAllRecipes());
    }

    private void showRecipeDetails(Recipe recipe) {
        if (recipe != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Title: ").append(recipe.getTitle()).append("\n");
            sb.append("Author: ").append(recipe.getAuthor()).append("\n\n");
            sb.append("Ingredients:\n");
            recipe.getIngredients().forEach(i -> sb.append("- ").append(i).append("\n"));
            sb.append("\nSteps:\n");
            recipe.getSteps().forEach(s -> sb.append("• ").append(s).append("\n"));
            sb.append("\nCategories:\n");
            recipe.getCategories().forEach(c -> sb.append("# ").append(c).append("\n"));
            recipeDetails.setText(sb.toString());
        } else {
            recipeDetails.clear();
        }
    }

    @FXML
    private void handleAddRecipe() {
        Dialog<Recipe> dialog = new Dialog<>();
        dialog.setTitle("Add Recipe");

        GridPane grid = new GridPane();
        TextField titleField = new TextField();
        TextArea ingField = new TextArea();
        TextArea stepField = new TextArea();
        TextField catField = new TextField();

        grid.addRow(0, new Label("Title:"), titleField);
        grid.addRow(1, new Label("Ingredients (comma-separated):"), ingField);
        grid.addRow(2, new Label("Steps (comma-separated):"), stepField);
        grid.addRow(3, new Label("Categories (comma-separated):"), catField);
        dialog.getDialogPane().setContent(grid);

        ButtonType okBtn = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okBtn, ButtonType.CANCEL);

        dialog.setResultConverter(btn -> {
            if (btn == okBtn) {
                String title = titleField.getText().trim();
                List<String> ingredients = List.of(ingField.getText().split(","));
                List<String> steps = List.of(stepField.getText().split(","));
                List<String> categories = List.of(catField.getText().split(","));
                return new Recipe(title, ingredients, steps, categories, currentUser);
            }
            return null;
        });

        dialog.showAndWait().ifPresent(recipe -> {
            controller.addRecipe(recipe);
            refreshRecipeList();
        });
    }

    @FXML
    private void handleDeleteRecipe() {
        Recipe selected = recipeTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            controller.deleteRecipe(selected.getTitle());
            refreshRecipeList();
            recipeDetails.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "No recipe selected.");
            alert.showAndWait();
        }
    }
}
