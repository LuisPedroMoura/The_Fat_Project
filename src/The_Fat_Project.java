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
			tables.getFoodTable().add(info[0]);
			
		}
		
		
		
		
	}
	

}
