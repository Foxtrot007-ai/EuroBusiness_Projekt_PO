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
		temp_panel.setSize(120, 60); 
		temp_panel.setLayout(null);
		temp_panel.setOpaque(true);
		temp_panel.setBorder(blackline);
		
		
		JLabel tytul= new JLabel(p.nazwa_pola(), JLabel.CENTER);
		temp_panel.add(tytul, 0);
		tytul.setSize(118, 19);
		tytul.setLocation(1,1);
		tytul.setVerticalAlignment(JLabel.TOP);
		tytul.setOpaque(true);
		tytul.setForeground(Color.black);
		tytul.setFont(new Font("Serif", Font.BOLD, 12));
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
		temp_panel.add(domek1, 1);	
		domek1.setLocation(5,25);
		domek1.setSize(20, 15);
		domek1.setOpaque(true);
		domek1.setBackground(Color.green);
		domek1.setVisible(false);
		
		JLabel domek2;
		domek2 = new JLabel();
		temp_panel.add(domek2, 2);domek2.setLocation(35,25);
		domek2.setSize(20, 15);
		domek2.setOpaque(true);
		domek2.setBackground(Color.green);
		domek2.setVisible(false);
		
		JLabel domek3;
		domek3 = new JLabel();
		temp_panel.add(domek3, 3);
        domek3.setLocation(65,25);
	    domek3.setSize(20, 15);
		domek3.setOpaque(true);
		domek3.setBackground(Color.green);
		domek3.setVisible(false);
		
		JLabel domek4;
		domek4 = new JLabel();
		temp_panel.add(domek4, 4);
		domek4.setLocation(95,25);
		domek4.setSize(20, 15);
		domek4.setOpaque(true);
		domek4.setBackground(Color.green);
		domek4.setVisible(false);
		
		
		JLabel cena;
		cena = new JLabel(p.nazwa_pola(), JLabel.CENTER);
		temp_panel.add(cena, 5);
		cena.setSize(118, 18);
		cena.setText(p.wartosc_pola() + "$");
		cena.setLocation(1,40);
		cena.setOpaque(true);
		
		
		return temp_panel;
	}
	public Plansza()
	{
		boolean temp;
		plansza = new ArrayList<Pole>();
		temp = plansza.add(new Pole("Start", "szary", 0, true));
		temp = plansza.add(new Pole("Saloniki", "zloty", 120 , false));
		temp = plansza.add(new Pole("-----", "szary", 0, true));
		temp = plansza.add(new Pole("Ateny", "zloty", 120, false));
		temp = plansza.add(new Pole("Parking","szary", 400, true));
		temp = plansza.add(new Pole("Koleje", "szary", 500 , true));
		temp = plansza.add(new Pole("Neapol", "czerwony", 200, false));
		temp = plansza.add(new Pole("-----", "szary", 0, true));
		temp = plansza.add(new Pole("Mediolan", "czerwony", 200 , false));
		temp = plansza.add(new Pole("Rzym", "czerwony", 240, false));
		
		temp = plansza.add(new Pole("-----", "szary", 0, true));	
		temp = plansza.add(new Pole("Barcelona", "niebieski", 280, false));
		temp = plansza.add(new Pole("-----", "szary", 0, true));
		temp = plansza.add(new Pole("Sewilla", "niebieski", 280, false));
		temp = plansza.add(new Pole("Madryt", "niebieski", 320, false));
		temp = plansza.add(new Pole("koleje", "szary", 500, true));
		temp = plansza.add(new Pole("Liverpool", "pomaranczowy", 360, false));
		temp = plansza.add(new Pole("-----", "szary", 0, true));
		temp = plansza.add(new Pole("Glasgow", "pomaranczowy", 360, false));
		temp = plansza.add(new Pole("Londyn", "pomaranczowy", 400, false));
		
		temp = plansza.add(new Pole("-----", "szary", 0, true));
		temp = plansza.add(new Pole("Rotterdam", "zielony", 440, false));
		temp = plansza.add(new Pole("-----", "szary", 0, true));
		temp = plansza.add(new Pole("Bruksela", "zielony", 440, false));
		temp = plansza.add(new Pole("Amsterdam", "zielony", 480, false));
		temp = plansza.add(new Pole("koleje", "szary", 500, true));
		temp = plansza.add(new Pole("Malmo", "fioletowy", 520, false));
		temp = plansza.add(new Pole("Goterborg", "fioletowy", 520, false));
		temp = plansza.add(new Pole("-----", "szary", 0, true));
		temp = plansza.add(new Pole("Sztokholm", "fioletowy", 560, false));
		
		temp = plansza.add(new Pole("-----", "szary", 0, true));	
		temp = plansza.add(new Pole("Frankfurt", "brazowy", 600, false));
		temp = plansza.add(new Pole("Kolonia", "brazowy", 600, false));
		temp = plansza.add(new Pole("-----", "szary", 0, true));
		temp = plansza.add(new Pole("Bonn", "brazowy", 640, false));
		temp = plansza.add(new Pole("koleje", "szary", 500, true));
		temp = plansza.add(new Pole("-----", "szary", 0, false));
		temp = plansza.add(new Pole("Innsbruck", "rozowy", 700, false));
		temp = plansza.add(new Pole("-----", "szary", 0, true));
		temp = plansza.add(new Pole("Wieden", "rozowy", 800, false));
		
		
		
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
	
	public int ile_domków(int i)
	{
		return plansza.get(i).ilosc_domkow_pola();
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
	
	public String nazwa_pola(int i)
	{
		return plansza.get(i).nazwa_pola();
	}
	
	public void zeruj_domki(String nazwa)
	{
		for (Pole pole : plansza) {
			if(pole.nazwa_pola().compareTo(nazwa) == 0)
			pole.usun_wszystkie_domki();
		}
	}
	
}
