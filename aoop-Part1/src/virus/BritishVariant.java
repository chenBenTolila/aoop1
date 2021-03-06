package virus;
import population.*;
import java.util.Random;
import simulation.Clock;


/**
 * @author Hadar Amsalem
 * ID: 316129212 
 * @author Chen Ben Tolila
 * ID: 207278029
 */

public class BritishVariant implements IVirus {
	
	
	/**
	 * return the probability to get infected in British variant according to the person age
	 */
	 public double contagionProbability(Person p){
		return p.contagionProbability()*infectProbAll;
	 }
	 
	 
	 // test
	 
	 /**
	  * if the second person is healthy check if he got infected by the first person
	  */
	 public boolean tryToContagion(Sick p1, Person p2){
		 
		 Random rand = new Random();   // the random probability of the person getting infected
		 double probToSick;   // the calculated probability
		 IVirus vType;   // the variant type
		 double varSickProb;   // the probability of p2 to get sick infected in the variant according to his age
		 if(!(p2.checkIfSick())) {   // check if the p2 is healthy
			 if(Clock.DaysPassed(p1.getContagiousTime()) < 5)   // check that p1 is sick for 5 or more days
			 {
				 return false;
			 }
			 
			 vType = (VirusManager.getVirusManager()).getRandomVirus(VirusesEnum.BRITISH);
			 if(vType == null)  // this variant can't develop to any variant
				 return false;
			 
			 varSickProb = vType.contagionProbability(p2);
			 if(varSickProb == 0)   // if the variant can contage at the moment (by status)
				 return false;
		
			 probToSick = varSickProb*Math.min(1,0.14*Math.pow(Math.E, 2-0.25*p1.distance(p2)));   // calculation of the probability
			 if (probToSick >= rand.nextDouble())  // exclude 1 - [0,1)  ///	
			 {
				 p2.contagion(vType);
			 }
			 return true;
		 }
		 else
			 throw new RuntimeException();   // p2 is not healthy
	 }
	 
	 
	 // end test


	 /**
	  * return true if the person died from the virus
	  */
	 public boolean tryToKill(Sick s){
		 Random rand = new Random();   // will keep the random probability of the person dying
		 double probToDie;   // will keep the calculated probability
		 if(s.getAge() <= 18)
			 probToDie = Math.max(0, dieProb18-0.01*dieProb18*Math.pow((s.getSicknessDuration()-15),2));   // calculate the probability to die if the person is 18 and under
		 else
			 probToDie = Math.max(0, dieProbUp18-0.01*dieProbUp18*Math.pow((s.getSicknessDuration()-15),2));  // calculate the probability to die if the person in above 18
		 return probToDie >= rand.nextDouble();  // exclude 1 = [0,1)  ///
	 }
	
	 
	 /**
	  * return the British variant in string form
	  */
	 @Override
	 public String toString() {
		 return "British variant";
	 }
	 

	
	// data members
	private final double dieProb18 = 0.01;    // The probability of dying by the age of 18
	private final double dieProbUp18 = 0.1;   // The probability of dying over the age of 18
	private final double infectProbAll = 0.7; // The probability of infection for all 
}
