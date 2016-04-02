package View;

import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

import javax.swing.JPanel;


public class Map extends JPanel {
	private int[][] mapMatrix;
	
	public Map(){
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void paint(Graphics g) {
		
		if(mapMatrix == null){ //if et puis??
		}else{
			for(int i = 0; i<mapMatrix.length; i++){
				for(int j = 0; j<mapMatrix[0].length; j++){
					int x = i;
					int y = j;
					int color = mapMatrix[i][j];
					
					herbe(x, y, g, color);
					if(color == 0){
						g.setColor(Color.GRAY);
					}
					if(color == 1){
						g.setColor(Color.DARK_GRAY);
					}else if(color == 3){
						g.setColor(Color.RED);
					}else if(color == 4){
						g.setColor(Color.BLACK);
					}
					if(java.lang.Math.abs(color)>4){
						perso1(x, y, g, color);}
					else if (color !=0 & color<4){
						g.fillRect(x*50, y*50, 48, 48); 

					g.setColor(Color.BLACK);
					g.drawRect(x*50, y*50, 48, 48); 
					System.out.print(color);
					System.out.print(" ");}
	
				}
				System.out.println("");
			}
		}
	}
	
	public void setMapMatrix(int[][] mapMatrix){
		this.mapMatrix = mapMatrix;
		this.repaint();
	}
	
	public void perso1(int x,int y,Graphics g, int color){
		Image perso1 = null;
		try {                
			if(color==5){perso1 = ImageIO.read(new File("/Users/oliviaverhulst/Documents/Xenor_back.png"));}
			else if(color==9){perso1 = ImageIO.read(new File("/Users/oliviaverhulst/Documents/Xenor_front.png"));}
			else if(color==8){perso1 = ImageIO.read(new File("/Users/oliviaverhulst/Documents/Xenor_rigth.png"));}
			else if(color==6){perso1 = ImageIO.read(new File("/Users/oliviaverhulst/Documents/Xenor_left.png"));}
			g.drawImage(perso1,x*50, y*50, 48, 48, null);
			g.drawRect(x*50, y*50, 48, 48);
			} catch (IOException ex) {
				g.setColor(Color.BLUE);
		       }
		}
	
	public void herbe(int x, int y, Graphics g, int color){
		Image herbe = null;
		try{
			if (color == 0){
				herbe = ImageIO.read(new File("/Users/oliviaverhulst/Documents/grass.png"));
				g.drawImage(herbe,x*50, y*50, 48, 48, Color.GRAY, null);
				g.drawRect(x*50, y*50, 48, 48);}
		} catch (IOException ex) {
			g.setColor(Color.GRAY);
	       }
	}

}
