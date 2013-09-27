package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Adri
 * Date: 27/09/13
 * Time: 11:03
 */
@Entity
@Table(name = "t_playlist")
public class Playlist {

    public Playlist() {
    }

    public Playlist(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "t_playlist_song",
            joinColumns = {@JoinColumn(name = "playlistId")},
            inverseJoinColumns = {@JoinColumn(name = "songId")})
    private Set<Song> songs = new HashSet<>();




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        song.addPlaylist(this);
        this.songs.add(song);
    }
}
