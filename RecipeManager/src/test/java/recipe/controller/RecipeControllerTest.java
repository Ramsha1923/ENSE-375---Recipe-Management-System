package recipe.controller;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import recipe.model.Recipe;

public class RecipeControllerTest {
    private RecipeController controller;
    private File tempDb = new File("recipes_ctrl_test.json");

    @BeforeEach
    public void setup() {
        if (tempDb.exists()) tempDb.delete();
        controller = new RecipeController(tempDb);
    }

    @Test
    public void testAddAndRetrieve() {
        controller.addRecipe(new Recipe("Tea", List.of("Water","Bag"), List.of("Boil","Steep"), List.of("Drink"), "Alice"));
        List<Recipe> list = controller.getAllRecipes();
        assertFalse(list.isEmpty());
        assertEquals("Tea", list.get(0).getTitle());
    }

    @Test
    public void testDelete() {
        controller.addRecipe(new Recipe("A", List.of(), List.of(), List.of(), "x"));
        controller.addRecipe(new Recipe("B", List.of(), List.of(), List.of(), "x"));
        controller.deleteRecipe("A");
        assertEquals(1, controller.getAllRecipes().size());
        assertEquals("B", controller.getAllRecipes().get(0).getTitle());
    }
}
