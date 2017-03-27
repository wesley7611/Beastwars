package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
//import com.mygdx.game.ItemCard;
import com.mygdx.game.Player;

public class CardDefUp extends ItemCard {

	public CardDefUp(Player owner) {
		super(owner);
		// TODO Auto-generated constructor stub
		front = new Texture(Gdx.files.internal("Item Cards/defUp.jpg"));
	}

	@Override
	public cards.ItemCard ItemUse(Player targetPlayer, int target) {
		if(owner.equals(targetPlayer)){
			targetPlayer.returnField().returnCard(target).setDEFUp(3);
		return this;
		}
		return null;

	}
	

}