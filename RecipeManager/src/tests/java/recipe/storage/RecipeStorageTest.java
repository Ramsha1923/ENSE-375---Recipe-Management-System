package recipe.storage;

import java.io.File;
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

    storage.save(recipe);
    List<Recipe> loaded = storage.loadAll();

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

    storage.save(r1);
    storage.save(r2);
    storage.delete("Soup");

    List<Recipe> remaining = storage.loadAll();
    assertEquals(1, remaining.size());
    assertEquals("Cake", remaining.get(0).getTitle());
}

@Test
public void testLoadFromEmptyFile() {
    List<Recipe> recipes = storage.loadAll();
    assertTrue(recipes.isEmpty());
}
}