package cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.mygdx.game.Player;

public class Card extends Actor{
    Sprite sprite;
    Texture front;
    Texture back;
    Player owner;
    //float X;
    //float Y;
    protected String name;
	protected int type; //1 = actor, 2 = item, used to determine how a card will be played from the hand
	//protected enum type{ACTOR, ITEM};
	protected int width;
	protected int height;
	
	int currentHP;
	boolean pressed;
	boolean hover;

	
    public Card(Player owner){
    	height = 135;
    	width = 105;
    	this.owner = owner;
    	pressed=false;
    	hover=false;
    	//X=0;
    	//Y=0;
    	
    	front = new Texture(Gdx.files.internal("card.jpg"));
    	back = new Texture(Gdx.files.internal("card.jpg"));
    	sprite = new Sprite(back);
    	sprite.setSize(width, height);
        setBounds(sprite.getX(),sprite.getY(),width,height);
        setTouchable(Touchable.enabled);
        
        addListener(new InputListener(){/*
        	public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor)
        	{
        		hover = true;
				
        		
        	}
        	public void exit(InputEvent event, float x, float y, int pointer, Actor toActor)
        	{
        		hover = false;
				
        		
        	}*/
        	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
        		
        		hover=true;
        		return true;
        	}
        	public void touchUp(InputEvent event, float x, float y, int pointer, int button){
        		hover=false;
        		pressed=true;
        		
        	}
        	
        	
        });
            	
           //@Override
			
        ;
    }
    
    public boolean isPressed(){
    	if(pressed){
    	pressed=false;
    	return true;
    	}
    	return false;
    }
    public boolean isHovered(){
    	if(hover){
    		hover = false;
    		return true;
    	}
    	return false;
    }
    //Overrided input methods from parent class
    @Override
	public void positionChanged() {
        sprite.setPosition(getX(),getY());
        super.positionChanged();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
    	
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
	
	
    
	public int returnType(){
		return type;
	}
	
	public Sprite returnSprite(){
		return sprite;
	}
	
	
	
	
	
	//Flips card to display eithe front or back
	public void flipFront(){
		
		sprite.setTexture(front);
	}
	public Texture returnFront(){
		return front;
	}
	public void flipBack(){
		
		//this.addAction(Actions.sequence(Actions.scaleTo(100, getY(), (float) 1), Actions.delay(2f), Actions.sizeTo(0, getY(), (float) 2)));
		
		sprite.setTexture(back);
		/*
		for(int i=0; i<width; i++){
			
			addAction(Actions.sequence(Actions.delay(10f), Actions.run(new Runnable() {
			    public void run () {
			    	
			    	sprite.setSize(width--, height);
			    }
			})));
			//act(Gdx.graphics.getDeltaTime());
			
		}
		
		//sprite.setSize(0, height);
		for(int i=0; i<width; i++){
			sprite.setSize(i+1, height);
			//act(Gdx.graphics.getDeltaTime());
		}*/
	}

	public boolean isActor() {
		if(type==1)return true;
		else return false;
	}
	
	public boolean isItem(){
		if(type==2)return true;
		else return false;
	}
	public void rotateCard(){
		sprite.setOrigin(width/2, height/2);
		sprite.rotate(180);
	}
}
