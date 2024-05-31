package sh.jacqui;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, Function<List<Ingredient>, Function<List<String>, Recipe>>> bakingRecipeFunctionClassic
                = RecipeBuilderClassic.recipeBuilder.apply(Category.BAKING);

        Recipe.AddTitle bakingRecipeFunction = Recipe.builder().withCategory(Category.BAKING);

        // ... some time passes ... but we don't know other parameters for the recipe ...

        Ingredient creamCheese = Ingredient.builder()
                .withName("Cream cheese")
                .withQuantity("750g");

        Ingredient casterSugar = Ingredient.builder()
                .withName("Caster sugar")
                .withQuantity("200g");

        Ingredient whippingCream = Ingredient.builder()
                .withName("Whipping cream")
                .withQuantity("310ml");

        Recipe recipe = bakingRecipeFunction
                .withTitle("Basque Cheesecake")
                .withIngredients(List.of(creamCheese, casterSugar, whippingCream))
                .withSteps(List.of("Preheat oven", "Beat", "Bake"));

        System.out.println(recipe.toString());
    }
}