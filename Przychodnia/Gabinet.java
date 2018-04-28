package Przychodnia;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Gabinet {

	private int numerGabinetu;
	private HashMap<Date, ArrayList<Wizyta>> grafik = new HashMap<Date, ArrayList<Wizyta>>();

	public Gabinet(int numer) {
		numerGabinetu = numer;
	}

	public int getNumer() {
		return numerGabinetu;
	}

	public void dodajDoGrafika(Wizyta wizyta) {
		if (grafik.get(wizyta.getData()) == null) {
			grafik.put(wizyta.getData(), new ArrayList<Wizyta>());
		}
		grafik.get(wizyta.getData()).add(wizyta);
	}
	
	public ArrayList<Wizyta> getWizyty(Date data){
		return grafik.get(data);
	}
}
