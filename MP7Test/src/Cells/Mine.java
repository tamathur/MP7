package Cells;
/**
 * A cell where
 * @author tmath
 *
 */
public class Mine extends Cell {
	public Mine() {
		super('M', (int)(-11*Math.random()), (int)(3*Math.random()), (int)(2*Math.random()), "Mine");
	}

}
