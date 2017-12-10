package Cells;
/**
 * An empty cell where a player can encounter animals to fight
 * @author tmath
 *
 */
public class Forest extends Cell {
	
	public Forest() {
		super(';',(int)(-26*Math.random()), 0, (int)(2*Math.random()));
	}
	
	

}
