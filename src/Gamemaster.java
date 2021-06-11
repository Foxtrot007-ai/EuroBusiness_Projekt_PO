import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gamemaster {
	private handel h;
	private Plansza p;
	private Gracz gracz1;
	private Gracz gracz2;
	private Gracz gracz3;
	private Gracz gracz4;
	private kostka k;
	private Budowanie b;
	private int liczba_pol;
	
	private JFrame f;
	private JButton handel;
	private JButton kostka;
	private JButton Budowanie;
	private JButton dalej;
	private JLabel informacje;
	private JLabel dane_gracza;
	
	private boolean czy_rzut_kostka;
	private boolean czy_handel;
	private boolean czy_Budowanie;
	
	private List<JPanel> panele_pol;
	
	private void uaktualnij_dane_gracza()
	{
		
	}
	
	public Gamemaster()
	{
		liczba_pol = 40;
		
		gracz1 = new Gracz(3000,liczba_pol);
		gracz2 = new Gracz(3000,liczba_pol);
		gracz3 = new Gracz(3000,liczba_pol);
		gracz4 = new Gracz(3000,liczba_pol);
		
		
		
		p = new Plansza();
	
		kostka = new JButton("kostka");
		handel = new JButton("Handel");
		
		k = new kostka(kostka, handel);
		k.ustaw_aktualnego_gracza(gracz1);
		
		
		h = new handel();
		h.ustaw_aktualnego_gracza(gracz1);
		h.ustaw_gracza_do_handlu(gracz2);
		
		b = new Budowanie();
		b.ustaw_aktualnego_gracza(gracz1);
		b.ustaw_plansze(p);
		
		
	
		
		
		
		
		kostka.setBounds(250,200,100, 40);
		kostka.setEnabled(true);
		kostka.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				k.actionPerformed(evt);

			}
		});
		
	
		handel.setBounds(250,150,100, 40);
		handel.setEnabled(false);
		handel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				h.actionPerformed(evt);
				if(h.koniec_handlu)
				{   
					handel.setEnabled(false);
					Budowanie.setEnabled(true);
				}
			}
		});
		
		Budowanie = new JButton("Budowanie");
		Budowanie.setBounds(250,250,100, 40);
		Budowanie.setEnabled(false);
		Budowanie.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				b.actionPerformed(evt);
				if(b.czy_koniec_budowania)
				{   
					Budowanie.setEnabled(false);
					dalej.setEnabled(true);
				}
			}
		});
		
		dalej = new JButton("dalej");
		dalej.setBounds(250,300,100, 40);
		dalej.setEnabled(false);
		dalej.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				dalej.setEnabled(false);
				kostka.setEnabled(true);
			}
		});
		
		
		
		f = new JFrame();
		f.setSize(1280,720);  
		f.add(Budowanie);
		f.add(handel);
		f.add(kostka);
		f.add(dalej);
		f.setLayout(null);  
		f.setVisible(true); 
		
	}
	
	
}
