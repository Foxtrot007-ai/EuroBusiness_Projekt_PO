import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.List;

public class Plansza {
	private List<Pole> plansza;
	
	public JPanel panel_pola(int i)
	{
		
		Pole p;
		p = plansza.get(i);	
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		JPanel temp_panel;
		temp_panel = new JPanel();
		temp_panel.setSize(200, 101); 
		temp_panel.setLayout(null);
		temp_panel.setOpaque(true);
		temp_panel.setBorder(blackline);
		
		
		JLabel tytul= new JLabel(p.nazwa_pola(), JLabel.CENTER);
		temp_panel.add(tytul, 0);
		tytul.setSize(200, 40);
		tytul.setLocation(0,0);
		tytul.setVerticalAlignment(JLabel.TOP);
		tytul.setOpaque(true);
		tytul.setForeground(Color.white);
		tytul.setFont(new Font("Serif", Font.BOLD, 20));
		switch(p.kolor_pola())
		{
		case "zloty":
			tytul.setBackground(Color.yellow);
			break;
		case "czerwony":
			tytul.setBackground(Color.red);
			break;
		case "niebieski":
			tytul.setBackground(Color.blue);
			break;
		case "pomaranczowy":
			tytul.setBackground(Color.orange);
			break;
		case "zielony":
			tytul.setBackground(Color.green);
			break;
		case "fioletowy":
			tytul.setBackground(Color.magenta);
			break;
		case "brazowy":
			tytul.setBackground(Color.getHSBColor(32, 100, 38));
			break;
		case "rozowy":
			tytul.setBackground(Color.pink);
			break;
		}
		
		
		
		JLabel domek1;
		domek1 = new JLabel();
		
		if(p.ilosc_domkow_pola() >= 1) 
	    {
			temp_panel.add(domek1, 1);
			domek1.setLocation(5,45);
			domek1.setSize(40, 25);
			domek1.setOpaque(true);
			domek1.setBackground(Color.green);
		}
		
		JLabel domek2;
		domek2 = new JLabel();
		
		if(p.ilosc_domkow_pola() >= 2) 
	    {
			temp_panel.add(domek2, 2);
			domek2.setLocation(55,45);
			domek2.setSize(40, 25);
			domek2.setOpaque(true);
			domek2.setBackground(Color.green);
		}
		
		JLabel domek3;
		domek3 = new JLabel();
		
		if(p.ilosc_domkow_pola() >= 3) 
	    {
			temp_panel.add(domek3, 3);
			domek3.setLocation(105,45);
			domek3.setSize(40, 25);
			domek3.setOpaque(true);
			domek3.setBackground(Color.green);
		}
		
		JLabel domek4;
		domek4 = new JLabel();
		
		if(p.ilosc_domkow_pola() >= 4) 
	    {
			
			temp_panel.add(domek4, 4);
			domek4.setLocation(155,45);
			domek4.setSize(40, 25);
			domek4.setOpaque(true);
			domek4.setBackground(Color.green);
			domek4.setOpaque(true);
		}
		
		
		JLabel cena;
		cena = new JLabel(p.nazwa_pola(), JLabel.CENTER);
		temp_panel.add(cena, 5);
		cena.setSize(198, 25);
		cena.setText(p.wartosc_pola() + "$");
		cena.setLocation(1,75);
		cena.setOpaque(true);
		
		
		return temp_panel;
	}
	public Plansza()
	{
		boolean temp;
		plansza = new ArrayList<Pole>();
		temp = plansza.add(new Pole("Berlin", "niebieski", 200 , false));
		temp = plansza.add(new Pole("Bayern", "niebieski", 200, false));
		temp = plansza.add(new Pole("Drezno", "niebieski", 200, false));
		temp = plansza.add(new Pole("Zoo","szary", 200, true));
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
				return pole.wartosc_pola();
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
