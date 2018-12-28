package laba.rocket;

public class SpeedException extends Exception{
	private int velosity;
	public SpeedException(int velosity){
		this.velosity = velosity;
	}
	public String getMessage(){
		return "Скорость ракеты должна быть положительной\n"+ "Введённое значение: "+velosity;
	}
}