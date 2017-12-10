package Cells;
/**
 * The cells on the map that the player can traverse
 * @author tmath
 *
 */
public class Cell {
	/**Every cell has a unique symbol*/
	private char symbol;
	private int[] coordinates;
	private int health;
	private int water;
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
	
	public int getWater() {
		return water;
	}
	
	public int getFood() {
		return food;
	}

}
