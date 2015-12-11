package machikoro.cards;

import java.util.HashSet;
import java.util.Set;

import machikoro.Card;
import machikoro.Game;

public class Cafe extends Card {

	@Override
	public int getCost() {
		return 2;
	}

	@Override
	public Set<Integer> getRolls() {
		Set<Integer> rollSet = new HashSet<>();
		rollSet.add(3);
		return rollSet;
	}

	@Override
	public void anyTurn(Game game) {
		getOwner().addCoins(game.getCurrentPlayer().takeCoins(1));
		//TODO avoid doing this to self?		
	}

	@Override
	public int getPriority() {
		return 1;
	}
}
