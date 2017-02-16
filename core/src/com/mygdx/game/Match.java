/**
 * Match class is responsible for managing the individual matches played by the PC.
 * 
 *
 * @author  Philip Wesley
 * @version 1.0
 * @since   2016-11-25 
 */
package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.scenes.scene2d.Actor;

import cards.*;

public class Match {

	Player p1;
	Player p2;
	APMeter p1m;

	boolean cardDraw;
	boolean turnOver;

	int turnCount;
	// SpriteBatch batch;
	BitmapFont font;

	int screenHeight = 720;
	int screenWidth = 1280;

	Actor textBox;
	int maxAP = 40;

	// public Stage stage;
	boolean end;

	TurnDisplay tDisplay;

	Texture board;

	// public Match(SpriteBatch batch, Stage stage) {
	public Match(Deck pDeck, Deck oDeck) {

		// tDisplay = new TurnDisplay();

		p1 = new PlayerLocal("Player 1", Game.stage);
		p2 = new PlayerCPU("CPU");
		// this.stage = stage;
		// this.batch = batch;

		font = new BitmapFont();
		// HP = new SpriteBatch();

		cardDraw = true;
		turnCount = 0;
		turnOver = false;

		board = new Texture(Gdx.files.internal("board.png"));

		p1.deck = pDeck;
		
		for (Card card : pDeck.deck) {
			card.setX(1280 - 185);
			card.setY(20);
			card.setPosition(card.getX(), card.getY());
			card.positionChanged();
			
			Game.stage.addActor(card);
		}
		
		p2.deck = oDeck;
		
		for (Card card : oDeck.deck) {

			card.setOrigin(card.getWidth() / 2, card.getHeight() / 2);
			card.rotateCard();
			card.setX(80);
			card.setY(720 - 145);
			card.setPosition(card.getX(), card.getY());
			card.positionChanged();
			Game.stage.addActor(card);
		}
		

		// /////
		// match = new Match(p1, p2);

		p1.initialisePlayer(Game.stage);
		p2.initialisePlayer(Game.stage);

		// Game.stage.addActor(tDisplay);

		// end = false;

	}

	public void act() {

		Game.batch.draw(board, 0, 0);

		Game.stage.draw();

		/*if (cardDraw == true && turnCount % 2 == 0) {

			// tDisplay.player1Texture();

			// tDisplay.scroll();
			cardDraw = p1.drawFromDeck();

		}*/

		if (turnCount % 2 == 0) {
			turnOver = p1.takeTurn(p2);
		}

		if (turnCount % 2 == 1) {
			turnOver = p2.takeTurn(p1);
		}

		if (turnOver == true) {

			turnOver = false;
			cardDraw = true;
			turnCount++;
		}

		if (p1.hasWon(p2)) {
			// font.draw(batch, "Player 1 Wins", 0, 350);
		}

		if (p2.hasWon(p1)) {
			// font.draw(batch, "Player 2 Wins", 0, 350);
		}

		// font.draw(batch, p1.selectedItem + " " + p1.selectedActor, 0, 300);
		// font.draw(batch, p1.AP + "", 0, 450);

	}

	/*
	 * public void disableInput() { for (int i = 0; i < p1.field.getFieldSize();
	 * i++) { // p1.field.returnCard(i).; } // for enemy field // for p field //
	 * for p hand }
	 */
	public void addToDeck(Deck deck, Card card) {
		deck.addCard(card);

		card.setOrigin(card.getWidth() / 2, card.getHeight() / 2);
		card.rotateCard();
		card.setX(80);
		card.setY(720 - 145);
		card.setPosition(card.getX(), card.getY());
		card.positionChanged();

		Game.stage.addActor(deck.deck.peek());
	}

}
