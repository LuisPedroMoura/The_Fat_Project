import java.io.Serializable;

public class MicroNutrients implements Serializable {
	

	private static final long serialVersionUID = -4196590520325408631L;
	private double salt;
	private double organicAcids;
	private double cholesterol;
	private double vitamin_A;
	private double carotene;
	private double vitamin_D;
	private double tocopherol;
	private double thiamine;
	private double riboflavin;
	private double niacin;
	private double niacinEquivalents;
	private double tryptophan;
	private double vitamin_B6;
	private double vitamin_B12;
	private double vitamin_C;
	private double folates;
	private double ash;
	private double sodium;
	private double potassium;
	private double calcium;
	private double phosphor;
	private double magnesium;
	private double iron;
	private double zinc;
	
	
	public MicroNutrients() {}
	
	public MicroNutrients(MicroNutrients micro) {
		this.salt = micro.getSalt();
		this.organicAcids = micro.getOrganicAcids();
		this.cholesterol = micro.getCholesterol();
		this.vitamin_A = micro.getVitamin_A();
		this.carotene = micro.getCarotene();
		this.vitamin_D = micro.getVitamin_D();
		this.tocopherol = micro.getTocopherol();
		this.thiamine = micro.getThiamine();
		this.riboflavin = micro.getRiboflavin();
		this.niacin = micro.getNiacin();
		this.niacinEquivalents = micro.getNiacinEquivalents();
		this.tryptophan = micro.getTryptophan();
		this.vitamin_B6 = micro.getVitamin_B6();
		this.vitamin_B12 = micro.getVitamin_B12();
		this.vitamin_C = micro.getVitamin_C();
		this.folates = micro.getFolates();
		this.ash = micro.getAsh();
		this.sodium = micro.getSodium();
		this.potassium = micro.getPotassium();
		this.calcium = micro.getCalcium();
		this.phosphor = micro.getPhosphor();
		this.magnesium = micro.getMagnesium();
		this.iron = micro.getIron();
		this.zinc = micro.getZinc();
	}



	public double getSalt() {
		return salt;
	}
	public void setSalt(double salt) {
		this.salt = salt;
	}
	public double getOrganicAcids() {
		return organicAcids;
	}
	public void setOrganicAcids(double organicAcids) {
		this.organicAcids = organicAcids;
	}
	public double getCholesterol() {
		return cholesterol;
	}
	public void setCholesterol(double cholesterol) {
		this.cholesterol = cholesterol;
	}
	public double getVitamin_A() {
		return vitamin_A;
	}
	public void setVitamin_A(double vitamin_A) {
		this.vitamin_A = vitamin_A;
	}
	public double getCarotene() {
		return carotene;
	}
	public void setCarotene(double carotene) {
		this.carotene = carotene;
	}
	public double getVitamin_D() {
		return vitamin_D;
	}
	public void setVitamin_D(double vitamin_D) {
		this.vitamin_D = vitamin_D;
	}
	public double getTocopherol() {
		return tocopherol;
	}
	public void setTocopherol(double tocopherol) {
		this.tocopherol = tocopherol;
	}
	public double getThiamine() {
		return thiamine;
	}
	public void setThiamine(double thiamine) {
		this.thiamine = thiamine;
	}
	public double getRiboflavin() {
		return riboflavin;
	}
	public void setRiboflavin(double riboflavin) {
		this.riboflavin = riboflavin;
	}
	public double getNiacin() {
		return niacin;
	}
	public void setNiacin(double niacin) {
		this.niacin = niacin;
	}
	public double getNiacinEquivalents() {
		return niacinEquivalents;
	}
	public void setNiacinEquivalents(double niacinEquivalents) {
		this.niacinEquivalents = niacinEquivalents;
	}
	public double getTryptophan() {
		return tryptophan;
	}
	public void setTryptophan(double tryptophan) {
		this.tryptophan = tryptophan;
	}
	public double getVitamin_B6() {
		return vitamin_B6;
	}
	public void setVitamin_B6(double vitamin_B6) {
		this.vitamin_B6 = vitamin_B6;
	}
	public double getVitamin_B12() {
		return vitamin_B12;
	}
	public void setVitamin_B12(double vitamin_B12) {
		this.vitamin_B12 = vitamin_B12;
	}
	public double getVitamin_C() {
		return vitamin_C;
	}
	public void setVitamin_C(double vitamin_C) {
		this.vitamin_C = vitamin_C;
	}
	public double getFolates() {
		return folates;
	}
	public void setFolates(double folates) {
		this.folates = folates;
	}
	public double getAsh() {
		return ash;
	}
	public void setAsh(double ash) {
		this.ash = ash;
	}
	public double getSodium() {
		return sodium;
	}
	public void setSodium(double sodium) {
		this.sodium = sodium;
	}
	public double getPotassium() {
		return potassium;
	}
	public void setPotassium(double potassium) {
		this.potassium = potassium;
	}
	public double getCalcium() {
		return calcium;
	}
	public void setCalcium(double calcium) {
		this.calcium = calcium;
	}
	public double getPhosphor() {
		return phosphor;
	}
	public void setPhosphor(double phosphor) {
		this.phosphor = phosphor;
	}
	public double getMagnesium() {
		return magnesium;
	}
	public void setMagnesium(double magnesium) {
		this.magnesium = magnesium;
	}
	public double getIron() {
		return iron;
	}
	public void setIron(double iron) {
		this.iron = iron;
	}
	public double getZinc() {
		return zinc;
	}
	public void setZinc(double zinc) {
		this.zinc = zinc;
	}
	

	public void add(MicroNutrients micro) {
		this.salt += micro.getSalt();
		this.organicAcids += micro.getOrganicAcids();
		this.cholesterol += micro.getCholesterol();
		this.vitamin_A += micro.getVitamin_A();
		this.carotene += micro.getCarotene();
		this.vitamin_D += micro.getVitamin_D();
		this.tocopherol += micro.getTocopherol();
		this.thiamine += micro.getThiamine();
		this.riboflavin += micro.getRiboflavin();
		this.niacin += micro.getNiacin();
		this.niacinEquivalents += micro.getNiacinEquivalents();
		this.tryptophan += micro.getTryptophan();
		this.vitamin_B6 += micro.getVitamin_B6();
		this.vitamin_B12 += micro.getVitamin_B12();
		this.vitamin_C += micro.getVitamin_C();
		this.folates += micro.getFolates();
		this.ash += micro.getAsh();
		this.sodium += micro.getSodium();
		this.potassium += micro.getPotassium();
		this.calcium += micro.getCalcium();
		this.phosphor += micro.getPhosphor();
		this.magnesium += micro.getMagnesium();
		this.iron += micro.getIron();
		this.zinc += micro.getZinc();
	}
	
	public void remove(MicroNutrients micro) {
		this.salt -= micro.getSalt();
		this.organicAcids -= micro.getOrganicAcids();
		this.cholesterol -= micro.getCholesterol();
		this.vitamin_A -= micro.getVitamin_A();
		this.carotene -= micro.getCarotene();
		this.vitamin_D -= micro.getVitamin_D();
		this.tocopherol -= micro.getTocopherol();
		this.thiamine -= micro.getThiamine();
		this.riboflavin -= micro.getRiboflavin();
		this.niacin -= micro.getNiacin();
		this.niacinEquivalents -= micro.getNiacinEquivalents();
		this.tryptophan -= micro.getTryptophan();
		this.vitamin_B6 -= micro.getVitamin_B6();
		this.vitamin_B12 -= micro.getVitamin_B12();
		this.vitamin_C -= micro.getVitamin_C();
		this.folates -= micro.getFolates();
		this.ash -= micro.getAsh();
		this.sodium -= micro.getSodium();
		this.potassium -= micro.getPotassium();
		this.calcium -= micro.getCalcium();
		this.phosphor -= micro.getPhosphor();
		this.magnesium -= micro.getMagnesium();
		this.iron -= micro.getIron();
		this.zinc -= micro.getZinc();
	}
	
	
	public String print() {
		return toString();
	}
	public String stats() {
		return toString();
	}
	@Override
	public String toString() {
		String str = "Micro Nutrients: " + "\n";
		str += ("\t" + salt + " Salt" + "\n");
		str += ("\t" + organicAcids + " OrganicAcids" + "\n");
		str += ("\t" + cholesterol + " Cholesterol" + "\n");
		str += ("\t" + vitamin_A + " Vitamin_A" + "\n");
		str += ("\t" + carotene + " Carotene" + "\n");
		str += ("\t" + vitamin_D + " Vitamin_D" + "\n");
		str += ("\t" + tocopherol + " Tocopherol" + "\n");
		str += ("\t" + tocopherol + " Tocopherol" + "\n");
		str += ("\t" + riboflavin + " Riboflavin" + "\n");
		str += ("\t" + niacin + " Niacin" + "\n");
		str += ("\t" + niacinEquivalents + " NiacinEquivalents" + "\n");
		str += ("\t" + tryptophan + " Tryptophan" + "\n");
		str += ("\t" + vitamin_B6 + " Vitamin_B6" + "\n");
		str += ("\t" + vitamin_B12 + " Vitamin_B12" + "\n");
		str += ("\t" + vitamin_C + " Vitamin_C" + "\n");
		str += ("\t" + folates + " Folates" + "\n");
		str += ("\t" + ash + " Ash" + "\n");
		str += ("\t" + sodium + " Sodium" + "\n");
		str += ("\t" + potassium + " Potassium" + "\n");
		str += ("\t" + calcium + " Calcium" + "\n");
		str += ("\t" + phosphor + " Phosphor" + "\n");
		str += ("\t" + magnesium + " Magnesium" + "\n");
		str += ("\t" + iron + " Iron" + "\n");
		str += ("\t" + zinc + " Zinc");
		return str;
	}
	
}
