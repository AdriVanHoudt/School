package oef;

public class FactorenRunnable implements Runnable{
    private static long getal;
    private static int aantalFactoren = 0;
    private int begin;
    private int einde;
    
    public FactorenRunnable(int begin, long teOnderzoekenGetal) {
        if (begin == 0) {
            this.begin = 2;
        } else {
            this.begin = begin;
        }
        
        getal = teOnderzoekenGetal;
        einde = begin + 99;
    }
    
    @Override
	public void run() {
    	for(int i = begin; i<=einde; i++){
    		double result = (double)getal / i;
    		if(Math.floor(result)==result){
    			System.out.printf("Factor %6d --> %s%n", i, Thread.currentThread().getName());
    			this.aantalFactoren++;
    		}
    	}
	}
}