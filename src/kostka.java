
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class kostka implements ActionListener{
		private JPanel f;
		private JButton b1;
		private JButton b2;
		private JTextField kostka1;
		private JTextField kostka2;
		private Gracz aktualny_gracz;
		private int wylosowana;
		private Random generator; 
		public boolean koniec_losowania;
		
		private JButton MyButton;
		private JButton NextButton;
		public JPanel pokaz_kostke()
		{
			f.setLocation(800, 200);
			return f;
		}
		public kostka(JButton a, JButton b)
		{
			MyButton = a;
			NextButton = b;
			generator = new Random();
			f = new JPanel();
	          
		    kostka1 = new JTextField();  
		    kostka1.setBounds(100,50, 100,20);  
		    kostka1.setEditable(false);
		    
		    kostka2 = new JTextField();  
		    kostka2.setBounds(100,100, 100,20);  
		    kostka2.setEditable(false);
		    
			b1 = new JButton("Losuj");
			b1.setBounds(50,150,100, 40);
			b1.setEnabled(true);
			b1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) {
						
					losuj();
					kostka1.setText(String.valueOf(wylosowana));  
					aktualny_gracz.wykonaj_ruch(wylosowana);
					
					losuj();
					kostka2.setText(String.valueOf(wylosowana));  
					aktualny_gracz.wykonaj_ruch(wylosowana);
					b2.setEnabled(true);
					b1.setEnabled(false);
							
				}
			});
			
			b2 = new JButton("Dalej");
			b2.setBounds(150,150,100, 40);
			b2.setEnabled(false);
			b2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) {
					koniec_losowania = true;
					  
						MyButton.setEnabled(false);
						NextButton.setEnabled(true);
					
					f.setVisible(false);
							
				}
			});
		
			
			f.add(b1);
			f.add(b2);
			f.add(kostka1);
			f.add(kostka2);
	          
			f.setSize(300,300);
			f.setLayout(null); 
			f.setVisible(false);
			
		}
		
		private void losuj()
		{
			wylosowana = generator.nextInt(5) + 1;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			koniec_losowania = false;
			f.setVisible(true);
			b1.setEnabled(true);
			wylosowana = 0;				
		}
		
		
		public void ustaw_aktualnego_gracza(Gracz g)
		{
			aktualny_gracz = g;
		}
		
		public boolean czy_wylosowalo()
		{
			return koniec_losowania;
		}
		
	}

