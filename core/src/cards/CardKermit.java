package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardKermit extends ActorCard{
	Card kermit;
	public CardKermit(Player owner){
		super(owner);
		kermit = new Card(owner);
		setMaxHP(85);
		currentHP=getMaxHP();
		name = "Kermit";
		type = 1;
		standardAttackCost=7;
		upkeep = 15;
		attPower= 45;
		front = new Texture(Gdx.files.internal("Level 4/Kermit.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
