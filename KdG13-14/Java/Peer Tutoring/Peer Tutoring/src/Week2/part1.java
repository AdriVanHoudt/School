package Week2;

import java.util.Scanner;

/**
 * User: Adri
 * Date: 27/09/13
 * Time: 15:42
 */
public class part1 {

    public static void main(String[] args) {
        System.out.println("Conversie tussen graden Celcius en Fahrenheit");

        int choice = 1;

        Scanner scanner = new Scanner(System.in);

        while (2 == choice || 1 == choice) {
            double value;
            System.out.println("Welke omzetting wil je doen?");
            System.out.println("1 Van °C naar °F");
            System.out.println("2 Van °F naar °C");
            System.out.println("Andere waarde om te stoppen");
            System.out.print("Uw keuze? :");

            choice = scanner.nextInt();

            System.out.print("Geef de waarde in " + ((1 == choice) ? "°C" : "°F") + ": ");

            value = scanner.nextInt();

           if (1 == choice){
               double newValue = value * 1.8 + 32 ;
               System.out.println(value + "C° = " + newValue + "°F");
           }
           if (2 == choice){
                double newValue = (value - 32) * 1.8;
                System.out.println(value + "F° = " + newValue + "°C");
           }


        }
    }
}
