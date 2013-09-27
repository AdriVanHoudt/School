package model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Adri
 * Date: 20/09/13
 * Time: 12:39
 */
@Entity
@Table(name = "t_artist")
public class Artist {

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")     //kan weggelaten worden
    private String name;

    @OneToMany(mappedBy = "artist")
    private Set<Song> songs = new HashSet<>();

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song){
        song.setArtist(this);
        this.songs.add(song);
    }
}
