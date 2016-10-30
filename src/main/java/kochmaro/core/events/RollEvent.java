package kochmaro.core.events;

import java.util.List;

import kochmaro.core.Player;


public class RollEvent implements Event {

	protected final Player player;
	protected final List<Integer> rolls;
	protected final int total;
	
	public RollEvent(Player player, List<Integer> rolls, int total) {
		this.player = player;
		this.rolls = rolls;
		this.total = total;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getTotal() {
		return total;
	}
	
}
