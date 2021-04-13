package problem1;

import java.util.HashSet;

public class Parking {
    
    int Capacite ; 
    int PlacesOccupees; 
    public HashSet<Voiture> informationsVoitures = new HashSet<Voiture>();
    Parking(int taille)
    { 
    	this.Capacite = taille;
    } 
    
    int places()
    { 
    	return (this.Capacite - this.PlacesOccupees);
    }  
	
    synchronized boolean  accept(Voiture voiture) {
	if  (this.places() >0 )
	    { 
		this.PlacesOccupees ++ ;
		informationsVoitures.add(voiture); 
		System.out.println( voiture.num +" a la permission , " +  this.places() +" places qui restent");
		
		System.out.println(informationsVoitures);
		return (true) ; 
	    }
	else {
	    System.out.println( voiture.num +" est refusée, " +  this.places() +" places qui restent");
	    return(false) ;
	}
    }
    synchronized void leave(Voiture voiture) {
	PlacesOccupees --; 
	informationsVoitures.remove(voiture);
	System.out.println( voiture.num +" est sortie, " +  this.places() +" places qui restent");
    }}
