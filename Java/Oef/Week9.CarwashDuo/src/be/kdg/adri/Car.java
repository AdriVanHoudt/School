package be.kdg.adri;
public class Car implements Runnable {
    private int wagenNummer;
    private int aankomstTijd;
    private Carwash carwash;
    
    public Car(int wagenNr, int aankomstTijd, Carwash carwash) {
        wagenNummer = wagenNr;
        this.aankomstTijd = aankomstTijd;
        this.carwash = carwash;
    }
    
    public void run() {
    	try {
			Thread.sleep(1000 * aankomstTijd);
		} catch (InterruptedException e) {
		}
    	
    	System.out.println("Start wagen nr " + wagenNummer);
    	this.carwash.aankomstWagen(wagenNummer);
    	
    	try {
			Thread.sleep(1600);
		} catch (InterruptedException e) {
		}
    	
    	carwash.vertrekWagen(wagenNummer);
    }
}