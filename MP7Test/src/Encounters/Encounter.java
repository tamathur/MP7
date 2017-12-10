package Encounters;
/**
 * Possible events to occur in the game (such as an attack)
 * @author tmath
 *
 */
public class Encounter {
	private int changeInHealth;
	private int changeInWater;
	private int changeInFood;
	
	public Encounter(final int ht, final int w, final int f) {
		this.changeInHealth = ht;
		this.changeInWater = w;
		this.changeInFood = f;
	}
	
	public int getHealthTaken() {
		return changeInHealth;
	}
	
	public int getChangeInWater() {
		return changeInWater;
	}
	
	public int getChangeInFood() {
		return changeInFood;
	}

}
