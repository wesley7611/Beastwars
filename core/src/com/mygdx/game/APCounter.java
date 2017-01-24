/**
* AP Meter counter is responsible for providing a visual representation
* of each players individual AP points as graphical counters
* 
*
* @author  Philip Wesley
* @version 1.0
* @since   2016-11-25 
*/

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class APCounter extends Actor {
	Sprite sprite;
	Texture texture;
	int size;
	
	public APCounter() {
		size = 20;
		setVisible(false);
		//setPosition(200,200);
		texture = new Texture(Gdx.files.internal("orb.png"));
    	sprite = new Sprite(texture);
    	sprite.setSize(size, size);
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
	
	public Sprite returnSprite(){
		return sprite;
	}
}
