/**
* Deck class is a collection DT containing all undrawn cards belonging to the player.
* This class is responsible for creating, adding to and shuffling the deck.
* 
*
* @author  Philip Wesley
* @version 1.0
* @since   2016-11-25 
*/
package com.mygdx.game;

import java.util.Collections;
import java.util.Stack;

import cards.Card;

public class Deck {
	int deckSize = 30;
	Stack<Card> deck;
	
	public Deck(){ 
		deck = new Stack<Card>();

	}
	public Card drawCard(){ //if deck has cards, draw one, else returns null
		if(deck.size()>0){
		return deck.pop();
		}
		else{
			return null;
		}
	}
	public void shuffleDeck(){
		Collections.shuffle(deck);
	}
	public void addCard(Card card){
		deck.push(card);
	}
}
