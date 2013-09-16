package be.kdg.adri;

import java.util.concurrent.ArrayBlockingQueue;

public class Carwash {
    private final ArrayBlockingQueue<Integer> carwash;
    
    public Carwash() {
        carwash = new ArrayBlockingQueue<>(1);
    }
    public void aankomstWagen(int nr) {
    	System.out.println("Start wagen nr " + nr);
        if(carwash.peek() != null){
        	System.out.println("Wagen nr " + nr + " moet wachten");
        }else{
        	try {
        		carwash.put(nr);
        	} catch (InterruptedException e) {
			}
        }
    }

    public void vertrekWagen(int nr) {
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
    	carwash.poll();
    	System.out.println("Wagen nr " + nr + " is klaar");
    	// Voorzie hier eerst een sleep van 100ms om System.out voorang te geven
    }
} 
