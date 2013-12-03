import java.util.Calendar;

public class Datum implements Comparable<Datum> {
    private int dag;
    private int maand;
    private int jaar;

    public Datum(int dag, int maand, int jaar) {
        if (!isGeldigeDatum(dag, maand, jaar)) {
            throw new IllegalArgumentException("Dit is een ongeldige datum");
        }
        this.dag = dag;
        this.maand = maand;
        this.jaar = jaar;
    }

    @Override
    public String toString() {
        return dag + "/" + maand + "/" + jaar;
    }

    @Override
    public int compareTo(Datum other) {
        if (this.jaar < other.jaar) return -1;
        if (this.jaar > other.jaar) return 1;
        if (this.maand < other.maand) return -1;
        if (this.maand > other.maand) return 1;
        if (this.dag < other.dag) return -1;
        if (this.dag > other.dag) return 1;
        return 0;
    }

    private boolean isGeldigeDatum(int dag, int maand, int jaar) {
        if (jaar < 1600)
            return false;
        else if (maand < 1 || maand > 12)
            return false;
        else if (dag < 1 || dag > 31)
            return false;
        else if (dag == 31 && (maand == 2 || maand == 4 || maand == 6 || maand == 9 || maand == 11))
            return false;
        else if (dag == 30 && maand == 2)
            return false;
        else return !(dag == 29 && maand == 2 && (jaar % 4 > 0 || jaar % 100 == 0) && jaar % 400 > 0);
    }

    public static Datum vandaag() {
        Calendar c = Calendar.getInstance();
        return new Datum(c.get(Calendar.DAY_OF_MONTH),
                c.get(Calendar.MONTH),
                c.get(Calendar.YEAR));
    }

}
