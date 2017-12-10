import Cells.Barrens;
import Cells.Cell;
import Cells.EmptyCell;
import Cells.Player;

/**
 * 
 * @author Kimi
 *
 */
public class Map {

	private Cell[][] mapCells;
	
	private Cell[][] mapCellsSecondLayer;
	
	private Player ourPlayer = new Player();
	int[] playerCoordinates = {15, 15};
	
	public static final int MAP_DIMENSIONS = 31;
	
	public Map() {
		mapCells = new Cell[MAP_DIMENSIONS][MAP_DIMENSIONS];
		mapCellsSecondLayer = new Cell[MAP_DIMENSIONS][MAP_DIMENSIONS];
		
		for(int i = 0; i < mapCells.length; i++)
		{
			for(int j = 0; j < mapCells[i].length; j++)
			{
				mapCells[i][j] = new Barrens();
				mapCellsSecondLayer[i][j] = new EmptyCell();				
				//individually assigns each Cell in the spreadsheetCells 2D array to an EmptyCell
				//(must do this individually or else cell value will be null)
			
			}
		}
		
		
		MapLocation playerLocation = new MapLocation(playerCoordinates);
		mapCellsSecondLayer[15][15] = ourPlayer;
	}
	
	
	
	public String getGridText()
	{
		
		String grid = "";
		String row = "";
		for(int i = 0; i < getRows(); i++)
		{
			for(int j = 0; j < getCols(); j++)
			{
				if (i == playerCoordinates[0] && j == playerCoordinates[1]) {
					row += ourPlayer.getSymbol() + "  ";
				} else {
					int[] loc = {i, j};
					MapLocation a = new MapLocation(loc);
					Cell theCell = getCell(a);
					row = row + theCell.getSymbol() + "  ";
				}
				
			}
			grid = grid + row + "\n";
			row = "";
		}
		return grid;
	}
	
	public int getRows() {
		return MAP_DIMENSIONS;
	}

	public int getCols() {
		return MAP_DIMENSIONS;
	}
	
	public Cell getCell(MapLocation loc) {
		int row = loc.getRow();
		int col = loc.getCol();
		return mapCells[row][col];
	}
	
	public void printBlankLines() {
		for (int i = 0; i < MAP_DIMENSIONS; i++) {
			System.out.println("");
		}
	}
	
	public String processCommand(String command) {
		String result = ""; 
		
		if (command.equals("L")) {
			playerCoordinates[1] --;
			printBlankLines();
			System.out.println(getGridText());
			
		} else if (command.equals("R")) {
			playerCoordinates[1] ++;
			printBlankLines();
			System.out.println(getGridText());
			
		} else if (command.equals("U")) {
			playerCoordinates[0] --;
			printBlankLines();
			System.out.println(getGridText());
			
		} else if (command.equals("D")) {
			playerCoordinates[0] ++;
			printBlankLines();
			System.out.println(getGridText());
		}
		
		//"result" is the string that will be returned at the end of this method
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
