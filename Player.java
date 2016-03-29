package Model;

public class Player extends Perso {
	private static int maxlife;
	
	public Player(int X, int Y, int health, int maxlife){
		super(X,Y,health);
		this.maxlife = maxlife;
	}


}
