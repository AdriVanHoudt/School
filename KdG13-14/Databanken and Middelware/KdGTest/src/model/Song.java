package model;

/**
 * User: Adri
 * Date: 20/09/13
 * Time: 10:01
 */

public class Song {

    public Integer id;
    public String title;
    public Integer length;
    public Artist artist;

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
