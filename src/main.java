import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class main {
	public static void main(String[] args){
		Gracz g1 = new Gracz(10000,32);
		Plansza p = new Plansza();
		Budowanie b = new Budowanie();
		
		
		//kostka k = new kostka();
		//handel h = new handel();
		//k.ustaw_aktualnego_gracza(g);
		
		//h.ustaw_aktualnego_gracza(g1);
	    //h.ustaw_gracza_do_handlu(g2);
	    JFrame f = new JFrame("EuroBusiness");  
	    
	    JButton b1 = new JButton("Kostka");  
	    JTextField pole_gracza = new JTextField();
	    pole_gracza.setEditable(false);
	    
	    g1.dodaj_miasto("Berlin");
	    g1.dodaj_miasto("Bayern");
	    g1.dodaj_miasto("Drezno");
	   // g2.dodaj_miasto("Warszawa");
	    b.ustaw_aktualnego_gracza(g1);
	    b.ustaw_plansze(p);
	    
	    
	    b1.setBounds(150,250,200,100);  
	    pole_gracza.setBounds(150,100,200,100);  
	    
	    
	    
	    b1.addActionListener(
	    		new ActionListener(){  
	    			public void actionPerformed(ActionEvent e){  
	    				
	    					
	    					b.actionPerformed(e);
	    					//pole_gracza.setText("g1: " + g1.czy_wlasciciel("Warszawa") + " "  + g1.czy_wlasciciel("Berlin") + " " + g1.ile_pieniedzy() +"\n" 
	    					//		+ "g2: " + g2.czy_wlasciciel("Warszawa") + " " + g2.czy_wlasciciel("Berlin") + " " + g2.ile_pieniedzy() + "\n"); 
	    					pole_gracza.setText("g1: " + g1.czy_wlasciciel("Berlin") + " "  + g1.czy_wlasciciel("Bayern") + " " + g1.czy_wlasciciel("Drezno") +"\n" 
	    	    			+ " " + p.ile_domków("Berlin") + " "  + p.ile_domków("Bayern") + " " + p.ile_domków("Drezno") +"\n" ); 
	    				
	    			}
	    		});  
	   
	    
	  
	    
	    f.add(b1);
	    f.add(pole_gracza);
	    f.setSize(500,500);  
	    f.setLayout(null);  
	    f.setVisible(true); 
	  }
}
