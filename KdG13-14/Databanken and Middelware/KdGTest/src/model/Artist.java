package model;

/**
 * User: Adri
 * Date: 20/09/13
 * Time: 12:39
 */
public class Artist {

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public Integer id;
    public String name;

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
}
