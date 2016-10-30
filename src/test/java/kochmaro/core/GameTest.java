package kochmaro.core;

import java.util.ArrayList;
import java.util.List;

import kochmaro.core.events.DebugEventListener;

import org.junit.Test;

public class GameTest {

	@Test
	public void Game() {
		//create four players who will make random choices
		List<Player> players = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			Player p = new Player(new RandomController(), "Player "+i);
			players.add(p);
		}
		
		//create a game between our players
		Game g = new Game(players);
		//attach a listener for reporting to standard out
		g.addEventListener(new DebugEventListener());
		//run the game
		g.play();
	}
}
