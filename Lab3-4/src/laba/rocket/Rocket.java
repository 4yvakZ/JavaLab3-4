package laba.rocket;
import laba.space.objects.*;
import laba.people.Human;
import laba.rocket.room.*;
public class Rocket{
	private int velosity;
	private int numberOfPassegers = 0;
	private Human passegers[];
	private Room rooms[];
	private int numberOfRooms = 0;
	private SpaceObject target;

	public Rocket(int velosity, SpaceObject target) throws SpeedException{
		if(velosity < 0){
			throw new SpeedException(velosity);
		}
		this.velosity = velosity;
		this.target = target;
	}

	public void addPasseger(Human human){
		numberOfPassegers ++;
		if(numberOfPassegers > 1){
			Human passegers1[] = passegers;
			passegers = new Human[numberOfPassegers];
			for(int i = 0; i < numberOfPassegers - 1; i++){
				passegers[i] = passegers1[i];
			}
			passegers[numberOfPassegers - 1] = human;
		} else {
			passegers = new Human[1];
			passegers[0] = human;
		}
	}

	public Human[] getPassegers(){
		return passegers;
	}

	public int getVelosity(){
		return velosity;
	}
	
	public int getNumberOfRooms(){
		return numberOfRooms;
	}

	public int getNumberOfPassegers(){
		return numberOfPassegers;
	}

	public SpaceObject getTarget(){
		return target;
	}

	public void addRoom(Room room){
		numberOfRooms ++;
		if(numberOfRooms > 1){
			Room rooms1[] = rooms;
			rooms = new Room[numberOfRooms];
			for(int i = 0; i < numberOfRooms - 1; i++){
				rooms[i] = rooms1[i];
			}
			rooms[numberOfRooms - 1] = room;
		} else {
			rooms = new Room[1];
			rooms[0] = room;
		}
	}	

	public Room[] getRooms(){
		return rooms;
	}

	public String toString(){
		return "Ракета летит со скоростью " + Integer.toString(velosity) + " км/с";
	}

	public boolean equals(Rocket rocket){
		if(velosity == rocket.getVelosity() && numberOfRooms == rocket.getNumberOfRooms() && numberOfPassegers == rocket.getNumberOfPassegers() && target.equals(rocket.getTarget())){
			Human passegers1[] = rocket.getPassegers();
			Room rooms1[] = rocket.getRooms();
			for(int i = 0; i<numberOfPassegers; i++){
				if(!passegers[i].equals(passegers1[i])){
					return false;
				}
			}
			for(int i = 0; i<numberOfRooms; i++){
				if(!rooms[i].equals(rooms1[i])){
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
