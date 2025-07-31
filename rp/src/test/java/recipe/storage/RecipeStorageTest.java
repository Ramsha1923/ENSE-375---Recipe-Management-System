package recipe.storage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import recipe.model.Recipe;

public class RecipeStorageTest {
    private RecipeStorage storage;
private final File file = new File("recipes.json");

@BeforeEach
public void setup() {
    if (file.exists()) {
        file.delete();
    }
    storage = new RecipeStorage();
}

@Test
public void testSaveAndLoadRecipe() {
    Recipe recipe = new Recipe(
        "Pizza",
        Arrays.asList("Dough", "Tomato", "Cheese"),
        Arrays.asList("Roll dough", "Add toppings", "Bake"),
        Arrays.asList("Dinner"),
        "Chef Mario"
    );

    List<Recipe> recipeList = new ArrayList<>();
    recipeList.add(recipe);
    storage.saveRecipes(recipeList);

    List<Recipe> loaded = storage.loadRecipes();
    assertEquals(1, loaded.size());
    assertEquals("Pizza", loaded.get(0).getTitle());
    assertEquals("Chef Mario", loaded.get(0).getAuthor());
}

@Test
public void testDeleteRecipe() {
    Recipe r1 = new Recipe(
        "Soup",
        Arrays.asList("Water", "Salt"),
        Arrays.asList("Boil water", "Add salt"),
        Arrays.asList("Starter"),
        "Alice"
    );

    Recipe r2 = new Recipe(
        "Cake",
        Arrays.asList("Flour", "Sugar", "Eggs"),
        Arrays.asList("Mix", "Bake"),
        Arrays.asList("Dessert"),
        "Bob"
    );

    List<Recipe> recipeList = new ArrayList<>();
    recipeList.add(r1);
    recipeList.add(r2);
    storage.saveRecipes(recipeList);

    // Remove recipe with title "Soup"
    recipeList.removeIf(recipe -> recipe.getTitle().equals("Soup"));
    storage.saveRecipes(recipeList);

    List<Recipe> remaining = storage.loadRecipes();
    assertEquals(1, remaining.size());
    assertEquals("Cake", remaining.get(0).getTitle());
}

@Test
public void testLoadFromEmptyFile() {
    List<Recipe> recipes = storage.loadRecipes();
    assertTrue(recipes.isEmpty());
}
}