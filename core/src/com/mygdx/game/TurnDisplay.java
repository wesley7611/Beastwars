package com.mygdx.game;

import java.io.Console;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;

public class TurnDisplay extends Actor{

	Sprite sprite;
	Texture p1;
	Texture p2;
	boolean completed;
	
	public TurnDisplay() {
		p1 = new Texture(Gdx.files.internal("PTurn.png"));
		p2 = new Texture(Gdx.files.internal("Oturn.png"));
		sprite = new Sprite(p1);
		setPosition(-600,400);
		positionChanged();
		setVisible(true);
		completed = false;
	}

	public boolean scroll(){
		completed=false;
		setPosition(-600,400);
		//sprite.setTexture(texture);
	
		
		
		addAction(Actions.sequence(Actions.moveTo((Game.screenWidth-sprite.getWidth())/2,getY(), (float) 2), Actions.delay(1f), Actions.moveTo(Game.screenWidth+sprite.getWidth(), getY(), 2), Actions.run(new Runnable() {
		    public void run () {
		        completed = true;
		    }
		}) ));

		return completed;
		
	}
	public void player1Texture(){
		sprite.setTexture(p1);
	}
	public void player2Texture(){
		sprite.setTexture(p2);
	}
	@Override
	public void positionChanged() {
		sprite.setPosition(getX(), getY());
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
}
