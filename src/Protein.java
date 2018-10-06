import java.io.Serializable;

public class Protein implements Serializable {
	

	private static final long serialVersionUID = -5508376135972414972L;
	private double protein;
	
	public Protein() {}
	
	public Protein(Protein protein) {
		this.protein = protein.getProtein();
	}


	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}
	
	
	public void add(Protein protein) {
		this.protein += protein.getProtein();
	}
	
	public void remove(Protein protein) {
		this.protein -= protein.getProtein();
	}
	
	
	public String print() {
		return toString();
	}
	public String stats() {
		return toString();
	}
	@Override
	public String toString() {
		String str = "Total Protein: " + protein;
		return str;
	}
	
}
