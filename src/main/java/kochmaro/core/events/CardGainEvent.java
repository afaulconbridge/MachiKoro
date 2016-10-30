package kochmaro.core.events;

import kochmaro.core.Card;
import kochmaro.core.Player;

public class CardGainEvent implements Event {

	protected final Player player;
	protected final Card card;
	
	public CardGainEvent(Player player, Card card) {
		this.player = player;
		this.card = card;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Card getCard() {
		return card;
	}
}
