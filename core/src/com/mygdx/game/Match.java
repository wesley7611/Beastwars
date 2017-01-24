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
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;

import cards.*;

public class Match {

	Player p1;
	Player p2;
	APMeter p1m;

	boolean cardDraw;
	boolean turnOver;
	// boolean textDisplay;
	int turnCount;
	SpriteBatch batch;
	BitmapFont font;
	// SpriteBatch HP;
	int screenHeight = 720;
	int screenWidth = 1280;
	Actor textBox;
	int maxAP = 40;

	public Stage stage;
	boolean end;

	TurnDisplay tDisplay;

	Texture board;

	// LargeDisplay large;

	public Match(SpriteBatch batch, Stage stage) {

		tDisplay = new TurnDisplay();

		p1 = new PlayerLocal("Player 1", stage);
		p2 = new PlayerCPU("CPU");
		this.stage = stage;
		this.batch = batch;
		font = new BitmapFont();
		// HP = new SpriteBatch();

		cardDraw = true;
		turnCount = 0;
		turnOver = false;

		board = new Texture(Gdx.files.internal("board.png"));

		/*
		 * this.font = new BitmapFont(); this.font.setColor(0, 0, 0, 255);
		 */

		// /////////CREATE DECKS -- TEST--/////

		// Creates two decks, one for each player. for the hack only
		for (int i = 0; i < p1.deck.deckSize; i++) {
			Card card;
			Random r = new Random();
			int x = r.nextInt(17);
			if (x == 0) {
				card = new CardBear(p1, stage);
				// p1.deck.addCard(card);
			} else if (x == 1) {
				card = new CardLion(p1, stage);
				// p1.deck.addCard(card);
			} else if (x == 2) {
				card = new CardFrog(p1, stage);
				// p1.deck.addCard(card);
			} else if (x == 3) {
				card = new CardPepe(p1, stage);
				// p1.deck.addCard(card);
			} else if (x == 4) {
				card = new CardEuthanise(p1);
			} else if (x == 5) {
				card = new CardSquirrel(p1, stage);

			} else if (x == 6) {
				card = new CardAttUp(p1);
			} else if (x == 7) {
				card = new CardDefUp(p1);
			} else if (x == 8) {
				card = new CardBadger(p1, stage);
			} else if (x == 9) {
				card = new CardChimpanzee(p1, stage);
			} else if (x == 10) {
				card = new CardStag(p1, stage);
			} else if (x == 11) {
				card = new CardRat(p1, stage);
			} else if (x == 12) {
				card = new CardEuthanise(p1);
			} else if (x == 13) {
				card = new CardFox(p1, stage);
			} else if (x == 14) {
				card = new CardFrog(p1, stage);
			} else if (x == 15) {
				card = new CardHeal(p1);
			} else if (x == 16) {
				card = new CardMinnow(p1, stage);
			} else if (x == 17) {
				card = new CardPidgeon(p1, stage);
			} else if (x == 17) {
				card = new CardKermit(p1, stage);
			} else if (x == 17) {
				card = new CardHarambe(p1, stage);
			} else if (x == 17) {
				card = new CardShrek(p1, stage);
			} else {
				card = new Card(p1);
			}
			p1.deck.addCard(card);
			card.setX(1280 - 185);
			card.setY(20);
			card.setPosition(card.getX(), card.getY());
			card.positionChanged();

			stage.addActor(p1.deck.deck.peek());
		}

		for (int i = 0; i < p2.deck.deckSize; i++) {
			Card card;
			Random r = new Random();
			int x = r.nextInt(4);
			if (x == 0) {
				card = new CardBear(p2, stage);
				// p1.deck.addCard(card);
			} else if (x == 1) {
				card = new CardLion(p2, stage);
				// p1.deck.addCard(card);
			} else if (x == 2) {
				card = new CardFrog(p2, stage);
				// p1.deck.addCard(card);
			} else if (x == 3) {
				card = new CardPepe(p2, stage);
				// p1.deck.addCard(card);
			} else {
				card = new Card(p2);
			}

			// card.setPosition(1280 - 140, 720 - 180);
			System.out.println(card.getWidth());
			card.setOrigin(card.getWidth() / 2, card.getHeight() / 2);
			card.rotateCard();
			card.setX(80);
			card.setY(720 - 145);
			card.setPosition(card.getX(), card.getY());
			card.positionChanged();

			p2.deck.addCard(card);

			stage.addActor(p2.deck.deck.peek());

		}

		// MVP ENEMY CARDS
		addToDeck(p2.deck, new CardHarambe(p2, stage));
		addToDeck(p2.deck, new CardFox(p2, stage));
		addToDeck(p2.deck, new CardStag(p2, stage));
		addToDeck(p2.deck, new CardPidgeon(p2, stage));

		// /////
		// match = new Match(p1, p2);

		p1.initialisePlayer(stage);
		p2.initialisePlayer(stage);

		stage.addActor(tDisplay);
		// end = false;

	}

	public void act() {
		batch.draw(board, 0, 0);
		font.draw(batch, "HEUEHE", 0, 500);
		stage.draw();

		if (cardDraw == true && turnCount % 2 == 0) {
			// end = true;
			tDisplay.player1Texture();
			// if(==true){
			tDisplay.scroll();
			cardDraw = p1.drawFromDeck();
			// }

		}

		if (turnCount % 2 == 0) {
			turnOver = p1.takeTurn(p2);
		}
		// if 2
		if (cardDraw == true && turnCount % 2 == 1) {
			tDisplay.player2Texture();
			cardDraw = p2.drawFromDeck();
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
			font.draw(batch, "Player 1 Wins", 0, 350);
		}

		if (p2.hasWon(p1)) {
			font.draw(batch, "Player 2 Wins", 0, 350);
		}

		font.draw(batch, p1.selectedItem + " " + p1.selectedActor, 0, 300);
		font.draw(batch, p1.AP + "", 0, 450);

	}
	/*
	public void disableInput() {
		for (int i = 0; i < p1.field.getFieldSize(); i++) {
			// p1.field.returnCard(i).;
		}
		// for enemy field
		// for p field
		// for p hand
	}
	*/
	public void addToDeck(Deck deck, Card card) {
		deck.addCard(card);

		card.setOrigin(card.getWidth() / 2, card.getHeight() / 2);
		card.rotateCard();
		card.setX(80);
		card.setY(720 - 145);
		card.setPosition(card.getX(), card.getY());
		card.positionChanged();

		stage.addActor(deck.deck.peek());
	}

}
