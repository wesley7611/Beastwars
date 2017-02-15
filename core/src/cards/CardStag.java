package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardStag extends ActorCard{
	Card bear;
	public CardStag(Player owner){
		super(owner);
		bear = new Card(owner);
		setMaxHP(100);
		currentHP=getMaxHP();
		name = "Bear";
		type = 1;
		standardAttackCost=2;
		upkeep = 1;
		front = new Texture(Gdx.files.internal("Level 2/Stag.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(30);
		return currentAttackCost;
	}

}
