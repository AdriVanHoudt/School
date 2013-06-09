package be.kdg.adri;

public class Carwash {
	public boolean bezet = false;
	
	public synchronized void aankomstWagen(int wagennr){
		System.out.println("Wagen nr " + wagennr +" komt aan");
		
		while(bezet){
			System.out.println("Wagen nr " + wagennr + " moet wachten");
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
	}
	
	public synchronized void vertrekWagen(int wagennr){
		this.notify();
		System.out.println("Wagen nr " + wagennr + " is klaar");
		bezet=false;
	}
}
