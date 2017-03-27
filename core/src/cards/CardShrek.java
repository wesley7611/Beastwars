package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardShrek extends ActorCard{
	Card shrek;
	public CardShrek(Player owner){
		super(owner);
		shrek = new Card(owner);
		setMaxHP(90);
		currentHP=getMaxHP();
		name = "Shrek";
		type = 1;
		standardAttackCost=9;
		upkeep = 15;
		attPower= 55;
		front = new Texture(Gdx.files.internal("Level 4/Shrek.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
