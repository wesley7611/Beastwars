package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardBadger extends ActorCard{
	Card badger;
	
	public CardBadger(Player owner){
		super(owner);
		badger = new Card(owner);
		setMaxHP(39);
		currentHP=getMaxHP();
		name = "Badger";
		type = 1;
		standardAttackCost=5;
		attPower = 20;
		upkeep = 8;
		front = new Texture(Gdx.files.internal("Level 2/Badger.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
