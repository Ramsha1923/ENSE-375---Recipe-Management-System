package recipe.model;

import java.util.List;

public class Recipe {
    private String title;
    private List<String> ingredients;
    private List<String> steps;
    private List<String> categories; // formerly "tags"
    private String author;

    public Recipe(String title, List<String> ingredients, List<String> steps, List<String> categories, String author) {
        this.title = title;
        this.ingredients = ingredients;
        this.steps = steps;
        this.categories = categories;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public List<String> getCategories() {
        return categories;
    }

    public String getAuthor() {
        return author;
    }
}
