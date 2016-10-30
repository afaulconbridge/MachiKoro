package kochmaro.core.events;

import kochmaro.core.Card;
import kochmaro.core.Player;


public class CoinGainEvent implements Event {

	protected final Player player;
	protected final int amount;
	protected final Card card;
	
	public CoinGainEvent(Player player, int amount, Card card) {
		this.player = player;
		this.amount = amount;		
		this.card = card;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public Card getCard() {
		return card;
	}

}
