package sh.jacqui;

import java.util.List;
import java.util.function.Function;

public class RecipeBuilderClassic {
    static Function<Category, Function<String, Function<List<Ingredient>, Function<List<String>, Recipe>>>> recipeBuilder
            = category
            -> title
            -> ingredients
            -> steps
            -> new Recipe(category, title, ingredients, steps);
}
