package country;

/**
 * @author Hadar Amsalem
 * ID: 316129212 
 * @author Chen Ben Tolila
 * ID: 207278029
 */

public class Map {
	
	/**
	 * constructor
	 */
	public Map()
	{
		m_settlements = new Settlement[0];   // create an empty map
	}
	

	
	/**
	 * the method adds a settlement to the map
	 * @param s - the settlement we want to add
	 * @return boolean according to if the add succeeded or failed
	 */
	public Settlement[] addSettlement(Settlement s){
		Settlement[] newArray = new Settlement[m_settlements.length + 1];  // create a new settlement array
		int i;
		for(i=0; i < m_settlements.length; ++i)   // go over the existing settlements array
			newArray[i] = m_settlements[i];    // copy the settlements to the new array
		newArray[i] = s;  // copy the new settlement
		m_settlements = newArray;  
		return m_settlements;
	}
	
	/**
	 * return the map in string form
	 */
	public String toString()   
	{
		String s = "=======================================\n"; 
		s += "The Map:\n" ;
		for(int i=0;i<m_settlements.length;++i) {
			s+= m_settlements[i].toString()+"\n";
			if(i != (m_settlements.length -1))
				s += "-----------------------\n";
		}
		s += "=======================================\n";
		return s;
	}
	
	
	
	/**
	 * Initialize 1% of the population as sick
	 */
	public void addSickToMap()
	{
		for(int i = 0; i < m_settlements.length; ++i)  // go over the settlements
		{
			m_settlements[i].intializeSickPeople();    // turn 1% of settlement's population into sick people
		}
	}
	 /**
	  * try to contagion 3 people with each sick person
	  */
	public void contagionSimu() {
		for(int i = 0; i < m_settlements.length; ++i)  // go over the settlements
		{
			m_settlements[i].tryToInfectThree();   
		}
	}
	
	/**
	 * 
	 * @param s1 get first name of settlement
	 * @param s2 get second name of settlement
	 */
	public void connectSettlements(String s1, String s2) {
		int index=-1;
		for(int i=0; i < m_settlements.length; ++i) {
			if((s1.equals(m_settlements[i].getSettlementName())) || (s2.equals(m_settlements[i].getSettlementName())))
				if(index==-1)
					index=i;
				else {
					m_settlements[i].addConnectedSettlement(m_settlements[index]);
					m_settlements[index].addConnectedSettlement(m_settlements[i]);
				}
		}
	}
	
	private Settlement[] m_settlements;    // the list of settlements in the simulation
}
