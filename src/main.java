import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class main {
	public static void main(String[] args){
		Gracz g = new Gracz(100,32);
		kostka k = new kostka();
		
		k.ustaw_aktualnego_gracza(g);
		
		
	    JFrame f = new JFrame("EuroBusiness");  
	    
	    JButton b1 = new JButton("Kostka");  
	    JTextField pole_gracza = new JTextField();
	    pole_gracza.setEditable(false);
	    
	    b1.setBounds(150,250,200,100);  
	    pole_gracza.setBounds(150,100,200,100);  
	    
	    
	    
	    b1.addActionListener(
	    		new ActionListener(){  
	    			public void actionPerformed(ActionEvent e){  
	    				
	    					
	    					k.actionPerformed(e);
	    					pole_gracza.setText("Pole: " + String.valueOf(g.aktualne_pole())); 
	    					
	    				
	    			}
	    		});  
	   
	    
	  
	    
	    f.add(b1);
	    f.add(pole_gracza);
	    f.setSize(500,500);  
	    f.setLayout(null);  
	    f.setVisible(true); 
	  }
}
