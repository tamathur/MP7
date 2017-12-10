package Cells;
/**
 * A cell where a player can enounter animals to fight
 * @author tmath
 *
 */
public class Field extends Cell {
	public Field() {
		super(',',(int)(2*Math.random()));
	}
}
