import java.util.*;


public class Recipe{
        private Ingredient[] ingredients;
        private String instruction
        private String recipeName;

        public Recipe(){
            instruction = "";
            ingredients = new Ingredient[0];
            this.recipeName = ""
        }

        public Recipe(Ingredient[] ingredients, String instructions, String name)
        {
            this.recipeName = name;
            this.ingredients = ingredients;
            this.instruction = instructions;
        }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}