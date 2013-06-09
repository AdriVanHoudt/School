package be.kdg.adri;

public class Automaat extends Thread {
    private Bankrekening rekening;
    
    public Automaat(String threadNaam, Bankrekening rekening) {
        super(threadNaam);
        this.rekening = rekening;
    }
    
    public void run() {
        rekening.geldOpname(500);
        rekening.geldOpname(250);
    }
}