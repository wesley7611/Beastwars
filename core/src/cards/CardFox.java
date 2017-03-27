package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardFox extends ActorCard{
	Card fox;
	public CardFox(Player owner){
		super(owner);
		fox = new Card(owner);
		setMaxHP(34);
		currentHP=getMaxHP();
		name = "Fox";
		type = 1;
		standardAttackCost=5;
		upkeep = 8;
		attPower= 22;
		front = new Texture(Gdx.files.internal("Level 2/Fox.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
