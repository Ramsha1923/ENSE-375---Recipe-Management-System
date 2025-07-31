package recipe.boundaryvaluetesting;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue; // ✅ Added missing import
import org.junit.jupiter.api.Test;

import recipe.model.Recipe;

public class RecipeBoundaryTest {
    @Test
public void testEmptyTitle() {
    Recipe recipe = new Recipe(
        "", 
        Collections.singletonList("Water"), 
        Collections.singletonList("Boil"), 
        Collections.emptyList(), 
        "Admin"
    );
    assertEquals("", recipe.getTitle());
}

@Test
public void testMaxIngredients() {
    List<String> ingredients = Collections.nCopies(1000, "Water"); // Boundary max case
    Recipe recipe = new Recipe(
        "Test", 
        ingredients, 
        Collections.singletonList("Boil"), 
        Collections.emptyList(), 
        "Admin"
    );
    assertEquals(1000, recipe.getIngredients().size());
}

@Test
public void testMinSteps() {
    Recipe recipe = new Recipe(
        "Test", 
        Collections.singletonList("Salt"), 
        Collections.emptyList(), 
        Collections.emptyList(), 
        "Admin"
    );
    assertTrue(recipe.getSteps().isEmpty());
}
}
