/**
 * User: Adri
 * Date: 20/09/13
 * Time: 10:23
 */

import model.Album;
import model.Artist;
import model.Playlist;
import model.Song;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        Artist a1 = new Artist("Artist1");
        Artist a2 = new Artist("Artist2");
        Artist a3 = new Artist("Artist3");

        Song s1 = new Song(3, "Alles geven");
        Song s2 = new Song(4, "Alles geven2");
        Song s3 = new Song(4, "Alles geven4");

        //artist in song set by artist himself
        a1.addSong(s1);
        a1.addSong(s2);
        a1.addSong(s3);

        Album al1 = new Album("Ace of spades");

        al1.addSong(s1);
        al1.addSong(s2);
        al1.addSong(s3);

        Playlist pl1 = new Playlist("Top 3");
        pl1.addSong(s1);
        pl1.addSong(s3);
        pl1.addSong(s2);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(al1);
        session.saveOrUpdate(pl1);
        tx.commit();
    }

}
