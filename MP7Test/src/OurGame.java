import java.util.Scanner;



public class OurGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	    Map a = new Map();
	    System.out.print(a.getGridText());
	    Scanner s = new Scanner(System.in);
	    
	    String input = "";
	    do{
	    	input = s.nextLine();
	    	if(!input.equals("quit"))
	    		System.out.println(a.processCommand(input));
	    }while(!input.equals("quit"));
	    
	    
	    s.close();
	}

}
