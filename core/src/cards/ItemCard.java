package cards;

import com.mygdx.game.Player;

public abstract class ItemCard extends Card{

	public ItemCard(Player owner) {
		super(owner);
		type=2;
		
	}
	public abstract ItemCard ItemUse(Player targetPlayer, int target);

}
