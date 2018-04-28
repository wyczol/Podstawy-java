package Przychodnia;

import java.util.Date;
import java.util.HashMap;

public class Lekarz extends Pracownik {
	
	private Specjalnosc[] specjalnosci;
	private HashMap<Date, Wizyta> grafik;
	
	public Lekarz(String imie, String nazwisko, String pesel, Specjalnosc[] specjalnosci){
		this.imie = imie;
		this.nazwisko = nazwisko;		
		this.pesel = pesel;
		this.specjalnosci = specjalnosci;
		grafik = new HashMap<Date, Wizyta>();
	}	
	
	public HashMap<Date, Wizyta> getGrafik(){
		return grafik;
	}
	
	public void dodajDoGrafika(Wizyta wizyta){
		grafik.put(wizyta.getData(), wizyta);
	}
	
	@Override
	public String toString(){
		String output = "Lekarz " + imie + " " + nazwisko + " o nr PESEL " + pesel + " ma specjalnosci";
		for(int i = 0; i < specjalnosci.length; i++){
			output += " " + specjalnosci[i];
		}
		return output;
	}
}
