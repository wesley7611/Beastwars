package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardLion extends ActorCard{
	Card lion;
	public CardLion(Player owner, Stage stage){
		super(owner, stage);
		lion = new Card(owner);
		setMaxHP(60);
		currentHP=getMaxHP();
		name = "Lion";
		type = 1;
		
		attackCost=2;
		upkeep = 1;
		front = new Texture(Gdx.files.internal("Level 3/Tiger.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(30);
		return attackCost;
	}

}
