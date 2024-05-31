package sh.jacqui;

public record Ingredient(String name, String quantity) {
    public static AddName builder() {
        return name
                -> quantity
                -> new Ingredient(name, quantity);
    }

    public interface AddName {
        Ingredient.AddQuantity withName(String name);
    }

    public interface AddQuantity {
        Ingredient withQuantity(String quantity);
    }
}
