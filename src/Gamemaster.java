import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private JList wybor_gracza_do_handlu;
	private JButton kostka;
	private JButton Budowanie;
	private JButton dalej;
	private JLabel informacje;
	private JLabel dane_gracza;
	private List<JPanel> pola;
	private boolean czy_rzut_kostka;
	private boolean czy_handel;
	private boolean czy_Budowanie;
	
	private List<JPanel> panele_pol;
	
	private void uaktualnij_dane_gracza()
	{
		
	}
	
	private void wczytaj_JPanele_pola()
	{
		for(int i = 0; i < liczba_pol; i++)
		{
			pola.add(p.panel_pola(i));
			f.add(pola.get(i));
		}
		pola.get(0).setLocation(1221, 620);
		pola.get(1).setLocation(1099, 620);
		pola.get(2).setLocation(977, 620);
		pola.get(3).setLocation(855, 620);
		pola.get(4).setLocation(733, 620);
		pola.get(5).setLocation(610, 620);
		pola.get(6).setLocation(488, 620);
		pola.get(7).setLocation(366, 620);
		pola.get(8).setLocation(244, 620);
		pola.get(9).setLocation(122, 620);
		
		pola.get(10).setLocation(0, 620);	
		pola.get(11).setLocation(0, 558);
		pola.get(12).setLocation(0, 496);
		pola.get(13).setLocation(0, 434);
		pola.get(14).setLocation(0, 372);
		pola.get(15).setLocation(0, 310);
		pola.get(16).setLocation(0, 248);
		pola.get(17).setLocation(0, 186);
		pola.get(18).setLocation(0, 124);
		pola.get(19).setLocation(0, 62);
		
		pola.get(30).setLocation(1221, 0);
		pola.get(29).setLocation(1099, 0);
		pola.get(28).setLocation(977, 0);
		pola.get(27).setLocation(855, 0);
		pola.get(26).setLocation(733, 0);
		pola.get(25).setLocation(610, 0);
		pola.get(24).setLocation(488, 0);
		pola.get(23).setLocation(366, 0);
		pola.get(22).setLocation(244, 0);
		pola.get(21).setLocation(122, 0);
		pola.get(20).setLocation(0, 0);
			
		pola.get(39).setLocation(1221, 558);
		pola.get(38).setLocation(1221, 496);
		pola.get(37).setLocation(1221, 434);
		pola.get(36).setLocation(1221, 372);
		pola.get(35).setLocation(1221, 310);
		pola.get(34).setLocation(1221, 248);
		pola.get(33).setLocation(1221, 186);
		pola.get(32).setLocation(1221, 124);
		pola.get(31).setLocation(1221, 62);
	
		
	}
	
	public Gamemaster()
	{
		f = new JFrame();
		f.setSize(1357,720);  
		f.setLayout(null);  
		liczba_pol = 40;
		
		gracz1 = new Gracz(3000,liczba_pol,1);
		gracz2 = new Gracz(3000,liczba_pol,2);
		gracz3 = new Gracz(3000,liczba_pol,3);
		gracz4 = new Gracz(3000,liczba_pol,4);
		
		
		
		p = new Plansza();
	
		kostka = new JButton("kostka");
		handel = new JButton("Handel");
		
		final DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement("Gracz 1");  
        l1.addElement("Gracz 2");  
        l1.addElement("Gracz 3");  
        l1.addElement("Gracz 4");  
        wybor_gracza_do_handlu = new JList<>(l1);
        dane_gracza = new JLabel();
        
		k = new kostka(kostka, handel);
		k.ustaw_aktualnego_gracza(gracz1);
		
		
		h = new handel();
		h.ustaw_aktualnego_gracza(gracz1);
		
		
		
		b = new Budowanie();
		b.ustaw_aktualnego_gracza(gracz1);
		b.ustaw_plansze(p);
		
		
		pola = new ArrayList<JPanel>();
		wczytaj_JPanele_pola();
		
		
		dane_gracza.setBounds(600, 120, 200, 100);
		dane_gracza.setEnabled(false);
		ustaw_dane_gracza(gracz1);
		
		kostka.setBounds(250,150,100, 40);
		kostka.setEnabled(true);
		kostka.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				k.actionPerformed(evt);

			}
		});
		
	
		handel.setBounds(250,200,100, 40);
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
		
		wybor_gracza_do_handlu.setBounds(250,250,75,80);
		wybor_gracza_do_handlu.setEnabled(false);
		
		Budowanie = new JButton("Budowanie");
		Budowanie.setBounds(360,150,100, 40);
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
		dalej.setBounds(360,200,100, 40);
		dalej.setEnabled(false);
		dalej.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				dalej.setEnabled(false);
				kostka.setEnabled(true);
			}
		});
		
		
		
		
		
		f.add(Budowanie);
		f.add(handel);
		f.add(dane_gracza);
		f.add(wybor_gracza_do_handlu);
		f.add(kostka);
		f.add(dalej);
		
		f.setVisible(true); 
		
	}
	
	void ustaw_dane_gracza(Gracz g)
	{
		dane_gracza.setText("<html><body><p align=\"center\">Aktualny gracz: " + g.numer_gracza() 
		+ "<br/>" +"Pieniadze: " + g.ile_pieniedzy() + 
		"<br/>lista w³asnosci: </p></body></html>");

	}
}
