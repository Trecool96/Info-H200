package Model;

public class Perso {
	private int posX;
	private int posY;
	private int health;
	
	public Perso(int X, int Y, int health){
		this.posX = X;
		this.posY = Y;
		setHealth(health);
	}
	
	public int getPosX(){
		return this.posX;
	}
	
	public int getPosY(){
		return this.posY;
	}
	
	public void setHealth(int health){
		this.health=health;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public void move(int X, int Y){
		this.posX = this.posX + X;
		this.posY = this.posY + Y;
	}


}
