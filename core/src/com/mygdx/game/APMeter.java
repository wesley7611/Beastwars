/**
* AP Meter class is responsible for providing a visual representation
* of each players AP.
* 
*
* @author  Philip Wesley
* @version 1.0
* @since   2016-11-25 
*/

package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class APMeter {
	List<APCounter> APMeter;
	int maxAP;
	public APMeter(int maxAP) {
		this.maxAP = maxAP;
		APMeter = new ArrayList<APCounter>();
		for(int i = 0; i<maxAP; i++){
			APCounter counter = new APCounter();
			APMeter.add(i, counter);
		}
	}

	public void setNumber(int number) {
		for (int i = 0; i < number; i++) {
			APMeter.get(i).setVisible(true);
			// make counter
			// push coun
		}
		for (int i=number; i<maxAP; i++){
			APMeter.get(i).setVisible(false);
		}
	}
	public int returnSize(){
		return APMeter.size();
	}
	public APCounter returnElement(int index){
		return APMeter.get(index);
	}
}
