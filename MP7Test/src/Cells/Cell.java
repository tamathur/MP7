package Cells;
/**
 * The cells on the map that the player can traverse
 * @author tmath
 *
 */
public class Cell {
	/**Every cell has a unique symbol*/
	private char symbol;
	/**The x and y coordinates of the Cell in the Cell array*/
	private int[] coordinates;
	/**The amount of health the player currently has*/
	private int health;
	/**The amount of water the player currently has*/
	private int water;
	/**The amount of food the player currently has*/
	private int food;
	
	// Constructor
	public Cell(final char sym, final int h, final int w, final int f) {
		symbol = sym;
		coordinates = new int[2];
		health = h;
		water = w;
		food = f;
	}

	// Getters and Setters
	public char getSymbol() {
		return symbol;
	}
	
	public int[] getCoordinates() {
		return coordinates;
	}
	
	public void setCoordinates(int x, int y) {
		coordinates[0] = x;
		coordinates[1] = y;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int setHealth) {
		this.health = setHealth;
	}
	
	public int getWater() {
		return water;
	}
	
	public void setWater(int setWater) {
		this.water = setWater;
	}
	
	public int getFood() {
		return food;
	}
	
	public void setFood(int setFood) {
		this.food = setFood;
	}

}
