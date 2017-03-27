package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardEel extends ActorCard{
	Card eel;
	public CardEel(Player owner){
		super(owner);
		eel = new Card(owner);
		setMaxHP(35);
		currentHP=getMaxHP();
		name = "Eel";
		type = 1;
		standardAttackCost=6;
		upkeep = 8;
		attPower= 35;
		front = new Texture(Gdx.files.internal("Level 3/Eel.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
