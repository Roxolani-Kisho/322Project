public class RecipeFinder {
    public RecipeFinder(String aRecipe){
        searchRecipe = aRecipe;
    }
    public ArrayList<Recipe> findRecipes(searchRecipe){
        ArrayList<Recipe> retRecipeList = new ArrayList<Recipe>();
        ArrayList<Recipe> generalList = new Array<Recipe>();
        RecipeFinder SpoonacularFinder = new SpoonacularRecipeFinder();
        RecipeFinder CookbookFinder = new CookbookRecipeFinder();
        retRecipeList.add(SpoonacularFinder.findRecipes(searchRecipe));
        retRecipeList.add(CookbookFinder.findRecipes(searchRecipe));
        return retRecipeList;
        
    }
    private String searchRecipe;
} 