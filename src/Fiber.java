import java.io.Serializable;

public class Fiber implements Serializable {
	

	private static final long serialVersionUID = 5572922172663348492L;
	private double fiber;
	
	public Fiber() {}
	
	public Fiber(Fiber fiber) {
		this.fiber = fiber.getFiber();
	}

	public double getFiber() {
		return fiber;
	}

	public void setFiber(double fiber) {
		this.fiber = fiber;
	}
	
	
	public void add(Fiber fiber) {
		this.fiber += fiber.getFiber();
	}
	
	public void remove(Fiber fiber) {
		this.fiber -= fiber.getFiber();
	}
	
	
	public String print() {
		return toString();
	}
	public String stats() {
		return toString();
	}
	@Override
	public String toString() {
		return "Total Fiber: " + fiber;
	}

	
}
