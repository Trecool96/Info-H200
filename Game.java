package Model;
import View.Window;

import java.util.ArrayList;


public class Game{
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private ArrayList<Monstre> monstres = new ArrayList<Monstre>();
	private Window window;
	private int size = 20;
	
	public Game(Window window){
		this.window = window;
		// Map building 
		for(int i = 0; i < size; i++){
			blocks.add(new Block(i,0));
			blocks.add(new Block(0,i));
			blocks.add(new Block(i, size-1));
			blocks.add(new Block(size-1, i));
		}
		
		blocks.add(new Block(5,6));
		
		// Creating one Player at position (1,1)
		players.add(new Player(2,2,10,20));
		System.out.println(players.toString());
		
		// Creating Monstre
		monstres.add(new Monstre(1,4,5));
		
		
		window.draw(this.getMap());
	}
	
	public void movePlayerLeft(){
		if (getMap()[players.get(0).getPosX()-1][players.get(0).getPosY()]==0){
		players.get(0).move(-1, 0);}
		window.draw(this.getMap());
	}
	public void movePlayerRight(){
		if (getMap()[players.get(0).getPosX()+1][players.get(0).getPosY()]==0){
		players.get(0).move(1,0);}
		moveMonstre(0);
		window.draw(this.getMap());	
	}
	public void movePlayerDown(){
		if (getMap()[players.get(0).getPosX()][players.get(0).getPosY()+1]==0){
		players.get(0).move(0, 1);}
		window.draw(this.getMap());
	}
	public void movePlayerUp(){
		if (getMap()[players.get(0).getPosX()][players.get(0).getPosY()-1]==0){
		players.get(0).move(0, -1);}
		window.draw(this.getMap());
	}
	
	public void moveMonstre(int i){
		if (getMap()[monstres.get(0).getPosX()+1][monstres.get(0).getPosY()]==0){monstres.get(i).move(1, 0);}
		else{monstres.get(i).move(0, 0);}
	}
	
	public int[][] getMap(){
		int[][] map = new int[this.size][this.size];
		for(int i = 0; i<this.size; i++)
			for(int j = 0; j<this.size; j++)
				map[i][j] = 0;
		
		for(Player player : players){
			int x = player.getPosX();
			int y = player.getPosY();
			map[x][y] = 2;
		}
		for(Block block : blocks){
			int x = block.getPosX();
			int y = block.getPosY();
			map[x][y] = 1;
		}
		for(Monstre monstre : monstres){
			int x = monstre.getPosX();
			int y = monstre.getPosY();
			map[x][y] = 3;
		}
		System.out.println(map);
		return map;
	}

}
