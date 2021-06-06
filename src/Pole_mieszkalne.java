
public class Pole_mieszkalne extends Pole {
	protected String kolor;
	 protected int wartosc;
	 protected int ilosc_domkow;
	 
	 public Pole_mieszkalne(String nazwa, String kolor, int wartosc)
	 {
		 super(nazwa, kolor);
		 this.wartosc = wartosc;
		 this.ilosc_domkow = 0;
	 }
	 
	 public String nazwa_pola()
	 {
		 return nazwa;
	 }
	 
	 public String kolor_pola()
	 {
		 return kolor;
	 }
	 
	 public int wartosc_pola()
	 {
		 return wartosc;
	 }
	 
	 public int ilosc_domkow_pola()
	 {
		 return ilosc_domkow;
	 }
	 
	 public void dodaj_domek()
	 {
		 ilosc_domkow++;
	 }
	 
	 public void usun_domek()
	 {
		 ilosc_domkow--;
	 }
	 
}
