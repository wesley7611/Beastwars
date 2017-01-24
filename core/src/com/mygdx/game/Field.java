/**
* Field class is responsible for holding and managing all cards currently in play by player.
* 
* 
*
* @author  Philip Wesley
* @version 1.0
* @since   2016-11-25 
*/

package com.mygdx.game;
import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import cards.ActorCard;
import cards.Card;


public class Field {
	ArrayList<ActorCard> field;
	
	public Field(){
		field = new ArrayList<ActorCard>(4);
	}
	
	public void add(ActorCard card, float fy){
		
		card.addAction(Actions.moveTo((field.size()*card.getWidth())+(field.size()*22)+390, fy, (float) 1));
		field.add(card);
	}
	public Card remove(int i){
		Card toGet = field.get(i);
		field.remove(i);
		return toGet;
	}
	public boolean isFieldFull(){
		if(field.size() > 3){
			return true;
		}
		return false;
	}
	
	public boolean isFieldEmpty(){
		if(field.size() < 1){
			return true;
		}
		return false;
	}
	
	public ActorCard returnCard(int index){ //return a card object
		return field.get(index);
	}
	
	public int getFieldSize(){
		return field.size();
	}
	
	public boolean fieldIsDefeated(){ //check each card in field to see if defeated, return true or false
		for(int i=0; i<field.size(); i++){
			if(!field.get(i).isDefeated()){
				return false;
			}
		}
		return true;
	}
	public void reallignField(){
		for(int i=0; i<field.size(); i++){
			field.get(i).addAction(Actions.moveTo((i*field.get(i).getWidth())+(i*22)+390, field.get(i).getY(), 1));
			
			//(field.size()*card.getWidth())+(field.size()*22)+390
		}
	}

}
