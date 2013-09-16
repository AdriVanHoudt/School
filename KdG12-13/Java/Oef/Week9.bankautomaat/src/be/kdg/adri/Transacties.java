package be.kdg.adri;

public class Transacties {
    public static final int BEGINSALDO = 1500;
    
    public static void main(String[] args) {
        Bankrekening rekening = new Bankrekening("BE15-0260-3699-1470", BEGINSALDO);
        Automaat a1 = new Automaat("Antwerpen", rekening);
        Automaat a2 = new Automaat("Gent", rekening);
        System.out.println("Beginsaldo: " + BEGINSALDO + "\n");
        a1.start();
        a2.start();
    }
}