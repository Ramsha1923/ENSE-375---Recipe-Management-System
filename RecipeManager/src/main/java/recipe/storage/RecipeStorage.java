package recipe.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import recipe.model.Recipe;

public class RecipeStorage {

    private final File dbFile;
    private final Gson gson;

    public RecipeStorage() {
        this(new File("recipes.json"));
    }

    public RecipeStorage(File file) {
        this.dbFile = file;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /** Load all recipes from JSON; return empty list if file missing or empty. */
    public synchronized List<Recipe> loadAll() {
        if (!dbFile.exists() || dbFile.length() == 0) {
            return new ArrayList<>();
        }
        try (Reader reader = new InputStreamReader(new FileInputStream(dbFile), StandardCharsets.UTF_8)) {
            Type listType = new TypeToken<List<Recipe>>() {}.getType();
            List<Recipe> list = gson.fromJson(reader, listType);
            return (list != null) ? list : new ArrayList<>();
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load recipes: " + ex.getMessage(), ex);
        }
    }

    /** Insert or replace by case-insensitive title. */
    public synchronized void save(Recipe recipe) {
        List<Recipe> all = loadAll();
        all = all.stream()
                .filter(r -> !r.getTitle().equalsIgnoreCase(recipe.getTitle()))
                .collect(Collectors.toCollection(ArrayList::new));
        all.add(recipe);
        persist(all);
    }

    /** Delete by case-insensitive title. */
    public synchronized void delete(String title) {
        List<Recipe> all = loadAll();
        all = all.stream()
                .filter(r -> !r.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toCollection(ArrayList::new));
        persist(all);
    }

    /** Write list atomically to JSON. */
    public synchronized void persist(List<Recipe> list) {
        // Ensure parent directories exist if writing outside project root
        File parent = dbFile.getParentFile();
        if (parent != null && !parent.exists()) {
            // best-effort
            parent.mkdirs();
        }
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(dbFile, false), StandardCharsets.UTF_8)) {
            gson.toJson(list, writer);
            writer.flush();
        } catch (IOException ex) {
            throw new RuntimeException("Failed to write recipes: " + ex.getMessage(), ex);
        }
    }

    /** Helper to quote CSV fields per RFC4180 (double-up embedded quotes). */
    private static String csvQuote(String s) {
        if (s == null) s = "";
        return "\"" + s.replace("\"", "\"\"") + "\"";
    }

    /** Export all recipes to CSV with |-joined lists. */
    public void exportCsv(File outFile) {
        List<Recipe> all = loadAll();

        // Ensure parent directories for output file
        File parent = outFile.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outFile), StandardCharsets.UTF_8))) {
            pw.println("Title,Author,Ingredients,Steps,Categories");
            for (Recipe r : all) {
                String ingredients = String.join("|", r.getIngredients());
                String steps = String.join("|", r.getSteps());
                String categories = String.join("|", r.getCategories());

                pw.println(
                        csvQuote(r.getTitle()) + "," +
                        csvQuote(r.getAuthor()) + "," +
                        csvQuote(ingredients) + "," +
                        csvQuote(steps) + "," +
                        csvQuote(categories)
                );
            }
            pw.flush();
        } catch (IOException ex) {
            throw new RuntimeException("Failed to export CSV: " + ex.getMessage(), ex);
        }
    }

    /** Export all recipes to a simple PDF. Requires OpenPDF on the classpath. */
    public void exportPdf(File outFile) {
        List<Recipe> all = loadAll();

        // Ensure parent directories for output file
        File parent = outFile.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(outFile));
            doc.open();
            doc.add(new Paragraph("Recipe Export"));
            doc.add(new Paragraph(" "));

            for (Recipe r : all) {
                doc.add(new Paragraph("Title: " + r.getTitle()));
                doc.add(new Paragraph("Author: " + r.getAuthor()));
                doc.add(new Paragraph("Ingredients: " + String.join(", ", r.getIngredients())));
                doc.add(new Paragraph("Steps: " + String.join(", ", r.getSteps())));
                doc.add(new Paragraph("Categories: " + String.join(", ", r.getCategories())));
                doc.add(new Paragraph(" "));
            }
        } catch (DocumentException | IOException ex) {
            throw new RuntimeException("Failed to export PDF: " + ex.getMessage(), ex);
        } finally {
            doc.close();
        }
    }
}
