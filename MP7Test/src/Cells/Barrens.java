package Cells;
/**
 * A cell where a player can encounter a loss in health, gain in water, gain in food, etc.
 * @author tmath
 *
 */
public class Barrens extends Cell {
	public Barrens() {
		super('.', (int)(-16*Math.random()), 0, 0, "Barrens");
	}
}
