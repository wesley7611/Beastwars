package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardSquirrel extends ActorCard{
	Card bear;
	public CardSquirrel(Player owner, Stage stage){
		super(owner, stage);
		bear = new Card(owner);
		setMaxHP(100);
		currentHP=getMaxHP();
		name = "Bear";
		type = 1;
		attackCost=2;
		upkeep = 1;
		front = new Texture(Gdx.files.internal("Level 1/Squirrel.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(30);
		return attackCost;
	}

}
