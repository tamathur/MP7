import Cells.Barrens;
import Cells.Cell;
import Cells.DampCave;
import Cells.DesertedTown;
import Cells.EmptyCell;
import Cells.Mine;
import Cells.Outpost;
import Cells.Player;
import Cells.Village;

/**
 * 
 * @author Kimi
 *
 */
public class Map {

	private static Cell[][] mapCells;
	
	private Cell[][] mapCellsSecondLayer;
	
	private Player ourPlayer;
	
	public static final int MAP_DIMENSIONS = 31;
	
	public Map() {
		mapCells = new Cell[MAP_DIMENSIONS][MAP_DIMENSIONS];
		mapCellsSecondLayer = new Cell[MAP_DIMENSIONS][MAP_DIMENSIONS];
		ourPlayer  = new Player();
		ourPlayer.setCoordinates(15, 15);
		
		for(int x = 0; x < mapCells[0].length; x++) {
			for(int y = 0; y < mapCells.length; y++)
			{
				mapCells[x][y] = new Barrens();
				mapCellsSecondLayer[x][y] = new EmptyCell();				
				//individually assigns each Cell in the spreadsheetCells 2D array to an EmptyCell
				//(must do this individually or else cell value will be null)
			
			}
		}
		mapCellsSecondLayer[15][15] = ourPlayer;
		mapCells[15][15] = new Village(); //places village (home base) in the center of the set map
		
		DampCave[] dampCaves = {new DampCave(), 
								new DampCave(), 
								new DampCave()};
		createCells(dampCaves);
		
		DesertedTown[] desertedTowns = {new DesertedTown(),
										new DesertedTown(), 
										new DesertedTown(),
										new DesertedTown(),
										new DesertedTown()};
		createCells(desertedTowns);
		
		Outpost[] outposts = {new Outpost(), 
								new Outpost()};
		createCells(outposts);
		
		Mine[] mines = {new Mine(), 
						new Mine()};
		createCells(mines);
	}
	
	
	private static void createCells(Cell[] cells) {
		for (int count = 0; count < cells.length; count++) {
			int randX = (int) (31 * Math.random());
			int randY = (int) (31 * Math.random());
			if (mapCells[randY][randX].getCellType().equals("Barrens")) {
				cells[count].setCoordinates(randX, randY);
				mapCells[randY][randX] = cells[count];
			} else {
				count--;
			}
		}
	}
	
	
	
	public String getGridText()
	{
		
		String grid = "";
		String row = "";
		for(int y = 0; y < getRows(); y++)
		{
			for(int x = 0; x < getCols(); x++)
			{
				if (x == ourPlayer.getCoordinates()[0] && y == ourPlayer.getCoordinates()[1]) {
					row += ourPlayer.getSymbol() + "  ";
				} else {
					
					Cell theCell = mapCells[y][x];
					row = row + theCell.getSymbol() + "  ";
				}
				
			}
			grid = grid + row + "\n";
			row = "";
		}
		return grid.trim();
	}
	
	public int getRows() {
		return MAP_DIMENSIONS;
	}

	public int getCols() {
		return MAP_DIMENSIONS;
	}
	
	public void printBlankLines() {
		for (int i = 0; i < MAP_DIMENSIONS; i++) {
			System.out.println("");
		}
	}
	
	public void processCommand(String command) {
		
		if (command.equals("L")) {
			ourPlayer.getCoordinates()[0] --;
			
		} else if (command.equals("R")) {
			ourPlayer.getCoordinates()[0] ++;
			
		} else if (command.equals("U")) {
			ourPlayer.getCoordinates()[1] --;
			
		} else if (command.equals("D")) {
			ourPlayer.getCoordinates()[1] ++;
		}
		
		int currentWater = ourPlayer.getWater() - 1;
		
		int[] currentCoordinates = ourPlayer.getCoordinates();
		Cell currentCell = mapCells[currentCoordinates[1]][currentCoordinates[0]];
		
		int currentHealth = ourPlayer.getHealth() + currentCell.getHealth();
		int currentFood = ourPlayer.getFood() + currentCell.getFood();
		currentWater += currentCell.getWater();
		
		ourPlayer.setHealth(currentHealth);
		ourPlayer.setWater(currentWater);
		ourPlayer.setFood(currentFood);
		
		printBlankLines();
		System.out.println(getGridText());
		System.out.println("current health: " + currentHealth);
		System.out.println("current water: " + currentWater);
		System.out.println("current food: " + currentFood);
	}

	
}
