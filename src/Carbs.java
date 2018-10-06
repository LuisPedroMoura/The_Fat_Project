import java.io.Serializable;

public class Carbs implements Serializable {
	

	private static final long serialVersionUID = 5630731610973258371L;
	private double carbs;
	private double saccharides;
	private double oligosaccharides;
	private double starch;
	
	
	public Carbs() {}
	
	public Carbs(Carbs carbs) {
		this.carbs = carbs.getCarbs();
		this.saccharides = carbs.getSaccharides();
		this.oligosaccharides = carbs.getOligosaccharides();
		this.starch = carbs.getStarch();
	}



	public double getCarbs() {
		return carbs;
	}
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
	public double getSaccharides() {
		return saccharides;
	}
	public void setSaccharides(double saccharides) {
		this.saccharides = saccharides;
	}
	public double getOligosaccharides() {
		return oligosaccharides;
	}
	public void setOligosaccharides(double oligosaccharides) {
		this.oligosaccharides = oligosaccharides;
	}
	public double getStarch() {
		return starch;
	}
	public void setStarch(double starch) {
		this.starch = starch;
	}
	
	
	public void add(Carbs carbs) {
		this.carbs += carbs.getCarbs();
		this.saccharides += carbs.getSaccharides();
		this.oligosaccharides += carbs.getOligosaccharides();
		this.starch += carbs.getStarch();
	}
	
	public void remove(Carbs carbs) {
		this.carbs -= carbs.getCarbs();
		this.saccharides -= carbs.getSaccharides();
		this.oligosaccharides -= carbs.getOligosaccharides();
		this.starch -= carbs.getStarch();
	}
	
	
	public String print() {
		return "Total Carbs: " + carbs + "g";
	}
	public String stats() {
		return toString();
	}
	@Override
	public String toString() {
		String str = "Total Carbs: " + carbs + ", of witch" + "\n";
		str += ("\t" + saccharides + " saccharides" + "\n");
		str += ("\t" + oligosaccharides + " oligosaccharides" + "\n");
		str += ("\t" + starch + " starch");
		return str;
	}
	
}
