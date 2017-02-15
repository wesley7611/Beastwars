package cards;

import java.util.ArrayList;
import java.util.List;

//import com.badlogic.gdx.graphics.G2d;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.mygdx.game.Game;
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
	int afflictedCount;
	
	boolean isStunned;
	int stunnedCount;
	
	boolean isTaunting;
	
	boolean isCrippled;
	int crippledCount;
	
	boolean isConfused;
	int confusedCount;
	
	boolean isSTRUp;
	int STRUpCount;
	
	boolean isDEFUp;
	int DEFUpCount;
	
	int value;
	
	int standardAttackCost;
	int currentAttackCost;
	
	public ActorCard(Player owner){
		super(owner);
		this.stage = Game.stage;
		maxHP=0;
		currentHP = getMaxHP();
		isDefeated = false;
		type=1;
		standardAttackCost = 0;
		currentAttackCost = 0;
		text = new Label("TEST", new LabelStyle(new BitmapFont(), Color.BLACK));
		//healthDisplay=new ArrayList<HPCounter>(maxHP);
		//text.setPosition(0, 0);
		
		
		afflictedCount = 0;
		stunnedCount = 0;
		crippledCount =0;
		confusedCount = 0;
		STRUpCount = 0;
		DEFUpCount = 0;
		
		
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
		return currentAttackCost;
	}
	public void statusCheck(){
		if(isAfflicted==true){
			//poison actions
			
			reduceTimer(afflictedCount, isAfflicted);
		}
		if(isStunned==true){
			//reduce stuncount
			reduceTimer(stunnedCount, isStunned);
		}
		if(isCrippled==true){
			reduceTimer(crippledCount, isCrippled);
		}
		if(isConfused==true){
			reduceTimer(confusedCount, isConfused);
		}
		if(isSTRUp==true){
			reduceTimer(STRUpCount, isSTRUp);
		}
		if(isDEFUp==true){
			reduceTimer(DEFUpCount, isDEFUp);
		}
		
	}
	private void reduceTimer(int timer, boolean status){
		timer --;
		if(timer<=0)status=false;
	}
}
