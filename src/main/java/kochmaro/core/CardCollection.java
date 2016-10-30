package kochmaro.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardCollection {

	protected Map<Card, Integer> cardMap = new HashMap<>();
	
	public void addCard(Card card) {
		if (!cardMap.containsKey(card)) {
			cardMap.put(card, 0);
		}
		cardMap.put(card, cardMap.get(card)+1);
	}
	
	public void removeCard(Card card) {
		if (!cardMap.containsKey(card)) {
			throw new IllegalArgumentException("Must contain card "+card);
		}
		cardMap.put(card, cardMap.get(card)-1);
		if (cardMap.get(card) == 0) {
			cardMap.remove(card);
		}
	}
	
	public List<Card> getCardTypes() {
		List<Card> cardList = new ArrayList<>();
		cardList.addAll(cardMap.keySet());
		Collections.sort(cardList);
		return cardList;
	}

	public int getCount(Card card) {
		if (!cardMap.containsKey(card)) {
			return 0;
		}
		return cardMap.get(card);
	}
}
