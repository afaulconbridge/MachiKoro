package machikoro.cards;

import java.util.HashSet;
import java.util.Set;

import machikoro.Card;
import machikoro.Game;

public class FamilyRestaurant extends Card {


	@Override
	public int getCost() {
		return 3;
	}

	@Override
	public Set<Integer> getRolls() {
		Set<Integer> rollSet = new HashSet<>();
		rollSet.add(9);
		rollSet.add(10);
		return rollSet;
	}

	@Override
	public void anyTurn(Game game) {
		getOwner().addCoins(game.getCurrentPlayer().takeCoins(2));
		//TODO avoid doing this to self?
	}

	@Override
	public int getPriority() {
		return 1;
	}
}
