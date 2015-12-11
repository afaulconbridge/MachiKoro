package machikoro.cards;

import java.util.HashSet;
import java.util.Set;

import machikoro.Card;
import machikoro.Game;

public class AppleOrchard extends Card {

	@Override
	public int getCost() {
		return 3;
	}

	@Override
	public Set<Integer> getRolls() {
		Set<Integer> rollSet = new HashSet<>();
		rollSet.add(10);
		return rollSet;
	}
	
	@Override
	public void anyTurn(Game game){
		getOwner().addCoins(3);
	}

	@Override
	public int getPriority() {
		return 2;
	}
}
