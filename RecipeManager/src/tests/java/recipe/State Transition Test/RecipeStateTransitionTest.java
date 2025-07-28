package tests.java.recipe.StateTransitionTest;

import org.junit.jupiter.api.Test;
import recipe.model.Recipe;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeStateTransitionTest {

    @Test
    public void testInitialState() {
        Recipe recipe = new Recipe("Soup", Arrays.asList("Water"), Arrays.asList("Boil"), Arrays.asList("Hot"), "User");
        assertEquals("Soup", recipe.getTitle());
    }

    @Test
    public void testTransitionTitle() {
        Recipe recipe = new Recipe("Soup", Arrays.asList("Water"), Arrays.asList("Boil"), Arrays.asList("Hot"), "User");

        // simulate title change (immutable structure so we re-create)
        recipe = new Recipe("Cold Soup", recipe.getIngredients(), recipe.getSteps(), recipe.getCategories(), recipe.getAuthor());

        assertEquals("Cold Soup", recipe.getTitle());
    }
}
