import java.io.Serializable;
import static java.lang.System.*;

public class Food implements Serializable{
	

	private static final long serialVersionUID = 982710775909361699L;
	protected String name;
	protected String group;
	protected double weight;
	protected double calories;
	protected Fats fats;
	protected Carbs carbs;
	protected Fiber fiber;
	protected Protein protein;
	protected MicroNutrients microNutrients;
	
	private static int globalID;
	protected int ID;
	
	
	public Food() {
		this.ID = globalID++;
		this.fats = new Fats();
		this.carbs = new Carbs();
		this.fiber = new Fiber();
		this.protein = new Protein();
		this.microNutrients = new MicroNutrients();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		recalculateNutritionalValues(weight);
		this.weight = weight;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public Fats getFats() {
		return fats;
	}
	public void setFats(Fats fats) {
		this.fats = fats;
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
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	
	
	private void recalculateNutritionalValues(double newWeight) {
		
		this.calories = newWeight * this.calories / this.weight;
		this.fats.setFats(newWeight * this.fats.getFats() / this.weight);
		this.fats.setSaturated(newWeight * this.fats.getSaturated() / this.weight);
		this.fats.setMonounsaturated(newWeight * this.fats.getMonounsaturated() / this.weight);
		this.fats.setPolyunsaturated(newWeight * this.fats.getPolyunsaturated() / this.weight);
		this.fats.setLinoleic(newWeight * this.fats.getLinoleic() / this.weight);
		this.fats.setTrans(newWeight * this.fats.getTrans() / this.weight);
		this.carbs.setCarbs(newWeight * this.carbs.getCarbs() / this.weight);
		this.carbs.setSaccharides(newWeight * this.carbs.getSaccharides() / this.weight);
		this.carbs.setOligosaccharides(newWeight * this.carbs.getOligosaccharides() / this.weight);
		this.carbs.setStarch(newWeight * this.carbs.getStarch() / this.weight);
		this.fiber.setFiber(newWeight * this.fiber.getFiber() / this.weight);
		this.protein.setProtein(newWeight * this.protein.getProtein() / this.weight);
		this.microNutrients.setSalt(newWeight * this.microNutrients.getSalt() / this.weight);
		this.microNutrients.setOrganicAcids(newWeight * this.microNutrients.getOrganicAcids() / this.weight);
		this.microNutrients.setCholesterol(newWeight * this.microNutrients.getCholesterol() / this.weight);
		this.microNutrients.setVitamin_A(newWeight * this.microNutrients.getVitamin_A() / this.weight);
		this.microNutrients.setCarotene(newWeight * this.microNutrients.getCarotene() / this.weight);
		this.microNutrients.setVitamin_D(newWeight * this.microNutrients.getVitamin_D() / this.weight);
		this.microNutrients.setTocopherol(newWeight * this.microNutrients.getTocopherol() / this.weight);
		this.microNutrients.setThiamine(newWeight * this.microNutrients.getThiamine() / this.weight);
		this.microNutrients.setRiboflavin(newWeight * this.microNutrients.getRiboflavin() / this.weight);
		this.microNutrients.setNiacin(newWeight * this.microNutrients.getNiacin() / this.weight);
		this.microNutrients.setNiacinEquivalents(newWeight * this.microNutrients.getNiacinEquivalents() / this.weight);
		this.microNutrients.setTryptophan(newWeight * this.microNutrients.getTryptophan() / this.weight);
		this.microNutrients.setVitamin_B6(newWeight * this.microNutrients.getVitamin_B6() / this.weight);
		this.microNutrients.setVitamin_B12(newWeight * this.microNutrients.getVitamin_B12() / this.weight);
		this.microNutrients.setVitamin_C(newWeight * this.microNutrients.getVitamin_C() / this.weight);
		this.microNutrients.setFolates(newWeight * this.microNutrients.getFolates() / this.weight);
		this.microNutrients.setAsh(newWeight * this.microNutrients.getAsh() / this.weight);
		this.microNutrients.setSodium(newWeight * this.microNutrients.getSodium() / this.weight);
		this.microNutrients.setPotassium(newWeight * this.microNutrients.getPotassium() / this.weight);
		this.microNutrients.setCalcium(newWeight * this.microNutrients.getCalcium() / this.weight);
		this.microNutrients.setPhosphor(newWeight * this.microNutrients.getPhosphor() / this.weight);
		this.microNutrients.setMagnesium(newWeight * this.microNutrients.getMagnesium() / this.weight);
		this.microNutrients.setIron(newWeight * this.microNutrients.getIron() / this.weight);
		this.microNutrients.setZinc(newWeight * this.microNutrients.getZinc() / this.weight);
	}
	
	
	public void printSimpleStats() {
		out.println("Calories: " + this.calories);
		out.println(fats.print());
		out.println(carbs.print());
		out.println(fiber.print());
		out.println(protein.print());
	}
	
	public void printFullStats() {
		out.println("Calories: " + this.calories);
		out.println(fats.stats());
		out.println(carbs.stats());
		out.println(fiber.stats());
		out.println(protein.stats());
		out.println(microNutrients.stats());
	}
	
	
	
}
