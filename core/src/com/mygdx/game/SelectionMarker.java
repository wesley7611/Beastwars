package com.mygdx.game;

import cards.Card;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class SelectionMarker extends Actor {
	Texture texture;
	Sprite sprite;
	float height = 135;
    float width = 105;

	public SelectionMarker() {
    	
    	
		texture = new Texture(Gdx.files.internal("selected.png"));
		sprite = new Sprite(texture);
		sprite.setSize(width, height);
		setTouchable(Touchable.disabled);
		setVisible(false);
	}
	
	public void selectCard(Card card){
		setPosition(card.getX(),card.getY());
		toFront();
		setVisible(true);
	}
	
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

}
