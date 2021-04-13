package problem2;
import java.io.*;

import java.util.Random ;


public class Baigneur extends Thread{
	
	//Swimming Pool
	
	
	static SourcePartagee  basket ;
    static SourcePartagee cubicle ;
	static PipedOutputStream pipeout =null;
	int number;
	int count ;
	

	static void startt(int numberBaskets, int numberCubicles) {
		
		basket = new SourcePartagee(numberBaskets);
		cubicle = new SourcePartagee(numberCubicles);
		try {
			pipeout = new PipedOutputStream(Dessin.piIN);
			
			
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	Baigneur(int num){
		this.number = num;
		start();
	}
	
	void informations (int etat) {
		try {
			pipeout.write(this.number);
			pipeout.write(etat);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	
	
	public int randomwait() {
		Random rand = new Random();
		return  rand.nextInt(5000);
	}
	
	
	
	public void run() {
		
		int nombre = 8;
		
		try {
			Thread.sleep(randomwait() );
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		informations(0);
		try {
			Thread.sleep(randomwait() );
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 basket.P();   
		 informations (1);  
		 try {
			Thread.sleep(randomwait() );
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 cubicle.P();
		 informations (2);
		 try {
			Thread.sleep(randomwait() );
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 informations (3); 
		 cubicle.V();
		 try {
			Thread.sleep(randomwait() );
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 cubicle.P();  
		 informations (4);
		 try {
			Thread.sleep(randomwait() );
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 informations (5);   
		 cubicle.V(); 
		 try {
			Thread.sleep(randomwait());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 
		 basket.V();
		  
		 nombre--;  
		 if (nombre == 0)
		 {     
			 try {   
				 pipeout.close();  
				 } catch (Exception e)
			 {         System.out.println (e);    
			 }   
			 
		 }
		 
	}
	

	
	
}
