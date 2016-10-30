package kochmaro.core.cards;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kochmaro.core.CardColour;
import kochmaro.core.Player;
import kochmaro.core.events.CoinGainEvent;
import kochmaro.core.events.Event;

public class ShoppingMall extends AbstractCard {

	protected static Set<Integer> activationNo = new HashSet<>();

	@Override
	public Set<Integer> getActivatesOn() {
		return activationNo;
	}
	
	@Override
	public String getName() {
		return "Shopping Mall";
	}

	@Override
	public int getCost() {
		return 10;
	}

	@Override
	public CardColour getColour() {
		return CardColour.GREY;
	}
	
	@Override
	public List<Event> activate(Player owner, Player currentPlayer,
			List<Player> players) {
		//do nothing directly
		//+1 value from food and drink
		List<Event> events = new ArrayList<>();
		return events;
	}

}
