import java.util.ArrayList;
import java.util.List;

public class Plansza {
	private List<Pole> plansza;
	public Plansza()
	{
		boolean temp;
		plansza = new ArrayList<Pole>();
		temp = plansza.add(new Pole_mieszkalne("Berlin", "niebieski", 200));
		temp = plansza.add(new Pole_mieszkalne("Bayern", "niebieski", 200));
		temp = plansza.add(new Pole_mieszkalne("Drezno", "niebieski", 200));
		temp = plansza.add(new Pole_specjalne("Zoo", 200));
		//tutaj inicjalizacja calej planszy
	}
	public String jaki_kolor(String nazwa)
	{
		for (Pole pole : plansza) {
			if(pole.nazwa_pola().compareTo(nazwa) == 0)
				return pole.kolor_pola();
		}
		return "";
	}
	
	public int wartosc_pola(String nazwa)
	{
		for (Pole pole : plansza) {
			if(pole.nazwa_pola().compareTo(nazwa) == 0)
				return pole.ile_do_zaplaty();
		}
		return -1;
	}
	
	public int ile_domków(String nazwa)
	{
		for (Pole pole : plansza) {
			if(pole.nazwa_pola().compareTo(nazwa) == 0)
				return pole.ilosc_domkow_pola();
		}
		return -1;
	}
	
	public void dodaj_domek(String nazwa)
	{
		for (Pole pole : plansza) {
			if(pole.nazwa_pola().compareTo(nazwa) == 0)
			pole.dodaj_domek();
		}
		
	}
	
	public void usun_domek(String nazwa)
	{
		for (Pole pole : plansza) {
			if(pole.nazwa_pola().compareTo(nazwa) == 0)
			pole.usun_domek();
		}
	}
	
}
