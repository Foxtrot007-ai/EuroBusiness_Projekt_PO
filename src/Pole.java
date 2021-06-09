
public class Pole {
 protected String nazwa;
 protected String kolor;
 protected int ilosc_domkow;
 protected int wartosc;
 protected boolean typ; //false -> mieszkalny, true -> kara
 public Pole(String nazwa, String kolor, int wartosc, boolean typ)
 {
	 this.nazwa = nazwa;
	 this.kolor = kolor;
     this.ilosc_domkow = 4;
	 this.wartosc = wartosc;
	 this.typ = typ;
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
