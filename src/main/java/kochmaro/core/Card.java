package kochmaro.core;

import java.util.List;
import java.util.Set;

import kochmaro.core.events.Event;

public interface Card extends Comparable<Card> {
	
	public String getName();
	
	public int getCost();
	
	public CardColour getColour();
	
	public Set<Integer> getActivatesOn();
	
	/**
	 * Apply the results of a roll. Note that this will be called for each activated card per player per card type per turn.
	 * @param players is the list of all players (including p)
	 * @param p is the current player
	 * @param phase is the stage of the comparisons to do
	 * @return list of events resulting from this activation, if any
	 */
	public List<Event> activate(Player owner, Player currentPlayer, List<Player> players);
	
}
