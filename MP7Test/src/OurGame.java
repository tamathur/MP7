import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;


/**
 * 
 * @author Kimi
 *
 */
public class OurGame implements KeyListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	    Map ourMap = new Map();
	    System.out.print(ourMap.getGridText());
	    Scanner s = new Scanner(System.in);
	    
	    String input = "";
	    do{
	    	input = s.nextLine();
	    	if(!input.equals("quit"))
	    		System.out.println(ourMap.processCommand(input));
	    }while(!input.equals("quit"));
	    
	    
	    s.close();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
