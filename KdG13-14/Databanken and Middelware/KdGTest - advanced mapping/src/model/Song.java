package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.*;

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

    @ManyToMany(mappedBy = "songs")
    @Cascade(CascadeType.SAVE_UPDATE)
    private List<Playlist> playlists = new ArrayList<>();

    @ManyToMany(mappedBy = "songs")
    @Cascade(CascadeType.SAVE_UPDATE)
    private  List<Album> albums = new ArrayList<>();


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


    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @ManyToMany(mappedBy = "songs")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Genre> genres;

    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Collection<Genre> genres) {
        this.genres = genres;
    }

}
