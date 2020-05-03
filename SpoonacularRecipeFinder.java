package RecipeFinder;

public class SpoonacularRecipeFinder extends RecipeFinder{
    public SpoonacularRecipeFinder(String aRecipe){
        SearchRecipe=aRecipe;
    }
    public ArrayList<Recipes> findRecipes(SearchRecipe){
        ArrayList<Recipe> retRecipeList = new ArrayList<Recipe>();
        ArrayList<Recipe> generalList = new ArrayList<Recipe>();
        DatabaseSpoonacular data = new DatabaseSpoonacular();
        retRecipeList.add(data.retrieveRecipe());
        return retRecipeList;
    }

    private String SearchRecipe;
}