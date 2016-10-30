package kochmaro.core.cards;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kochmaro.core.CardColour;
import kochmaro.core.Player;
import kochmaro.core.events.CoinGainEvent;
import kochmaro.core.events.CoinStealEvent;
import kochmaro.core.events.Event;

public class Cafe extends AbstractCard {
	protected static Set<Integer> activationNo = new HashSet<>();
	static {
		activationNo.add(3);
	};

	@Override
	public Set<Integer> getActivatesOn() {
		return activationNo;
	}
	
	@Override
	public String getName() {
		return "Cafe";
	}

	@Override
	public int getCost() {
		return 2;
	}

	@Override
	public CardColour getColour() {
		return CardColour.RED;
	}
	
	@Override
	public List<Event> activate(Player owner, Player currentPlayer,
			List<Player> players) {
		List<Event> events = new ArrayList<>();
		if (!owner.equals(currentPlayer)) {
			int amount = currentPlayer.removeCash(1);
			owner.addCash(amount);
			events.add(new CoinStealEvent(owner, currentPlayer, amount, this));
		}
		return events;
	}

}
