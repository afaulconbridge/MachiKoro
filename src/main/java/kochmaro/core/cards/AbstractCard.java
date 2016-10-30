package kochmaro.core.cards;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import kochmaro.core.Card;
/*
WheatField
Ranch
Bakery
ConvenienceStore
Forest
Stadium
TVStation
BuisnessCentre
CheeseFactory
FurnitureFactory
Mine
FamilyRestaurant
AppleOrchard
FruitAndVegMarket

Station
ShoppingMall
AmusementPark
RadioTower
 */
public abstract class AbstractCard implements Card {

	@Override
	public int compareTo(Card other) {
		if (this.equals(other)) return 0;
		
		int thisActivateMin = 1000;
		int thisActivateMax = 1000;
		int otherActivateMin = 1000;
		int otherActivateMax = 1000;
		if (this.getActivatesOn().size() > 0) {
			thisActivateMin = Collections.min(this.getActivatesOn());
			thisActivateMax = Collections.max(this.getActivatesOn());
		}
		if (other.getActivatesOn().size() > 0) {
			otherActivateMin = Collections.min(other.getActivatesOn());
			otherActivateMax = Collections.max(other.getActivatesOn());
		}	
		
		if (thisActivateMin < otherActivateMin) return -1;
		if (thisActivateMin > otherActivateMin) return 1;
		if (thisActivateMax < otherActivateMax) return -1;
		if (thisActivateMax > otherActivateMax) return 1;
		
		if (this.getCost() < other.getCost()) return -1;
		if (this.getCost() > other.getCost()) return 1;
		
		return this.getName().compareTo(other.getName());
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		} 
		if (other instanceof Card) {
			Card otherCard = (Card) other;
			return this.getName().equals(otherCard.getName());			
		} else {
			return false;
		}
	}
}
