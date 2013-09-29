/**
 * User: Adri
 * Date: 20/09/13
 * Time: 10:23
 */

import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        SoloArtist a1 = new SoloArtist("Solo");
        a1.setLastName("peeters");
        Band a2 = new Band("Band");
        a2.setBandName("Tool");
        SoloArtist a3 = new SoloArtist("Artist3");

        session.saveOrUpdate(a1);
        session.saveOrUpdate(a2);

        Song s1 = new Song(3, "Alles geven");
        Song s2 = new Song(4, "Alles geven2");
        Song s3 = new Song(4, "Alles geven4");

        //only save or update objects into session when all connections are there
        //e.g. don't save song in session unless artist is added

        //artist in song set by artist himself
        a1.addSong(s1);
        a1.addSong(s2);
        a2.addSong(s3);

        Album al1 = new Album("Ace of spades");
        Album al2 = new Album("Ace of hearts");

        al1.addSong(s1);
        al1.addSong(s2);
        al2.addSong(s3);

        session.saveOrUpdate(al1);
        session.saveOrUpdate(al2);

        Playlist pl1 = new Playlist("Top 3");
        pl1.addSong(s1);
        pl1.addSong(s3);
        pl1.addSong(s2);

        session.saveOrUpdate(al1);
        session.saveOrUpdate(al2);
        session.saveOrUpdate(pl1);
        tx.commit();
    }

}
