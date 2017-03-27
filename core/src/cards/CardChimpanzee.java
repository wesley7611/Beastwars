package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardChimpanzee extends ActorCard{
	Card chimp;
	public CardChimpanzee(Player owner){
		super(owner);
		chimp = new Card(owner);
		setMaxHP(45);
		currentHP=getMaxHP();
		name = "Chimpanzee";
		type = 1;
		standardAttackCost=5;
		upkeep = 8;
		attPower= 25;
		
		front = new Texture(Gdx.files.internal("Level 2/Chimpanzee.jpg"));
		
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(attPower);
		return currentAttackCost;
	}

}
