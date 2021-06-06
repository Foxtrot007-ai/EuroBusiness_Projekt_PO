import java.util.List;

public class Gracz {

private int liczba_p�l_na_planszy;
private int ilo��_pieni�dzy;
private List<String> Lista_posiad�o�ci;
private int nr_pozycji_na_planszy;

public Gracz(int warto��_startowa, int liczba_p�l)
{
	ilo��_pieni�dzy = warto��_startowa;
	nr_pozycji_na_planszy = 0;
	liczba_p�l_na_planszy = liczba_p�l;
}

public boolean dodaj_pieni�dze(int ilo��)
{
	ilo��_pieni�dzy += ilo��;
	return true;
}

public boolean zabierz_pieni�dze(int ilo��)
{
	ilo��_pieni�dzy -= ilo��;
	return true;
}

public boolean dodaj_miasto(String miasto)
{
	if(!Lista_posiad�o�ci.contains(miasto))
	{
		Lista_posiad�o�ci.add(miasto);
		return true;
	}else return false;
	
}

public boolean usun_miasto(String miasto)
{
	if(Lista_posiad�o�ci.contains(miasto))
	{
		Lista_posiad�o�ci.remove(miasto);
		return true;
	}else return false;
}

public void wykonaj_ruch(int ruchy)
{
	nr_pozycji_na_planszy += ruchy;
	nr_pozycji_na_planszy %= liczba_p�l_na_planszy;
}

public boolean czy_bankrut()
{
	return ilo��_pieni�dzy < 0 && Lista_posiad�o�ci.isEmpty();
}

public boolean czy_wlasciciel(String miasto)
{
	 return Lista_posiad�o�ci.contains(miasto);
}



}
