package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardRat extends ActorCard{
	Card rat;
	public CardRat(Player owner){
		super(owner);
		rat = new Card(owner);
		setMaxHP(100);
		currentHP=getMaxHP();
		name = "Rat";
		type = 1;
		standardAttackCost=1;
		upkeep = 5;
		attPower= 8;
		front = new Texture(Gdx.files.internal("Level 1/Rat.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
