import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tables {
	
	private Map<Integer, Food> foodTable = new HashMap<>();
	private Map<String, List<Food>> foodsPerGroup = new HashMap<>();
	
	
	public Map<Integer, Food> getFoodTable() {
		return foodTable;
	}

	public Map<String, List<Food>> getFoodsPerGroup() {
		return foodsPerGroup;
	}

	
	

}
