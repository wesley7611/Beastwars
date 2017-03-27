package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardPidgeon extends ActorCard{
	Card pigeon;
	public CardPidgeon(Player owner){
		super(owner);
		pigeon = new Card(owner);
		setMaxHP(12);
		currentHP=getMaxHP();
		name = "Pigeon";
		type = 1;
		standardAttackCost=1;
		upkeep = 5;
		attPower= 10;
		front = new Texture(Gdx.files.internal("Level 1/Pidgeon.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
