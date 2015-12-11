package machikoro;

import java.util.Set;

public abstract class Card {

	private Player owner;
	
	public abstract int getCost();
	public abstract Set<Integer> getRolls();
	public abstract int getPriority();
	
	public String getName() {
		return getClass().getSimpleName();
	}
	
	public void playerTurn(Game game) {
		//do nothing
	}
	
	public void anyTurn(Game game) {
		//do nothing
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
}
