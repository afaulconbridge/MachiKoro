package machikoro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {

	protected List<Player> players = new ArrayList<>();
	
	protected Map<Card, Integer> cards = new HashMap<>();
	
	protected Random rng = new Random();

	/**
	 * Private constructor for use from static method
	 */
	private Game() {
		
	}
	
	public List<Player> getPlayers() {
		return Collections.unmodifiableList(players);
	}
	
	public List<Player> getPlayersReverse() {
		List<Player> reversed = new ArrayList<>();
		reversed.addAll(reversed);
		Collections.reverse(reversed);
		return Collections.unmodifiableList(reversed);
	}
	
	public Map<Card, Integer> getCards() {
		return cards;
	}
	
	public static Game newGame(int playerCount){
		Game game = new Game();
		game.players = new ArrayList<>(playerCount);
		for (int i = 0; i < game.players.size(); i++) {
			//TODO for the moment just use the random AI
			game.players.add(new AIRandom());
		}
		return game;
	}
	
	public Player getCurrentPlayer() {
		return players.get(0);
	}
	
	public void moveToNextPlayer() {
		Player current = players.get(0);
		for (int i = 0 ; i < players.size()-1 ;i++) {
			players.set(i, players.get(i+1));
		}
		players.set(players.size() -1, current);
	}
	
	public void doTurn() {
		//get how many dice to roll
		int diceCount = getCurrentPlayer().deicdeDiceCount();
		//roll the dice
		List<Integer> diceRolls = new ArrayList<>();
		int diceTotal = 0;
		for (int i = 0; i < diceCount; i++) {
			int roll = rng.nextInt(5)+1; 
			diceRolls.add(roll);
			diceTotal += roll;
		}
		//do payouts
		//  red first
		//  then blue/green
		//  then purple
		
		for (int priority = 1; priority <= 3 ; priority++) {
			//use reverse player order to ensure takes work correctly
			for (Player player : getPlayersReverse()) {
				//go through each of the cards that player has
				for (Card card : player.getCards().keySet()) {
					//see if they are the right priority and the right score
					if (card.getPriority() == priority
							 && card.getRolls().contains(diceTotal)) {
						if (player == getCurrentPlayer()) {
							card.playerTurn(this);
						} else {
							card.anyTurn(this);
						}
					}
				}
			}
		}
		
		//buy a card
		getCurrentPlayer().buyCard(this);
	}
}
