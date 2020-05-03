package RecipeFinder;

public class CookbookRecipeFinder extends RecipeFinder{
    public CookbookRecipeFinder(String aRecipe){
        SearchRecipe=aRecipe;
    }
    public ArrayList<Recipe> findRecipes(SearchRecipe){
        ArrayList<Recipe> retRecipeList = new ArrayList<Recipe>();
        ArrayList<Recipe> generalList = new Array<Recipe>();
        PersonalCookbook cb = new PersonalCookbook();
        generalList=cb.displayAll();
        int i=0;
        while(i!=generalList.size()){
            if(generalList.get(i)==SearchRecipe){
                retRecipeList.add(generalList.get(i));
            }
        }
        return retRecipeList;
    }
    private String SearchRecipe;
    
}