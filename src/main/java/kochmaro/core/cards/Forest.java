package kochmaro.core.cards;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kochmaro.core.CardColour;
import kochmaro.core.Player;
import kochmaro.core.events.CoinGainEvent;
import kochmaro.core.events.Event;

public class Forest extends AbstractCard {

	protected static Set<Integer> activationNo = new HashSet<>();
	static {
		activationNo.add(5);
	};

	@Override
	public Set<Integer> getActivatesOn() {
		return activationNo;
	}
	
	@Override
	public String getName() {
		return "Forest";
	}

	@Override
	public int getCost() {
		return 3;
	}

	@Override
	public CardColour getColour() {
		return CardColour.BLUE;
	}

	@Override
	public List<Event> activate(Player owner, Player currentPlayer,
			List<Player> players) {
		List<Event> events = new ArrayList<>();
		owner.addCash(1);
		events.add(new CoinGainEvent(owner, 1, this));
		return events;
	}

}