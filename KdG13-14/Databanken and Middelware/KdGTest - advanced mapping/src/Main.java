/**
 * User: Adri
 * Date: 20/09/13
 * Time: 10:23
 */

import model.Album;
import model.Artist;
import model.Song;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        Artist a1 = new Artist("pom");
        Artist a2 = new Artist("pom2");
        Artist a3 = new Artist("pom3");

        Song s1 = new Song(3, "Alles geven", a1);
        Song s2 = new Song(4, "Alles geven2", a2);
        Song s3 = new Song(4, "Alles geven4", a3);
        Song s4 = new Song(4, "Alles geven5", a1);

        Album al1 = new Album("Ace of spades");
        al1.addSong(s1);
        al1.addSong(s2);
        al1.addSong(s3);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(al1);
        tx.commit();
    }

}
