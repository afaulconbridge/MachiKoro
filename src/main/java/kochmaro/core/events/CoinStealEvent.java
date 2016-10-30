package kochmaro.core.events;

import kochmaro.core.Card;
import kochmaro.core.Player;

public class CoinStealEvent implements Event {

	protected final Player player;
	protected final Player victim;
	protected final int amount;
	protected final Card card;
	
	public CoinStealEvent(Player player, Player victim, int amount, Card card) {
		this.player = player;
		this.victim = victim;
		this.amount = amount;	
		this.card = card;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Player getVictim() {
		return victim;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public Card getCard() {
		return card;
	}
}
