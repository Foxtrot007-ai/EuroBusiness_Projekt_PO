import java.util.ArrayList;
import java.util.List;

public class Gracz {

private int liczba_pol_na_planszy;
private int ilosc_pieniedzy;
private List<String> Lista_posiadlosci;
private int nr_pozycji_na_planszy;
private int index;

public Gracz(int wartosc_startowa, int liczba_pol, int i)
{
	ilosc_pieniedzy = wartosc_startowa;
	nr_pozycji_na_planszy = 0;
	liczba_pol_na_planszy = liczba_pol;
	index = i;
	Lista_posiadlosci = new ArrayList<String>();
}

public void dodaj_pieniadze(int ilosc)
{
	ilosc_pieniedzy += ilosc;
}

public void zabierz_pieniadze(int ilosc)
{
	ilosc_pieniedzy -= ilosc;
}

public void dodaj_miasto(String miasto)
{
	if(!Lista_posiadlosci.contains(miasto))
	{
		boolean b = Lista_posiadlosci.add(miasto);
	}
	
}

public void usun_miasto(String miasto)
{
	if(Lista_posiadlosci.contains(miasto))
	{
		boolean b = Lista_posiadlosci.remove(miasto);
	}
}

public void wykonaj_ruch(int ruchy)
{
	nr_pozycji_na_planszy += ruchy;
	nr_pozycji_na_planszy %= liczba_pol_na_planszy;
}

public boolean czy_bankrut()
{
	return ilosc_pieniedzy < 0 && Lista_posiadlosci.isEmpty();
}

public boolean czy_wlasciciel(String miasto)
{
	 return Lista_posiadlosci.contains(miasto);
}

public int ile_pieniedzy()
{
	 return ilosc_pieniedzy;
}

public int aktualne_pole()
{
	 return nr_pozycji_na_planszy;
}
public boolean czy_mozna_budowac(String nazwa, Plansza p)
{
	int licznik = 0;
	int limit;
	if(p.jaki_kolor(nazwa) == "zloty" || p.jaki_kolor(nazwa) == "rozowy") limit = 2;
	else limit = 3;
		for (String s1 : Lista_posiadlosci) {
			if(p.jaki_kolor(nazwa) == p.jaki_kolor(s1))
			{
				licznik++;
			}
		}
		return (licznik == limit);
}
public int numer_gracza()
{
	 return index;
}
public String lista_wlasnosci()
{
	 int iter = 1;
	 String temp = "<p align=\"center\">";
	 for (String s1 : Lista_posiadlosci) {
			temp += s1 + ", ";
			if(iter % 3 == 0) temp += "<br/>";
			iter++;
		}	 
	 temp += "</p>";
	 return temp;
	 
}

}
