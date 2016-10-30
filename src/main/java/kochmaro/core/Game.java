package kochmaro.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import kochmaro.core.cards.*;
import kochmaro.core.events.CardGainEvent;
import kochmaro.core.events.DebugEventListener;
import kochmaro.core.events.Event;
import kochmaro.core.events.EventListener;
import kochmaro.core.events.RollEvent;
import kochmaro.core.events.WinEvent;

public class Game {

	protected List<Player> players = new ArrayList<>();
	
	protected List<EventListener> eventListeners = new ArrayList<>();
	
	protected CardCollection supply = new CardCollection();
	
	protected Random rng = new Random(42);
	
	public Game(List<Player> players) {
		if (players.size() < 2) throw new IllegalArgumentException("Must have at least 2 players");
		if (players.size() > 4) throw new IllegalArgumentException("Must have at most 4 players");
		this.players = players;
		
		//shuffle the players
		Collections.shuffle(this.players, rng);
		
		//give every player starting stuff
		for (Player p : this.players) {
			p.addCash(3);
			p.getCardCollection().addCard(new WheatField());
			p.getCardCollection().addCard(new Bakery());
		}
		
		//add the standard cards to the supply
		for (int i = 0; i < 6; i++) {
			supply.addCard(new WheatField());
			supply.addCard(new Ranch());
			supply.addCard(new Bakery());
			supply.addCard(new Cafe());
			supply.addCard(new ConvenienceStore());
			supply.addCard(new Forest());
		}
		
	}
	
	public void play() {
		while (true) {
			Player currentPlayer = players.get(0);
			
			//decide if 1 or 2 dice
			int diceCount = 1;
			//2 dice is only possible if train built by current player
			if (currentPlayer.getCardCollection().getCardTypes().contains(new TrainStation())) {
				diceCount = currentPlayer.getController().getDiceCount();
				if (diceCount < 1) throw new IllegalArgumentException("Must roll at least one dice");
				if (diceCount > 2) throw new IllegalArgumentException("Must roll at most two dice");
			}
			
			//roll the dice
			int diceResult = 0;
			List<Integer> diceRolls = new ArrayList<>();
			for (int i = 0; i < diceCount; i++) {
				Integer result = new Integer(rng.nextInt(6)+1);
				diceRolls.add(result);
				diceResult += result; 
			}
			
			signalEvent(new RollEvent(currentPlayer, diceRolls, diceResult));
			
			//for each card of each player, try to activate it by this roll
			
			//different types of card activate in a different order
			//so split the turn into phases for each type
			// red
			// green
			// blue
			// purple
			for (CardColour colour : CardColour.values()) {
				//go through players in reverse play order
				for (int i = players.size()-1; i >= 0; i--) {
					Player p = players.get(i);
					//go through each of the types of card the player has
					//in their sorted order
					CardCollection c = p.getCardCollection();
					List<Card> cardTypes = c.getCardTypes();
					for (int j = 0; j < cardTypes.size(); j++) {
						//for each of those cards the player has
						Card card = cardTypes.get(j);
						if (card.getColour() == colour && card.getActivatesOn().contains(diceResult)) {
							for (int k=0; k < c.getCount(card); k++) {
								List<Event> activateEvents = card.activate(p, currentPlayer, players);
								//pass any events generated to listeners
								for (Event e : activateEvents) {
									signalEvent(e);
								}
							}
						}
					}
				}
			}
			
			//now the current player can decide if they want to buy one new card
			List<Card> optionsToBuy = new ArrayList<>();
			//can buy from the supply
			for (Card card : supply.getCardTypes()) {
				if (card.getCost() <= currentPlayer.getCash()) {
					optionsToBuy.add(card);
					//TODO purple cards are one of each per player only
				}
			}
			//or one of the landmarks they don't already own
			Card trainStation = new TrainStation();
			if (trainStation.getCost() <= currentPlayer.getCash()
					&& !currentPlayer.getCardCollection().getCardTypes().contains(trainStation)) {
				optionsToBuy.add(trainStation);
			}
			Card radioTower = new RadioTower();
			if (radioTower.getCost() <= currentPlayer.getCash()
					&& !currentPlayer.getCardCollection().getCardTypes().contains(radioTower)) {
				optionsToBuy.add(radioTower);
			}
			Card amusementPark = new AmusementPark();
			if (amusementPark.getCost() <= currentPlayer.getCash()
					&& !currentPlayer.getCardCollection().getCardTypes().contains(amusementPark)) {
				optionsToBuy.add(amusementPark);
			}
			Card shoppingMall = new ShoppingMall();
			if (shoppingMall.getCost() <= currentPlayer.getCash()
					&& !currentPlayer.getCardCollection().getCardTypes().contains(shoppingMall)) {
				optionsToBuy.add(shoppingMall);
			}

			//if there is something avaliable for purchase
			if (optionsToBuy.size() > 0) {
				//ask the controller to make a choice
				Card purchase = currentPlayer.getController().getCardPurchase(currentPlayer, players, optionsToBuy);
				
				
				//if it was a purchase from the supply, remove from supply
				if (supply.getCardTypes().contains(purchase)) {
					supply.removeCard(purchase);
				}
				//add it to the players collection
				currentPlayer.getCardCollection().addCard(purchase);
		
				signalEvent(new CardGainEvent(currentPlayer, purchase));
			}

			//if they won, break
			if (hasWon(currentPlayer)) {
				signalEvent(new WinEvent(currentPlayer));
				break;
			}
			
			//if it wasn't a double
			if (diceCount > 1) {
				
			}
			
			//put the current player at the end
			players.add(players.remove(0));
		}	
	}
	
	protected boolean hasWon(Player player) {
		//if you have built all 4 landmarks, you win
		int landmarkCount = 0;
		for (Card card : player.getCardCollection().getCardTypes()) {
			if (card.getColour() == CardColour.GREY) {
				landmarkCount += 1;
			}
		}
		if (landmarkCount >= 4) {
			return true;
		} else {
			return false;
		}
	}
	
	protected void signalEvent(Event e) {
		for (EventListener listener : eventListeners) {
			listener.handleEvent(e);
		}
	}

	public void addEventListener(EventListener e) {
		this.eventListeners.add(e);		
	}
}
