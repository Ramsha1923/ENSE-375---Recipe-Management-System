package recipe.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RecipeApp extends Application {
    @Override
public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
    Parent root = loader.load();

    primaryStage.setTitle("Recipe Manager");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
}

public static void main(String[] args) {
    launch(args);
}
}