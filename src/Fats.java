import java.io.Serializable;

public class Fats implements Serializable{


	private static final long serialVersionUID = -3604007428457752520L;
	private double fats;
	private double saturated;
	private double monounsaturated;
	private double polyunsaturated;
	private double linoleic;
	private double trans;
	
	public Fats() {}
	
	// copy constructor
	public Fats(Fats fats) {
		this.fats = fats.getFats();
		this.saturated = fats.getSaturated();
		this.monounsaturated = fats.getMonounsaturated();
		this.polyunsaturated = fats.getPolyunsaturated();
		this.linoleic = fats.getLinoleic();
		this.trans = fats.getTrans();
	}
	
	public double getFats() {
		return fats;
	}
	public void setFats(double fats) {
		this.fats = fats;
	}
	public double getSaturated() {
		return saturated;
	}
	public void setSaturated(double saturated) {
		this.saturated = saturated;
	}
	public double getMonounsaturated() {
		return monounsaturated;
	}
	public void setMonounsaturated(double monounsaturated) {
		this.monounsaturated = monounsaturated;
	}
	public double getPolyunsaturated() {
		return polyunsaturated;
	}
	public void setPolyunsaturated(double polyunsaturated) {
		this.polyunsaturated = polyunsaturated;
	}
	public double getLinoleic() {
		return linoleic;
	}
	public void setLinoleic(double linoleic) {
		this.linoleic = linoleic;
	}
	public double getTrans() {
		return trans;
	}
	public void setTrans(double trans) {
		this.trans = trans;
	}
	
	
	public void add(Fats fats) {
		this.fats += fats.getFats();
		this.saturated += fats.getSaturated();
		this.monounsaturated += fats.getMonounsaturated();
		this.polyunsaturated += fats.getPolyunsaturated();
		this.linoleic += fats.getLinoleic();
		this.trans += fats.getTrans();
	}
	
	public void remove(Fats fats) {
		this.fats -= fats.getFats();
		this.saturated -= fats.getSaturated();
		this.monounsaturated -= fats.getMonounsaturated();
		this.polyunsaturated -= fats.getPolyunsaturated();
		this.linoleic -= fats.getLinoleic();
		this.trans -= fats.getTrans();
	}

	
	public String print() {
		return "Total Fats: " + fats + "g";
	}
	public String stats() {
		return toString();
	}
	@Override
	public String toString() {
		String str = "Total Fats: " + fats + ", of witch" + "\n";
		str += ("\t" + saturated + " Saturated" + "\n");
		str += ("\t" + monounsaturated + " monounsaturated" + "\n");
		str += ("\t" + polyunsaturated + " Polyunsaturated" + "\n");
		str += ("\t" + linoleic + " Linoleic" + "\n");
		str += ("\t" + trans + " Trans");
		return str;
	}
	
	
	
	
}
