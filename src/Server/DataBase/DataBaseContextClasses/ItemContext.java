package Server.DataBase.DataBaseContextClasses;

import Server.DataBase.ModelClasses.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ItemContext extends Context {

    Session session;

    public ItemContext(Session session) {
        this.session = session;
    }


    public Item getItemById(int id)
    {
        Item it = null;
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            String queryString = "from Item where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            it = (Item) query.uniqueResult();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            //session.close();
        }
        return it;
    }

    public void deleteItem(int id)
    {
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            Item it = (Item) session.load(Item.class, new Integer(id));
            session.delete(it);
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

    public void addItem(Item it)
    {
        super.add(it, session);
    }

    public List<Item> getAllItems() {
        List<Item> it = new ArrayList<Item>();
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            it  = session.createQuery("from Item").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            //session.close();
        }
        return it;
    }

    public void updateItem(Item it) {
        super.update(it, session);
    }
}
