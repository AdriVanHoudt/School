package Week2;

import java.util.Scanner;

/**
 * User: Adri
 * Date: 27/09/13
 * Time: 16:10
 */
public class part3 {
    public static void main(String[] args) {
        int start, end, step;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Geef de begintemperatuur in °C: ");
        start =  scanner.nextInt();
        System.out.print("Geef de eindtemperatuur in °C: ");
        end = scanner.nextInt();

        if (end < start){
            System.out.println("De eindwaarde moet groter zijn dan de beginwaarde.");
        }

        if (end > start){

            System.out.print("Geef de stopwaarde: ");
            step = scanner.nextInt();

            while (start <= end){
                double result = start * 1.8 + 32 ;
                System.out.printf("%6s°C = %4s°F\n", "" + start, "" + result);
                start += step;
            }
        }
    }
}
