package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardFrog extends ActorCard{
	Card frog;
	public CardFrog(Player owner){
		super(owner);
		frog = new Card(owner);
		setMaxHP(14);
		currentHP=getMaxHP();
		name = "Frog";
		type = 1;
		standardAttackCost=3;
		upkeep = 5;
		attPower= 12;
		front = new Texture(Gdx.files.internal("Level 1/Frog.JPG"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
