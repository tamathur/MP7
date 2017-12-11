package Cells;
/**
 * A cell where a player can encounter a loss in health, gain in water, gain in food, etc.
 * @author tmath
 *
 */
public class Barrens extends Cell {
	public Barrens() {
		super('.', (int)(-26*Math.random()), 0, (int)(3*Math.random()), "Barrens");
	}
}
