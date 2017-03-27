package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardPepe extends ActorCard{
	Card pepe;
	public CardPepe(Player owner){
		super(owner);
		pepe = new Card(owner);
		setMaxHP(95);
		currentHP=getMaxHP();
		name = "Pepe";
		type = 1;
		standardAttackCost=10;
		upkeep = 15;
		attPower= 60;
		front = new Texture(Gdx.files.internal("Level 4/Pepe.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
