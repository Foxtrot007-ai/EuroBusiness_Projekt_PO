
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Random;


public class Budowanie implements ActionListener{
		private JPanel f;
		private JButton b1;
		private JButton b2;
		private JButton b3;
		private int max_domkow;
		private String nazwa_miasta;
		//private JPanel domek;
		
		private JTextField miasto1;
		private JTextField wartosc1;
		private JTextField wartosc2;
		private JTextField wartosc3;
		private JTextField wartosc4;
		private Gracz aktualny_gracz;
		private Plansza plansza;
		private List<JPanel> pola;
		public boolean czy_koniec_budowania;
		
		private JButton aktualny;
		private JButton nastepny;
			
		public JPanel pokaz_budowanie()
		{
			f.setLocation(700,150);
			return f;
		}
		private void uaktualnij()
		{
			nazwa_miasta = miasto1.getText();
			if(aktualny_gracz.czy_wlasciciel(nazwa_miasta)){
				wartosc2.setText(String.valueOf(plansza.ile_domków(nazwa_miasta)));
				wartosc4.setText(String.valueOf(plansza.wartosc_pola(nazwa_miasta)));
			}
			
		}
		
		public Budowanie(JButton b, JButton d)
		{
			aktualny = b;
			nastepny = d;
			//this.domek = domek;
			max_domkow = 4;
			f = new JPanel();
			nazwa_miasta = "";		
			miasto1 = new JTextField();  
			miasto1.setBounds(200,50, 100,20);  
			miasto1.setText("Berlin");		    
		    
			wartosc1 = new JTextField();  
			wartosc1.setBounds(200,100,100,20);  
			wartosc1.setText("Liczba domkow:");
			wartosc1.setEditable(false);
			
			wartosc2 = new JTextField();  
			wartosc2.setBounds(200,150, 100,20);  
			wartosc2.setText("");
			wartosc2.setEditable(false);
		    
			
			wartosc3 = new JTextField();  
			wartosc3.setBounds(200,200,100,20);  
			wartosc3.setText("Cena jednego domku:");
			wartosc3.setEditable(false);
		    
			wartosc4 = new JTextField();  
			wartosc4.setBounds(200,250, 100,20);  
			wartosc4.setText("");
			wartosc4.setEditable(false);
		    
		    
			

			b1 = new JButton("Sprzedaj");
			b1.setBounds(200,300,100, 40);
			b1.setEnabled(true);
			b1.addActionListener(new ActionListener()
			{
				
				public void actionPerformed(ActionEvent evt) {
					uaktualnij();
					if(aktualny_gracz.czy_wlasciciel(nazwa_miasta)
					   && (plansza.ile_domków(nazwa_miasta) > 0)
					   && aktualny_gracz.czy_mozna_budowac(nazwa_miasta, plansza)){
						aktualny_gracz.dodaj_pieniadze(plansza.wartosc_pola(nazwa_miasta));
						plansza.usun_domek(nazwa_miasta);
					}
					uaktualnij();
					
							
				}
	
							
				
			});
			
			b2 = new JButton("Kup");
			b2.setBounds(350,300,100, 40);
			b2.setEnabled(true);
			b2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) {
					uaktualnij();
					if(aktualny_gracz.czy_wlasciciel(nazwa_miasta)
					   && (plansza.ile_domków(nazwa_miasta) <= max_domkow)
					   && aktualny_gracz.czy_mozna_budowac(nazwa_miasta, plansza)
					   && aktualny_gracz.ile_pieniedzy() >= plansza.wartosc_pola(nazwa_miasta) ){
								aktualny_gracz.zabierz_pieniadze(plansza.wartosc_pola(nazwa_miasta));
								plansza.dodaj_domek(nazwa_miasta);
							}		
					uaktualnij();
				}
				
			});
			
			b3 = new JButton("Koniec");
			b3.setBounds(200,350,100, 40);
			b3.setEnabled(true);
			b3.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) {
						
							czy_koniec_budowania = true;
							aktualny.setEnabled(false);
							nastepny.setEnabled(true);
							f.setVisible(false);
							System.out.print(plansza.ile_domków("Saloniki"));
							uaktualnij_pola();
						}
	
							
				
			});
						

			f.add(b1);
			f.add(b2);
			f.add(b3);
			f.add(miasto1);
			f.add(wartosc1);
			f.add(wartosc2);
			f.add(wartosc3);
			f.add(wartosc4);
	          
			f.setSize(500, 500);
			f.setLayout(null); 
			f.setVisible(false);
			
		}
	
		public void actionPerformed(ActionEvent e)
		{
			czy_koniec_budowania = false;
			f.setVisible(true);
			uaktualnij();
		}
		
		
		public void ustaw_aktualnego_gracza(Gracz g)
		{
			aktualny_gracz = g;
		}
		
		public void ustaw_plansze(Plansza p)
		{
			plansza = p;
		}
		public void ustaw_liste_pol(List<JPanel> p)
		{
			
			pola = p;
		}
		
		private void uaktualnij_pola()
		{
			for (int i = 0; i < 40; i++) {
				if(plansza.ile_domków(i) >= 1)	pola.get(i).getComponent(1).setVisible(true);
				else pola.get(i).getComponent(1).setVisible(false);
				
				if(plansza.ile_domków(i) >= 2)	pola.get(i).getComponent(2).setVisible(true);
				else pola.get(i).getComponent(2).setVisible(false);
				
				if(plansza.ile_domków(i) >= 3)	pola.get(i).getComponent(3).setVisible(true);
				else pola.get(i).getComponent(3).setVisible(false);
				
				if(plansza.ile_domków(i) >= 4)	pola.get(i).getComponent(4).setVisible(true);
				else pola.get(i).getComponent(4).setVisible(false);
			}
		}
		
		
		
		
	}




