package kochmaro.core.events;

import kochmaro.core.Player;

public class WinEvent implements Event {

	protected final Player player;
	
	public WinEvent(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
