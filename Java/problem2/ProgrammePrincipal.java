package problem2;

public class ProgrammePrincipal {
	
	
	public static void main(String[] args) {
		
		
		 final int nombreBaigneur = 8;  
		 final int nombrePanier   = 4;  
		 final int nombreCabine   = 4; 
		 
		 Baigneur.startt (nombrePanier, nombreCabine);
		 Baigneur[] tableDesbaigneur = new Baigneur [nombreBaigneur];
		 for (int i=0; i < nombreBaigneur; i++)
		 tableDesbaigneur[i] = new Baigneur (i);
		 Dessin dessin  = new Dessin (nombreBaigneur);  
		 Thread tableDessin = new Thread (dessin);  
		 tableDessin.start();
		 try {     
			 for (int i=0; i < nombreBaigneur; i++) {
					tableDesbaigneur[i].join();   
					 tableDessin.join(); 
			 }
				 	 
		 } catch (InterruptedException e) 
		 {      System.out.println (e);    }   
		 System.out.println ("End");
		
	}
}
