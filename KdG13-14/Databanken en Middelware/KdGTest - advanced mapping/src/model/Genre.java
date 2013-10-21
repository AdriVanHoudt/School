package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Adri
 * Date: 29/09/13
 * Time: 15:17
 */
@Entity
@Table(name = "t_genre")
public class Genre {
    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "t_genre_song",
            joinColumns = {@JoinColumn(name = "songId")},
            inverseJoinColumns = {@JoinColumn(name = "songId0")}
    )

    private List<Song> songs = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addSong(Song song){
        this.songs.add(song);
    }
}
