
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

}
