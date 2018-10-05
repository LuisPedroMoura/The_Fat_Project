import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class The_Fat_Project {
	
	
	
	public static void main (String[] args) throws FileNotFoundException {
		
		String filename = args.length == 0 ? "Food.csv" : args[0];
		File file = new File(filename);
		Scanner read = new Scanner(file);
		
		Tables tables = new Tables();
		
		read.nextLine();
		while (read.hasNextLine()) {
			
			String line = read.nextLine();
			
			String[] info = line.split(",");
			
			Food food = new Food();
			food.setName(info[0]);
			food.setGroup(info[1]);
			food.setCalories(Double.parseDouble(info[2]));
			Fats fats = new Fats();
			fats.setFats(Double.parseDouble(info[3]));
			fats.set(Double.parseDouble(info[4]));
			fats.set(Double.parseDouble(info[5]));
			fats.set(Double.parseDouble(info[6]));
			fats.set(Double.parseDouble(info[7]));
			fats.set(Double.parseDouble(info[8]));
			food.setFat(fats);
			Carbs carbs = new Carbs();
			carbs.setCarbs(Double.parseDouble(info[9]));
			carbs.setCarbs(Double.parseDouble(info[10]));
			carbs.setCarbs(Double.parseDouble(info[11]));
			carbs.setCarbs(Double.parseDouble(info[12]));
			food.setCarbs(carbs);
			Fiber fiber = new Fiber();
			fiber.setFiber(Double.parseDouble(info[13]));
			food.setFiber(fiber);
			Protein protein = new Protein();
			protein.setProtein(Double.parseDouble(info[14]));
			food.setProtein(protein);
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
			micro.setVitamin_B6(Double.parseDouble(info[26]));
			micro.setVitamin_B12(Double.parseDouble(info[27]));
			micro.setVitamin_C(Double.parseDouble(info[28]));
			micro.setFolates(Double.parseDouble(info[29]));
			micro.setAsh(Double.parseDouble(info[30]));
			micro.setSodium(Double.parseDouble(info[31]));
			micro.setPotassium(Double.parseDouble(info[32]));
			micro.setCalcium(Double.parseDouble(info[33]));
			micro.setPhosphor(Double.parseDouble(info[34]));
			micro.setMagnesium(Double.parseDouble(info[35]));
			micro.setIron(Double.parseDouble(info[36]));
			micro.setZinc(Double.parseDouble(info[37]));
			
			;
			
			
			tables.getFoodTable().add(info[0]);
			
		}
		
		
		
		
	}
	

}
