package recipe.decisiontabletest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import recipe.model.Recipe;

public class RecipeDecisionTableTest {

    @Test
    public void testAllValidInputs() {
        Recipe recipe = new Recipe("Pasta", Arrays.asList("Water", "Salt"), Arrays.asList("Boil", "Stir"), Arrays.asList("Dinner"), "Chef");
        assertNotNull(recipe);
        assertEquals("Pasta", recipe.getTitle());
    }

    @Test
    public void testMissingTitle() {
        Recipe recipe = new Recipe("", Arrays.asList("Water"), Arrays.asList("Boil"), Arrays.asList("Simple"), "Admin");
        assertEquals("", recipe.getTitle());
    }

    @Test
    public void testNullCategories() {
        Recipe recipe = new Recipe("Rice", Arrays.asList("Rice", "Water"), Arrays.asList("Cook"), null, "Chef");
        assertNull(recipe.getCategories());
    }
}
