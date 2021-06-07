



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Budowanie implements ActionListener{
		private JFrame f;
		private JButton b1;
		private JButton b2;
		private JButton b3;
		private JButton b4;
		private int max_domkow;
		private String nazwa_miasta;
		
		private JTextField miasto1;
		private JTextField wartosc1;
		private JTextField wartosc2;
		private JTextField wartosc3;
		private JTextField wartosc4;
		private Gracz aktualny_gracz;
		private Plansza plansza;
		private boolean czy_koniec_budowania;
			
		public Budowanie()
		{
			max_domkow = 4;
			f = new JFrame();
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
		    
		    
			b1 = new JButton("Uaktualnij");
			b1.setBounds(50,300,100, 40);
			b1.setEnabled(true);
			b1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) {
					
					nazwa_miasta = miasto1.getText();
						if(aktualny_gracz.czy_wlasciciel(nazwa_miasta)){
							wartosc2.setText(String.valueOf(plansza.ile_domków(nazwa_miasta)));
							wartosc4.setText(String.valueOf(plansza.wartosc_pola(nazwa_miasta)));
						}
	
				}		
				
			});

			b2 = new JButton("Sprzedaj");
			b2.setBounds(200,300,100, 40);
			b2.setEnabled(true);
			b2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) {
					if(aktualny_gracz.czy_wlasciciel(nazwa_miasta)
					   && (plansza.ile_domków(nazwa_miasta) > 0)
					   && aktualny_gracz.czy_mozna_budowac(nazwa_miasta, plansza)){
						aktualny_gracz.dodaj_pieniadze(plansza.wartosc_pola(nazwa_miasta));
						plansza.usun_domek(nazwa_miasta);
					}
							
				}
	
							
				
			});
			
			b3 = new JButton("Kup");
			b3.setBounds(350,300,100, 40);
			b3.setEnabled(true);
			b3.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) {
					if(aktualny_gracz.czy_wlasciciel(nazwa_miasta)
					   && (plansza.ile_domków(nazwa_miasta) <= max_domkow)
					   && aktualny_gracz.czy_mozna_budowac(nazwa_miasta, plansza)
					   && aktualny_gracz.ile_pieniedzy() >= plansza.wartosc_pola(nazwa_miasta) ){
								aktualny_gracz.zabierz_pieniadze(plansza.wartosc_pola(nazwa_miasta));
								plansza.dodaj_domek(nazwa_miasta);
							}					
				}
				
			});
			
			b4 = new JButton("Koniec");
			b4.setBounds(200,350,100, 40);
			b4.setEnabled(true);
			b4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) {
						
							czy_koniec_budowania = true;
							f.dispose();
						}
	
							
				
			});
			
			
		
			
			f.add(b1);
			f.add(b2);
			f.add(b3);
			f.add(b4);
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
			b1.setEnabled(true);
					
		}
		
		
		public void ustaw_aktualnego_gracza(Gracz g)
		{
			aktualny_gracz = g;
		}
		
		public void ustaw_plansze(Plansza p)
		{
			plansza = p;
		}
		
		
		public boolean czy_budowano()
		{
			return czy_koniec_budowania;
		}
		
	}




