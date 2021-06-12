import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		
		
		f = new JFrame();
		f.setSize(1280,720);  
		f.add(Budowanie);
		f.add(handel);
		f.add(dane_gracza);
		f.add(wybor_gracza_do_handlu);
		f.add(kostka);
		f.add(dalej);
		f.setLayout(null);  
		f.setVisible(true); 
		
	}
	
	void ustaw_dane_gracza(Gracz g)
	{
		dane_gracza.setText("<html><body><p align=\"center\">Aktualny gracz: " + g.numer_gracza() 
		+ "<br/>" +"Pieniadze: " + g.ile_pieniedzy() + 
		"<br/>lista w³asnosci: </p></body></html>");

	}
}
