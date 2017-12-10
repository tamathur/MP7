package Cells;

/**
 * The game player
 * @author tmath
 *
 */
public class Player extends Cell {
	
	/**The amount of health the player currently has*/
	private int health;
	/**The amount of water the player currently has*/
	private int water;
	/**The amount of food the player currently has*/
	private int curedMeat;
	
	// Constructor
	public Player() {
		super('@', 0);
		health = 100;
		water = 10;
		curedMeat = 10;
	}

}