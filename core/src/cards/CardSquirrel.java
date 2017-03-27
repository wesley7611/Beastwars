package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardSquirrel extends ActorCard{
	Card squirrel;
	public CardSquirrel(Player owner){
		super(owner);
		squirrel = new Card(owner);
		setMaxHP(15);
		currentHP=getMaxHP();
		name = "Squirrel";
		type = 1;
		standardAttackCost=2;
		upkeep = 5;
		attPower= 14;
		front = new Texture(Gdx.files.internal("Level 1/Squirrel.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
