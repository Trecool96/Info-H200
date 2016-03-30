import Controller.Keyboard;
import Model.Game;
import View.Window;

public class Main {
	public static void main(String[] args) {
		int size = 20;
		
		Window window = new Window(size*50, size*50+22);
		
		Game game = new Game(window,size);
		Keyboard keyboard = new Keyboard(game);
		window.setKeyListener(keyboard);
	}
}

