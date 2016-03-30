package Model;
import View.Window;

import java.util.ArrayList;
import java.util.Random;

public class Game{
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private ArrayList<Monstre> monstres = new ArrayList<Monstre>();
	private Window window;
	private int size;
	
	public Game(Window window, int size){
		this.window = window;
		this.size=size;
		// Map building 
		for(int i = 0; i < 2*size; i++){
			Random rand = new Random();
			int j= rand.nextInt(size); //nouvelle pos en x
			Random rando = new Random();
			int h= rando.nextInt(size);//nouvelle pos en y
			blocks.add(new Block(j,h));
		}
		
		blocks.add(new Block(5,6));
		
		// Creating one Player at position (1,1)
		players.add(new Player(size/2,size/2,10,1));
		System.out.println(players.toString());
		
		// Creating Monstre
		for (int i=0; i<6;i++){
			Random rand = new Random();
			int j= rand.nextInt(size); //nouvelle pos en x
			Random rando = new Random();
			int h= rando.nextInt(size);//nouvelle pos en y
			if (getMap()[j][h]==0){monstres.add(new Monstre(j,h,h/2,1));}
		}
		
		window.draw(this.getMap());
	}
	
	public void movePlayerLeft(){
		if (getMap()[players.get(0).getPosX()-1][players.get(0).getPosY()]==0){
		players.get(0).move(-1, 0);}
		players.get(0).setOrien(-1);
		window.draw(this.getMap());
	}
	public void movePlayerRight(){
		if (getMap()[players.get(0).getPosX()+1][players.get(0).getPosY()]==0){
		players.get(0).move(1,0);}
		players.get(0).setOrien(1);
		window.draw(this.getMap());	
	}
	public void movePlayerDown(){
		if (getMap()[players.get(0).getPosX()][players.get(0).getPosY()+1]==0){
		players.get(0).move(0, 1);}
		players.get(0).setOrien(2);
		window.draw(this.getMap());
	}
	public void movePlayerUp(){
		if (getMap()[players.get(0).getPosX()][players.get(0).getPosY()-1]==0){
		players.get(0).move(0, -1);}
		players.get(0).setOrien(-2);
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
			map[x][y] =  7+(players.get(0).getOrien());
			System.out.println(map[x][y]);
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
		
		map[0][0] = 4; //cimetière
		
		System.out.println(map);
		return map;
	}
	
	public void Attack(){
		int orien=players.get(0).getOrien();
		
		if (orien==1 || orien==-1){
			for(int i=0; i<monstres.size();i++){
				if (monstres.get(i).getPosX()==players.get(0).getPosX()+orien && monstres.get(i).getPosY()==players.get(0).getPosY()){
					monstres.get(i).receive(1);}
				window.draw(this.getMap());}
			}
		
		else{
			orien=orien/2;
			for(int i=0; i<monstres.size();i++){
				if (monstres.get(i).getPosX()==players.get(0).getPosX() && monstres.get(i).getPosY()==players.get(0).getPosY()+orien){
					monstres.get(i).receive(1);}
				window.draw(this.getMap());}
		}
	}

}
