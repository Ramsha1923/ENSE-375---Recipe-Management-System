package recipe.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RecipeApp extends Application {
    @Override
public void start(Stage primaryStage) throws Exception {
    // This must match the location and name in your resources folder
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/recipe/ui/main.fxml"));
    BorderPane root = loader.load();

    Scene scene = new Scene(root);
    primaryStage.setTitle("Recipe Manager");
    primaryStage.setScene(scene);
    primaryStage.show();
}

public static void main(String[] args) {
    launch(args);
}
}