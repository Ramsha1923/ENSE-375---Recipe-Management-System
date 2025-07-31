package recipe.controller;

import recipe.model.Recipe;
import recipe.storage.RecipeStorage;

import java.io.File;
import java.util.List;

public class RecipeController {
    private final RecipeStorage storage;

    public RecipeController() {
        this.storage = new RecipeStorage();
    }

    public RecipeController(File dbFile) {
        this.storage = new RecipeStorage(dbFile);
    }

    public void addRecipe(Recipe recipe) { storage.save(recipe); }

    public List<Recipe> getAllRecipes() { return storage.loadAll(); }

    public void deleteRecipe(String title) { storage.delete(title); }

    public void exportCsv(File outFile) { storage.exportCsv(outFile); }

    public void exportPdf(File outFile) { storage.exportPdf(outFile); }
}
