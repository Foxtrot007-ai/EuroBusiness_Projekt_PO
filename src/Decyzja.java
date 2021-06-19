    import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.util.Random;
public class Decyzja implements ActionListener{
			private JPanel f;
			private JButton b1;
			private JButton b2;
			private JButton b3;
			private JLabel decyzja1;
			private Gracz aktualny_gracz;
			private Informacje info;
			private JButton MyButton;
			private JButton NextButton;
			private Plansza plansza;
			private Gracz gracze[];
			
			
			
			
			public JPanel pokaz_decyzje()
			{
				f.setLocation(800, 200);
				return f;
			}
			
			public void koniec_decyzji()
			{
				MyButton.setEnabled(false);
				NextButton.setEnabled(true);
				f.setVisible(false);
				info.uaktualnij_informacje();
			}
			
			public Decyzja(JButton a, JButton b, Informacje i, Plansza p, Gracz g[])
			{
				MyButton = a;
				NextButton = b;
				info = i;
				plansza = p;
				gracze = g;

				f = new JPanel();
		          
				decyzja1 = new JLabel();  
				decyzja1.setBounds(100,50, 100,100);  
						
			    
				b1 = new JButton("Kup pole");
				b1.setBounds(50,150,100, 40);
				b1.setEnabled(true);
				b1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) {
						String nazwa_pola = plansza.nazwa_pola(aktualny_gracz.aktualne_pole());
						if(aktualny_gracz.ile_pieniedzy() >= plansza.wartosc_pola(nazwa_pola))
						{
							aktualny_gracz.zabierz_pieniadze(plansza.wartosc_pola(nazwa_pola));
							aktualny_gracz.dodaj_miasto(nazwa_pola);
						}
						koniec_decyzji();
						
								
					}
				});
				
				b2 = new JButton("Idz dalej");
				b2.setBounds(150,150,100, 40);
				b2.setEnabled(true);
				b2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) {
						
						  
						koniec_decyzji();
								
					}
				});
			
				
				b3 = new JButton("dalej");
				b3.setBounds(100,150,100, 40);
				b3.setEnabled(true);
				b3.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) {
						
						  
						koniec_decyzji();
								
					}
				});
				
				f.add(b1);
				f.add(b2);
				f.add(b3);
				f.add(decyzja1);       
				f.setSize(300,300);
				f.setLayout(null); 
				f.setVisible(false);
				
			}
			
			
			
			public void actionPerformed(ActionEvent e)
			{
				
				String nazwa_pola = plansza.nazwa_pola(aktualny_gracz.aktualne_pole());
				f.setVisible(true);
				if(!aktualny_gracz.czy_wlasciciel(nazwa_pola))
				{
					if(!(plansza.jaki_kolor(nazwa_pola) == "szary"))
					{
						if(gracze[0].czy_wlasciciel(nazwa_pola)
						|| gracze[1].czy_wlasciciel(nazwa_pola)
						|| gracze[2].czy_wlasciciel(nazwa_pola)
						|| gracze[3].czy_wlasciciel(nazwa_pola))
						{
							placi_do_innego_gracza(nazwa_pola);
						}else {
							moze_kupic_pole(nazwa_pola);
						}
					}
					else
					{
						placi_kare(nazwa_pola);
					}
				}else
				{
					wlasciciel_pola(nazwa_pola);
				}
				
							
			}
			
			private void placi_do_innego_gracza(String nazwa_pola)
			{
				Gracz do_wymiany = gracze[0];
				if(gracze[0].czy_wlasciciel(nazwa_pola)) do_wymiany = gracze[0];
				if(gracze[1].czy_wlasciciel(nazwa_pola)) do_wymiany = gracze[1];
				if(gracze[2].czy_wlasciciel(nazwa_pola)) do_wymiany = gracze[2];
				if(gracze[3].czy_wlasciciel(nazwa_pola)) do_wymiany = gracze[3];
				
				aktualny_gracz.zabierz_pieniadze(plansza.wartosc_pola(nazwa_pola) * (plansza.ile_domków(nazwa_pola) + 1));
				do_wymiany.dodaj_pieniadze(plansza.wartosc_pola(nazwa_pola) * (plansza.ile_domków(nazwa_pola) + 1));
				
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(true);
				decyzja1.setText("<html><body><p align=\"center\">Zaplacono kare dla gracza: " + do_wymiany.numer_gracza()+ "</p></body></html>");
				
						
			}
			
			private void moze_kupic_pole(String nazwa_pola)
			{
				b1.setVisible(true);
				b2.setVisible(true);
				b3.setVisible(false);
				decyzja1.setText("<html><body><p align=\"center\">Czy chcesz zakupic pole " + nazwa_pola + "?</p></body></html>");
				
			}
			
			private void placi_kare(String nazwa_pola)
			{
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(true);
				decyzja1.setText("<html><body><p align=\"center\">Pole szare: " + nazwa_pola + "</p></body></html>");
				aktualny_gracz.zabierz_pieniadze(plansza.wartosc_pola(nazwa_pola));
				
			}
			
			private void wlasciciel_pola(String nazwa_pola)
			{
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(true);
				decyzja1.setText("<html><body><p align=\"center\">Stanales na swoim polu: " + nazwa_pola+ "</p></body></html>");
				
			}
			
			
			public void ustaw_aktualnego_gracza(Gracz g)
			{
				aktualny_gracz = g;
			}
			
			
			
		}

