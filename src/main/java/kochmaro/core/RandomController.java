package kochmaro.core;

import java.util.List;
import java.util.Random;

public class RandomController implements PlayerController {

	protected Random rng = new Random();
	
	@Override
	public int getDiceCount() {
		return rng.nextInt(1)+1;
	}

	@Override
	public Card getCardPurchase(Player p, List<Player> players, List<Card> optionsToBuy) {
		return optionsToBuy.get(rng.nextInt(optionsToBuy.size()));
	}
}
