

public class Map {

	Cell[][] mapCells;
	
	public String getGridText()
	{		
		
		String grid = "";
		String row = "";
		for(int i = 0; i < getRows(); i++)
		{
			for(int j = 0; j < getCols(); j++)
			{
				int[] loc = {i, j};
				MapLocation a = new MapLocation(loc);
//				Cell theCell = getCell(a);
				row = row + ".";
			}
			grid = grid + row + "\n";
			row = "";
		}
		return grid;
	}
	
	public int getRows() {
		return 61;
	}

	public int getCols() {
		return 61;
	}
	
	public Cell getCell(MapLocation loc) {
		int row = loc.getRow();
		int col = loc.getCol();
		return mapCells[row][col];
	}
	
	public String processCommand(String command) {
		String result = ""; //"result" is the string that will be returned at the end of this method
//		command = command.trim(); //removes spaces from the ends of the string "command"
//		if(command.length() == 0)
//		{
//			//if user enters an empty command, return an empty string
//			result = command;
//		}
//		else if(command.length() <= 3)
//		{
//			//if user enters the location name of a cell (ie A1 or F17), send to the method cellInspection
//			//cellInspection will return the string that is stored in that cell location
//			result = cellInspection(command);
//			
//		}
//		else if(command.indexOf("=") >= 0)
//		{
//			//if user wants to assign a value to a cell (A1 = "blahblahblah"), send to cellAssignment
//			//cellAssignment will assign the given value to the given cell location and return getGridText()
//			result = cellAssignment(command);
//		}
//		else if(command.toLowerCase().equals("clear"))
//		{
//			
//			result = clearAll(command);
//		}
//		else if(command.toLowerCase().indexOf("clear") >= 0)
//		{
//			result = clearCell(command);
//		}
//		else if(command.toLowerCase().indexOf("sorta") >= 0)
//		{
//			String[] splitCommand = command.split(" ");
//			sortCellsA(splitCommand[1]);
//			result = getGridText();
//		}
//		else if(command.toLowerCase().indexOf("sortd") >= 0)
//		{
//			String[] splitCommand = command.split(" ");
//			sortCellsD(splitCommand[1]);
//			result = getGridText();
//		}
		return result;
	}

	
}
