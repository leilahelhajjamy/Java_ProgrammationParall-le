package problem1;

import java.util.Random;

public class Voiture  implements Runnable { 
	String num; 
	Parking park;
	
	public Voiture(String name, Parking park){
		this.num=name; 
		this.park=park; 
	}
	public String toString(){ return this.num;} 
	
	public void entrer() throws InterruptedException{	
		while (!(this.park.accept(this)))
		{
            Thread.sleep((long)  (randomwait(1000)));
    		System.out.format("[%s]  : Puis je  entrer  \n", this.num);
		}
	}
	

	public int randomwait(int n) {
		Random rand = new Random();
		return  rand.nextInt(n);
	}
	
	
	public void run(){ 
	System.out.format("[%s]: Je débute !  \n", this.num);
	try {
		
	while(true){
		Thread.sleep((long)  (randomwait(40000)));
		System.out.format("[%s]: Puis je entrer   \n", this.num);
		this.entrer();
		System.out.format("[%s]: je suis garée \n", this.num);
		Thread.sleep((long) (randomwait(40000)));
	    System.out.format("[%s]: Puis je sortir \n", this.num);
	    this.park.leave(this);  

	}}
	catch (InterruptedException e) {
		e.printStackTrace();	}
	}
	
	
	public static void main(String[] args) {
		
		int TailleParking=8;
		int nombreVoitures=12; 
		Parking parking = new Parking(TailleParking);
		
		
		
		Thread Voiturest[] = new Thread[nombreVoitures];

		for (int i =0; i< nombreVoitures; i++){
			Voiturest[i]= new Thread(new Voiture(String.format("%d ", i) , parking));
			Voiturest[i].start();
		}
		
	}
}