package laba.people;

import laba.rocket.room.*;
import laba.timeline.*;

public class Donut extends Human{
	public Donut(int timeUntilHunger, Room room, String name){
		super(name, timeUntilHunger, room);
	}
	public void sleep(){
		Dream dream = new Dream(){
			public void sleep(){
				System.out.println(Integer.toString(Timeline.getCurrentTime()) + " часов: " + name + ": спит, находясь в " + room.toString() + ".");
			}
			public void wakeUp(){
				System.out.println(Integer.toString(Timeline.getCurrentTime()) + " часов: " + name + ": проснулся, находясь в " + room.toString() + ".");
			}
		};
		if (!(Timeline.getCurrentTime() - lastMealTime + 1 > timeUntilHunger)){
			dream.sleep();
		} else {
			dream.wakeUp();
		}
	}
	public void eat(){
		class DonutFood{
			private String name;
			public DonutFood(){
				name = "Пышка";
			}
			public DonutFood(String name){
				this.name = name;
			}
			public String getName(){
				return name;
			}
			public String toString(){
				return name;
			}
			public boolean equals(DonutFood food){
				if(name.equals(food.getName())){
					return true;
				}
				return false;
			}
		}
		DonutFood food = new DonutFood();
		if(room.getType() == Type.FOODSTORAGE){
			System.out.println(Integer.toString(Timeline.getCurrentTime()) + " часов: " + name + ": ест "+ food.toString() + ", находясь в " + room.toString() + ".");
			lastMealTime = Timeline.getCurrentTime();
		}
	}
}