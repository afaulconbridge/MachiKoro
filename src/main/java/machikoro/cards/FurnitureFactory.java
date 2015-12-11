package machikoro.cards;

import java.util.HashSet;
import java.util.Set;

import machikoro.Card;
import machikoro.Game;

public class FurnitureFactory extends Card {


	@Override
	public int getCost() {
		return 3;
	}

	@Override
	public Set<Integer> getRolls() {
		Set<Integer> rollSet = new HashSet<>();
		rollSet.add(8);
		return rollSet;
	}

	public void playerTurn(Game game) {
		getOwner().addCoins(getOwner().getCards().get(new Forest()) * 3);
		getOwner().addCoins(getOwner().getCards().get(new Mine()) * 3);
	}

	@Override
	public int getPriority() {
		return 2;
	}
}
