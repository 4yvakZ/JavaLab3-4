package laba.people;
import laba.timeline.*;
import laba.space.objects.*;
import laba.rocket.room.*;

public class Fool extends Human{
	private Thumb thumb;

	class Thumb{
		private final int length;
		public Thumb(int length){
			this.length = length;
		}
		public int getLength(){
			return length;
		}
		public boolean equals(Thumb thumb){
			boolean equals = false;
			if (length == thumb.getLength()){
				equals = true;
			}
			return equals;
		}
		public String toString(){
			return "палец";
		}
	}

	public Fool(int timeUntilHunger, int thumbLength, Room room, String name){
		super(name, timeUntilHunger, room);
		thumb = new Thumb(thumbLength);
	}

	public void seems(int distance, int rocketSpeed){
		String str = Integer.toString(Timeline.getCurrentTime()) + " часов: " + name + ": кажется, что ";
		if(distance/rocketSpeed > thumb.getLength()/2){
			str += "ракета стоит на месте";
		}else{
			str += "ракета летит";	
		}
		System.out.println(str + ".");
	}

	public void lookAt(SpaceObject spaceObject){
		System.out.println(Integer.toString(Timeline.getCurrentTime()) + " часов: " + name + ": смотрит на " + spaceObject.toString());
	}
}