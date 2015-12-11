package machikoro.cards;

import java.util.HashSet;
import java.util.Set;

import machikoro.Card;
import machikoro.Game;

public class Mine extends Card {


	@Override
	public int getCost() {
		return 6;
	}

	@Override
	public Set<Integer> getRolls() {
		Set<Integer> rollSet = new HashSet<>();
		rollSet.add(9);
		return rollSet;
	}

	public void anyTurn(Game game) {
		getOwner().addCoins(5);
	}

	@Override
	public int getPriority() {
		return 2;
	}
}
