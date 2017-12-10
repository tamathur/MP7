/**
 * The cells on the map that the player can traverse
 * @author tmath
 *
 */
public class Cell {
	/**Every cell has a unique symbol*/
	private char symbol;
	
	// Constructor
	public Cell(final char sym) {
		symbol = sym;
	}

	// Getter
	public char getSymbol() {
		return symbol;
	}

}
