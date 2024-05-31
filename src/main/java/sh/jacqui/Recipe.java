package sh.jacqui;

import java.util.List;
import java.util.stream.Collectors;

public class Recipe {
    private final Category category;
    private final String title;
    private final List<Ingredient> ingredients;
    private final List<String> steps;

    public Recipe(Category category, String title, List<Ingredient> ingredients, List<String> steps) {
        this.category = category;
        this.title = title;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public static AddCategory builder() {
        return category
                -> title
                -> ingredients
                -> steps
                -> new Recipe(category, title, ingredients, steps);
    }

    public String getTitle() {
        return title;
    }

    public interface AddCategory {
        Recipe.AddTitle withCategory(Category category);
    }

    public interface AddTitle {
        Recipe.AddIngredients withTitle(String title);
    }

    public interface AddIngredients {
        Recipe.AddSteps withIngredients(List<Ingredient> ingredients);
    }

    public interface AddSteps {
        Recipe withSteps(List<String> steps);
    }

    public String toString() {
        String ingredientsStr = ingredients
                .stream()
                .map(i -> i.name() + " (" + i.quantity() + ")")
                .collect(Collectors.joining(", "));

        return "Category: " + category + "\n" +
               "Title: " + title + "\n" +
               "Ingredients: " + ingredientsStr + "\n" +
               "Steps: " + steps;
    }

}

