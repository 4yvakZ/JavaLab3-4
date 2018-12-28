package laba.people;
import laba.timeline.*;
import laba.rocket.room.*;
public class Human{
	protected final String name;
	protected int timeUntilHunger;
	protected int lastMealTime = 0;
	protected Room room;
	public Human(int timeUntilHunger, Room room){
		this.timeUntilHunger = timeUntilHunger;
		this.name = "Эй ты";
		try{
			if(room == null){
				throw new NullPointerException();
			}
			this.room = room;
		}catch(NullPointerException e){
			throw new RoomException(name, e);
		}
	}
	public Human(String name,int timeUntilHunger, Room room){
		this.timeUntilHunger = timeUntilHunger;
		this.name = name;
		try{
			if(room == null){
				throw new NullPointerException();
			}
			this.room = room;
		}catch(NullPointerException e){
			throw new RoomException(name, e);
		}
	}
	public boolean isHungryNow(){
		if (Timeline.getCurrentTime() - lastMealTime + 1 > timeUntilHunger){
			return true;
		}
		return false;
	}
	public void goTo(Room room){
		if(!this.room.equals(room)){
			this.room = room;
			System.out.println(Integer.toString(Timeline.getCurrentTime()) + " часов: " + name + ": пошёл в " + room.toString() + ".");
		}
	}

	public void eat(){
		if(room.getType() == Type.FOODSTORAGE){
			System.out.println(Integer.toString(Timeline.getCurrentTime()) + " часов: " + name + ": ест, находясь в " + room.toString() + ".");
			lastMealTime = Timeline.getCurrentTime();
		}
	}

	public Room getRoom(){
		return room;
	}

	public String getName(){
		return name;
	}

	public int getTimeUntilHunger(){
		return timeUntilHunger;
	}

	public int getLastMealTime(){
		return lastMealTime;
	}

	public String toString(){
		return name;
	}

	public boolean equals(Human human){
		if(room.equals(human.getRoom()) && name.equals(human.getName()) && lastMealTime == human.getLastMealTime() && timeUntilHunger == human.getTimeUntilHunger()){
			return true;
		}
		return false;
	}
}