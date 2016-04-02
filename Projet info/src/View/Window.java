package View;

import java.awt.Color;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class Window {
	private Map map = new Map();
	
	public Window(int x_max, int y_max){	    
	    JFrame window = new JFrame("Bloody Boucherie");
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //frame=cadre
	    window.setBounds(200, 0, x_max,y_max); 
	    window.getContentPane().setBackground(Color.yellow);//yellow??
	    window.getContentPane().add(this.map);
	    window.setVisible(true);		    
	}	
	
	public void draw(int[][] mapMatrix){
		map.setMapMatrix(mapMatrix);
	}
	
	public void setKeyListener(KeyListener keyboard){
	    this.map.addKeyListener(keyboard);
	}
	
}
