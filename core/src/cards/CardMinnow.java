package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardMinnow extends ActorCard{
	Card minnow;
	public CardMinnow(Player owner){
		super(owner);
		minnow = new Card(owner);
		setMaxHP(10);
		currentHP=getMaxHP();
		name = "Minnow";
		type = 1;
		attPower= 10;
		standardAttackCost=1;
		upkeep = 5;
		front = new Texture(Gdx.files.internal("Level 1/Minnow.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
