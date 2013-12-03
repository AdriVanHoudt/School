import java.util.InputMismatchException;
import java.util.Scanner;

//TODO todo gebruiken
public class Wunderlist {
    public static void main(String[] args) {
        new Wunderlist();
    }

    private TodoLijst lijst;
    private Scanner scanner = new Scanner(System.in);

    public Wunderlist() {
        lijst = new TodoLijst();
        while (true) toonMenu();
    }

    private void toonMenu() {
        System.out.println("TODOLIST:");
        System.out.println("---------");
        lijst.printAll();
        System.out.println("1)item toevoegen");
        System.out.println("2)item op afgewerkt zetten");
        System.out.println("3)afgewerkte items opkuisen");
        System.out.println("---------------------");
        System.out.print("Geef je keuze:");
        try {
            int keuze = scanner.nextInt();

            scanner.nextLine();
            switch (keuze) {
                case 1:
                    toonVoegItemToeMenu();
                    break;
                case 2:
                    toonZetItemOpDoneMenu();
                    break;
                case 3:
                    verwijderAfgewerkteItems();
                    break;
                default:
            }
        } catch (InputMismatchException e) {
            System.out.println("Geef een getal in!");
            scanner.nextLine();
        }
    }

    private void toonVoegItemToeMenu() {
        System.out.println("VOEG EEN ITEM TOE");
        System.out.println("-----------------");
        System.out.print("Geef de titel:");
        String titel = scanner.nextLine();
        System.out.println("Geef nu de deadline in voor het item:");
        System.out.print("Geef de dag:");
        int dag = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Geef de maand:");
        int maand = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Geef het jaar:");
        int jaar = scanner.nextInt();
        scanner.nextLine();
        try {
            lijst.add(titel, new Datum(dag, maand, jaar));
            System.out.println("Het item is toegevoegd");
        } catch (TodoException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void toonZetItemOpDoneMenu() {
        System.out.println("ZET EEN ITEM OP AFGEWERKT");
        System.out.println("-------------------------");
        lijst.printNietAfgewerkt();
        System.out.print("Welke item?");
        int itemIndex = scanner.nextInt();
        scanner.nextLine();
        try {
            lijst.zetOpAfgewerkt(itemIndex);
        } catch (TodoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void verwijderAfgewerkteItems() {
        lijst.verwijderAfgewekteItems();
    }
}
