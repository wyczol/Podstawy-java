package Przychodnia;

import java.util.ArrayList;

public class Pacjent {

	private String imie;
	private String nazwisko;
	private String pesel;
	private ArrayList<Wizyta> listaWizyt;
	
	public Pacjent(String imie, String nazwisko, String pesel){
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		listaWizyt = new ArrayList<Wizyta>();
	}	
	
	public String getImie(){
		return imie;
	}
	
	public String getNazwisko(){
		return nazwisko;
	}
	
	public String getPesel(){
		return pesel;
	}
	
	public ArrayList<Wizyta> getWizyty(){
		return listaWizyt;
	}
	
	public void dodajWizyte(Wizyta wizyta){
		listaWizyt.add(wizyta);
	}	
	
	public void usunWizyte(Wizyta wizyta){
		listaWizyt.remove(wizyta);
	}
}
