package be.kdg.adri;

public class Bankrekening {
    private String rekeningNummer;
    private int saldo;
    
    public Bankrekening(String reknr, int bedrag) {
        rekeningNummer = reknr;
        saldo = bedrag;
    }
	public synchronized void geldOpname(int bedrag) {
        System.out.println("Geldopname te " + Thread.currentThread().getName()+ " van rekening " + rekeningNummer);
        System.out.println("Bedrag: " + bedrag);
        if (bedrag <= saldo) {
           try {
               Thread.sleep(100); // tijd nodig voor de transactie
            }
            catch (InterruptedException e) { /* negeer */ }
           		saldo -= bedrag;
            	System.out.println("Nieuw saldo: " + saldo);
        } else {
            System.out.println("Het saldo is te klein!");
        }
        System.out.println();
    }
}