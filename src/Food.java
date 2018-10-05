
public class Food {
	
	private static double globalID;
	private double ID;
	private String group;
	private String name;
	private double weight;
	private double calories;
	private Fats fats;
	private Carbs carbs;
	private Fiber fiber;
	private Protein protein;
	private MicroNutrients microNutrients;
	
	public Food (){
		this.ID = globalID++;
	}

	public double getID() {
		return ID;
	}

	public void setID(double iD) {
		ID = iD;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public Fats getFat() {
		return fats;
	}

	public void setFat(Fats fat) {
		this.fats = fat;
	}

	public Carbs getCarbs() {
		return carbs;
	}

	public void setCarbs(Carbs carbs) {
		this.carbs = carbs;
	}

	public Fiber getFiber() {
		return fiber;
	}

	public void setFiber(Fiber fiber) {
		this.fiber = fiber;
	}

	public Protein getProtein() {
		return protein;
	}

	public void setProtein(Protein protein) {
		this.protein = protein;
	}

	public MicroNutrients getMicroNutrients() {
		return microNutrients;
	}

	public void setMicroNutrients(MicroNutrients microNutrients) {
		this.microNutrients = microNutrients;
	}
	
	
	
	

}
