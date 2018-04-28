package Przychodnia;

import java.util.HashMap;
import java.util.Date;
import java.util.ArrayList;

public class SystemPrzychodni {

	private static HashMap<Date, HashMap<Specjalnosc, ArrayList<Wizyta>>> grafik = new HashMap<Date, HashMap<Specjalnosc, ArrayList<Wizyta>>>();
	private static HashMap<String, Pracownik> pracownicy = new HashMap<String, Pracownik>();
	private static HashMap<String, Pacjent> pacjenci = new HashMap<String, Pacjent>();

	/**
	 * Metoda dodaje wizytę do grafika
	 * @param wizyta
	 */
	public static void dodajDoGrafika(Wizyta wizyta) {
		Date klucz = new Date(wizyta.getData().getYear(), wizyta.getData().getMonth(), wizyta.getData().getDate());
		if(grafik.get(klucz)== null){
			grafik.put(klucz, new HashMap<Specjalnosc, ArrayList<Wizyta>>());
		}
		if(grafik.get(klucz).get(wizyta.getSpecjalnosc()) == null){
			grafik.get(klucz).put(wizyta.getSpecjalnosc(), new ArrayList<Wizyta>());
		}
		grafik.get(klucz).get(wizyta.getSpecjalnosc()).add(wizyta);
	}
	
	/**
	 * 
	 * @param data Data wyszukiwanej wizyty
	 * @param specjalnosc W jakiej specjalności ma się znaleźć dana wizyta
	 * @return Zwraca listę wizyt spełniających podane kryteria.
	 */
	public static ArrayList<Wizyta> wyswietlWszystkieWizyty(Date data, Specjalnosc specjalnosc){
		return grafik.get(data).get(specjalnosc);
	}
	
	public static Wizyta[] wyswietlDostepneWizyty(Date data, Specjalnosc specjalnosc){
		Wizyta[] dostepneWizyty = new Wizyta[5];
		int j = 0;
		for(int i = 0; i < dostepneWizyty.length; i++){
			while(dostepneWizyty[i] == null){
				if(!grafik.get(data).get(specjalnosc).get(j).zarezerwowana()){
					dostepneWizyty[i] = grafik.get(data).get(specjalnosc).get(j);
				
				}
				j++;
			}
		}
		return dostepneWizyty;
	}
	
	/**
	 * Tworzy grafik dla danego lekarza, wypełniając go wizytami o określonej długości od momentu "początek wizyty" do momentu "koniec dnia".
	 * @param lekarz
	 * @param specjalnosc
	 * @param gabinet
	 * @param poczatekWizyty
	 * @param koniecDnia
	 * @param dlugoscWizyty
	 */
	
	public static void tworzGrafik(Lekarz lekarz, Specjalnosc specjalnosc, Gabinet gabinet, Date poczatekWizyty, Date koniecDnia, int dlugoscWizyty){
		while(poczatekWizyty.before(koniecDnia)){
			new Wizyta(lekarz, specjalnosc, new Date(poczatekWizyty.getYear(), poczatekWizyty.getMonth(), poczatekWizyty.getDate(), poczatekWizyty.getHours(), poczatekWizyty.getMinutes()), dlugoscWizyty, gabinet);	
			poczatekWizyty.setMinutes(poczatekWizyty.getMinutes() + dlugoscWizyty);	
		}
	}
	
	/**
	 * Rezerwuje wizytę dla danego pacjenta. 
	 * @param wizyta
	 * @param pacjent
	 */
	public static void rezerwujWizyte(Wizyta wizyta, Pacjent pacjent){
		if(!wizyta.zarezerwowana())
			wizyta.setPacjent(pacjent);
	}	
	
	public static void odwolajWizyte(Wizyta wizyta){
		if(wizyta.zarezerwowana())
			wizyta.odwolaj();
	}
}
