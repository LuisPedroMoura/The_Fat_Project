import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static java.lang.System.*;

public class The_Fat_Project {
	
	public static Scanner rd = new Scanner(System.in);
	private static Tables tables = new Tables();
	private static File ingredientsFile;
	
	public static void main (String[] args) throws Exception {
		
		String filename = args.length == 0 ? "Ingredients.csv" : args[0];
		ingredientsFile = new File(filename);
		parseIngredientFile(ingredientsFile);
		
//		String filename2 = args.length == 0 ? "Ingredient.csv" : args[1];
//		File file2 = new File(filename2);
//		parseStatsFile(file2);
		
		printMenu();		
	}
	
	
	private static void parseIngredientFile (File file) throws FileNotFoundException {
		
		Scanner read = new Scanner(file);
		
		read.nextLine();
		while (read.hasNextLine()) {
			
			String line = read.nextLine();
			Ingredient ingredient = parseIngredient(line);
			
			tables.getIngredientTable().put(ingredient.getID(), ingredient);
			
			Map<String,List<Ingredient>> ingredientsPerGroup = tables.getIngredientsPerGroup();
			if (!ingredientsPerGroup.containsKey(ingredient.getGroup())) {
				ingredientsPerGroup.put(ingredient.getGroup(), new ArrayList<>());
			}
			ingredientsPerGroup.get(ingredient.getGroup()).add(ingredient);
		}
		
		read.close();
	}
	
	private static Ingredient parseIngredient(String line) {
		
		String[] info = line.split(",");
		
		Ingredient ingredient = new Ingredient();
		ingredient.setWeight(100); // sets standard weight to 100g in file
		ingredient.setName(info[0]);
		ingredient.setGroup(info[1]);
		ingredient.setCalories(Double.parseDouble(info[2]));
		Fats fats = new Fats();
		fats.setFats(Double.parseDouble(info[3]));
		fats.setSaturated(Double.parseDouble(info[4]));
		fats.setMonounsaturated(Double.parseDouble(info[5]));
		fats.setPolyunsaturated(Double.parseDouble(info[6]));
		fats.setLinoleic(Double.parseDouble(info[7]));
		fats.setTrans(Double.parseDouble(info[8]));
		ingredient.setFats(fats);
		Carbs carbs = new Carbs();
		carbs.setCarbs(Double.parseDouble(info[9]));
		carbs.setSaccharides(Double.parseDouble(info[10]));
		carbs.setOligosaccharides(Double.parseDouble(info[11]));
		carbs.setStarch(Double.parseDouble(info[12]));
		ingredient.setCarbs(carbs);
		Fiber fiber = new Fiber();
		fiber.setFiber(Double.parseDouble(info[13]));
		ingredient.setFiber(fiber);
		Protein protein = new Protein();
		protein.setProtein(Double.parseDouble(info[14]));
		ingredient.setProtein(protein);
		MicroNutrients micro = new MicroNutrients();
		micro.setSalt(Double.parseDouble(info[15]));
		micro.setOrganicAcids(Double.parseDouble(info[16]));
		micro.setCholesterol(Double.parseDouble(info[17]));
		micro.setVitamin_A(Double.parseDouble(info[18]));
		micro.setCarotene(Double.parseDouble(info[19]));
		micro.setVitamin_D(Double.parseDouble(info[20]));
		micro.setTocopherol(Double.parseDouble(info[21]));
		micro.setThiamine(Double.parseDouble(info[22]));
		micro.setRiboflavin(Double.parseDouble(info[23]));
		micro.setNiacin(Double.parseDouble(info[24]));
		micro.setNiacinEquivalents(Double.parseDouble(info[25]));
		micro.setTryptophan(Double.parseDouble(info[26]));
		micro.setVitamin_B6(Double.parseDouble(info[27]));
		micro.setVitamin_B12(Double.parseDouble(info[28]));
		micro.setVitamin_C(Double.parseDouble(info[29]));
		micro.setFolates(Double.parseDouble(info[30]));
		micro.setAsh(Double.parseDouble(info[31]));
		micro.setSodium(Double.parseDouble(info[32]));
		micro.setPotassium(Double.parseDouble(info[33]));
		micro.setCalcium(Double.parseDouble(info[34]));
		micro.setPhosphor(Double.parseDouble(info[35]));
		micro.setMagnesium(Double.parseDouble(info[36]));
		micro.setIron(Double.parseDouble(info[37]));
		micro.setZinc(Double.parseDouble(info[38]));
		ingredient.setMicroNutrients(micro);
		
		return ingredient;
	}
	
	
	/**
	 * Main Application Menu
	 * @throws Exception 
	 */
	private static void printMenu() throws Exception {
		
		String option = "";
		do {
			out.println("THE FAT PROJECT");
			out.println();
			out.println("1 - Add Meal");
			out.println("2 - Add New Ingredient to File");
			out.println("3 - See Statistics");
			out.println("0 - SAVE AND EXIT");
			out.println();
			
			option = rd.nextLine();
			switch (option){
				case "1": addMealMenu(new Meal()); break;
				case "2": addNewIngredientToFileMenu(); break;
				case "3": seeStatsMenu(); break;
				case "0": 
					FileOutputStream fos = new FileOutputStream("myStats.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(tables.getMeals());
					oos.close();
					option = "0";
				default: ;
			}
		} while (option != "0");
	}
	
	
	/**
	 * Menu used to add a meal to the system
	 * @param meal
	 * @throws IOException 
	 */
	private static void addMealMenu(Meal meal) throws IOException {
		
		boolean correctDate = true;
		do {
			out.println();
			out.print("day: ");
			String day = rd.nextLine();
			out.print("month: ");
			String month = rd.nextLine();
			out.print("year: ");
			String year = rd.nextLine();
			Date date;
			try {
				date = new Date(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
				meal.setDate(date);
			}
			catch (Exception e) {
				out.println();
				out.println("Invalid Date");
				out.println();
				correctDate = false;
			}
		} while (!correctDate);
		
		String option = "";
		do {
			out.println();
			out.println("1 - Add Ingredient");
			out.println("2 - Remove Ingredient");
			out.println("3 - See Meal");
			out.println("4 - See Meal Simple Nutritional Value");
			out.println("5 - See Meal Detailed Nutritional Value");
			out.println("6 - Save Meal to File as a new Ingredient");
			out.println("0 - RETURN AND SAVE");
			out.println();
			
			option = rd.nextLine();
			switch (option){
				case "1": ingredientGroupMenu(meal); break;
				case "2": removeIngredientMenu(meal); break;
				case "3": seeMealMenu(meal); break;
				case "4": seeMealSimpleNutrVal(meal); break;
				case "5": seeMealDetailedNutrVal(meal); break;
				case "6": 
					out.println();
					out.println("Meal Nutritional Values will be saved in relation to 100g");
					meal.setWeight(100);
					saveToFile(meal); break;
				case "0":
					tables.getMeals().put(meal.getDate(), meal);
					option = "0";
				default: ;
			}
		} while (option != "0");
		
	}
	
	private static void ingredientGroupMenu(Meal meal) throws IOException {
		
		Map<String, List<Ingredient>> groupTable = tables.getIngredientsPerGroup();
		Object[] group = groupTable.keySet().toArray();
		boolean correctOption = true;
		int option = -1;
		do {
			out.println();
			out.println("FOOD GROUPS");
			out.println();
			for (int i = 0; i < groupTable.size(); i++) {
				out.print((i+1) + " - " + group[i].toString() + "\n");
			}
			
			try {
				option = Integer.parseInt(rd.nextLine())-1;
			}
			catch (Exception e) {
				correctOption = false;
			}
			
			if (option >= groupTable.size() || option < 0) {
				correctOption = false;
			}
			out.println();
			
		} while (!correctOption);
		
		ingredientMenu(meal, groupTable.get((String)group[option]));
	}

	private static void ingredientMenu(Meal meal, List<Ingredient> ingredients) throws IOException {
		
		boolean correctOption = true;
		Ingredient ingredient = new Ingredient();
		do {
			out.println();
			out.println("CHOOSE THE FOOD TO ADD");
			out.println();
			
			for (int i = 0; i < ingredients.size(); i++) {
				Ingredient f = ingredients.get(i);
				out.print(f.getID() + " - " + f.getName() + "\n");
			}
			
			String option = rd.nextLine();
			try {
				ingredient = tables.getIngredientTable().get(Integer.parseInt(option));
			}
			catch (Exception e) {
				correctOption = false;
			}
		} while (!correctOption);
		
		correctOption = true;
		double weight = 0.0;
		do {
			out.println();
			out.println("Weight of ingredient in grams:");
			try {
				weight = Double.parseDouble(rd.nextLine());
			}
			catch (Exception e) {
				correctOption = false;
			}
		}while (!correctOption);
		
		meal.addIngredient(new Ingredient(ingredient, weight));
		out.println();
		
	}
	
	public static void removeIngredientMenu(Meal meal) {
		
		boolean correctOption = true;
		int option = 0;
		do {
			out.println();
			out.println(meal);
			out.println();
			out.println("Which ingredient do you wish to remove?");
			try {
				option = Integer.parseInt(rd.nextLine());
			}
			catch (Exception e) {
				correctOption = false;
			}
		} while (!correctOption);
		
		meal.removeIngredient(meal.getIngredients().get(option-1));
		out.println();
	}
	
	public static void seeMealMenu(Food meal) {
		out.println();
		out.println(meal);
		out.println();
		out.println("PRESS ANY KEY + ENTER TO RETURN");
		rd.nextLine();
		out.println();
	}
	
	public static void seeMealSimpleNutrVal(Food meal) {
		out.println();
		out.println(meal.simpleStats());
		out.println();
		out.println("PRESS ANY KEY + ENTER TO RETURN");
		rd.nextLine();
		out.println();
	}
	
	public static void seeMealDetailedNutrVal(Food meal) {
		out.println();
		out.println(meal.fullStats());
		out.println();
		out.println("PRESS ANY KEY + ENTER TO RETURN");
		rd.nextLine();
		out.println();
	}
	
	
	public static void addNewIngredientToFileMenu() throws IOException {
		
		try {
			out.println();
			out.println("ADD FOOD TO FILE TOOL");
			out.println("All given values must be for 100g of ingredient");
			out.println();
			
			Ingredient ingredient = new Ingredient();
			ingredient.setWeight(100);
			
			out.println("Name: ");
			ingredient.setName(rd.nextLine());
			
			out.println("Select ingredient group: ");
			Map<String, List<Ingredient>> groupTable = tables.getIngredientsPerGroup();
			Object[] group = groupTable.keySet().toArray();
			for (int i = 0; i < groupTable.size(); i++) {
				out.print((i+1) + " - " + group[i].toString() + "\n");
			}
			int option = Integer.parseInt(rd.nextLine());
			ingredient.setGroup((String)group[option-1]);
			
			out.println("Calories: ");
			ingredient.setCalories(Double.parseDouble(rd.nextLine()));
			
			Fats fats = new Fats();
			out.println("Total Fats: ");
			fats.setFats(Double.parseDouble(rd.nextLine()));
			out.println("Add detailed fats nutritional values? (y/n)");
			String opt = rd.nextLine();
			if (opt.equals("y")) {
				out.println("Saturated Fats: ");
				fats.setSaturated(Double.parseDouble(rd.nextLine()));
				out.println("Monounsatrated Fats: ");
				fats.setMonounsaturated(Double.parseDouble(rd.nextLine()));
				out.println("Polyunsaturated Fats: ");
				fats.setPolyunsaturated(Double.parseDouble(rd.nextLine()));
				out.println("Linoleic Fatty Acids: ");
				fats.setLinoleic(Double.parseDouble(rd.nextLine()));
				out.println("Trans Fats: ");
				fats.setTrans(Double.parseDouble(rd.nextLine()));
			}
			else {
				fats.setFats(0.0);
				fats.setSaturated(0.0);
				fats.setMonounsaturated(0.0);
				fats.setPolyunsaturated(0.0);
				fats.setLinoleic(0.0);
				fats.setTrans(0.0);
			}
			ingredient.setFats(fats);
			
			Carbs carbs = new Carbs();
			out.println("Total Carbs: ");
			carbs.setCarbs(Double.parseDouble(rd.nextLine()));
			out.println("Add detailed carbs nutritional values? (y/n)");
			opt = rd.nextLine();
			if (opt.equals("y")) {
				out.println("Saccharides: ");
				carbs.setSaccharides(Double.parseDouble(rd.nextLine()));
				out.println("Oligosaccharides: ");
				carbs.setOligosaccharides(Double.parseDouble(rd.nextLine()));
				out.println("Starch: ");
				carbs.setStarch(Double.parseDouble(rd.nextLine()));
			}
			else {
				carbs.setSaccharides(0.0);
				carbs.setOligosaccharides(0.0);
				carbs.setStarch(0.0);
			}
			ingredient.setCarbs(carbs);
			
			Fiber fiber = new Fiber();
			out.println("Total Fiber: ");
			fiber.setFiber(Double.parseDouble(rd.nextLine()));
			ingredient.setFiber(fiber);
			
			Protein protein = new Protein();
			out.println("Total Protein: ");
			protein.setProtein(Double.parseDouble(rd.nextLine()));
			ingredient.setProtein(protein);
			
			MicroNutrients micro = new MicroNutrients();
			out.println("Add detailed micro nutrients nutritional values? (y/n)");
			opt = rd.nextLine();
			if (opt.equals("y")) {
				out.println("Salt: ");
				micro.setSalt(Double.parseDouble(rd.nextLine()));
				out.println("Organic Acids: ");
				micro.setOrganicAcids(Double.parseDouble(rd.nextLine()));
				out.println("Cholesterol: ");
				micro.setCholesterol(Double.parseDouble(rd.nextLine()));
				out.println("Vitamin A: ");
				micro.setVitamin_A(Double.parseDouble(rd.nextLine()));
				out.println("Carotene: ");
				micro.setCarotene(Double.parseDouble(rd.nextLine()));
				out.println("Vitamin D: ");
				micro.setVitamin_D(Double.parseDouble(rd.nextLine()));
				out.println("Tocopherol: ");
				micro.setTocopherol(Double.parseDouble(rd.nextLine()));
				out.println("Thiamine: ");
				micro.setThiamine(Double.parseDouble(rd.nextLine()));
				out.println("Riboflavin: ");
				micro.setRiboflavin(Double.parseDouble(rd.nextLine()));
				out.println("Niacin: ");
				micro.setNiacin(Double.parseDouble(rd.nextLine()));
				out.println("Niacin Equivalents: ");
				micro.setNiacinEquivalents(Double.parseDouble(rd.nextLine()));
				out.println("Tryptophan: ");
				micro.setTryptophan(Double.parseDouble(rd.nextLine()));
				out.println("Vitamin B6: ");
				micro.setVitamin_B6(Double.parseDouble(rd.nextLine()));
				out.println("Vitamin B12: ");
				micro.setVitamin_B12(Double.parseDouble(rd.nextLine()));
				out.println("Vitamin C: ");
				micro.setVitamin_C(Double.parseDouble(rd.nextLine()));
				out.println("Folates: ");
				micro.setFolates(Double.parseDouble(rd.nextLine()));
				out.println("Ash: ");
				micro.setAsh(Double.parseDouble(rd.nextLine()));
				out.println("Sodium: ");
				micro.setSodium(Double.parseDouble(rd.nextLine()));
				out.println("Potassium: ");
				micro.setPotassium(Double.parseDouble(rd.nextLine()));
				out.println("Calcium: ");
				micro.setCalcium(Double.parseDouble(rd.nextLine()));
				out.println("Phosphor: ");
				micro.setPhosphor(Double.parseDouble(rd.nextLine()));
				out.println("Magnesium: ");
				micro.setMagnesium(Double.parseDouble(rd.nextLine()));
				out.println("Iron: ");
				micro.setIron(Double.parseDouble(rd.nextLine()));
				out.println("Zinc: ");
				micro.setZinc(Double.parseDouble(rd.nextLine()));
			}
			else {
				micro.setSalt(0.0);
				micro.setOrganicAcids(0.0);
				micro.setCholesterol(0.0);
				micro.setVitamin_A(0.0);
				micro.setCarotene(0.0);
				micro.setVitamin_D(0.0);
				micro.setTocopherol(0.0);
				micro.setThiamine(0.0);
				micro.setRiboflavin(0.0);
				micro.setNiacin(0.0);
				micro.setNiacinEquivalents(0.0);
				micro.setTryptophan(0.0);
				micro.setVitamin_B6(0.0);
				micro.setVitamin_B12(0.0);
				micro.setVitamin_C(0.0);
				micro.setFolates(0.0);
				micro.setAsh(0.0);
				micro.setSodium(0.0);
				micro.setPotassium(0.0);
				micro.setCalcium(0.0);
				micro.setPhosphor(0.0);
				micro.setMagnesium(0.0);
				micro.setIron(0.0);
				micro.setZinc(0.0);
			}
			ingredient.setMicroNutrients(micro);

			saveToFile(ingredient);
			out.println();
			
		}
		catch (Exception e) {
			out.print("An invalid value was given. Returning to Main Menu");
		}
		
	}
	
	public static void saveToFile(Food ingredient) throws IOException {
		
	    FileWriter wr = new FileWriter(ingredientsFile,true);
		wr.write(ingredient.getName() + ",");
		wr.write(ingredient.getGroup() + ",");
		wr.write(ingredient.getCalories() + ",");
		wr.write(ingredient.getFats().getFats() + ",");
		wr.write(ingredient.getFats().getSaturated() + ",");
		wr.write(ingredient.getFats().getMonounsaturated() + ",");
		wr.write(ingredient.getFats().getPolyunsaturated() + ",");
		wr.write(ingredient.getFats().getLinoleic() + ",");
		wr.write(ingredient.getFats().getTrans() + ",");
		wr.write(ingredient.getCarbs().getCarbs() + ",");
		wr.write(ingredient.getCarbs().getSaccharides() + ",");
		wr.write(ingredient.getCarbs().getOligosaccharides() + ",");
		wr.write(ingredient.getCarbs().getStarch() + ",");
		wr.write(ingredient.getFiber().getFiber() + ",");
		wr.write(ingredient.getProtein().getProtein() + ",");
		wr.write(ingredient.getMicroNutrients().getSalt() + ",");
		wr.write(ingredient.getMicroNutrients().getOrganicAcids() + ",");
		wr.write(ingredient.getMicroNutrients().getCholesterol() + ",");
		wr.write(ingredient.getMicroNutrients().getVitamin_A() + ",");
		wr.write(ingredient.getMicroNutrients().getCarotene() + ",");
		wr.write(ingredient.getMicroNutrients().getVitamin_D() + ",");
		wr.write(ingredient.getMicroNutrients().getTocopherol() + ",");
		wr.write(ingredient.getMicroNutrients().getThiamine() + ",");
		wr.write(ingredient.getMicroNutrients().getRiboflavin() + ",");
		wr.write(ingredient.getMicroNutrients().getNiacin() + ",");
		wr.write(ingredient.getMicroNutrients().getNiacinEquivalents() + ",");
		wr.write(ingredient.getMicroNutrients().getTryptophan() + ",");
		wr.write(ingredient.getMicroNutrients().getVitamin_B6() + ",");
		wr.write(ingredient.getMicroNutrients().getVitamin_B12() + ",");
		wr.write(ingredient.getMicroNutrients().getVitamin_C() + ",");
		wr.write(ingredient.getMicroNutrients().getFolates() + ",");
		wr.write(ingredient.getMicroNutrients().getAsh() + ",");
		wr.write(ingredient.getMicroNutrients().getSodium() + ",");
		wr.write(ingredient.getMicroNutrients().getPotassium() + ",");
		wr.write(ingredient.getMicroNutrients().getCalcium() + ",");
		wr.write(ingredient.getMicroNutrients().getPhosphor() + ",");
		wr.write(ingredient.getMicroNutrients().getMagnesium() + ",");
		wr.write(ingredient.getMicroNutrients().getIron() + ",");
		wr.write(ingredient.getMicroNutrients().getZinc() + "");
		wr.write("\n");
		wr.close();
		
		parseIngredientFile(ingredientsFile);
		
	}
	
	
	public static void seeStatsMenu() throws Exception {
		for (Date date : tables.getMeals().keySet()) {
			out.println(tables.getMeals().get(date));
		}
	}

}
