package kochmaro.core.cards;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kochmaro.core.CardColour;
import kochmaro.core.Player;
import kochmaro.core.events.CoinGainEvent;
import kochmaro.core.events.Event;

public class RadioTower extends AbstractCard {

	protected static Set<Integer> activationNo = new HashSet<>();

	@Override
	public Set<Integer> getActivatesOn() {
		return activationNo;
	}
	
	@Override
	public String getName() {
		return "Radio Tower";
	}

	@Override
	public int getCost() {
		return 22;
	}

	@Override
	public CardColour getColour() {
		return CardColour.GREY;
	}
	
	@Override
	public List<Event> activate(Player owner, Player currentPlayer,
			List<Player> players) {
		//do nothing directly
		//re-roll one dice per turn
		List<Event> events = new ArrayList<>();
		return events;
	}

}
