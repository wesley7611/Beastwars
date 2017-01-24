/**
* Hand class is responsible for containing and managing all cards drawn from the deck into the hand.
* 
*
* @author  Philip Wesley
* @version 1.0
* @since   2016-11-25 
*/
package com.mygdx.game;
import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
//import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

import cards.Card;

public class Hand{
	
	ArrayList<Card> hand;
	
	public Hand(){
	hand = new ArrayList<Card>();
	}
	
	public void addCard(Card card){
		
		
		card.addAction(Actions.moveTo(225+hand.size()*card.getWidth(), card.getY(), 1));
		hand.add(card);
		
	}
	public Card removeCard(int number){
		Card card = hand.get(number);
		hand.remove(number);
		return card;
	}
	public Card returnCard(int number){
		return hand.get(number);
	}
	public int handSize(){
		return hand.size();
	}
	public void reallignHand(){
		for(int i=0; i<hand.size(); i++){
			hand.get(i).addAction(Actions.moveTo(225+i*hand.get(i).getWidth(), hand.get(i).getY(), 1));
		}
	}

}
