package recipe.controller;

import java.io.File;
import java.util.List;

import recipe.model.Recipe;
import recipe.storage.RecipeStorage;

public class RecipeController {
    private final RecipeStorage storage;
    private List<Recipe> recipes;

    public RecipeController() {
        this.storage = new RecipeStorage();
        this.recipes = storage.loadRecipes();
    }

    // constructor for test use or custom file
    public RecipeController(File file) {
        this.storage = new RecipeStorage(file);
        this.recipes = storage.loadRecipes();
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        storage.saveRecipes(recipes);
    }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    public void deleteRecipe(String title) {
        storage.delete(title);
        this.recipes = storage.loadRecipes(); // update the in-memory list
    }
}
