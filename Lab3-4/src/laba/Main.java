package laba;
import laba.rocket.*;
import laba.rocket.room.*;
import laba.people.*;
import laba.space.objects.*;
import laba.timeline.*;
public class Main{

	public static void main(String[] args){
		try{
			Timeline.setTime(0);
			
			Room cabin = new Room(Type.CABIN, "Кабина");
			Room foodStorage = new Room(Type.FOODSTORAGE, "Пищевой блок");
			Room space = null;
			Fool fool = new Fool(3, 10, cabin, "Незнайка");
			Donut donut = new Donut(2, cabin, "Пончик");
			SpaceObject earth = new Earth(6400);
			Moon moon = new Moon(1740, 400000, earth);
			Rocket rocket = new Rocket(12, moon);

			rocket.addPasseger(fool);
			rocket.addPasseger(donut);
			rocket.addRoom(cabin);
			rocket.addRoom(foodStorage);

			System.out.println(rocket.toString() + ".");
			fool.seems(moon.getOrbit(), rocket.getVelosity());
			moon.orbitInfo();
			Human[] passegers = rocket.getPassegers();
			for(int i = 0; i<=3; i++){
				donut.sleep();
				fool.lookAt(moon);
				for(Human human : passegers){
					if(human.isHungryNow()){
						human.goTo(foodStorage);
						human.eat();
					}
				}
				Timeline.increaseTime();
			}
		}catch(SpeedException e){
			System.out.println(e.getMessage());
		}
	}	
}