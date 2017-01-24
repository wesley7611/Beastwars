package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
//import com.mygdx.game.ItemCard;
import com.mygdx.game.Player;

public class CardHeal extends ItemCard {

	public CardHeal(Player owner) {
		super(owner);
		// TODO Auto-generated constructor stub
		front = new Texture(Gdx.files.internal("Item Cards/heal.JPG"));
	}

	@Override
	public cards.ItemCard ItemUse(Player targetPlayer, int target) {
		if(owner.equals(targetPlayer)){
		targetPlayer.discardFieldCard(target);
		return this;
		}
		return null;

	}
	

}