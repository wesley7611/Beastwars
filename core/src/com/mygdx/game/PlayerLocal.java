/**
 * PlayerLocal is the player's main player class. Handles player turn based on user input
 * and allows for user control against AI or network opponent.
 * 
 *
 * @author  Philip Wesley
 * @version 1.0
 * @since   2016-11-25 
 */
package com.mygdx.game;

import cards.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

public class PlayerLocal extends Player {

	int selectedItemInt;
	LargeDisplay large;
	SelectionMarker marker;
	TurnDisplay tDisplay;
	SequenceAction sequence;
	
	boolean firstAction;

	public PlayerLocal(String name) {
		super(name);
		APCounterNextY = 20;
		fy = 180;
		meterX = 1228;
		meterY = 25;
		large = new LargeDisplay();
		large.positionChanged();

		marker = new SelectionMarker();
		
		sequence = new SequenceAction();

		Game.stage.addActor(large);
		Game.stage.addActor(marker);
		
		firstAction = true;
		
		tDisplay = new TurnDisplay(new Texture(Gdx.files.internal("PTurn.png")));
		Game.stage.addActor(tDisplay);
	}

	/**
	 * takeTurn handles user input and enables user interaction to carry out
	 * their turn
	 */
	public boolean takeTurn(Player enemy) {
		/*
		 *RUN ONCE - DRAW CARD AND TURN DISPLAY 
		 * 
		 */
		if(firstAction==true){
			
			sequence.addAction(new RunnableAction() {
				public void run() {
					tDisplay.toFront();
					tDisplay.scroll();
					//drawFromDeck();
				}
			});
			sequence.addAction(Actions.delay(650f));
			
			sequence.addAction(new RunnableAction() {
				public void run() {
					drawFromDeck();
					
				}
			});
			
			sequence.addAction(Actions.delay(300f));
			sequence.addAction(new RunnableAction() {
				public void run() {
					
					statusCheck();
					
				}
			});
			sequence.addAction(new RunnableAction() {
				public void run() {
					
					Game.inputEnabled=true;
					
				}
			});
			
			
			firstAction=false;
			
		}
		Game.stage.addAction(sequence);
		
		if (Game.inputEnabled == true) {
			// Checks for input on card in hand
			for (int i = 0; i < hand.handSize(); i++) {
				if (hand.returnCard(i).isHovered()) {
					large.toFront();
					large.sprite.setTexture(hand.returnCard(i).returnFront());
					// large.setSprite();
					large.setVisible(true);
				}

				if (hand.returnCard(i).isPressed()) {
					large.setVisible(false);
					if (hand.returnCard(i).isActor()) {
						clearSelection();
						// selectedItemInt=null;
						playFromHand(i);

					} else if (hand.returnCard(i).isItem()) {
						if (selectedItem == hand.returnCard(i)) {
							this.selectedItem = null;
							clearSelection();
						} else {
							if (selectedItem != null) {

								// SET MARKER TO NEW ITEM
								marker.selectCard(hand.returnCard(i));
								selectedItemInt = i;

							}
							// HERE
							clearSelection();
							this.selectedItem = (ItemCard) hand.returnCard(i);
							marker.selectCard(hand.returnCard(i));
							selectedItemInt = i;
						}

					}

				}

			}

			for (int i = 0; i < field.getFieldSize(); i++) {
				if (field.returnCard(i).isPressed()) {
					if (selectedItem != null) {
						selectedItem.ItemUse(this, i);
						
						/*
						 * Sends used item card off screen, removes it and realligns hand
						 */
						selectedItem.addAction(Actions.moveTo(1400, 800, 1));
						hand.removeCard(selectedItemInt);
						hand.reallignHand();
						
						clearSelection();
					} else if (selectedActor == field.returnCard(i)) {
						clearSelection();

					} else {
						if(field.returnCard(i).canAct()){
						this.selectedActor = field.returnCard(i);
						marker.selectCard(field.returnCard(i));}
					}
				}

			}

			// checks for inputon cards in enemt field
			for (int i = 0; i < enemy.field.getFieldSize(); i++) {
				if (enemy.field.returnCard(i).isPressed()
						&& selectedActor != null
						&& AP >= selectedActor.returnAttackCost()) {
					attackCard(selectedActor, enemy.field.returnCard(i));
					clearSelection();
				}
			}

			// checks to see if enter hit to end turn
			if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {

				if (!field.isFieldEmpty()) {
					replenishAP();
					Game.inputEnabled=false;
					firstAction=true;
					sequence.reset();
					return true;
				}
			}
			
		}
		return false;
	}

	private void clearSelection() {
		selectedActor = null;
		selectedItem = null;
		// selectedItemInt=(Integer) null;
		marker.setVisible(false);
	}

}
