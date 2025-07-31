package recipe.unittest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import recipe.model.Recipe;

public class RecipeUnitTest {
    @Test
    public void testRecipeCreation() {
        Recipe r = new Recipe("Pasta", Arrays.asList("noodles", "sauce"), Arrays.asList("boil", "mix"), Arrays.asList("dinner"), "Chef");
        assertEquals("Pasta", r.getTitle());
        assertEquals("Chef", r.getAuthor());
    }
}
