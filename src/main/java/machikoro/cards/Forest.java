package machikoro.cards;

import java.util.HashSet;
import java.util.Set;

import machikoro.Card;
import machikoro.Game;

public class Forest extends Card {


	@Override
	public int getCost() {
		return 3;
	}

	@Override
	public Set<Integer> getRolls() {
		Set<Integer> rollSet = new HashSet<>();
		rollSet.add(5);
		return rollSet;
	}

	@Override
	public void anyTurn(Game game) {
		getOwner().addCoins(1);
	}

	@Override
	public int getPriority() {
		return 2;
	}

}
