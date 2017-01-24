package cards;

import java.util.ArrayList;
import java.util.List;
//import com.badlogic.gdx.graphics.G2d;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.mygdx.game.Player;


public abstract class ActorCard extends Card{
	Stage stage;
	
	protected int currentHP;
	private int maxHP;
	protected String name;
	protected Label text;
	protected List<HPCounter> healthDisplay;
	
	BitmapFont font;
	
	protected int upkeep;
	boolean isDefeated;
	
	boolean isAfflicted;
	boolean isStunned;
	boolean isTaunting;
	boolean isCrippled;
	boolean isConfused;
	boolean isSTRup;
	boolean isDEFup;
	
	int value;
	
	int attackCost;
	
	public ActorCard(Player owner, Stage stage){
		super(owner);
		this.stage = stage;
		maxHP=0;
		currentHP = getMaxHP();
		isDefeated = false;
		type=1;
		attackCost = 0;
		text = new Label("TEST", new LabelStyle(new BitmapFont(), Color.BLACK));
		//healthDisplay=new ArrayList<HPCounter>(maxHP);
		text.setPosition(0, 0);
		
		
		/*
		for(int i=0; i < 10; i++){
			HPCounter counter = new HPCounter();
			healthDisplay.add(counter);
			counter.setPosition(getX(), getY());
			addActor(counter);
			stage.addActor(counter);
		}*/
		
		
		
	}
	protected void createHealthDisplay(int max){
		
	}
	protected void updateHealthPosition(){
		for(int i =0; i<maxHP; i++){
			
		}
	}
	public String getName(){
		return name;
	}
	
	public abstract int attack(ActorCard target); //this is main attack of the card when played from field; will differ from card to card
	
	public void decreaseHP(int hp){
		currentHP = currentHP - hp;
		if(currentHP<=0){
			currentHP=0;
			isDefeated=true;
			flipBack();
		}
	}
	
	public void increaseHP(int hp){
		currentHP = currentHP + hp;
		if(currentHP > getMaxHP()){
			currentHP = getMaxHP();
		}
	}
	
	public int getCurrentHP(){
		return currentHP;
	}
	public boolean isDefeated(){
		return isDefeated;
	}
	public int returnHP() {
		return currentHP;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public int returnUpkeep(){
		return upkeep;
	}
	public int returnAttackCost(){
		return attackCost;
	}
}
