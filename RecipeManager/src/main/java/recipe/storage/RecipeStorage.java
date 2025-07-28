package recipe.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import recipe.model.Recipe;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RecipeStorage {
    private final File file = new File("recipes.json");
    private final Gson gson = new Gson();

    public void save(Recipe recipe) {
        List<Recipe> all = loadAll();
        all.add(recipe);
        try (Writer writer = new FileWriter(file)) {
            gson.toJson(all, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Recipe> loadAll() {
        if (!file.exists()) return new ArrayList<>();
        try (Reader reader = new FileReader(file)) {
            Type listType = new TypeToken<List<Recipe>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void delete(String title) {
        List<Recipe> all = loadAll();
        all.removeIf(recipe -> recipe.getTitle().equalsIgnoreCase(title));
        try (Writer writer = new FileWriter(file)) {
            gson.toJson(all, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
