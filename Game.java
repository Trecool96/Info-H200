package Model;

import View.LifeWindow;
import View.Window;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Game{
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private ArrayList<Monstre> monstres = new ArrayList<Monstre>();
	private ArrayList<LifeWindow> lifeW = new ArrayList<LifeWindow>();
	private LifeWindow lifeHero;
	private Window window;
	private static int numberMonster = 10;
	private int x_max;
	private int y_max;
	
	public Game(Window window, int x_max, int y_max){
		this.window = window;
		this.x_max=x_max;
		this.y_max=y_max;
		// Map building 
		for(int i = 0; i < this.x_max; i++){
			Random rand = new Random();
			int j= rand.nextInt(this.x_max); //nouvelle pos en x
			Random rando = new Random();
			int h= rando.nextInt(this.y_max);//nouvelle pos en y
			blocks.add(new Block(j,h));
		}
		
		blocks.add(new Block(5,6));
		
		// Creating one Player at position (1,1)
		players.add(new Player(this.x_max/2,this.y_max/2,10,10,1));
		System.out.println(players.toString());
		
		// Creating Monstre
		for (int i=0; i<numberMonster;i++){
			Random rand = new Random();
			int j= rand.nextInt(this.x_max); //nouvelle pos en x
			Random rando = new Random();
			int h= rando.nextInt(this.y_max);//nouvelle pos en y
			if (getMap()[j][h]==0){monstres.add(new Monstre(j,h,10,10,5));}
		}
		
		window.draw(this.getMap());
		
		// Creating Barre de vie for monsters
		for (int i=0; i<numberMonster-1;i++){
			lifeW.add(new LifeWindow(0,y_max+62*i,Color.RED, "Vie Monstre"));
			lifeW.get(i).draw(monstres.get(i).getHealth(), monstres.get(i).getHealth(),Color.RED);}
		
		// Creating Barre de vie for le hŽros
		this.lifeHero = new LifeWindow(200+50*x_max,0,Color.GREEN, "Vie du HŽros");
		this.lifeHero.draw(players.get(0).getHealth(), players.get(0).getHealth(), Color.green);
		
	}
	
	public void movePlayerLeft(){
		if (getMap()[players.get(0).getPosX()-1][players.get(0).getPosY()]==0){
		players.get(0).move(-1, 0);}
		players.get(0).setOrien(-1);
		window.draw(this.getMap());
		if (players.get(0).getOrien() == -1){players.get(0).receive(1);}
		this.lifeHero.draw(players.get(0).getHealth(), players.get(0).getMax_life(), Color.green);
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
		int[][] map = new int[this.x_max][this.y_max];
		for(int i = 0; i<this.x_max; i++)
			for(int j = 0; j<this.y_max; j++)
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
		
		map[0][0] = 4; //cimetire
		
		System.out.println(map);
		return map;
	}
	
	public void Attack(){
		int orien=players.get(0).getOrien();
		
		if (orien==1 || orien==-1){
			for(int i=0; i<monstres.size();i++){
				if (monstres.get(i).getPosX()==players.get(0).getPosX()+orien && monstres.get(i).getPosY()==players.get(0).getPosY()){
					monstres.get(i).receive(1);
					lifeW.get(i).draw(monstres.get(i).getHealth(), monstres.get(i).getMax_life(),Color.RED);
					if (monstres.get(i).getHealth() == 0){lifeW.get(i).dispose();}
					}
				window.draw(this.getMap());}
			}
		
		else{
			orien=orien/2;
			for(int i=0; i<monstres.size();i++){
				if (monstres.get(i).getPosX()==players.get(0).getPosX() && monstres.get(i).getPosY()==players.get(0).getPosY()+orien){
					monstres.get(i).receive(1);
					lifeW.get(i).draw(monstres.get(i).getHealth(), monstres.get(i).getMax_life(),Color.RED);
					if (monstres.get(i).getHealth() == 0){lifeW.get(i).dispose();}
					}
				window.draw(this.getMap());}
		}
	}

}
