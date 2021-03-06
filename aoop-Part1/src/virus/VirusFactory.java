package virus;


/**
 * @author Hadar Amsalem
 * ID: 316129212 
 * @author Chen Ben Tolila
 * ID: 207278029
 */

public class VirusFactory {
	
	/**
	 *	a virus factory method
	 * @param index - an index of a virus
	 * @return the relevant virus
	 */
	public IVirus getVirus(String virus)
	{
		if(virus!=null) {
			switch(virus)
			{
			case "BritishVariant":
				return new BritishVariant();
			case "ChineseVariant":
				return new ChineseVariant();
			case "SouthAfrican": 
				return new SouthAfricanVariant();
			default: 
				return null;
			}
		}
		return null;
	}
}
