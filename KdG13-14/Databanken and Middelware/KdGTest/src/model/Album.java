package model;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Adri
 * Date: 20/09/13
 * Time: 11:21
 */
public class Album {

    public Album() {
    }

    public Integer id;
    public String title;
    public Set<Song> songs = new HashSet<>();

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public Album(String title, Set<Song> songs) {
        this.title = title;
        this.songs = songs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song){
        songs.add(song);
    }
}
