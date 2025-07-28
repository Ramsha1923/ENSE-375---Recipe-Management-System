package recipe.ui;

import recipe.controller.RecipeController;
import recipe.model.Recipe;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final RecipeController controller = new RecipeController();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new ConsoleUI().start();
    }

    public void start() {
        System.out.println("Welcome to the Recipe Manager!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Recipe");
            System.out.println("2. View Recipes");
            System.out.println("3. Delete Recipe");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> addRecipe();
                case "2" -> viewRecipes();
                case "3" -> deleteRecipe();
                case "4" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please enter 1-4.");
            }
        }
    }

    private void addRecipe() {
        System.out.print("Title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Ingredients (comma-separated): ");
        List<String> ingredients = parseList(scanner.nextLine());

        System.out.print("Steps (comma-separated): ");
        List<String> steps = parseList(scanner.nextLine());

        System.out.print("Categories (comma-separated): ");
        List<String> categories = parseList(scanner.nextLine());

        System.out.print("Author: ");
        String author = scanner.nextLine().trim();

        Recipe recipe = new Recipe(title, ingredients, steps, categories, author);
        controller.addRecipe(recipe);
        System.out.println("✅ Recipe added.");
    }

    private void viewRecipes() {
        List<Recipe> recipes = controller.getAllRecipes();

        if (recipes.isEmpty()) {
            System.out.println("No recipes found.");
            return;
        }

        for (Recipe r : recipes) {
            System.out.println("\n-----------------------------");
            System.out.println("Title: " + r.getTitle());
            System.out.println("Author: " + r.getAuthor());
            System.out.println("Ingredients: " + String.join(", ", r.getIngredients()));
            System.out.println("Steps: " + String.join(", ", r.getSteps()));
            System.out.println("Categories: " + String.join(", ", r.getCategories()));
        }
        System.out.println("-----------------------------");
    }

    private void deleteRecipe() {
        System.out.print("Enter title of recipe to delete: ");
        String title = scanner.nextLine().trim();
        controller.deleteRecipe(title);
        System.out.println("🗑️ If the recipe existed, it was deleted.");
    }

    private List<String> parseList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }
}
