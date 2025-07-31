package recipe.storage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import recipe.model.Recipe;

public class RecipeStorage {
    private final File file;
    private final Gson gson = new Gson();
    private final Type recipeListType = new TypeToken<List<Recipe>>() {}.getType();

    public RecipeStorage() {
        this(new File("recipes.json")); // default file
    }

    public RecipeStorage(File file) {
        this.file = file;
    }

    public List<Recipe> loadRecipes() {
        if (!file.exists()) return new ArrayList<>();
        try (Reader reader = new FileReader(file)) {
            return gson.fromJson(reader, recipeListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveRecipes(List<Recipe> recipes) {
        try (Writer writer = new FileWriter(file)) {
            gson.toJson(recipes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(String title) {
        List<Recipe> current = loadRecipes();
        current.removeIf(r -> r.getTitle().equals(title));
        saveRecipes(current);
    }
}
