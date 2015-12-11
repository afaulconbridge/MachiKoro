package machikoro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		new Main().run();
	}
	
	private void run() {
		log.info("Hello world");
		
		//start a new two player game
		Game game = Game.newGame(2);
		
		game.doTurn();
		
		
	}
}
