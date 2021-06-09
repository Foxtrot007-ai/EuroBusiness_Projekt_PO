import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
	    
	   
	    
	    g1.dodaj_miasto("Berlin");
	    g1.dodaj_miasto("Bayern");
	    g1.dodaj_miasto("Drezno");
	   // g2.dodaj_miasto("Warszawa");
	    b.ustaw_aktualnego_gracza(g1);
	    b.ustaw_plansze(p);
	    
	    System.out.printf(" "+ p.wartosc_pola("Berlin"));
	
	    JPanel pole = new JPanel();
	    pole = p.panel_pola(0);
		pole.setLocation(150, 100);
		
	    b1.setBounds(150,250,200,100);  
	    
	   
	    
	    b1.addActionListener(
	    		new ActionListener(){  
	    			public void actionPerformed(ActionEvent e){  
	    				
	    					
	    					 b.actionPerformed(e);
	    					 
	    					
	    					
	    					
	    			}
	    		});  
	   
	    
	  
	    
	    f.add(b1);
	    f.add(pole);
	    f.setSize(500,500);  
	    f.setLayout(null);  
	    f.setVisible(true); 
	  }
}
