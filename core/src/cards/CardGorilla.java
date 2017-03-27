package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardGorilla extends ActorCard{
	Card gorilla;
	public CardGorilla(Player owner){
		super(owner);
		gorilla = new Card(owner);
		setMaxHP(75);
		currentHP=getMaxHP();
		name = "Gorilla";
		type = 1;
		standardAttackCost=6;
		upkeep = 12;
		attPower= 38;
		front = new Texture(Gdx.files.internal("Level 3/Gorilla.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
