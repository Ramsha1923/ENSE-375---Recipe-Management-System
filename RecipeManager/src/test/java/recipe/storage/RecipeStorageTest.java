package recipe.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipe.model.Recipe;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeStorageTest {
    private RecipeStorage storage;
    private final File db = new File("recipes_test.json");

    @BeforeEach
    public void setup() {
        if (db.exists()) db.delete();
        storage = new RecipeStorage(db);
    }

    @Test
    public void testSaveAndLoadRecipe() {
        Recipe r = new Recipe("Pizza",
                Arrays.asList("Dough", "Tomato", "Cheese"),
                Arrays.asList("Roll", "Top", "Bake"),
                Arrays.asList("Dinner"),
                "Chef Mario");
        storage.save(r);
        List<Recipe> list = storage.loadAll();
        assertEquals(1, list.size());
        assertEquals("Pizza", list.get(0).getTitle());
    }

    @Test
    public void testDeleteRecipe() {
        storage.save(new Recipe("A", List.of(), List.of(), List.of(), "x"));
        storage.save(new Recipe("B", List.of(), List.of(), List.of(), "x"));
        storage.delete("A");
        List<Recipe> list = storage.loadAll();
        assertEquals(1, list.size());
        assertEquals("B", list.get(0).getTitle());
    }

    @Test
    public void testExportCsvAndPdf() {
        storage.save(new Recipe("A", List.of("a","b"), List.of("s1"), List.of("c1"), "x"));
        storage.exportCsv(new File("out_test.csv"));
        storage.exportPdf(new File("out_test.pdf"));
        assertTrue(new File("out_test.csv").exists());
        assertTrue(new File("out_test.pdf").exists());
        new File("out_test.csv").delete();
        new File("out_test.pdf").delete();
    }
}
