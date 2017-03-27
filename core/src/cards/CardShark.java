package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardShark extends ActorCard{
	Card shark;
	public CardShark(Player owner){
		super(owner);
		shark = new Card(owner);
		setMaxHP(65);
		currentHP=getMaxHP();
		name = "Shark";
		type = 1;
		standardAttackCost=6;
		upkeep = 12;
		attPower= 35;
		front = new Texture(Gdx.files.internal("Level 3/Shark.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
