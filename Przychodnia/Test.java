package Przychodnia;

import java.util.Date;
public class Test {

	public static void main(String[]args){
		

		Lekarz janKowalski = new Lekarz("Jan", "Kowalski", "88101105677", new Specjalnosc[]{Specjalnosc.LARYNGOLOG, Specjalnosc.INTERNISTA});
		
		System.out.println(janKowalski);
		
		Gabinet gabinet5 = new Gabinet(5);
		
		System.out.println(gabinet5.getNumer());
		
		Date dataWizyty1 = new Date(2017, 11, 15, 9, 30);
		
		Wizyta wizyta1 = new Wizyta(janKowalski, Specjalnosc.INTERNISTA, dataWizyty1, 20, gabinet5);
		
		System.out.println(SystemPrzychodni.wyswietlWszystkieWizyty(new Date(2017, 11, 15), Specjalnosc.INTERNISTA).get(0));

		System.out.println(janKowalski.getGrafik().get(dataWizyty1));
		
		System.out.println(gabinet5.getWizyty(new Date(2017, 11, 15, 9, 30)).get(0));
		
		System.out.println("Test tworzenia grafika");
		
		Date poczatekWizyty = new Date(2017, 11, 22, 9, 0);
		Date koniecDnia = new Date(2017, 11, 22, 17, 0);
		SystemPrzychodni.tworzGrafik(janKowalski, Specjalnosc.INTERNISTA, gabinet5, new Date(2017, 11, 22, 9, 0), new Date(2017, 11, 22, 17, 0), 20);
		
		System.out.println("Wyświetlanie listy wizyt lekarza");
		System.out.println(janKowalski.getGrafik().get(new Date(2017, 11, 22, 9, 0)));

		System.out.println(SystemPrzychodni.wyswietlWszystkieWizyty(new Date(2017, 11, 22), Specjalnosc.INTERNISTA));
		
		//Dodawanie pacjenta
		
		Pacjent jacekSoplica = new Pacjent("Jacek","Soplica", "34090834567");
		
		SystemPrzychodni.rezerwujWizyte(SystemPrzychodni.wyswietlDostepneWizyty(new Date(2017, 11, 22), Specjalnosc.INTERNISTA)[0], jacekSoplica);
		System.out.println("Wizyta zarezerwowana: ");
		System.out.println(jacekSoplica.getWizyty().get(0));
		SystemPrzychodni.rezerwujWizyte(SystemPrzychodni.wyswietlDostepneWizyty(new Date(2017, 11, 22), Specjalnosc.INTERNISTA)[2], jacekSoplica);
		System.out.println("Wizyta zarezerwowana: ");
		System.out.println(jacekSoplica.getWizyty().get(1));
		
		System.out.println("5 dostępnych wizyt: ");
		System.out.println(SystemPrzychodni.wyswietlDostepneWizyty(new Date(2017, 11, 22), Specjalnosc.INTERNISTA)[0]);
		System.out.println(SystemPrzychodni.wyswietlDostepneWizyty(new Date(2017, 11, 22), Specjalnosc.INTERNISTA)[1]);
		System.out.println(SystemPrzychodni.wyswietlDostepneWizyty(new Date(2017, 11, 22), Specjalnosc.INTERNISTA)[2]);
		System.out.println(SystemPrzychodni.wyswietlDostepneWizyty(new Date(2017, 11, 22), Specjalnosc.INTERNISTA)[3]);
		System.out.println(SystemPrzychodni.wyswietlDostepneWizyty(new Date(2017, 11, 22), Specjalnosc.INTERNISTA)[4]);
		}
}
