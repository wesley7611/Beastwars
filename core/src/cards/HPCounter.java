/**
 * HPCounter is responsible for providing a visual representation of each
 * cards individual HP points as graphical counters
 * 
 *
 * @author Philip Wesley
 * @version 1.0
 * @since 2016-11-25
 */

package cards;

//package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class HPCounter extends Actor {
	Sprite sprite;
	Texture texture;
	int size;

	public HPCounter() {
		// TODO Auto-generated constructor stub

		size = 20;
		setVisible(true);
		// setPosition(200,200);
		texture = new Texture(Gdx.files.internal("hp.png"));
		sprite = new Sprite(texture);
		sprite.setSize(size, size);
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

	public Sprite returnSprite() {
		return sprite;
	}

}



