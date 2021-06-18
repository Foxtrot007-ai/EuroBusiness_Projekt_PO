import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Informacje {
	
	private JPanel f;
	private JLabel informacje[] ;
	private Gracz gracze[];

	
	public void uaktualnij_informacje()
	{
		informacje[0].setText("<html><body><p align=\"center\">"
				+ "<p style=\"color:red\">Gracz nr_1 <br/></p>"
				+ " Aktualne pole: "  + gracze[0].aktualne_pole() + "<br/>"
				+ " Ilosc pieniedzy: "  + gracze[0].ile_pieniedzy() + "<br/>"
				+ " Lista posiadlosci: "  + gracze[0].lista_wlasnosci()
			    +"</p></body></html>");
		
		informacje[1].setText("<html><body><p align=\"center\">"
				+ "<p style=\"color:red\">Gracz nr_2 <br/></p>"
				+ " Aktualne pole: "  + gracze[1].aktualne_pole() + "<br/>"
				+ " Ilosc pieniedzy: "  + gracze[1].ile_pieniedzy() + "<br/>"
				+ " Lista posiadlosci: "  + gracze[1].lista_wlasnosci()
				+"</p></body></html>");
		
		informacje[2].setText("<html><body><p align=\"center\">"
				+ "<p style=\"color:red\">Gracz nr_3 <br/></p>"
				+ " Aktualne pole: "  + gracze[2].aktualne_pole() + "<br/>"
				+ " Ilosc pieniedzy: "  + gracze[2].ile_pieniedzy() + "<br/>"
				+ " Lista posiadlosci: "  + gracze[2].lista_wlasnosci()
				+"</p></body></html>");
		
		informacje[3].setText("<html><body><p align=\"center\">"
				+ "<p style=\"color:red\">Gracz nr_4 <br/></p>"
				+ " Aktualne pole: "  + gracze[3].aktualne_pole() + "<br/>"
				+ " Ilosc pieniedzy: "  + gracze[3].ile_pieniedzy() + "<br/>"
				+ " Lista posiadlosci: "  + gracze[3].lista_wlasnosci()
				+"</p></body></html>");
	}
	
	public JPanel pokaz_informacje()
	{
		f.setLocation(60, 60);
		return f;
	}
	public Informacje()
	{
		
		
		f = new JPanel();
		
        informacje = new JLabel[4];
       
        
        informacje[0] = new JLabel();  
        informacje[0].setBounds(100,0, 100,200);  
       
	    
        informacje[1] = new JLabel();  
        informacje[1].setBounds(100,120, 100,200);  
        
        
        informacje[2] = new JLabel();  
        informacje[2].setBounds(100,240, 100,200);  
        
	    
        informacje[3] = new JLabel();  
        informacje[3].setBounds(100,360, 100,200);  
       
	    
		f.add(informacje[0]);
		f.add(informacje[1]);
		f.add(informacje[2]);
		f.add(informacje[3]);
          
		f.setSize(700,800);
		f.setLayout(null); 
		f.setVisible(true);
		
	}
	
	
	
	
	
	
	public void ustaw_tablice_graczy(Gracz gracze[])
	{
		this.gracze = gracze;
	}
	
	
}
