package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
//import com.mygdx.game.ItemCard;
import com.mygdx.game.Player;

public class CardEuthanise extends ItemCard {

	public CardEuthanise(Player owner) {
		super(owner);
		// TODO Auto-generated constructor stub
		front = new Texture(Gdx.files.internal("Item Cards/euthanise.jpg"));
	}

	@Override
	public cards.ItemCard ItemUse(Player targetPlayer, int target) {
		System.out.println(targetPlayer + " " + owner);
		if(owner.equals(targetPlayer)){
		/*
		 * TODO: Add animation for euthanise
		 */	
			
		targetPlayer.discardFieldCard(target);
		return this;
		}
		return null;

	}
	

}