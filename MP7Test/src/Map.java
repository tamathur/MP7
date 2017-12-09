

public class Map {

	Cell[][] spreadsheetCells;
	
	public String getGridText()
	{
		String abc = "ABCDEFGHIJKL";
		String columnHeaders = "   |";
		for(int i = 0; i < abc.length(); i++)
		{
			columnHeaders = columnHeaders + abc.substring(i, i+1) + "         |";
		}
		
		String grid = columnHeaders + "\n";
		String row = "";
		for(int i = 0; i < getRows(); i++)
		{
			row = String.format("%-3d|", i+1);
			for(int j = 0; j < getCols(); j++)
			{
				String loc = abc.substring(j, j+1) + Integer.toString(i+1);
				MapLocation a= new MapLocation(loc);
//				Cell theCell = getCell(a);
				row = row + "*" + "|";
			}
			grid = grid + row + "\n";
			row = "";
		}
		return grid;
	}
	
	public int getRows()
	{
		return 100;
	}

	public int getCols()
	{
		return 100;
	}
	
	public Cell getCell(MapLocation loc)
	{
		int row = loc.getRow();
		int col = loc.getCol();
		return spreadsheetCells[row][col];
	}
	
	public String processCommand(String command)
	{
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
