package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player;

public class CardPepe extends ActorCard{
	Card pepe;
	public CardPepe(Player owner, Stage stage){
		super(owner, stage);
		pepe = new Card(owner);
		setMaxHP(80);
		currentHP=getMaxHP();
		name = "Pepe";
		type = 1;
		attackCost=3;
		upkeep = 3;
		front = new Texture(Gdx.files.internal("Level 4/Pepe.jpg"));
		//sprite = new Sprite(back);
	}
	public int attack(ActorCard target){
		target.decreaseHP(70);
		return attackCost;
	}

}
