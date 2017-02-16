/**
 * PlayerCPU is an extension of the player class, which will handle the player turn as an AI
 * opponent.
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
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

import cards.Card;

//CPU player - For hack, will play first 4 cards from hand and randomly choose one to attack its opposite opponent
public class PlayerCPU extends Player {

	boolean endTurn;

	int card1;
	int card2;
	int card3;
	Card card4;
	Actions A1;
	Actions A2;
	Actions A3;
	Actions A4;
	RunnableAction run1;
	RunnableAction run2;
	RunnableAction run3;
	RunnableAction run4;
	RunnableAction run5;
	RunnableAction run6;
	SequenceAction sequence;
	int fieldCount;
	boolean fieldFull;

	int turnCount;
	
	TurnDisplay tDisplay;

	boolean done = false;
	boolean runOnce = true;

	public PlayerCPU(String name) {
		super(name);
		turnCount = 0;

		sequence = new SequenceAction();

		fieldCount = field.getFieldSize();
		fieldFull = false;
		
		tDisplay = new TurnDisplay(new Texture(Gdx.files.internal("Oturn.png")));
		
		Game.stage.addActor(tDisplay);
		

		/*
		 * CPU Action sequence. Display Turn Text, plays cards to field if
		 * necessary, and then uses attacks until AP is depleted before ending
		 * CPU Turn. Pause between each action.
		 */
		
		/*
		 * Add the player turn scroll text
		 */
		sequence.addAction(new RunnableAction() {
			public void run() {
				tDisplay.toFront();
				tDisplay.scroll();
				
			}
		});
		sequence.addAction(Actions.delay(650f));
		
		sequence.addAction(new RunnableAction() {
			public void run() {
				drawFromDeck();
				
			}
		});
		sequence.addAction(Actions.delay(300f));
		
		// Plays cards to field
		for (int i=0; i<4-field.getFieldSize(); i++) {
			sequence.addAction(new RunnableAction() {
				public void run() {
					playFromHand(0);
					
				}
			});
			sequence.addAction(Actions.delay(200f));
		}
		
		
		/*
		 * Final CPU Action returns control to player
		 */
		sequence.addAction(new RunnableAction() {
			public void run() {
				
				//Game.inputEnabled=true;
				sequence.reset();
				
			}
		});
	}


	/*
	 * Determines which card to next play into hand by CPU, and returns its
	 * index
	 */
	public int selectCard() {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mygdx.game.Player#takeTurn(com.mygdx.game.Player)
	 */
	public boolean takeTurn(Player enemy) {
		//check if hand is full
		
		//if not full, add card
		
		//identify most powerful card
		
		//use that card as many times
		
		//identify second most powerful
		
		//repeat
		
		//add end turn action
		
		Game.stage.addAction(sequence);
		return sequence.act(0f);

	}

}
