package tests.java.recipe.UnitTest;

import org.junit.jupiter.api.Test;
import recipe.model.Recipe;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeUnitTest {

    @Test
    public void testGetTitle() {
        Recipe recipe = new Recipe("Sandwich", Arrays.asList("Bread", "Butter"), Arrays.asList("Spread butter", "Assemble"), Arrays.asList("Lunch"), "Admin");
        assertEquals("Sandwich", recipe.getTitle());
    }

    @Test
    public void testGetIngredients() {
        List<String> ingredients = Arrays.asList("Egg", "Oil");
        Recipe recipe = new Recipe("Omelette", ingredients, Arrays.asList("Whisk", "Fry"), Arrays.asList("Breakfast"), "Chef");
        assertEquals(ingredients, recipe.getIngredients());
    }

    @Test
    public void testGetSteps() {
        List<String> steps = Arrays.asList("Chop", "Cook");
        Recipe recipe = new Recipe("Soup", Arrays.asList("Tomato"), steps, Arrays.asList("Starter"), "Chef");
        assertEquals(steps, recipe.getSteps());
    }
}
