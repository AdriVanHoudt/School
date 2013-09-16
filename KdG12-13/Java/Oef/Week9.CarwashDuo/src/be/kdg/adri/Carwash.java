package be.kdg.adri;

public class Carwash {
	private static final int MAXAANTAL = 2;
	public int aantal = 0;
	
	public synchronized void aankomstWagen(int wagennr){
		System.out.println("Wagen nr " + wagennr +" komt aan");
		aantal++;
		while(aantal>MAXAANTAL){
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
		aantal--;
	}
}
