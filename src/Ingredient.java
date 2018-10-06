
public class Ingredient extends Food{
	

	private static final long serialVersionUID = -2969257104341084123L;
	private static int globalID;
	private int ID;

	
	public Ingredient () {
		super();
		this.ID = globalID++;
		this.weight = 100.0;
	}
	
	public Ingredient(Ingredient ingredient, double weight) {
		super();
		this.ID = -1;
		this.group = ingredient.getGroup();
		this.name = ingredient.getName();
		this.calories = ingredient.getCalories();
		this.fats = new Fats(ingredient.getFats());
		this.carbs = new Carbs(ingredient.getCarbs());
		this.fiber = new Fiber(ingredient.getFiber());
		this.protein = new Protein(ingredient.getProtein());
		this.microNutrients = new MicroNutrients(ingredient.getMicroNutrients());
		this.setWeight(weight);
	}



	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

}
