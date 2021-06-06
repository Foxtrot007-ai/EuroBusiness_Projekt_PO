import java.util.List;

public class Plansza {
	private List<Pole> plansza;
	public Plansza()
	{
		boolean temp;
		temp = plansza.add(new Pole_mieszkalne("Berlin", "niebieski", 200));
		temp = plansza.add(new Pole_mieszkalne("Bayern", "niebieski", 200));
		temp = plansza.add(new Pole_mieszkalne("Drezno", "niebieski", 200));
		temp = plansza.add(new Pole_specjalne("Zoo", 200));
		//tutaj inicjalizacja calej planszy
	}
	
	public int ile_domków(String nazwa)
	{
		for (Pole pole : plansza) {
			if(pole.nazwa == nazwa)
				return pole.ilosc_domkow_pola();
		}
		return -1;
	}
	
	public void dodaj_domek(String nazwa)
	{
		for (Pole pole : plansza) {
			if(pole.nazwa == nazwa)
			pole.dodaj_domek();
		}
		
	}
	
	public void usun_domek(String nazwa)
	{
		for (Pole pole : plansza) {
			if(pole.nazwa == nazwa)
			pole.usun_domek();
		}
	}
	
}
