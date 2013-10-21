package model;

import javax.persistence.*;

/**
 * User: Adri
 * Date: 28/09/13
 * Time: 18:08
 */
@Entity
@Table(name = "t_artist")
@DiscriminatorValue(value = "B")
public class Band extends Artist {

    public Band() {
    }

    public Band(String name) {
        super(name);
    }

    private String bandName;

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }
}
