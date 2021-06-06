
public class Pole_specjalne extends Pole{
	private int wartosc_kary;
	public Pole_specjalne(String nazwa, int kara)
	{
		super(nazwa, "szary");
		wartosc_kary = kara;
	}
	
	public int ile_do_zaplaty()
	{
		return wartosc_kary;
	}

}
