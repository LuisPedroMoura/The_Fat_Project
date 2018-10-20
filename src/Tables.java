import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tables {
	
	private Map<Integer, Ingredient> ingredientTable = new HashMap<>();
	private Map<String, List<Ingredient>> ingredientsPerGroup = new HashMap<>();
	private Map<Date, List<Meal>> meals = new HashMap<>();
	
	
	
	@SuppressWarnings("unchecked")
	public Tables() {
		try {
			FileInputStream fis = new FileInputStream("myStats.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			meals = (Map<Date, List<Meal>>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println("myStats file was not found!");
		}
	}
	
	public Map<Integer, Ingredient> getIngredientTable() {
		return ingredientTable;
	}
	public Map<String, List<Ingredient>> getIngredientsPerGroup() {
		return ingredientsPerGroup;
	}
	public Map<Date, List<Meal>> getMeals() {
		return meals;
	}
	public void setMeals(Map<Date, List<Meal>> meals) {
		this.meals = meals;
	}
	
	
	public void saveMeal(Meal meal) {
		if (!meals.containsKey(meal.getDate())) {
			meals.put(meal.getDate(), new ArrayList<>());
		}
		meals.get(meal.getDate()).add(meal);
	}
	
	
}
