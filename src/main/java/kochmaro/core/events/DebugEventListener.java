package kochmaro.core.events;

import kochmaro.core.Card;
import kochmaro.core.Player;


public class DebugEventListener implements EventListener {

	public void handleEvent(Event e) {
		if (e instanceof RollEvent) {
			RollEvent re = (RollEvent) e;
			Player p = re.getPlayer();
			//if rolled one dice, just do the result
			//if rolled two dice, show the separates
			StringBuilder sb = new StringBuilder();
			if (re.rolls.size()==1) {
				sb.append(re.rolls.get(0));
			} else if (re.rolls.size() == 2) {
				sb.append(re.rolls.get(0));
				sb.append("+");
				sb.append(re.rolls.get(1));
				sb.append(" = ");
				sb.append(re.rolls.get(0)+re.rolls.get(1));
			}
			System.out.println(p.getName()+" rolled "+sb.toString());
		} else if (e instanceof CardGainEvent) {
			CardGainEvent cge = (CardGainEvent) e;
			Player p = cge.getPlayer();
			System.out.println(p.getName()+" gained "+cge.getCard().getName());
		} else if (e instanceof CoinGainEvent) {
			CoinGainEvent cge = (CoinGainEvent) e;
			Player p = cge.getPlayer();
			Card c = cge.getCard();
			System.out.println(p.getName()+" gained "+cge.getAmount()+" coin(s) from "+c.getName()+" (total: "+p.getCash()+")");
		} else if (e instanceof CoinStealEvent) {
			CoinStealEvent cse = (CoinStealEvent) e;
			Player p = cse.getPlayer();
			Player v = cse.getVictim();
			Card c = cse.getCard();
			System.out.println(p.getName()+" stole "+cse.getAmount()+" from "+v.getName()+" with "+c.getName()+" (total: "+p.getCash()+")");
		}
	}
}
