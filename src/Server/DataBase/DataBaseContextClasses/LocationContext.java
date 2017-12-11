package Server.DataBase.DataBaseContextClasses;

import Server.DataBase.ModelClasses.Item;
import Server.DataBase.ModelClasses.Location;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class LocationContext extends Context {

    Session session;

    public LocationContext(Session session) {
        this.session = session;
    }


    public Location getLocationById(int id)
    {
        Location lc = null;
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            String queryString = "from Location where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            lc = (Location) query.uniqueResult();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            //session.close();
        }
        return lc;
    }

    public void deleteLocation(int id)
    {
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            Location lc = (Location) session.load(Location.class, new Integer(id));
            session.delete(lc);
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

    public void addLocation(Location lc)
    {
        super.add(lc, session);
    }

    public List<Location> getAllLocations() {
        List<Location> lc = new ArrayList<Location>();
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            lc  = session.createQuery("from Location").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            //session.close();
        }
        return lc;
    }

    public void updateLocation(Location lc) {
        super.update(lc, session);
    }
}
