package laba.space.objects;

public abstract class SpaceObject{
	protected final int radius;
	protected final String name;
	public SpaceObject(int radius){
		this.radius = radius;
		name = "Космический объект";
	}

	public SpaceObject(int radius, String name){
		this.name = name;
		this.radius = radius;
	}

	public int getRadius(){
		return radius;
	}

	public String getName(){
		return name;
	}

	public String toString(){
		return name;
	}

	public boolean equals(SpaceObject spaceObject){
		if(radius == spaceObject.getRadius() && name.equals(spaceObject.getName())){
			return true;
		}
		return false;
	}
}