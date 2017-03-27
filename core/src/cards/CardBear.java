package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardBear extends ActorCard{
	Card bear;
	public CardBear(Player owner){
		super(owner);
		bear = new Card(owner);
		setMaxHP(75);
		currentHP=getMaxHP();
		name = "Bear";
		type = 1;
		standardAttackCost=7;
		upkeep = 12;
		attPower= 40;
		front = new Texture(Gdx.files.internal("Level 3/Bear.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
