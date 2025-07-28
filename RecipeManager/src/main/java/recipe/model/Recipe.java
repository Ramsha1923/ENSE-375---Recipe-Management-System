package recipe.model;

import java.util.List;

public class Recipe {
    private String title;
    private List<String> ingredients;
    private List<String> steps;
    private List<String> categories; // formerly "tags"
    private String author;

public Recipe(String title, List<String> ingredients, List<String> steps, List<String> categories, String author) {
    if (title == null || title.length() < 3 || title.length() > 100) {
        throw new IllegalArgumentException("Title must be between 3 and 100 characters.");
    }
    if (ingredients == null || ingredients.isEmpty()) {
        throw new IllegalArgumentException("Ingredients cannot be empty.");
    }
    if (steps == null || steps.isEmpty()) {
        throw new IllegalArgumentException("Steps cannot be empty.");
    }
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