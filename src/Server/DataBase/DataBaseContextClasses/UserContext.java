package Server.DataBase.DataBaseContextClasses;

import Server.DataBase.ModelClasses.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserContext extends Context {

    Session session;

    public UserContext(Session session) {
        this.session = session;
    }


    public User getUserById(int id) {

        User u = null;
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            String queryString = "from User where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            u = (User) query.uniqueResult();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            //session.close();
        }
        return u;
    }

    public void deleteUser(int id) {
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            User u = (User) session.load(User.class, new Integer(id));
            session.delete(u);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            //session.close();
        }
    }

    public void addUser(User u) {
        super.add(u, session);
    }

    public List<User> getAllUsers() {
        List<User> u = new ArrayList<User>();
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            u  = session.createQuery("from User").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            //session.close();
        }
        return u;
    }

    public void updateUser(User u) {
        super.update(u, session);
    }
}
