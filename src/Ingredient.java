import static java.lang.System.out;

public class Ingredient extends Food{
	

	private static final long serialVersionUID = -2969257104341084123L;

	
	public Ingredient () {
		super();
		this.weight = 100.0;
	}
	
	/**
	 * copy CTOR, adjusts nutrients weights
	 * @param ingredient
	 * @param weight
	 */
	public Ingredient(Ingredient ingredient, double weight) {
		super();
		this.ID = -1;
		this.group = ingredient.getGroup();
		this.name = ingredient.getName();
		this.weight = 100.0;
		this.calories = ingredient.getCalories();
		this.fats = new Fats(ingredient.getFats());
		this.carbs = new Carbs(ingredient.getCarbs());
		this.fiber = new Fiber(ingredient.getFiber());
		this.protein = new Protein(ingredient.getProtein());
		this.microNutrients = new MicroNutrients(ingredient.getMicroNutrients());
		this.setWeight(weight);
	}
	
	public Ingredient(Meal meal) {
		super();
		this.group = meal.getGroup();
		this.name = meal.getName();
		this.calories = meal.getCalories();
		this.fats = new Fats(meal.getFats());
		this.carbs = new Carbs(meal.getCarbs());
		this.fiber = new Fiber(meal.getFiber());
		this.protein = new Protein(meal.getProtein());
		this.microNutrients = new MicroNutrients(meal.getMicroNutrients());
		this.setWeight(100);
	}

	@Override
	public String toString() {
		return weight + "g " + name;
	}
	
	

}
