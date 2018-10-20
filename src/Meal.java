import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class Meal extends Food{
	

	private static final long serialVersionUID = -3340026292949245220L;
	Date date;
	private List<Ingredient> ingredients = new ArrayList<>();
	

	public Meal() throws Exception {
		super();
		this.calories = 0.0;
		this.weight = 0.0;
	}
	

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public boolean isEmpty() {
		return ingredients.size() == 0;
	}
	
	
	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
		this.calories += ingredient.getCalories();
		this.weight += ingredient.getWeight();
		this.fats.add(ingredient.getFats());
		this.carbs.add(ingredient.getCarbs());
		this.fiber.add(ingredient.getFiber());
		this.protein.add(ingredient.getProtein());
		this.microNutrients.add(ingredient.getMicroNutrients());
	}
	
	public void removeIngredient(Ingredient ingredient) {
		ingredients.remove(ingredient);
		this.calories -= ingredient.getCalories();
		this.weight -= ingredient.getWeight();
		this.fats.remove(ingredient.getFats());
		this.carbs.remove(ingredient.getCarbs());
		this.fiber.remove(ingredient.getFiber());
		this.protein.remove(ingredient.getProtein());
		this.microNutrients.remove(ingredient.getMicroNutrients());
	}
	
	
	@Override
	public String toString() {
		String str = "(" + date.toString() + ")\n";
		for (int i = 0; i < ingredients.size(); i++) {
			Ingredient ingredient = ingredients.get(i);
			str += ("\t" + (i+1) + " - " + ingredient);
			if (i < ingredients.size()-1) {
				str += "\n";
			}
		}
		return str;
	}

}
