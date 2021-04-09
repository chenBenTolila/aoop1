package population;
import virus.IVirus;
import location.Point;
import country.Settlement; 

public class Convalescent extends Person{
	
	public Convalescent(int age, Point location, Settlement settlement, IVirus virus) {
		super(age, location, settlement);
		this.virus =virus;
	}
	
	public double contagionProbability() {
		return 0.2;
	}
	
	
	/**
	 * return true if the person in not infected in the virus
	 */
	public boolean checkIfHealthy()
	{
		return true;
	}
	
	private IVirus virus;
}
