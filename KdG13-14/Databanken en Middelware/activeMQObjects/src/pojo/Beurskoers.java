package pojo;

/**
 * User: Adri
 * Date: 4/10/13
 * Time: 11:40
 */
public class Beurskoers {
    private String aandeel;
    private int prijs;

    public Beurskoers() {
    }

    public Beurskoers(String aandeel, int prijs) {
        this.aandeel = aandeel;
        this.prijs = prijs;
    }

    public String getAandeel() {
        return aandeel;
    }

    public void setAandeel(String aandeel) {
        this.aandeel = aandeel;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }
}
