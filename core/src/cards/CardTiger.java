package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardTiger extends ActorCard{
	Card tiger;
	public CardTiger(Player owner){
		super(owner);
		tiger = new Card(owner);
		setMaxHP(68);
		currentHP=getMaxHP();
		name = "Tiger";
		type = 1;
		standardAttackCost=7;
		upkeep = 12;
		attPower= 45;
		front = new Texture(Gdx.files.internal("Level 3/Tiger.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
