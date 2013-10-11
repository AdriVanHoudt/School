package Week4;

import java.util.Scanner;

/**
 * User: Adri
 * Date: 11/10/13
 * Time: 15:46
 */
public class TestAuto {

    public static void main(String[] args) {
        Auto mijnAuto = new Auto("Mini OneD", "", 5);
        System.out.println("Uw auto is een " + mijnAuto.getMerk());
        System.out.println("Uw auto is een " + mijnAuto.getMerk() + " met " + mijnAuto.getFiscaalVermogen() +"PK");
        System.out.println("Uw auto is een " + mijnAuto.getMerk() + " met " + mijnAuto.getFiscaalVermogen() +"PK. U betaald €" + mijnAuto.berekenVerkeersbelasting() + " verkeersbelasting.");

        Scanner scanner = new Scanner(System.in);

        String merk = " ";
        String type;
        int vermogen;

        while(!merk.equalsIgnoreCase("stop")){

            System.out.print("Geef het merk:");
            merk = scanner.nextLine();

            if (merk.equalsIgnoreCase("stop")) return;

            System.out.print("Geef het type:");
            type = scanner.nextLine();

            System.out.print("Geef het fiscaal vermogen");
            vermogen = scanner.nextInt();
            scanner.nextLine();

            Auto tempCar = new Auto(merk, type, vermogen);
            System.out.println("Uw auto is een " + tempCar.getMerk() + " met " + tempCar.getFiscaalVermogen() +"PK. U betaald €" + tempCar.berekenVerkeersbelasting() + " verkeersbelasting.");
        }
    }
}
