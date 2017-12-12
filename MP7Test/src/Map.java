import Cells.Barrens;
import Cells.Cell;
import Cells.DampCave;
import Cells.DesertedTown;
import Cells.EmptyCell;
import Cells.Field;
import Cells.Forest;
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
		ourPlayer = new Player();
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
		
		//populates upper left quadrant with forest cells
		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {
				mapCells[x][y] = new Forest();
			}
		}
		
		//populates bottom right quadrant with field cells
		for(int x = 16; x < mapCells[0].length; x++) {
			for (int y = 16; y < mapCells.length; y++) {
				mapCells[x][y] = new Field();
			}
		}
		mapCellsSecondLayer[15][15] = ourPlayer;
		mapCells[15][15] = new Village(); //places village (home base) in the center of the set map
		
		
		DampCave[] dampCaves = new DampCave[5];
		for (int i = 0; i < dampCaves.length; i++) {
			dampCaves[i] = new DampCave();
		}
		createCells(dampCaves);
		
		
		DesertedTown[] desertedTowns = new DesertedTown[10];
		for (int i = 0; i < desertedTowns.length; i++) {
			desertedTowns[i] = new DesertedTown();
		}
		createCells(desertedTowns);
		
		
		Outpost[] outposts = {new Outpost(), 
								new Outpost()};
		createCells(outposts);
		
		
		Mine[] mines = new Mine[6];
		for (int i = 0; i < mines.length; i++) {
			mines[i] = new Mine();
		}
		createCells(mines);
		
		
	}
	
	
	private static void createCells(Cell[] cells) {
		for (int count = 0; count < cells.length; count++) {
			int randX = (int) (31 * Math.random());
			int randY = (int) (31 * Math.random());
			if (mapCells[randY][randX].getCellType().equals("Barrens")
					||mapCells[randY][randX].getCellType().equals("Field")
					||mapCells[randY][randX].getCellType().equals("Forest")) {
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
		grid += "current health: " + ourPlayer.getHealth() + "\n"
				+ "current water: " + ourPlayer.getWater() + "\n"
				+ "current food: " + ourPlayer.getFood();
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
		int currentFood = ourPlayer.getFood();
		if (ourPlayer.getStepCount() % 2 == 0) {
			currentFood = ourPlayer.getFood() - 1;
		}
		
		int[] currentCoordinates = ourPlayer.getCoordinates();
		Cell currentCell = mapCells[currentCoordinates[1]][currentCoordinates[0]];
		
		int currentStepCount = ourPlayer.getStepCount() + currentCell.getStepCount();
		int currentHealth = ourPlayer.getHealth() + currentCell.getHealth();
		currentFood += currentCell.getFood();
		currentWater += currentCell.getWater();
		
		int previousHealth = ourPlayer.getHealth();
		int previousFood = ourPlayer.getFood();
		int previousWater = ourPlayer.getWater();
		
		ourPlayer.setStepCount(currentStepCount);
		if (currentHealth > 100) {
			currentHealth = 100;
		}
		if (currentFood > 100) {
			currentFood = 100;
		}
		if (currentWater > 100) {
			currentWater = 100;
		}
		ourPlayer.setHealth(currentHealth);
		ourPlayer.setWater(currentWater);
		ourPlayer.setFood(currentFood);
		
		printBlankLines();
		System.out.println(getGridText());
		
		System.out.println();
		otherMessage(currentHealth, currentFood, currentWater, currentCell);
		healthMessage(previousHealth - currentHealth, currentCell);
		foodMessage(previousFood - currentFood, currentCell);
		waterMessage(previousWater - currentWater, currentCell);

	}

	public void healthMessage(int difference, Cell current) {
		if (current.getSymbol() == '.') { //Barrens			
			if (Math.abs(difference) > 0) {
				System.out.println("an animal leaves a deep wound in your arm.");
			}
		}		
		if (current.getSymbol() == 'V') { //DampCave			
			if (Math.abs(difference) > 10) {
				System.out.println("a giant lizard shambles forward.");
			} else if (Math.abs(difference) > 0) {
				System.out.println("a cave lizard attacks.");
			}
		}		
		if (current.getSymbol() == 'O') { //DesertedTown
			if (Math.abs(difference) > 30) {
				System.out.println("a beast charges out of a ransacked classroom.");
			} else if (Math.abs(difference) > 20) {
				System.out.println("a panicked scavenger bursts through the door, screaming.");
			} else if (Math.abs(difference) > 10) {
				System.out.println("a frail man stands defiantly, blocking the path.");
			} else if (Math.abs(difference) > 0) {
				System.out.println( "a youth lashes out with a tree branch.");
			}
		}		
		if (current.getSymbol() == ',') { //Field
			if (Math.abs(difference) > 10) {
				System.out.println("a snarling beast jumps out of the underbrush.");
			} else if (Math.abs(difference) > 0) {
				System.out.println("the grass thrashes wildly as a huge lizard pushes through.");
			}
		}
		if (current.getSymbol() == ';') { //Forest
			if (Math.abs(difference) > 20) {
				System.out.println("the shadow of a beast grows larger.");
			} else if (Math.abs(difference) > 0) {
				System.out.println("a lizard charges from a branch.");
			}
		}
		
	}
	
	public void foodMessage(int difference, Cell current) {
		if (current.getSymbol() == 'V') { //DampCave			
			if (Math.abs(difference) > 0) {
				System.out.println("some other creature's meal sits in the corner.");
			}
		}
		if (current.getSymbol() == 'O') { //DesertedTown
			if (Math.abs(difference) > 0) {
				System.out.println("a stranger's house provides a meal for later.");
			}
		}
		if (current.getSymbol() == ';') { //Forest
			if (Math.abs(difference) > 0) {
				System.out.println("inside a tree trunk lies some abonded food.");
			}
		}
		if (current.getSymbol() == 'M') { //Mine
			if (Math.abs(difference) > 0) {
				System.out.println("long gone inhabitants kindly left food for the journey.");
			}
		}

	}
	
	public void waterMessage(int difference, Cell current) {
		if (current.getSymbol() == 'V') { //DampCave			
			if (Math.abs(difference) > 0) {
				System.out.println("water glistens as it falls from the cave walls.");
			}
		}
		if (current.getSymbol() == 'O') { //DesertedTown
			if (Math.abs(difference) > 0) {
				System.out.println("a stream of clear water distracts you.");
			}
		}
	}
	
	public void otherMessage(int health, int food, int water, Cell current) {
		if (health <= 0 || food <= 0 || water <= 0) { // if you die the game ends
			System.out.println("the world fades.");
			System.exit(0);
		}
		if (current.getSymbol() == '.') { // Random Barren message
			System.out.println("the trees are gone. parched earth and blowing dust are poor replacements.");
		}
		if (current.getSymbol() == 'V') { // Random DampCave message
			System.out.println("the earth here is split, as if bearing an ancient wound.");
		}
		if (current.getSymbol() == 'O') { // Random DesertedTown message
			System.out.println("the town lies abonded, its citizens long dead.");
		}
		if (current.getSymbol() == ',') { // Random Field message			
			System.out.println("the trees yeild to dry grass. the yellowed brush rustles in the wind.");		
		}
		if (current.getSymbol() == ';') { // Random Forest message
			System.out.println("a wall of gnarled trees rises from the dust. their branches twist into a skeletal canopy overhead.");
		}
		if (current.getSymbol() == 'M') { // Random Mine message
			System.out.println("a safe place in the wilds.");
		}
		if (current.getSymbol() == 'P') { // Outpost message
			System.out.println("water and food are replenished.");
			System.out.println("finally a good meal.");
		}
		if (current.getSymbol() == 'A') { // Village message
			System.out.println("a necessary good rest.");
		}
	}
	
}
