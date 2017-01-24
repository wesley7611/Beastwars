package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

class LargeDisplay extends Actor{
Sprite sprite;
Texture texture;

public LargeDisplay(){
	texture = new Texture(Gdx.files.internal("card.jpg"));
	sprite = new Sprite(texture);
	sprite.setSize(560, 720);
	setPosition((1280-560)/2, 0);
	setVisible(false);
	toFront();
}
public void setSprite(Sprite sprite){
	this.sprite = sprite;
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
