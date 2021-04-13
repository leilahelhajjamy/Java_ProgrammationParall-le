package problem2;

public class SourcePartagee {
	
	

	int val;
    public SourcePartagee(int i){val=i;}
    synchronized void P(){
        try {
            while(val<=0){
                wait();
            }
            val--;
        } catch(InterruptedException e){}
    }
    synchronized void V(){
        if(++val > 0) 
        	notifyAll();
    }
	
	
}


