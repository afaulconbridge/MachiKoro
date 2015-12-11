package machikoro;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import machikoro.cards.Ranch;
import machikoro.cards.WheatField;

public abstract class Player {

	public abstract Card buyCard(Game game);
	public abstract int deicdeDiceCount();
	
	protected Map<Card, Integer> cards = new HashMap<>();
	
	protected int coins = 0;

	public Player () {
		cards.put(new WheatField(), 1);
		cards.put(new Ranch(), 1);
		
	}
	
	public Map<Card, Integer> getCards() {
		return Collections.unmodifiableMap(cards);
	}
	
	public int getCoins() {
		return coins;
	}
	
	public void addCoins(int extra) {
		coins += extra;
	}
	
	/** 
	 * Try to take some coins from this player. The returned value is the number
	 * of actual coins taken, which may be less than the target or zero.
	 * @param target
	 * @return
	 */
	public int takeCoins(int target) {
		target = Math.min(target, coins);
		coins -= target;
		return target;
	}
	
	public void addCard(Card card) {
		if (!cards.containsKey(card)) {
			cards.put(card, 1);
		} else {
			cards.put(card, cards.get(card)+1);
		}
	}
}
