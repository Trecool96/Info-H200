package Model;

public class Perso {
	private int posX;
	private int posY;
	private int health;
	private int max_life;
	private int orien;
	
	public Perso(int X, int Y, int health, int max_life, int orien){
		this.posX = X;
		this.posY = Y;
		this.max_life = max_life;
		setHealth(health);
		setOrien(orien);
	}
	
	public int getPosX(){
		return this.posX;
	}
	
	public int getPosY(){
		return this.posY;
	}
	
	public void setHealth(int health){
		if (health <= this.max_life){this.health=health;}
		else{health = this.max_life;}
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public int getMax_life(){
		return this.max_life;
	}
	
	public void setOrien(int orien){
		this.orien=orien;
	}
	
	public int getOrien(){
		return this.orien;
	}
	
	public void move(int X, int Y){
		this.posX = this.posX + X;
		this.posY = this.posY + Y;
	}

	public void receive(int dŽg‰ts){
		int new_life= this.health-dŽg‰ts;
		if (new_life>0){setHealth(new_life);}
		else {
			setHealth(0);
			this.posX=0;this.posY=0;}
	}

}
