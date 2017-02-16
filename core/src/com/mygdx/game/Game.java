/**
 * Main game class for Beast Wars
 * 
 *
 * @author  Philip Wesley
 * @version 1.0
 * @since   2016-11-25 
 */

package com.mygdx.game;

import java.util.Random;

import cards.*;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Game extends ApplicationAdapter {

	Player p1;
	Player p2;

	public static boolean inputEnabled;
	boolean cardDraw;
	boolean turnOver;
	boolean textDisplay;
	int turnCount;
	public static SpriteBatch batch;
	BitmapFont font;
	
	int screenHeight = 720;
	public static int screenWidth = 1280;
	//Actor textBox;

	public static Stage stage;

	Match match;

	Texture board;

	Deck pDeck = new Deck();
	Deck oDeck = new Deck();

	private Matrix4 Projection;

	@Override
	public void create() {
		inputEnabled = false;
		Projection = new Matrix4().setToOrtho2D(0, 0,
				(float) Gdx.graphics.getWidth(),
				(float) Gdx.graphics.getHeight());

		ScreenViewport viewport = new ScreenViewport();
		stage = new Stage(viewport);

		Gdx.input.setInputProcessor(stage);
		
		

		batch = new SpriteBatch();

		createPlayerDeck();

		// match = new Match(batch, stage);
		match = new Match(pDeck, oDeck);

		board = new Texture(Gdx.files.internal("board.png"));
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 0, 0, 1);

		batch.setProjectionMatrix(Projection);

		batch.begin();

		batch.draw(board, 0, 0);

		match.act();

		stage.act();
		batch.end();
	}

	public void dispose() {

		batch.dispose();
		stage.dispose();
	}

	private void createPlayerDeck() {
		for (int i = 0; i < 30; i++) {
			Card card;
			Random r = new Random();
			int x = r.nextInt(17);
			if (x == 0) {
				card = new CardBear(p1);
				// p1.deck.addCard(card);
			} else if (x == 1) {
				card = new CardLion(p1);
				// p1.deck.addCard(card);
			} else if (x == 2) {
				card = new CardFrog(p1);
				// p1.deck.addCard(card);
			} else if (x == 3) {
				card = new CardPepe(p1);
				// p1.deck.addCard(card);
			} else if (x == 4) {
				card = new CardEuthanise(p1);
			} else if (x == 5) {
				card = new CardSquirrel(p1);

			} else if (x == 6) {
				card = new CardAttUp(p1);
			} else if (x == 7) {
				card = new CardDefUp(p1);
			} else if (x == 8) {
				card = new CardBadger(p1);
			} else if (x == 9) {
				card = new CardChimpanzee(p1);
			} else if (x == 10) {
				card = new CardStag(p1);
			} else if (x == 11) {
				card = new CardRat(p1);
			} else if (x == 12) {
				card = new CardEuthanise(p1);
			} else if (x == 13) {
				card = new CardFox(p1);
			} else if (x == 14) {
				card = new CardFrog(p1);
			} else if (x == 15) {
				card = new CardHeal(p1);
			} else if (x == 16) {
				card = new CardMinnow(p1);
			} else if (x == 17) {
				card = new CardPidgeon(p1);
			} else if (x == 17) {
				card = new CardKermit(p1);
			} else if (x == 17) {
				card = new CardHarambe(p1);
			} else if (x == 17) {
				card = new CardShrek(p1);
			} else {
				card = new Card(p1);
			}
			pDeck.addCard(card);
		}
		
		for (int i = 0; i < 30; i++) {
			Card card;
			Random r = new Random();
			int x = r.nextInt(17);
			if (x == 0) {
				card = new CardBear(p2);
				// p1.deck.addCard(card);
			} else if (x == 1) {
				card = new CardLion(p2);
				// p1.deck.addCard(card);
			} else if (x == 2) {
				card = new CardFrog(p2);
				// p1.deck.addCard(card);
			} else if (x == 3) {
				card = new CardPepe(p2);
				// p1.deck.addCard(card);
			} else if (x == 4) {
				card = new CardEuthanise(p2);
			} else if (x == 5) {
				card = new CardSquirrel(p2);

			} else if (x == 6) {
				card = new CardAttUp(p2);
			} else if (x == 7) {
				card = new CardDefUp(p2);
			} else if (x == 8) {
				card = new CardBadger(p2);
			} else if (x == 9) {
				card = new CardChimpanzee(p2);
			} else if (x == 10) {
				card = new CardStag(p2);
			} else if (x == 11) {
				card = new CardRat(p2);
			} else if (x == 12) {
				card = new CardEuthanise(p2);
			} else if (x == 13) {
				card = new CardFox(p2);
			} else if (x == 14) {
				card = new CardFrog(p2);
			} else if (x == 15) {
				card = new CardHeal(p2);
			} else if (x == 16) {
				card = new CardMinnow(p2);
			} else if (x == 17) {
				card = new CardPidgeon(p2);
			} else if (x == 17) {
				card = new CardKermit(p2);
			} else if (x == 17) {
				card = new CardHarambe(p2);
			} else if (x == 17) {
				card = new CardShrek(p2);
			} else {
				card = new Card(p2);
			}
			oDeck.addCard(card);
		}
	}
}
