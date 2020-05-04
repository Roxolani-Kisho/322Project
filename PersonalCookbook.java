import java.util.*;

public class PersonalCookbook extends Recipe{
	// Variable(s)
	ArrayList<Recipe> recipeList = new ArrayList<Recipe>(); 	// List containing all recipes for user
	
	// Constructors
	PersonalCookbook(ArrayList<Recipe> recipeList){ 
		this.recipeList = recipeList;
	}
	
	// Methods
	public void addRecipe(Recipe newRecipe){
		recipeList.add(newRecipe);
	}

	public void removeRecipe(String recipeName){
		recipeList.removeif(n -> n.name.equals(recipeName));	// Remove recipe with specified name from recipelist in cookbook
	}

	public Recipe getRecipe(String recipeName){
		for()
	}

}