package recipe.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import recipe.model.Recipe;

public class RecipeControllerTest {
    private RecipeController controller;

    @BeforeEach
    public void setup() {
        // Clear recipes.json before each test
        File file = new File("recipes.json");
        if (file.exists()) file.delete();
        controller = new RecipeController();
    }

    @Test
    public void testAddAndRetrieveRecipe() {
        Recipe recipe = new Recipe(
                "Pancakes",
                Arrays.asList("Flour", "Eggs", "Milk"),
                Arrays.asList("Mix ingredients", "Cook on skillet"),
                Arrays.asList("Breakfast"),
                "Alice"
        );

        controller.addRecipe(recipe);
        List<Recipe> recipes = controller.getAllRecipes();

        assertEquals(1, recipes.size());
        assertEquals("Pancakes", recipes.get(0).getTitle());
    }

    @Test
    public void testDeleteRecipe() {
        Recipe recipe = new Recipe(
                "Toast",
                Arrays.asList("Bread", "Butter"),
                Arrays.asList("Toast bread", "Spread butter"),
                Arrays.asList("Snack"),
                "Bob"
        );

        controller.addRecipe(recipe);
        controller.deleteRecipe("Toast");

        List<Recipe> recipes = controller.getAllRecipes();
        assertTrue(recipes.isEmpty());
    }
}
