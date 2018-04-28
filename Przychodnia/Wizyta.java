package Przychodnia;

import java.util.Date;

public class Wizyta {
	
	private Lekarz lekarz;
	private Pacjent pacjent;
	private Specjalnosc specjalnosc;
	private Gabinet gabinet;
	private Date data;
	private int czasTrwania;
	private boolean zarezerwowana = false;
	
	public Wizyta(Lekarz lekarz, Specjalnosc specjalnosc, Date data, int czasTrwania, Gabinet gabinet){
		this.lekarz = lekarz;
		this.specjalnosc = specjalnosc;
		this.gabinet = gabinet;
		this.data = data;
		this.czasTrwania = czasTrwania;
		lekarz.dodajDoGrafika(this);
		SystemPrzychodni.dodajDoGrafika(this);	
		gabinet.dodajDoGrafika(this);
	}
	
	public void setPacjent(Pacjent pacjent){
		this.pacjent = pacjent;
		pacjent.dodajWizyte(this);
		zarezerwowana = true;
	}	
	
	public void odwolaj(){
		pacjent.usunWizyte(this);
		pacjent = null;
		zarezerwowana = false;
	}
	
	public Date getData(){
		return data;
	}
	
	public Specjalnosc getSpecjalnosc(){
		return specjalnosc;
	}
	
	public Lekarz getLekarz(){
		return lekarz;
	}
	
	public Pacjent getPacjent(){
		return pacjent;
	}
	
	public Gabinet getGabinet(){
		return gabinet;
	}
	
	public boolean zarezerwowana(){
		return zarezerwowana;
	}
	
	public int getCzasTrwania(){
		return czasTrwania;
	}
	
	@Override
	public String toString(){
		return "Wizyta " + data + " w gabinecie nr " + gabinet.getNumer() + " u lekarza " + lekarz.getImie() + " " + lekarz.getNazwisko();
	}
}
