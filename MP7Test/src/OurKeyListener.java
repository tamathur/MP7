import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class OurKeyListener {
	
	JTextArea inputText;
    JTextArea feedbackText;
    private static Map ourMap;
    
    private static boolean gameEnded = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ourMap = new Map();
	    System.out.print(ourMap.getGridText());
	    
		
		 EventQueue.invokeLater(new Runnable() {             
            @Override
             public void run() {
                 new OurKeyListener(); 
             }            
         });
	}
	
	 public OurKeyListener() {
		 JFrame guiFrame = new JFrame();
	        
	     inputText = new JTextArea();
	        
	     inputText.addKeyListener(new KeyListener() {
	    	 
	    	 private boolean leftPressed = false;
	    	 private boolean rightPressed = false;
	    	 private boolean upPressed = false;
	    	 private boolean downPressed = false;
	    	 
	    	 @Override 
	         public void keyPressed(KeyEvent e) {
	    		 if (e.getExtendedKeyCode() == 37) {
	    			 leftPressed = true;
	    		 }
	    		 if (e.getExtendedKeyCode() == 38) {
	    			 upPressed = true;
	    		 }
	    		 if (e.getExtendedKeyCode() == 39) {
	    			 rightPressed = true;
	    		 }
	    		 if (e.getExtendedKeyCode() == 40) {
	    			 downPressed = true;
	    		 }
	    		 if (e.getExtendedKeyCode() == 27) {
	    			 System.out.println("game ended");
	    			 gameEnded = true;
	    		 }
	         }
	         
	    	 @Override
	         public void keyReleased(KeyEvent e) {
	    		 if (e.getExtendedKeyCode() == 37 && leftPressed == true) {
	    			 System.out.println("left!");
	    		 }
	    		 if (e.getExtendedKeyCode() == 38 && upPressed == true) {
	    			 System.out.println("up!");
	    		 }
	    		 if (e.getExtendedKeyCode() == 39 && rightPressed == true) {
	    			 System.out.println("Right!");
	    		 }
	    		 if (e.getExtendedKeyCode() == 40 && downPressed == true) {
	    			 System.out.println("down!");
	    		 }
	         }
	              
	         @Override
	         public void keyTyped(KeyEvent e) {
	         }
	     });
	     
	     guiFrame.add(inputText, BorderLayout.NORTH);
	     guiFrame.setVisible(true);
	 }

}
