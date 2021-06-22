
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class handel implements ActionListener{
		private JPanel f;
		private JButton b1;
		private JButton b2;
		private JTextField etykieta1;
		private JTextField etykieta2;
		private JTextField miasto1;
		private JTextField miasto2;
		private JTextField wartosc1;
		private JTextField wartosc2;
		private Gracz aktualny_gracz;
		private Gracz drugi_gracz;
		
		
		
		public boolean koniec_handlu;	
		private JButton aktualny;
		private JButton nastepny;
		private Informacje info;
		
		public JPanel pokaz_budowanie()
		{
			f.setLocation(700,200);
			return f;
		}
			
		public handel(JButton h, JButton b)
		{
			aktualny = h;
			nastepny = b;
			f = new JPanel();
	          
			etykieta1 = new JTextField();  
			etykieta1.setBounds(100,20, 100,20);
			etykieta1.setText("Aktualny gracz");
			etykieta1.setEditable(false);
		
			etykieta2 = new JTextField();  
			etykieta2.setBounds(300,20, 100,20);
			etykieta2.setText("Drugi_gracz");
			etykieta2.setEditable(false);
			
			miasto1 = new JTextField();  
			miasto1.setBounds(100,70, 100,20);  
			miasto1.setText("miasto");
		    
			miasto2 = new JTextField();  
			miasto2.setBounds(300,70, 100,20);  
			miasto2.setText("miasto");
		    
			wartosc1 = new JTextField();  
			wartosc1.setBounds(100,120,100,20);  
			wartosc1.setText("wartosc");
		    
			wartosc2 = new JTextField();  
			wartosc2.setBounds(300,120, 100,20);  
			wartosc2.setText("wartosc");
		    
		    
			b1 = new JButton("Akceptuj");
			b1.setBounds(100,220,100, 40);
			b1.setEnabled(true);
			b1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) {
						if((aktualny_gracz.czy_wlasciciel(miasto1.getText()) || miasto1.getText().equals(""))
						&& (aktualny_gracz.ile_pieniedzy() >= Integer.valueOf(wartosc1.getText()) || Integer.valueOf(wartosc1.getText()) == 0)
						&& (drugi_gracz.czy_wlasciciel(miasto2.getText()) || miasto2.getText().equals(""))
						&& (drugi_gracz.ile_pieniedzy() >= Integer.valueOf(wartosc2.getText()) || Integer.valueOf(wartosc1.getText()) == 0))
						{
							drugi_gracz.dodaj_miasto(miasto1.getText());
							aktualny_gracz.dodaj_miasto(miasto2.getText());
							
							drugi_gracz.usun_miasto(miasto2.getText());
							aktualny_gracz.usun_miasto(miasto1.getText());
							
							drugi_gracz.dodaj_pieniadze(Integer.valueOf(wartosc1.getText()));
							aktualny_gracz.dodaj_pieniadze(Integer.valueOf(wartosc2.getText()));
							
							drugi_gracz.zabierz_pieniadze(Integer.valueOf(wartosc2.getText()));
							aktualny_gracz.zabierz_pieniadze(Integer.valueOf(wartosc1.getText()));
						}
						info.uaktualnij_informacje();
							
				}
			});
			
			b2 = new JButton("Dalej");
			b2.setBounds(300,220,100, 40);
			b2.setEnabled(true);
			b2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) {
						
							koniec_handlu = true;
							aktualny.setEnabled(false);
							nastepny.setEnabled(true);
						
							f.setVisible(false);
		
				}
			});
			
		
			
			f.add(b1);
			f.add(b2);
			f.add(etykieta1);
			f.add(etykieta2);
			f.add(miasto1);
			f.add(miasto2);
			f.add(wartosc1);
			f.add(wartosc2);
	          
			f.setSize(500, 320);
			f.setLayout(null); 
			f.setVisible(false);
			
		}
	
		public void actionPerformed(ActionEvent e)
		{
			
			
			if(drugi_gracz.numer_gracza() != aktualny_gracz.numer_gracza()) 
			{
				f.setVisible(true);
				etykieta1.setText("Gracz_nr " + aktualny_gracz.numer_gracza());
				etykieta2.setText("Gracz_nr " + drugi_gracz.numer_gracza() );
				koniec_handlu = false;
				b1.setEnabled(true);
			}
			
			
					
		}
		
		
		public void ustaw_aktualnego_gracza(Gracz g)
		{
			aktualny_gracz = g;
		}
		
		public void ustaw_informacje(Informacje i)
		{
			info = i;
		}
		
		public void ustaw_gracza_do_handlu(Gracz g)
		{
			drugi_gracz = g;
		}
		
		
	}


