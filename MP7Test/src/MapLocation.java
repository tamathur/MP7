/**
 * 
 * @author Kimi
 *
 */
public class MapLocation {
	private int row;
	private int col;
	
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    public MapLocation(int[] cellName)
    {
    	row = cellName[0];
    	col = cellName[1];
    }
    
    public static MapLocation createRandomMapLocation() {
    	int r = (int) (61 * Math.random());
    	int c = (int) (61 * Math.random());
    	
    	int[] cellName = {r, c};
    	MapLocation randomLoc = new MapLocation(cellName);
    	
    	return randomLoc;
    }

}
