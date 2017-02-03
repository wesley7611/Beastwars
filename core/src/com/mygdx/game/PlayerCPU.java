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

	// source.addAction(Actions.sequence(Actions.moveTo(target.getX(),
	// target.getY()-20, (float) 0.1), Actions.moveTo(endX, endY, (float)
	// 0.1)));

	// test
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
				
				Game.inputEnabled=true;
				sequence.reset();
				
			}
		});
	}

	/*
	 * addAction(Actions.sequence(Actions.moveTo((Game.screenWidth-sprite.getWidth
	 * ())/2,getY(), (float) 2), Actions.delay(1f),
	 * Actions.moveTo(Game.screenWidth+sprite.getWidth(), getY(), 2),
	 * Actions.run(new Runnable() { public void run () { completed = true; } })
	 * ));
	 */

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
		
		Game.stage.addAction(sequence);
		return sequence.act(0f);

		/*
		 * if(done=true)return true; else return false;
		 */
		/*
		 * while(field.getFieldSize()<4){ playFromHand(0); }
		 * 
		 * if (field.isFieldFull()) { Random r = new Random(); int x =
		 * r.nextInt(4); int y = r.nextInt(enemy.field.getFieldSize()); if
		 * (field.returnCard(x) != null && field.returnCard(x).isDefeated() ==
		 * false && enemy.field.returnCard(y).isDefeated() == false) { //
		 * field.returnCard(x).attack(enemy.field.returnCard(y));
		 * attackCard(field.returnCard(x), enemy.field.returnCard(y));
		 * replenishAP(); Game.inputEnabled=true; return true; } } return false;
		 */

	}

}
