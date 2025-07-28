package recipe.controller;

import recipe.model.Recipe;
import recipe.storage.RecipeStorage;

import java.util.List;

public class RecipeController {
    private final RecipeStorage storage = new RecipeStorage();

    public void addRecipe(Recipe recipe) {
        storage.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return storage.loadAll();
    }

    public void deleteRecipe(String title) {
        storage.delete(title);
    }
}
