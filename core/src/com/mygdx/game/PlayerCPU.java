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
	
	// source.addAction(Actions.sequence(Actions.moveTo(target.getX(),
	// target.getY()-20, (float) 0.1), Actions.moveTo(endX, endY, (float)
	// 0.1)));

	public PlayerCPU(String name) {
		super(name);
		turnCount = 0;
		
		run1 = new RunnableAction() {
			public void run() {
				playFromHand(0);
				System.out.println("Action Firing");
			}
		};/*
		run2 = new RunnableAction() {
			public void run() {
				playFromHand(0);
				System.out.println("Action Firing");
			}
		};
		run3 = new RunnableAction() {
			public void run() {
				playFromHand(0);
				System.out.println("Action Firing");
			}
		};
		sequence = new SequenceAction();
		fieldCount =field.getFieldSize();
		fieldFull=false;*/
	}

	public boolean takeTurn(Player enemy) {

		while(field.getFieldSize()<4){
			playFromHand(0);
		}

		if (field.isFieldFull()) {
			Random r = new Random();
			int x = r.nextInt(4);
			int y = r.nextInt(enemy.field.getFieldSize());
			if (field.returnCard(x) != null
					&& field.returnCard(x).isDefeated() == false
					&& enemy.field.returnCard(y).isDefeated() == false) {
				// field.returnCard(x).attack(enemy.field.returnCard(y));
				attackCard(field.returnCard(x), enemy.field.returnCard(y));
				replenishAP();
				Game.inputEnabled=true;
				return true;
			}
		}
		return false;

	}

}
