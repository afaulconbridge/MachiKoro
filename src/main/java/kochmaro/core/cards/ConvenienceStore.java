package kochmaro.core.cards;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kochmaro.core.CardColour;
import kochmaro.core.Player;
import kochmaro.core.events.CoinGainEvent;
import kochmaro.core.events.Event;

public class ConvenienceStore extends AbstractCard {
	protected static Set<Integer> activationNo = new HashSet<>();
	static {
		activationNo.add(4);
	};

	@Override
	public Set<Integer> getActivatesOn() {
		return activationNo;
	}
	
	@Override
	public String getName() {
		return "Convenience Store";
	}

	@Override
	public int getCost() {
		return 2;
	}

	@Override
	public CardColour getColour() {
		return CardColour.GREEN;
	}
	
	@Override
	public List<Event> activate(Player owner, Player currentPlayer,
			List<Player> players) {
		List<Event> events = new ArrayList<>();
		if (owner.equals(currentPlayer)) {
			owner.addCash(3);
			events.add(new CoinGainEvent(owner, 3, this));
		}
		return events;
	}

}
