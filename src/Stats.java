import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.lang.System.*;

public class Stats extends Food{
	

	private static final long serialVersionUID = -2271066062308560780L;
	private Map<Date, List<Meal>> days = new HashMap<>();
	private Stats avStats;
	private Date firstDay;
	private Date lastDay;
	private int totalDays = 0;
	
	private double totalMacroWeight;
	private double totalWeight;
	private double fatsCal;
	private double proteinCal;
	private double carbsCal;
	private double fiberCal;
	
	
	
	public Stats(Date first, Date last) {
		this.firstDay = first;
		this.lastDay = last;
		this.calories = 0;
	}

	
	public Map<Date, List<Meal>> getDays() {
		return days;
	}
	public Date getFirstDay() {
		return firstDay;
	}
	public void setFirstDay(Date firstDay) {
		this.firstDay = firstDay;
	}
	public Date getLastDay() {
		return lastDay;
	}
	public void setLastDay(Date lastDay) {
		this.lastDay = lastDay;
	}
	public double getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}
	public double getTotalMacroWeight() {
		return totalMacroWeight;
	}
	public void setTotalMacroWeight(double totalMacroWeight) {
		this.totalMacroWeight = totalMacroWeight;
	}
	public double getFatsCal() {
		return fatsCal;
	}
	public void setFatsCal(double fatCal) {
		this.fatsCal = fatCal;
	}
	public double getCarbsCal() {
		return carbsCal;
	}
	public void setCarbsCal(double carbCal) {
		this.carbsCal = carbCal;
	}
	public double getProteinCal() {
		return proteinCal;
	}
	public void setProteinCal(double proteinCal) {
		this.proteinCal = proteinCal;
	}
	public double getFiberCal() {
		return fiberCal;
	}
	public void setFiberCal(double fiberCal) {
		this.fiberCal = fiberCal;
	}


	public void addDay(Date date, List<Meal> list) {
		totalDays++;
		days.put(date, list);
		for (Meal meal : list) {
			this.calories += meal.getCalories();
			this.totalWeight += meal.getWeight();
			this.getFats().add(meal.getFats());
			this.getCarbs().add(meal.getCarbs());
			this.getFiber().add(meal.getFiber());
			this.getProtein().add(meal.getProtein());
			this.getMicroNutrients().add(meal.getMicroNutrients());
		}
	}
	
	
	public void calcCalories() {
		
		this.totalMacroWeight = fats.getFats() + carbs.getCarbs() + fiber.getFiber() + protein.getProtein();
		
		this.fatsCal = fats.getFats() * 9;
		this.proteinCal = protein.getProtein() * 4;
		this.carbsCal = carbs.getCarbs() * 4;
		this.fiberCal = fiber.getFiber() * 1;
		
		double macroCal = this.fatsCal + this.proteinCal + this.carbsCal + this.fiberCal;
		double remCal = this.calories - macroCal;
		
		double fatCalPercent = this.fatsCal/this.calories;
		double proteinCalPercent = this.proteinCal/this.calories;
		double carbCalPercent = this.carbsCal/this.calories;
		double fiberCalPercent = this.fiberCal/this.calories;
		
		this.fatsCal += fatCalPercent * remCal;
		this.proteinCal += proteinCalPercent * remCal;
		this.carbsCal += carbCalPercent * remCal;
		this.fiberCal += fiberCalPercent * remCal;
		
	}
	
	
	public void calcStats() {
		
		calcCalories();
		calculateNutritionalAverages(this.totalDays);
	}
	
	@Override
	public void printSimpleStats() {
		
		calcStats();
		
		out.printf("---------------------------------------------------------------------------------\n");
		out.printf("|                      MACRO NUTRIENTS STATISTICS - GLOBAL                      |\n");
		out.printf("|-------------------------------------------------------------------------------|\n");
		out.printf("| Total macro nutrients: %10.0f g, %10.0f cal                           |\n", totalMacroWeight, calories);
		out.printf("| Total fats: %21.0f g, %10.0f cal                           |\n", fats.getFats(), fatsCal);
		out.printf("| Total protein: %18.0f g, %10.0f cal                           |\n", protein.getProtein(), proteinCal);
		out.printf("| Total carbs: %20.0f g, %10.0f cal                           |\n", carbs.getCarbs(), carbsCal);
		out.printf("| Total fiber: %20.0f g, %10.0f cal                           |\n", fiber.getFiber(), fiberCal);
		out.printf("|-------------------------------------------------------------------------------|\n");
		out.printf("| Average macro nutrients: %8.0f g, %10.0f cal                           |\n", avStats.getTotalMacroWeight(), avStats.getCalories());
		out.printf("| Average fats weight: %12.0f g, %10.0f cal                           |\n", avStats.getFats().getFats(), avStats.getFatsCal());
		out.printf("| Average protein weight: %9.0f g, %10.0f cal                           |\n", avStats.getProtein().getProtein(), avStats.getProteinCal());
		out.printf("| Average carbs weight: %11.0f g, %10.0f cal                           |\n", avStats.getCarbs().getCarbs(), avStats.getCarbsCal());
		out.printf("| Average fiber weight: %11.0f g, %10.0f cal                           |\n", avStats.getFiber().getFiber(), avStats.getFiberCal());
		out.printf("---------------------------------------------------------------------------------\n");
	}
	
	@Override
	public void printFullStats() {

		calcStats();
		
		out.printf("---------------------------------------------------------------------------------\n");
		out.printf("|                 MACRO AND MICRO NUTRIENTS STATISTICS - GLOBAL                 |\n");
		out.printf("|-------------------------------------------------------------------------------|\n");
		out.printf("| Total weight: %31.0f g %10.0f cal                |\n", totalWeight, calories);
		out.printf("| Total fats: %33.0f g %10.0f cal                |\n", fats.getFats(), fatsCal);
		out.printf("| Total protein: %30.0f g %10.0f cal                |\n", protein.getProtein(), proteinCal);
		out.printf("| Total carbs: %32.0f g %10.0f cal                |\n", carbs.getCarbs(), carbsCal);
		out.printf("| Total fiber: %32.0f g %10.0f cal                |\n", fiber.getFiber(), fiberCal);
		out.printf("|-------------------------------------------------------------------------------|\n");
		out.printf("| Average weight: %29.0f g %10.0f cal                |\n", avStats.getTotalWeight(), avStats.getCalories());
		out.printf("| Average fats weight: %24.0f g %10.0f cal                |\n", avStats.getFats().getFats(), avStats.getFatsCal());
		out.printf("| 		Saturated: %20.1f g                               |\n", avStats.getFats().getSaturated());
		out.printf("| 		Monounsaturated: %14.1f g                               |\n", avStats.getFats().getMonounsaturated());
		out.printf("| 		Polyunsaturated: %14.1f g                               |\n", avStats.getFats().getPolyunsaturated());
		out.printf("| 		Linoleic: %21.1f g                               |\n", avStats.getFats().getLinoleic());
		out.printf("| 		Trans: %24.1f g                               |\n", avStats.getFats().getTrans());
		out.printf("| Average protein weight: %21.0f g %10.0f cal                |\n", avStats.getProtein().getProtein(), avStats.getProteinCal());
		out.printf("| Average carbs weight: %23.0f g %10.0f cal                |\n", avStats.getCarbs().getCarbs(), avStats.getCarbsCal());
		out.printf("| 		Saccharides: %18.1f g                               |\n", avStats.getCarbs().getSaccharides());
		out.printf("| 		Oligosaccharides: %13.1f g                               |\n", avStats.getCarbs().getOligosaccharides());
		out.printf("| 		Starch: %23.1f g                               |\n", avStats.getCarbs().getStarch());
		out.printf("| Average fiber weight: %23.0f g %10.0f cal                |\n", avStats.getFiber().getFiber(), avStats.getFiberCal());
		out.printf("| Average minerals and vitamins:                                                |\n");
		out.printf("| 		Salt: %25.9f g                               |\n", avStats.getMicroNutrients().getSalt());
		out.printf("| 		Organic Acids: %16.9f g                               |\n", avStats.getMicroNutrients().getOrganicAcids());
		out.printf("| 		Cholesterol: %18.9f g                               |\n", avStats.getMicroNutrients().getCholesterol());
		out.printf("| 		Vitamin A: %20.9f g     (0.0009 - 0.003)          |\n", avStats.getMicroNutrients().getVitamin_A());
		out.printf("| 		Carotene: %21.9f g     (ad to Vit. A)            |\n", avStats.getMicroNutrients().getCarotene());
		out.printf("| 		Vitamin D: %20.9f g     (0.000015 - 0.0001)       |\n", avStats.getMicroNutrients().getVitamin_D());
		out.printf("| 		Tocopherol: %19.9f g     (0.000000825 - 0.000027)  |\n", avStats.getMicroNutrients().getTocopherol());
		out.printf("| 		Thiamine: %21.9f g     (0.000120 - )             |\n", avStats.getMicroNutrients().getThiamine());
		out.printf("| 		Riboflavin: %19.9f g     (0.0013 - )               |\n", avStats.getMicroNutrients().getRiboflavin());
		out.printf("| 		Niacin: %23.9f g     (0.016 - 0.035)           |\n", avStats.getMicroNutrients().getNiacin());
		out.printf("| 		Niacin Equivalents: %11.9f g     (add to Niacin)           |\n", avStats.getMicroNutrients().getNiacinEquivalents());
		out.printf("| 		Tryptophan: %19.9f g                               |\n", avStats.getMicroNutrients().getTryptophan());
		out.printf("| 		Vitamin B6: %19.9f g     (0.0013 - 0.1)            |\n", avStats.getMicroNutrients().getVitamin_B6());
		out.printf("| 		Vitamin B12: %18.9f g     (0.0000024 - )            |\n", avStats.getMicroNutrients().getVitamin_B12());
		out.printf("| 		Vitamin C: %20.9f g     (0.09 - 2)                |\n", avStats.getMicroNutrients().getVitamin_C());
		out.printf("| 		Folates: %22.9f g     (0.0004 - 0.001)          |\n", avStats.getMicroNutrients().getFolates());
		out.printf("| 		Ash: %26.9f g                               |\n", avStats.getMicroNutrients().getAsh());
		out.printf("| 		Sodium: %23.9f g     (0.5 - 2)                 |\n", avStats.getMicroNutrients().getSodium());
		out.printf("| 		Potassium: %20.9f g     (4.7 - )                  |\n", avStats.getMicroNutrients().getPotassium());
		out.printf("| 		Calcium: %22.9f g     (1 - 2.5)                 |\n", avStats.getMicroNutrients().getCalcium());
		out.printf("| 		Phosphor: %21.9f g     (0.000700 - 4)            |\n", avStats.getMicroNutrients().getPhosphor());
		out.printf("| 		Magnesium: %20.9f g     (0.000420)                |\n", avStats.getMicroNutrients().getMagnesium());
		out.printf("| 		Iron: %25.9f g     (0.008 - 0.045)           |\n", avStats.getMicroNutrients().getIron());
		out.printf("| 		Zinc: %25.9f g     (0.011 - 0.040)           |\n", avStats.getMicroNutrients().getZinc());	
		out.printf("---------------------------------------------------------------------------------\n");
	}
	
	
	private void calculateNutritionalAverages(double totalDays) {
		this.avStats = new Stats(firstDay, lastDay);
		
		
		this.avStats.setTotalMacroWeight(this.totalMacroWeight / totalDays);
		this.avStats.setFatsCal(this.fatsCal / totalDays);
		this.avStats.setProteinCal(this.proteinCal / totalDays);
		this.avStats.setCarbsCal(this.carbsCal / totalDays);
		this.avStats.setFiberCal(this.fiberCal / totalDays);

		
		this.avStats.setCalories(this.getCalories() / totalDays);
		this.avStats.setWeight(this.getTotalWeight() / totalDays);
		this.avStats.getFats().setFats(this.fats.getFats() / totalDays);
		this.avStats.getFats().setSaturated(this.fats.getSaturated() / totalDays);
		this.avStats.getFats().setMonounsaturated(this.fats.getMonounsaturated() / totalDays);
		this.avStats.getFats().setPolyunsaturated(this.fats.getPolyunsaturated() / totalDays);
		this.avStats.getFats().setLinoleic(this.fats.getLinoleic() / totalDays);
		this.avStats.getFats().setTrans(this.fats.getTrans() / totalDays);
		this.avStats.getCarbs().setCarbs(this.carbs.getCarbs() / totalDays);
		this.avStats.getCarbs().setSaccharides(this.carbs.getSaccharides() / totalDays);
		this.avStats.getCarbs().setOligosaccharides(this.carbs.getOligosaccharides() / totalDays);
		this.avStats.getCarbs().setStarch(this.carbs.getStarch() / totalDays);
		this.avStats.getFiber().setFiber(this.fiber.getFiber() / totalDays);
		this.avStats.getProtein().setProtein(this.protein.getProtein() / totalDays);
		this.avStats.getMicroNutrients().setSalt(this.microNutrients.getSalt() / totalDays);
		this.avStats.getMicroNutrients().setOrganicAcids(this.microNutrients.getOrganicAcids() / totalDays);
		this.avStats.getMicroNutrients().setCholesterol(this.microNutrients.getCholesterol() / totalDays);
		this.avStats.getMicroNutrients().setVitamin_A(this.microNutrients.getVitamin_A() / totalDays);
		this.avStats.getMicroNutrients().setCarotene(this.microNutrients.getCarotene() / totalDays);
		this.avStats.getMicroNutrients().setVitamin_D(this.microNutrients.getVitamin_D() / totalDays);
		this.avStats.getMicroNutrients().setTocopherol(this.microNutrients.getTocopherol() / totalDays);
		this.avStats.getMicroNutrients().setThiamine(this.microNutrients.getThiamine() / totalDays);
		this.avStats.getMicroNutrients().setRiboflavin(this.microNutrients.getRiboflavin() / totalDays);
		this.avStats.getMicroNutrients().setNiacin(this.microNutrients.getNiacin() / totalDays);
		this.avStats.getMicroNutrients().setNiacinEquivalents(this.microNutrients.getNiacinEquivalents() / totalDays);
		this.avStats.getMicroNutrients().setTryptophan(this.microNutrients.getTryptophan() / totalDays);
		this.avStats.getMicroNutrients().setVitamin_B6(this.microNutrients.getVitamin_B6() / totalDays);
		this.avStats.getMicroNutrients().setVitamin_B12(this.microNutrients.getVitamin_B12() / totalDays);
		this.avStats.getMicroNutrients().setVitamin_C(this.microNutrients.getVitamin_C() / totalDays);
		this.avStats.getMicroNutrients().setFolates(this.microNutrients.getFolates() / totalDays);
		this.avStats.getMicroNutrients().setAsh(this.microNutrients.getAsh() / totalDays);
		this.avStats.getMicroNutrients().setSodium(this.microNutrients.getSodium() / totalDays);
		this.avStats.getMicroNutrients().setPotassium(this.microNutrients.getPotassium() / totalDays);
		this.avStats.getMicroNutrients().setCalcium(this.microNutrients.getCalcium() / totalDays);
		this.avStats.getMicroNutrients().setPhosphor(this.microNutrients.getPhosphor() / totalDays);
		this.avStats.getMicroNutrients().setMagnesium(this.microNutrients.getMagnesium() / totalDays);
		this.avStats.getMicroNutrients().setIron(this.microNutrients.getIron() / totalDays);
		this.avStats.getMicroNutrients().setZinc(this.microNutrients.getZinc() / totalDays);	
	}


	@Override
	public String toString() {
		String str = "";
		str += firstDay.writeOutDate() + "to" + lastDay.writeOutDate();
		return str;
	}
	
	
	
	

}
