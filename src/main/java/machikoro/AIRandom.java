package machikoro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIRandom extends Player {

	public AIRandom() {
		super();
	}

	@Override
	public Card buyCard(Game game) {
		//get a set of all cards we could buy
		//randomly pick one of them to buy
		
		List<Card> buyable = new ArrayList<>();
		
		for (Card card : game.getCards().keySet()) {
			if (card.getCost() <= getCoins()) {
				buyable.add(card);
			}
		}
		
		//check if anything is buyable
		if (buyable.size() == 0) {
			return null;
		}
		
		Random random = new Random();
		Card toBuy = buyable.get(random.nextInt(buyable.size()));
		
		return toBuy;
	}

	@Override
	public int deicdeDiceCount() {
		int maxCardRoll = 0;
		for (Card card : cards.keySet()) {
			for (Integer roll : card.getRolls()) {
				maxCardRoll = Math.max(maxCardRoll, roll);
			}
		}
		if (maxCardRoll > 6) {
			return 2;
		} else {
			return 1;
		}
	}

}
