import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;
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
			out.println("2 - Manage Ingredients File");
			out.println("3 - See Statistics");
			out.println("0 - SAVE AND EXIT");
			out.println();
			
			option = rd.nextLine();
			switch (option){
				case "1": 
					Meal meal = addMealMenu(new Meal(), false);
					if (meal != null) {
						tables.saveMeal(meal);
					}
					break;
				case "2": manageIngredientsFile(); break;
				case "3": seeStatsMenu(); break;
				case "0":
					
					// saving meals
					try {
						FileOutputStream fos = new FileOutputStream("myStats.ser");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(tables.getMeals());
						oos.close();
					} catch (Exception e) {
						err.print("ERROR while saving meal added in this session. Please repeat.");
						System.exit(1);
					}
					
					// saving ingredients
					// temporary copy
					InputStream is = null;
					OutputStream os = null;
					File tempFile = new File("IngredientsSafetyCopy.csv");
				    try {
				        is = new FileInputStream(ingredientsFile);
				        os = new FileOutputStream(tempFile);
				        byte[] buffer = new byte[1024];
				        int length;
				        while ((length = is.read(buffer)) > 0) {
				            os.write(buffer, 0, length);
				        }
				    } catch (Exception e) {
				    	out.print("Error while saving - temporary copy failed");
				    	System.exit(1);
				    } finally {
				        is.close();
				        os.close();
				    }
					
				    // save the ingredients to File
					ingredientsFile.delete();
					ingredientsFile = new File("Ingredients.csv");
					Map<Integer, Ingredient> ingTable = tables.getIngredientTable();
					for (Integer key : ingTable.keySet()) {
						saveToFile(ingTable.get(key), ingredientsFile);
					}
					
					// delete temporary safety copy
					try {
						tempFile.delete();
						
					} catch (Exception e) {
						out.println("Error in deletion of temporary archive file, please verify in folder");
					}
					option = "0";
				default: ;
			}
		} while (!option.equals("0"));
		out.println();
	}
	
	
	/**
	 * Menu used to add a meal to the system
	 * @param meal
	 * @throws IOException 
	 */
	private static Meal addMealMenu(Meal meal, boolean toFile) throws IOException {
		
		if (!toFile) {
			
			boolean correctOption;
			do {
				correctOption = true;
				out.println("Is the Meal for today? (y/n)");
				String option = rd.nextLine();
				if (option.equals("n")) {

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
				}
				else if (option.equals("y")) {
					meal.setDate(new Date());
				}
				else {
					correctOption = false;
				}
			} while (!correctOption);
		}
		else {
			meal.setDate(new Date());
		}
		
		String option = "";
		do {
			out.println();
			out.println("1 - Add Ingredient");
			out.println("2 - Remove Ingredient");
			out.println("3 - See Meal");
			out.println("4 - See Meal Simple Nutritional Value");
			out.println("5 - See Meal Detailed Nutritional Value");
			out.println("0 - RETURN AND SAVE");
			out.println("x - RETURN WITHOUT SAVING");
			out.println();
			
			option = rd.nextLine();
			switch (option){
				case "1":
					Ingredient ingredient = ingredientGroupMenu();
					if (ingredient != null) {
						meal.addIngredient(ingredient);
					}
					break;
				case "2": removeIngredientMenu(meal); break;
				case "3": seeMealMenu(meal); break;
				case "4": seeMealSimpleNutrVal(meal); break;
				case "5": seeMealDetailedNutrVal(meal); break;
				case "0": 
					if (!meal.isEmpty()) {
						return meal;
					}
					else {
						return null;
					}
				case "x": return null;
				default: ;
			}
		} while (!option.equals("0"));
		
		return null;
	}
	
	private static Ingredient ingredientGroupMenu() throws IOException {
		
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
			out.println("x - CANCEL");
			
			String read = rd.nextLine();
			try {
				option = Integer.parseInt(read)-1;
			}
			catch (Exception e) {
				if (read.equals("x")) {
					return null;
				}
				correctOption = false;
			}
			
			if (option >= groupTable.size() || option < 0) {
				correctOption = false;
			}
			out.println();
			
		} while (!correctOption);
		
		out.println();
		
		return ingredientMenu(groupTable.get((String)group[option]));
	}

	private static Ingredient ingredientMenu(List<Ingredient> ingredients) throws IOException {
		
		boolean correctOption = true;
		Ingredient ingredient = new Ingredient();
		do {
			out.println();
			out.println("CHOOSE THE INGREDIENT TO ADD");
			out.println();
			
			for (int i = 0; i < ingredients.size(); i++) {
				Ingredient f = ingredients.get(i);
				out.print(f.getID() + " - " + f.getName() + "\n");
			}
			out.println("x - CANCEL");
			
			String option = rd.nextLine();
			try {
				
				boolean correctWeight = true;
				double weight = 0.0;
				do {
					out.println();
					out.println("Weight of ingredient in grams:");
					try {
						weight = Double.parseDouble(rd.nextLine());
					}
					catch (Exception e) {
						correctWeight = false;
					}
				}while (!correctWeight);
				
				ingredient = new Ingredient(tables.getIngredientTable().get(Integer.parseInt(option)), weight);
			}
			catch (Exception e) {
				if (option.equals("x")) {
					return null;
				}
				correctOption = false;
			}
		} while (!correctOption);
		
		out.println();
		return ingredient;
		
	}
	
	public static void removeIngredientMenu(Meal meal) {
		
		boolean correctOption = true;
		int option = 0;
		do {
			out.println();
			out.println(meal);
			out.println("x - CANCEL");
			out.println();
			out.println("Which ingredient do you wish to remove?");
			
			String read = rd.nextLine();
			try {
				option = Integer.parseInt(read);
			}
			catch (Exception e) {
				if (read.equals("x")) {
					return;
				}
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
		meal.printSimpleStats();
		out.println();
		out.println("PRESS ANY KEY + ENTER TO RETURN");
		rd.nextLine();
		out.println();
	}
	
	public static void seeMealDetailedNutrVal(Food meal) {
		out.println();
		meal.printFullStats();
		out.println();
		out.println("PRESS ANY KEY + ENTER TO RETURN");
		rd.nextLine();
		out.println();
	}
	
	
	public static void manageIngredientsFile() throws Exception {
		
		String option = "";
		do {
			out.println();
			out.println("INGREDIENTS FILE TOOL");
			out.println();
			out.println("1 - Add Ingredient to File");
			out.println("2 - Remove Ingredient to File");
			out.println("0 - RETURN");
			out.println();
			
			option = rd.nextLine();
			switch(option) {
				case "1": addNewIngredientToFileMenu(); break;
				case "2": removeIngredientFromFile(); break;
			}
		} while (!option.equals("0"));
	}

	public static void addNewIngredientToFileMenu() throws Exception {
		
		String option = "";
		do {
			out.println();
			out.println("ADD FOOD TO FILE TOOL");
			out.println();
			out.println("1 - Add new simple Ingredient");
			out.println("2 - Add Meal as an Ingredient");
			out.println("3 - Remove Ingredient");
			out.println("0 - RETURN");
			out.println();
			
			option = rd.nextLine();
			switch(option) {
				case "1": addNewSimpleIngredientToFile(); break;
				case "2": addMealAsIngredientToFile(new Meal()); break;
				case "3": removeIngredientFromFile(); break;
				case "0": option = "0"; break;
			}
		} while (!option.equals("0"));
		out.println();
	}
	
	public static void addNewSimpleIngredientToFile() {
		
		try {
			out.println();
			out.println("ADD FOOD TO FILE TOOL");
			out.println();
			
			Ingredient ingredient = new Ingredient();
			ingredient.setWeight(100);
			
			out.println("Name: ");
			ingredient.setName(rd.nextLine());
			
			out.println("Select ingredient group: ");
			Map<String, List<Ingredient>> groupTable = tables.getIngredientsPerGroup();
			Object[] group = groupTable.keySet().toArray();
			int i = 0;
			for (; i < groupTable.size(); i++) {
				out.print((i+1) + " - " + group[i].toString() + "\n");
			}
			out.print((i+2) + " - " + "New Food Group" + "\n");
			int option = Integer.parseInt(rd.nextLine());
			if (option == i+2) {
				out.println("New Group Name: ");
				ingredient.setGroup(rd.nextLine());
			}
			else {
				ingredient.setGroup((String)group[option-1]);
			}
			
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

			tables.getIngredientTable().put(ingredient.getID(), ingredient);
			out.println();
		}
		catch (Exception e) {
			out.print("ERROR while creating New Ingredient!");
		}
	}
	
	public static void addMealAsIngredientToFile(Meal meal) throws IOException {
		
		out.println();
		out.println("ADD FOOD TO FILE TOOL");
		out.println();
		meal = addMealMenu(meal, true);
		Ingredient ingredient = new Ingredient(meal);
		if (meal != null) {
			tables.getIngredientTable().put(ingredient.getID(), ingredient);
		}
	}
	
	public static void removeIngredientFromFile() throws IOException {
		
		out.println();
		out.println("REMOVE FOOD TO FILE TOOL");
		out.println();
		Ingredient ingredient = ingredientGroupMenu();
		tables.getIngredientTable().remove(ingredient.getID());
	}
	
	public static void saveToFile(Food ingredient, File file) throws IOException {
		
	    FileWriter wr = new FileWriter(file,true);
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
	}
	
	
	public static void seeStatsMenu() throws Exception {
		

		String option = "";
		do {
			out.println();
			out.println("1 - Global Stats");
			out.println("2 - Last 30 days");
			out.println("3 - Last 7 days");
			out.println("4 - Yesterday");
			out.println("5 - Today");
			out.println("6 - Personalized");
			out.println("0 - RETURN");
			out.println();
			
			option = rd.nextLine();
			switch (option){
				case "1": printGlobalStats(); break;
				case "2": printLastDaysStats(30); break;
				case "3": printLastDaysStats(7); break;
				case "4": 
					Date date = new Date();
					printStats(date.yesterday(), date.yesterday());
					break;
				case "5": 
					Date today = new Date();
					printStats(today, today);
					break;
				case "6":
					boolean correctDate = true;
					Date first = null;
					Date last = null;
					do {
						try {
							out.println("First date:");
							out.println();
							out.print("day: ");
							String day = rd.nextLine();
							out.print("month: ");
							String month = rd.nextLine();
							out.print("year: ");
							String year = rd.nextLine();
							first = new Date(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
							out.println("Last date:");
							out.println();
							out.print("day: ");
							day = rd.nextLine();
							out.print("month: ");
							month = rd.nextLine();
							out.print("year: ");
							year = rd.nextLine();
							last = new Date(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
						}
						catch (Exception e) {
							out.println();
							out.println("Invalid Date");
							out.println();
							correctDate = false;
						}
					} while (!correctDate);
					printStats(first, last);
					break;
				case "0": option = "0";
				default: ;
			}
		} while (!option.equals("0"));
		out.println();
	}
	
	
	public static void printGlobalStats() {
		
//		for (Date date: tables.getMeals().keySet()) {
//			List<Meal> list = tables.getMeals().get(date);
//			for (Meal meal : list) {
//				out.println(meal);
//			}
//		}
		
		Comparator<Date> dateComp = new Comparator<Date>() {
			@Override
			public int compare(Date d1, Date d2) {
				return d1.compareTo(d2);
			}
		};
		
		try {
			Date first = tables.getMeals().keySet().stream()
									  			   .min(dateComp)
									  			   .get();
			
			Date last = tables.getMeals().keySet().stream()
		  			   							   .max(dateComp)
		  			   							   .get();
			printStats(first, last);
		} catch (Exception e) {
			out.println("There are no meals saved yet!");
		}
		
		out.println();
	}
	
	public static void printLastDaysStats(int days) {
		
		Comparator<Date> dateComp = new Comparator<Date>() {
			@Override
			public int compare(Date d1, Date d2) {
				return d1.compareTo(d2);
			}
		};
		
		Date last = tables.getMeals().keySet().stream()
					   .max(dateComp)
					   .get();
		
		Date first = last.subtractDays(days);
		
		printStats(first, last);
		out.println();
	}
	
	public static void printStats(Date first, Date last) {
		
		Stats stats = new Stats(first, last);
		Map<Date,List<Meal>> meals = tables.getMeals();
		
		for (Date date : meals.keySet()) {
			if (date.compareTo(first) >= 0 && date.compareTo(last) <= 0) {
				List<Meal> list = new ArrayList<>();
				for (Meal meal : meals.get(date)) {
					list.add(meal);
				}
				stats.addDay(date, list);
			}
		}
		
		String option = "";
		do {
			out.println();
			out.println("PRINT STATISTICS");
			out.println();
			out.println("1 - Simple Macro Nutrient Statistics");
			out.println("2 - All Nutrient Statistics");
			out.println("0 - RETURN");
			out.println();
			
			option = rd.nextLine();
			switch(option) {
				case "1": stats.printSimpleStats(); break;
				case "2": stats.printFullStats(); break;
				case "0": option = "0"; break;
			}
		} while (!option.equals("0"));
		out.println();
	}

}
