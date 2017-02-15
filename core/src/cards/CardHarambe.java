package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardHarambe extends ActorCard{
	Card pepe;
	public CardHarambe(Player owner){
		super(owner);
		pepe = new Card(owner);
		setMaxHP(80);
		currentHP=getMaxHP();
		name = "Pepe";
		type = 1;
		standardAttackCost=2;
		upkeep = 3;
		front = new Texture(Gdx.files.internal("Level 4/Harambe.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(70);
		return currentAttackCost;
	}

}
