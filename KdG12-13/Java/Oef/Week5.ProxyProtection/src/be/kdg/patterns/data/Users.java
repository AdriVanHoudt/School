package be.kdg.patterns.data;

import java.util.ArrayList;
import java.util.List;

/**
 * DOE DIT ALS EERSTE!
 *
 * Wijzig deze klasse zodat er maar één object van de klasse Users kan bestaan.
 */
public class Users {
    private List<User> users;

    public Users() {
        users = new ArrayList<User>();
        voegWatUsersToe();
    }

    private void voegWatUsersToe() {
        users.add(new User("BE01-0012-3456-7890", "matrix"));
        users.add(new User("BE02-0123-4567-8901", "psycho"));
        users.add(new User("BE03-4567-8901-1234", "crash"));
    }

    public List<User> getUsers() {
        return users;
    }
}
