package kochmaro.core;

public class Player {
	protected int cash = 0;
	protected CardCollection cards = new CardCollection();
	protected PlayerController controller;
	protected String name;
	
	public Player(PlayerController controller, String name) {
		this.controller = controller;
		this.name = name;
	}
	
	public PlayerController getController() {
		return controller;
	}
	
	public String getName() {
		return name;
	}

	public int getCash() {
		return cash;
	}
	
	public void addCash(int amount) {
		this.cash += amount;
	}
	
	public int removeCash(int amount) {
		//can only remove as much as they have
		if (cash < amount) amount = cash;
		cash -= amount;
		return amount;
	}
	
	public CardCollection getCardCollection() {
		return cards;
	}
}
