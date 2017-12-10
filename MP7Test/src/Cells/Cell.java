package Cells;
/**
 * The cells on the map that the player can traverse
 * @author tmath
 *
 */
public class Cell {
	/**Every cell has a unique symbol*/
	private char symbol;
	private int animalNum;
	
	// Constructor
	public Cell(final char sym, final int aNum) {
		symbol = sym;
		animalNum = aNum;
	}

	// Getter
	public char getSymbol() {
		return symbol;
	}

}
