/**
 * User: Adri
 * Date: 20/09/13
 * Time: 10:23
 */
import model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx;

    public static void main(String[] args) {
        Main me = new Main();

        me.tx = me.session.beginTransaction();

        Artist a1 = me.makeArtist("pom");
        Artist a2 = me.makeArtist("pom2");
        Artist a3 = me.makeArtist("pom3");
        me.tx.commit();

        me.session = HibernateUtil.getSessionFactory().getCurrentSession();
        me.tx = me.session.beginTransaction();

        me.makeSong(3, "Alles geven",a1);
        me.makeSong(4, "Alles geven2", a2);
        me.makeSong(4, "Alles geven4", a3);
        me.makeSong(4, "Alles geven5", a1);
        me.tx.commit();

        me.session = HibernateUtil.getSessionFactory().getCurrentSession();
        me.tx = me.session.beginTransaction();

        me.makeAlbum("Ace of spades",me.getSongs() );
        me.tx.commit();
    }

    private Artist makeArtist(String name) {
        Artist artist = new Artist(name);
        session.saveOrUpdate(artist);
        return artist;
    }

    public void makeAlbum(String title, Set<Song> songs){
        Album album = new Album(title, songs);
        session.saveOrUpdate(album);
    }

    public void makeSong(Integer length, String name, Artist artist){
        Song song = new Song(length,name, artist);
        session.saveOrUpdate(song);
    }

    public Set<Song> getSongs(){
        Song song1 = (Song) session.get(Song.class, 1);
        System.out.println(song1.getTitle());

        Query query  = session.createQuery("from Song");
        Collection songs = query.list();

        for(Object s : songs){
            Song s1 = (Song) s;
            System.out.println(s1.getTitle());
        }

        Set<Song> songs2 = new HashSet<Song>(songs) ;
        return songs2;
    }


}
