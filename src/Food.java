
public class Food {
	
	private static int globalID;
	private int ID;
	private String group;
	private String name;
	private int weight;
	private int calories;
	private Fats fat;
	private Carbs carbs;
	private Fiber fiber;
	private Proteins proteins;
	private MicroNutrients microNutrients;
	
	public Food (){
		this.ID = globalID++;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public Fats getFat() {
		return fat;
	}

	public void setFat(Fats fat) {
		this.fat = fat;
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

	public Proteins getProteins() {
		return proteins;
	}

	public void setProteins(Proteins proteins) {
		this.proteins = proteins;
	}

	public MicroNutrients getMicroNutrients() {
		return microNutrients;
	}

	public void setMicroNutrients(MicroNutrients microNutrients) {
		this.microNutrients = microNutrients;
	}
	
	
	
	

}
