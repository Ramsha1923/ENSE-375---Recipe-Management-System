package recipe.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import recipe.controller.RecipeController;
import recipe.model.Recipe;

public class ConsoleUI {
private final RecipeController controller = new RecipeController();
private final Scanner scanner = new Scanner(System.in);
private String currentUser = "Anonymous";

public void start() {
    System.out.println("Welcome to the Recipe Manager (Console Mode)");
    login();

    while (true) {
        System.out.println("\nMenu:");
        System.out.println("1. Add Recipe");
        System.out.println("2. View Recipes");
        System.out.println("3. Delete Recipe");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");

        String input = scanner.nextLine();
        switch (input) {
            case "1": addRecipe(); break;
            case "2": viewRecipes(); break;
            case "3": deleteRecipe(); break;
            case "4": return;
            default: System.out.println("Invalid option. Please try again.");
        }
    }
}

private void login() {
    System.out.print("Enter your name (optional): ");
    String name = scanner.nextLine().trim();
    if (!name.isEmpty()) {
        currentUser = name;
    }
    System.out.println("Logged in as: " + currentUser);
}

private void addRecipe() {
    System.out.print("Enter title: ");
    String title = scanner.nextLine();

    List<String> ingredients = new ArrayList<>();
    System.out.println("Enter ingredients (type 'done' to finish):");
    while (true) {
        String ing = scanner.nextLine();
        if ("done".equalsIgnoreCase(ing)) break;
        ingredients.add(ing);
    }

    List<String> steps = new ArrayList<>();
    System.out.println("Enter steps (type 'done' to finish):");
    while (true) {
        String step = scanner.nextLine();
        if ("done".equalsIgnoreCase(step)) break;
        steps.add(step);
    }

    List<String> categories = new ArrayList<>();
    System.out.println("Enter categories (type 'done' to finish):");
    while (true) {
        String cat = scanner.nextLine();
        if ("done".equalsIgnoreCase(cat)) break;
        categories.add(cat);
    }

    Recipe recipe = new Recipe(title, ingredients, steps, categories, currentUser);
    controller.addRecipe(recipe);
    System.out.println("Recipe added!");
}

private void viewRecipes() {
    List<Recipe> recipes = controller.getAllRecipes();
    if (recipes.isEmpty()) {
        System.out.println("No recipes found.");
        return;
    }
    for (int i = 0; i < recipes.size(); i++) {
        Recipe r = recipes.get(i);
        System.out.println("Recipe #" + (i + 1) + ": " + r.getTitle() + " by " + r.getAuthor());
    }
}

private void deleteRecipe() {
    viewRecipes();
    System.out.print("Enter recipe title to delete: ");
    String title = scanner.nextLine();
    controller.deleteRecipe(title);
    System.out.println("Recipe deleted (if it existed).");
}

public static void main(String[] args) {
    new ConsoleUI().start();
}
}