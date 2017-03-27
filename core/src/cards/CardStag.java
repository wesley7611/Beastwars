package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardStag extends ActorCard{
	Card stag;
	public CardStag(Player owner){
		super(owner);
		stag = new Card(owner);
		setMaxHP(49);
		currentHP=getMaxHP();
		name = "Stag";
		type = 1;
		standardAttackCost=4;
		upkeep = 8;
		attPower= 19;
		front = new Texture(Gdx.files.internal("Level 2/Stag.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
