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
			food.setCalories(info[2]);
			Fats fats = new Fats();
			food.
			
			tables.getFoodTable().add(info[0]);
			
		}
		
		
		
		
	}
	

}
