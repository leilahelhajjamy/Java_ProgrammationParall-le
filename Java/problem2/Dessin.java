package problem2;
import java.awt.*;
import java.io.IOException;
import java.io.PipedInputStream;

import javax.swing.*;
import java.util.concurrent.*;
public class Dessin extends JFrame implements Runnable{
	
	JLabel[][] tableEtats; 
	int        nombreProcessus;  
	int[]      etatsBaigneurs;   
	 
	int count;
	static PipedInputStream piIN = new PipedInputStream();
	String[] tableActions = {   
			" Arrive",    
			"basket",   
			 "Undress",   
			"Swim",      
			"Dressback",    
			"leave"       
			};
	String[] nomb = { 
			"A", "B", "C", "D", "E", "F", "G", "H" };
	 int nombrebEtats = tableActions.length;
	
	Dessin (int nombreProcessus) {  
		Container cont = getContentPane();   
		this.nombreProcessus = nombreProcessus;    etatsBaigneurs = new int [nombreProcessus];  
		tableEtats    = new JLabel [nombrebEtats][nombreProcessus];   
		for (int i=0; i < etatsBaigneurs.length; i++) etatsBaigneurs [i] = 0;  
		
		setTitle ("Swimming pool");    cont.setLayout (new GridLayout(0,nombreProcessus+1));   
		JLabel labelG = new JLabel ("Actions/baigneurs");  
		cont.add (labelG);    for (int j=0; j < nombreProcessus; j++) {     
			JLabel labelName = new JLabel (nomb[j], JLabel.CENTER);  
			labelName.setOpaque(true);  
			labelName.setBackground (Color.PINK);  
			cont.add (labelName);  
			}    
		for (int j=0; j < nombrebEtats; j++) {  
			JLabel labelactions = new JLabel (tableActions[j]);  
			labelactions.setOpaque (true);    
			labelactions.setBackground (Color.PINK);    
			cont.add (labelactions);     
			for (int i=0; i < nombreProcessus; i++) {   
				JLabel lC = new JLabel (" ", JLabel.CENTER);   
				lC.setOpaque (true);   
				tableEtats[j][i] = lC;   
				cont.add (lC);     
				    }  } 
		
		
		setBounds (300, 300, 650, 300);    setVisible (true);
		
			}
	
	
	
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int numero;     
		try {    
			while ( (numero = piIN.read()) != -1) {  
				int etat = piIN.read();
				tableEtats[etatsBaigneurs[numero]][numero].setText ("+");      
				tableEtats[etatsBaigneurs[numero]][numero].setBackground (Color.ORANGE);
				etatsBaigneurs [numero] = etat;  tableEtats[etat][numero].setText ("+");     
				tableEtats[etat][numero].setBackground (Color.ORANGE);  
				
				  
			
				} piIN.close ();   
				} catch (IOException e) {   
					System.out.println (e);   
					}  
			}
		
		
	}
	
	
	
	
	
	


	