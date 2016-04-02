package defaultpackage;

import Controller.Keyboard;
import Model.Game;
import View.Window;
//import View.LifeWindow; jamais utilisé 

public class Main {
	public static void main(String[] args) {
		int x_max = 15; //à quoi correspondent x_max et y_max? 
		int y_max = 15;
		
		Window window = new Window(x_max*50, y_max*50+22); // *50+22? 
		
		Game game = new Game(window,x_max,y_max);
		Keyboard keyboard = new Keyboard(game);
		window.setKeyListener(keyboard);
	}
}
