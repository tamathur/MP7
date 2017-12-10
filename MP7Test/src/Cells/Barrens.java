package Cells;
/**
 * A cell where a player can encounter animals to fight
 * @author tmath
 *
 */
public class Barrens extends Cell {
	public Barrens() {
		super('.', (int)(2*Math.random()));
	}
}
