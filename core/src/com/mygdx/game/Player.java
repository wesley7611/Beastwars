/**
* Player class is an abstration of the two participating players. 
* Handles the individual stats and turn procedure of each player.
* 
*
* @author  Philip Wesley
* @version 1.0
* @since   2016-11-25 
*/
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import cards.ActorCard;
import cards.Card;
import cards.ItemCard;

public abstract class Player {
	String name;
	Deck deck;
	Hand hand;
	Field field;
	Boolean isDefeated;
	int AP;
	int APperTurn;
	int maxAP;
	float meterX;
	float meterY;
	float fy; // FIELD Y
	protected float APCounterNextY;

	APMeter meter;
	

	// TEST
	protected ActorCard selectedActor;
	protected ItemCard selectedItem;

	public Player(String name) {
		fy = 415;
		meterY=685;
		meterX = 30;
		this.name = name;
		isDefeated = false;
		AP = 0;
		APperTurn = 10;
		maxAP = 20;
		// create the players card piles
		deck = new Deck();
		hand = new Hand();
		field = new Field();
		meter = new APMeter(maxAP);
		APCounterNextY = -20;

		
	}

	public Field returnField(){
		return field;
	}
	// /check return value...
	public boolean drawFromDeck() { // draw card from deck, if deck isnt empty
		Card draw = deck.drawCard();
		if (draw != null) {
			draw.toFront();
			draw.flipFront();
			hand.addCard(draw);

		}
		return false;
	}

	protected void playFromHand(int card) { // play card from hand
		if (hand.returnCard(card).returnType() == 1 && !field.isFieldFull()) { // if
																				// actor
																				// card,
																				// remove
																				// from
																				// hand,
																				// add
																				// to
																				// field
			Card toPlay = hand.returnCard(card);
			hand.removeCard(card);
			field.add((ActorCard) toPlay, fy);
			hand.reallignHand();
		}

		else if (hand.returnCard(card).returnType() == 2) { // if item card,
															// remove from hand,
															// use ability,
															// discard
			// use item
		}
	}

	public Card discardFieldCard(int card) {
		Card discarded = field.returnCard(card);
		field.returnCard(card).setVisible(false);
		field.remove(card);
		field.reallignField();
		return discarded;
	}

	public void initialisePlayer(Stage stage) {
		// draw 7 cards from deck to hand
		for (int i = 0; i < 7; i++) {
			drawFromDeck();
		}
		createMeter(stage, APCounterNextY);
	}

	public abstract boolean takeTurn(Player enemy);

	public boolean hasWon(Player enemy) {
		// checks enemy field to see if all cards in play have been defeated
		return enemy.field.fieldIsDefeated();
	}

	public void replenishAP() {
		int upkeep = 0;
		for (int i = 0; i < field.getFieldSize(); i++) {
			upkeep = upkeep + field.returnCard(i).returnUpkeep();
		}
		AP = AP + (APperTurn - upkeep);

		if (AP > maxAP)
			AP = maxAP;
		refreshAP();
	}
	public void refreshAP(){
		if(AP<0)AP=0;
		System.out.println(AP);
		meter.setNumber(AP);
	}

	public int returnAP() {
		return AP;
	}

	public void createMeter(Stage stage, float nextCounterY) {
		for (int i = 0; i < maxAP; i++) {
			meter.returnElement(i).setPosition(meterX, meterY+(i * nextCounterY));
			Game.stage.addActor(meter.returnElement(i));

		}
	}
	public void attackCard(ActorCard source, ActorCard target){
		float endX;
		float endY;
		endX = source.getX();
		endY = source.getY();
		if(source.returnAttackCost()<=AP){
		source.addAction(Actions.sequence(Actions.moveTo(target.getX(), target.getY()-20, (float) 0.1), Actions.moveTo(endX, endY, (float) 0.1)));
		AP = AP - source.attack(target);
		refreshAP();
		}
		selectedActor = null;
	}
	public void itemCard(int itemInt){
		selectedItem.ItemUse(this, itemInt);
		selectedItem.addAction(Actions.moveTo(1400, 800, 1));
		//clearSelection();
		hand.removeCard(itemInt);
		hand.reallignHand();
	}
	protected void statusCheck(){
		for(int i = 0; i<field.getFieldSize(); i++){
			field.returnCard(i).statusCheck();
		}
	}
}
