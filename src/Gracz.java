import java.util.List;

public class Gracz {

private int liczba_pól_na_planszy;
private int iloœæ_pieniêdzy;
private List<String> Lista_posiad³oœci;
private int nr_pozycji_na_planszy;

public Gracz(int wartoœæ_startowa, int liczba_pól)
{
	iloœæ_pieniêdzy = wartoœæ_startowa;
	nr_pozycji_na_planszy = 0;
	liczba_pól_na_planszy = liczba_pól;
}

public boolean dodaj_pieni¹dze(int iloœæ)
{
	iloœæ_pieniêdzy += iloœæ;
	return true;
}

public boolean zabierz_pieni¹dze(int iloœæ)
{
	iloœæ_pieniêdzy -= iloœæ;
	return true;
}

public boolean dodaj_miasto(String miasto)
{
	if(!Lista_posiad³oœci.contains(miasto))
	{
		Lista_posiad³oœci.add(miasto);
		return true;
	}else return false;
	
}

public boolean usun_miasto(String miasto)
{
	if(Lista_posiad³oœci.contains(miasto))
	{
		Lista_posiad³oœci.remove(miasto);
		return true;
	}else return false;
}

public void wykonaj_ruch(int ruchy)
{
	nr_pozycji_na_planszy += ruchy;
	nr_pozycji_na_planszy %= liczba_pól_na_planszy;
}

public boolean czy_bankrut()
{
	return iloœæ_pieniêdzy < 0 && Lista_posiad³oœci.isEmpty();
}

public boolean czy_wlasciciel(String miasto)
{
	 return Lista_posiad³oœci.contains(miasto);
}



}
