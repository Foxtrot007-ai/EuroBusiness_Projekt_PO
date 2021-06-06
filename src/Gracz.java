import java.util.List;

public class Gracz {

private int liczba_pol_na_planszy;
private int ilosc_pieniedzy;
private List<String> Lista_posiadlosci;
private int nr_pozycji_na_planszy;

public Gracz(int wartosc_startowa, int liczba_pol)
{
	ilosc_pieniedzy = wartosc_startowa;
	nr_pozycji_na_planszy = 0;
	liczba_pol_na_planszy = liczba_pol;
}

public boolean dodaj_pieniadze(int ilosc)
{
	ilosc_pieniedzy += ilosc;
	return true;
}

public boolean zabierz_pieniadze(int ilosc)
{
	ilosc_pieniedzy -= ilosc;
	return true;
}

public boolean dodaj_miasto(String miasto)
{
	if(!Lista_posiadlosci.contains(miasto))
	{
		Lista_posiadlosci.add(miasto);
		return true;
	}else return false;
	
}

public boolean usun_miasto(String miasto)
{
	if(Lista_posiadlosci.contains(miasto))
	{
		Lista_posiadlosci.remove(miasto);
		return true;
	}else return false;
}

public void wykonaj_ruch(int ruchy)
{
	nr_pozycji_na_planszy += ruchy;
	nr_pozycji_na_planszy %= liczba_pol_na_planszy;
	System.out.printf(String.valueOf(ruchy) + " " +String.valueOf(nr_pozycji_na_planszy) + "\n");
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



}
