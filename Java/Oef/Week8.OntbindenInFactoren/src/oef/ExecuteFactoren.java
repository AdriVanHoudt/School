package oef;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExecuteFactoren {
    private static final long DEMOGETAL = 214_577_422_401L;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geef een getal: ");
        long getal = DEMOGETAL;
        try {
            getal = scanner.nextLong();
        } catch (InputMismatchException e) {
            // foutieve invoer, we nemen het demogetal
        }        
        double AantalThreads = (double)(Math.ceil((Math.sqrt(getal)/100)+1));

        for(int i = 0; i<AantalThreads; i++){
        	Thread t = new Thread(new FactorenRunnable(i*100, getal));	
        	t.start();
        }
    }
}