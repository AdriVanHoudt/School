package model;

import javax.persistence.*;

/**
 * User: Adri
 * Date: 28/09/13
 * Time: 17:58
 */
@Entity
@Table(name = "t_artist")
@DiscriminatorValue(value = "S")
public class SoloArtist extends Artist {

    public SoloArtist() {
    }

    public SoloArtist(String name) {
        super(name);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;
}
