package laba.timeline;
import laba.rocket.*;
public abstract class Timeline{
	static private int currentTime;
	
	static public void setTime(int currentTime){
		currentTime = currentTime;
	}

	static public void increaseTime(){
		currentTime++;
	}

	static public int getCurrentTime(){
		return currentTime;
	}
}