import java.awt.Color;
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
	private Gracz gracze[];
	private Informacje info;
	private Decyzja d;
	private kostka k;
	private Budowanie b;
	private int liczba_pol;
	private int aktualny_gracz;
	
	private JFrame f;
	private JButton handel;
	private JList wybor_gracza_do_handlu;
	private JButton kostka;
	private JPanel kostka_ekran;
	private JButton decyzja;
	private JButton Budowanie;
	private JButton dalej;

	

	private List<JPanel> pola;
	private boolean czy_rzut_kostka;
	private boolean czy_handel;
	private boolean czy_Budowanie;

	
	private List<JPanel> panele_pol;
	
	private void okresl_nastepnego_gracza()
	{
		int temp = aktualny_gracz;
		
		do
		{
			aktualny_gracz++;
		}while(gracze[aktualny_gracz % 4].czy_bankrut());
		
	}
	
	
	
	
	
	private void sprawdz_czy_banktur()
	{
		if(gracze[aktualny_gracz % 4].czy_bankrut())
		{
			for (String nazwa_pola : gracze[aktualny_gracz % 4].usun_wlasnosci()) {
				p.zeruj_domki(nazwa_pola);
			}
		}
	}
	
	
	private void ustaw_pola()
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
		
		aktualny_gracz = 0;
		gracze = new Gracz[4];
		gracze[0] = new Gracz(3000,liczba_pol,1);
		gracze[1] = new Gracz(3000,liczba_pol,2);
		gracze[2] = new Gracz(3000,liczba_pol,3);
		gracze[3] = new Gracz(3000,liczba_pol,4);
		
	/*	gracze[0].dodaj_miasto("Saloniki");
		gracze[0].dodaj_miasto("Ateny");
		gracze[0].dodaj_miasto("Neapol"); */
		
		p = new Plansza();
	
		kostka = new JButton("kostka");
		decyzja = new JButton("decyzja");
		handel = new JButton("Handel");
		Budowanie = new JButton("Budowanie");
		dalej = new JButton("dalej");
		
		final DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement("Gracz 1");  
        l1.addElement("Gracz 2");  
        l1.addElement("Gracz 3");  
        l1.addElement("Gracz 4");  
        wybor_gracza_do_handlu = new JList<>(l1);
       
        //ustawienia inforamcji
        info = new Informacje();
      	info.ustaw_tablice_graczy(gracze);
      	info.uaktualnij_informacje();
      	
      	
        //ustawianie kostki
		k = new kostka(kostka, decyzja);	
		k.ustaw_aktualnego_gracza(gracze[0]);
		k.ustaw_informacje(info);
		
		
		//ustawianie handlu
		d = new Decyzja(decyzja, handel ,info, p, gracze);
		d.ustaw_aktualnego_gracza(gracze[0]);
		
		//ustawianie handlu
		h = new handel(handel, Budowanie);
		h.ustaw_aktualnego_gracza(gracze[0]);
		h.ustaw_informacje(info);
		
		
		//ustawianie budowania
		b = new Budowanie(Budowanie, dalej);
		b.ustaw_aktualnego_gracza(gracze[0]);
		b.ustaw_plansze(p);
		b.ustaw_informacje(info);
	
		
		
		pola = new ArrayList<JPanel>();
		ustaw_pola();
		b.ustaw_liste_pol(pola);
		
		
		
		
		kostka.setBounds(610,90 + 40,100, 40);
		kostka.setEnabled(true);
		kostka.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				k.actionPerformed(evt);

			}
		});
		
		decyzja.setBounds(610,150 + 40,100, 40);
		decyzja.setEnabled(false);
		decyzja.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				d.actionPerformed(evt);
				
			}
		});
	
		handel.setBounds(610,210 + 40,100, 40);
		handel.setEnabled(false);
		handel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				switch (wybor_gracza_do_handlu.getSelectedIndex()) {
				case 0:
					h.ustaw_gracza_do_handlu(gracze[0]);
					break;
				case 1:
					h.ustaw_gracza_do_handlu(gracze[1]);
					break;
				case 2:
					h.ustaw_gracza_do_handlu(gracze[2]);
					break;
				case 3:
					h.ustaw_gracza_do_handlu(gracze[3]);
					break;
				default:
					h.ustaw_gracza_do_handlu(gracze[0]);
					break;
				}
				
				if(wybor_gracza_do_handlu.getSelectedIndex() != aktualny_gracz)
				h.actionPerformed(evt);
			}
		});
		
		wybor_gracza_do_handlu.setBounds(610,270 + 40,75,80);
		wybor_gracza_do_handlu.setEnabled(true);
		
		
		Budowanie.setBounds(610,390 + 40,100, 40);
		Budowanie.setEnabled(false);
		Budowanie.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				b.actionPerformed(evt);
				
			}
		});
		
		
		dalej.setBounds(610,450 + 40,100, 40);
		dalej.setEnabled(false);
		dalej.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) {
				dalej.setEnabled(false);
				kostka.setEnabled(true);
				sprawdz_czy_banktur();
				info.uaktualnij_informacje();
				okresl_nastepnego_gracza();
				k.ustaw_aktualnego_gracza(gracze[aktualny_gracz % 4]);
				d.ustaw_aktualnego_gracza(gracze[aktualny_gracz % 4]);
				h.ustaw_aktualnego_gracza(gracze[aktualny_gracz % 4]);
				b.ustaw_aktualnego_gracza(gracze[aktualny_gracz % 4]);
				
			}
		});
		
		
		
		
		
		f.add(Budowanie);
		f.add(handel);
		f.add(wybor_gracza_do_handlu);
		f.add(kostka);
		f.add(dalej);
		f.add(decyzja);
		f.add(k.pokaz_kostke());
		f.add(h.pokaz_budowanie());
		f.add(b.pokaz_budowanie());
		f.add(d.pokaz_decyzje());
		f.add(info.pokaz_informacje());
		f.setVisible(true); 
		
	}
	
}
