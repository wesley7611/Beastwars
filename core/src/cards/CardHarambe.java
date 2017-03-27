package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardHarambe extends ActorCard{
	Card harambe;
	public CardHarambe(Player owner){
		super(owner);
		harambe = new Card(owner);
		setMaxHP(90);
		currentHP=getMaxHP();
		name = "Harambe";
		type = 1;
		standardAttackCost=8;
		upkeep = 15;
		attPower= 50;
		front = new Texture(Gdx.files.internal("Level 4/Harambe.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
