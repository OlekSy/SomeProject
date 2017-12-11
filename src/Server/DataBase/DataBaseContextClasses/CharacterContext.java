package Server.DataBase.DataBaseContextClasses;

import Server.DataBase.HibernateManager;
import Server.DataBase.ModelClasses.Character;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CharacterContext extends Context {

    Session session;

    public CharacterContext(Session session) {
        this.session = session;
    }

    public Character getCharacterById(int id)
    {
        Character ch = null;
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            String queryString = "from Character where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            ch = (Character) query.uniqueResult();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            //session.close();
        }
        return ch;
    }

    public void deleteCharacter(int id)
    {
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            Character ch = (Character) session.load(Character.class, new Integer(id));
            session.delete(ch);
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

    public void addCharacter(Character ch)
    {
        super.add(ch, session);
    }

    public List<Character> getAllCharacters() {
        List<Character> ch = new ArrayList<Character>();
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            ch  = session.createQuery("from Character").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            //session.close();
        }
        return ch;
    }

    public void updateCharacter(Character ch) {

        super.update(ch, session);
    }
}
