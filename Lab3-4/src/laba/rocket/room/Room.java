package laba.rocket.room;
import laba.people.*;


public class Room{
	private Type type;
	private final String name;
	public Room(Type type, String name){
		this.type = type;
		this.name = name;
	}
	public String toString(){
		return name;
	}
	public Type getType(){
		return type;
	}
	public boolean equals(Room room){
		if(type == room.getType() && name.equals(room.toString())){
			return true;
		}
		return false;
	}
}