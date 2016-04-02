package View;

import java.awt.Color;

import javax.swing.JFrame;

public class LifeWindow {
	private Life life = new Life();
	private JFrame lifeWindow = null;
	
	public LifeWindow(int x_max, int y_max,Color color, String str){
		this.lifeWindow = new JFrame(str);
	    this.lifeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.lifeWindow.setBounds(x_max, y_max, 200, 50);
	    this.lifeWindow.getContentPane().setBackground(color);
	    this.lifeWindow.getContentPane().add(this.life);
	    this.lifeWindow.setAlwaysOnTop(true);
	    this.lifeWindow.setVisible(true);
	}

	public void draw(int health, int max_life, Color color){
		life.setLife(health, max_life, color);
	}
	
	public void dispose(){
		this.lifeWindow.dispose();
	}
}
