package model;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: Adri
 * Date: 20/09/13
 * Time: 11:21
 */
@Entity
@Table(name = "t_album")
public class Album {

    public Album() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(
            name = "t_album_song",
            joinColumns = {@JoinColumn(name = "albumId")},
            inverseJoinColumns = {@JoinColumn(name = "songId")})
    private List<Song> songs = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public Album(String title, List<Song> songs) {
        this.title = title;
        this.songs = songs;
    }

    public Album(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song){
        songs.add(song);
    }
}
