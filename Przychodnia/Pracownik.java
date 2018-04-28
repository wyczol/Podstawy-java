package Przychodnia;

import java.util.Date;

public abstract class Pracownik {
	
	protected String imie;
	protected String nazwisko;
	protected String pesel;
	
	public String getImie(){
		return imie;
	}
	
	public String getNazwisko(){
		return nazwisko;
	}
	
	public String getPesel(){
		return pesel;
	}
}
