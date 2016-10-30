package kochmaro.core;

import java.util.List;

public interface PlayerController {

	/**
	 * This is called after a player has purchased a Train Station because then they can roll one or two dice
	 * @return number of dice to roll (1 or 2)
	 */
	public int getDiceCount();
	
	public Card getCardPurchase(Player p, List<Player> players, List<Card> optionsToBuy);
	
	
}
