/**
* Main game class for Beast Wars
* 
*
* @author  Philip Wesley
* @version 1.0
* @since   2016-11-25 
*/

package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Game extends ApplicationAdapter {

	Player p1;
	Player p2;

	boolean cardDraw;
	boolean turnOver;
	boolean textDisplay;
	int turnCount;
	SpriteBatch batch;
	BitmapFont font;
	//SpriteBatch HP;
	int screenHeight = 720;
	int screenWidth= 1280;
	Actor textBox;
			
	Stage stage;
	
	Match match;


	private Matrix4 Projection;

	@Override
	public void create() {
		Projection = new Matrix4().setToOrtho2D(0, 0, (float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight());
		//textDisplay=true;
		//textBox=new Actor();
		
		ScreenViewport viewport = new ScreenViewport();
		stage = new Stage(viewport);

		Gdx.input.setInputProcessor(stage);

		
		//p1 = new PlayerLocal("Player 1");
		//p2 = new PlayerCPU("CPU");
	
		
		batch = new SpriteBatch();
		
		
		match = new Match(batch, stage);

	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		
		batch.setProjectionMatrix(Projection);
		
		
		batch.begin();

		    	
		match.act();
		
		
		stage.act();
		batch.end();
	}

	public void dispose() {

		batch.dispose();
		stage.dispose();
	}
}
