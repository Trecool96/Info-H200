package View;

import java.awt.Color; 
import java.awt.Graphics;

import javax.swing.JPanel;

public class Life extends JPanel{
	private int health;
	private int max_life;
	private Color color;
	
	public Life(){
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void paint(Graphics g){
		g.clearRect(0, 0, 1000, 1000);
		g.setColor(this.color);
		g.fillRect(0, 0,((this.health*200)/this.max_life), 50); 
		g.setColor(this.color);
		g.drawRect(0, 0, ((this.health*200)/this.max_life), 50); 
		System.out.println((this.health*200)/this.max_life);
	}

	public void setLife(int health, int max_life, Color color){
		this.health = health;
		this.max_life = max_life;
		this.color = color;
		this.repaint();
	}
	
	public int getHealth(){
		return this.health;
	}
}
