package Week4;

/**
 * User: Adri
 * Date: 11/10/13
 * Time: 15:45
 */
public class Auto {
    private String merk;
    private String type;
    private int fiscaalVermogen;

    public Auto(String merk, String type, int fiscaalVermogen) {
        this.merk = merk;
        this.type = type;
        this.fiscaalVermogen = fiscaalVermogen;
    }

    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
    }

    public int getFiscaalVermogen() {
        return fiscaalVermogen;
    }

    public double berekenVerkeersbelasting(){

        switch (fiscaalVermogen){
            case 1|2|3|4:
                return 75.77;
            case 5:
                return 94.91;
            case 6:
                return 137.02;
            default:
                return 1938.68+(105.73*(fiscaalVermogen-20));
        }

    }
}

