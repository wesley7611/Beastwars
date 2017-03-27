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
	Texture hp0;
	Texture hp10;
	Texture hp20;
	Texture hp30;
	Texture hp40;
	Texture hp50;
	Texture hp60;
	Texture hp70;
	Texture hp80;
	Texture hp90;
	Texture hp100;
	int hp;
	ActorCard owner;
	
	int size;

	public HPCounter(int hp) {
		// TODO Auto-generated constructor stub
		this.hp = hp;
		size = 200;
		//size = 20;
		setVisible(true);
		//owner = card;
		
		hp0 = new Texture(Gdx.files.internal("hp0.png"));
		hp10 = new Texture(Gdx.files.internal("10.png"));
		hp20 = new Texture(Gdx.files.internal("20.png"));
		hp30 = new Texture(Gdx.files.internal("30.png"));
		hp40 = new Texture(Gdx.files.internal("40.png"));
		hp50 = new Texture(Gdx.files.internal("50.png"));
		hp60 = new Texture(Gdx.files.internal("60.png"));
		hp70 = new Texture(Gdx.files.internal("70.png"));
		hp80 = new Texture(Gdx.files.internal("80.png"));
		hp90 = new Texture(Gdx.files.internal("90.png"));
		hp100 = new Texture(Gdx.files.internal("100.png"));
		sprite = new Sprite(hp0);
		updateHP();
		sprite.setPosition(0, 0);
		sprite.setSize(size, size);
		toFront();
		
	}
	
	private void updateHP(){
		if(hp<=0) sprite.setTexture(hp0);
		else if (hp<=10) sprite.setTexture(hp10);
		else if (hp<=20) sprite.setTexture(hp20);
		else if (hp<=30) sprite.setTexture(hp30);
		else if (hp<=40) sprite.setTexture(hp40);
		else if (hp<=50) sprite.setTexture(hp50);
		else if (hp<=60) sprite.setTexture(hp60);
		else if (hp<=70) sprite.setTexture(hp70);
		else if (hp<=80) sprite.setTexture(hp80);
		else if (hp<=90) sprite.setTexture(hp90);
		else if (hp<=100) sprite.setTexture(hp100);
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



