public class Pantry extends Ingredient
{
	// Variables
	// <Ingredient name, quantity>
	Hashtable<Ingredient, int> ingredients;
	
	// Constructors
	public Pantry()
	{
		this.ingredients = new Hashtable<Ingredient, int>();
	}
	
	public Pantry(Hashtable<Ingredient, int> ingredients)
	{
		this.ingredients = ingredients;
	}
	
	// Methods
	public void addIngredient(Ingredient newingredient, int quantity)
	{
		ingredients.put(newingredient, quantity);
	}
	
	public void removeIngredient(Ingredient ingredient)
	{
		ingredients.remove(ingredient);
	}
	
	public Ingredient getIngredient(Ingredient ingredient)
	{
		return ingredients.get(ingredient);
	}
	
	public Ingredient[] displayAll()
	{
		//System.out.println(ingredients);
		Ingredient[] ing;
		ing = new Ingredient[ingredients.size()]
		Set<Ingredient> keys = ingredients.keySet();
		int counter = 0;
		for (Ingredient key: keys)
		{
			ing[counter] = key;
			counter++;
		}
		
		return ing;
	}
}
