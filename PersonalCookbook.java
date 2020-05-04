import java.util.*;

public class PersonalCookbook extends Recipe{
	// Variable(s)
	ArrayList<Recipe> recipeList = new ArrayList<Recipe>(); 	// List containing all recipes for user
	
	// Constructors
	PersonalCookbook(ArrayList<Recipe> recipeList){ 
		this.recipeList = recipeList;
	}
	
	// Methods

	// Add recipe object to Recipe List
	public void addRecipe(Recipe newRecipe){
		recipeList.add(newRecipe);
	}

	// Remove recipe with specified name from recipelist in cookbook
	public void removeRecipe(String recipeName){
		recipeList.removeIf(n -> n.name.equals(recipeName));
	}

	// return Recipe object with specified name
	public Recipe getRecipe(String recipeName){	
		for(int i = 0; i < recipeList.size(); i++){
			if (recipeList.get(i).name.equals(recipeName)){
				return recipeList.get(i);
			} 	
		}
		return null; // return null if specified recipe not found
	}

	// Return list of current recipes 
	public void displayAll(){
		return recipeList.toArray();
	}
}