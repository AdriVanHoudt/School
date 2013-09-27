package model;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: Adri
 * Date: 20/09/13
 * Time: 10:01
 */
@Entity
@Table(name = "t_song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer length;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "artistId", nullable = false)
    private Artist artist;

    public Song(Integer l, String s) {
        this.length = l;
        this.title = s;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Song() {
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Song(Integer duration, String title, Artist artist) {
        this.artist = artist;
        this.length = duration;
        this.title = title;
    }
}
