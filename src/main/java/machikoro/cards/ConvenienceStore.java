package machikoro.cards;

import java.util.HashSet;
import java.util.Set;

import machikoro.Card;
import machikoro.Game;

public class ConvenienceStore extends Card {

	@Override
	public String getName() {
		return "Convenience Store";
	}

	@Override
	public int getCost() {
		return 2;
	}

	@Override
	public Set<Integer> getRolls() {
		Set<Integer> rollSet = new HashSet<>();
		rollSet.add(4);
		return rollSet;
	}

	@Override
	public void playerTurn(Game game) {
		getOwner().addCoins(3);
	}
	
	@Override
	public int getPriority() {
		return 2;
	}
}
