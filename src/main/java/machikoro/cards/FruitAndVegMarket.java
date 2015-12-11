package machikoro.cards;

import java.util.HashSet;
import java.util.Set;

import machikoro.Card;
import machikoro.Game;

public class FruitAndVegMarket extends Card {


	@Override
	public int getCost() {
		return 2;
	}

	@Override
	public Set<Integer> getRolls() {
		Set<Integer> rollSet = new HashSet<>();
		rollSet.add(11);
		rollSet.add(12);
		return rollSet;
	}

	@Override
	public void playerTurn(Game game) {
		getOwner().addCoins(getOwner().getCards().get(new WheatField())*2);
		getOwner().addCoins(getOwner().getCards().get(new AppleOrchard())*2);
	}

	@Override
	public int getPriority() {
		return 2;
	}
}
