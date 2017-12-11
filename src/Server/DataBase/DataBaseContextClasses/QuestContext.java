package Server.DataBase.DataBaseContextClasses;

import Server.DataBase.ModelClasses.Quest;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class QuestContext extends Context {

    Session session;

    public QuestContext(Session session) {
        this.session = session;
    }


    public Quest getQuestById(int id) {

        Quest q = null;
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            String queryString = "from Quest where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            q = (Quest) query.uniqueResult();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            //session.close();
        }
        return q;
    }

    public void deleteQuest(int id) {
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            Quest q = (Quest) session.load(Quest.class, new Integer(id));
            session.delete(q);
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

    public void addQuest(Quest q) {
        super.add(q, session);
    }

    public List<Quest> getAllQuests() {
        List<Quest> q = new ArrayList<Quest>();
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            q  = session.createQuery("from Quest").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            //session.close();
        }
        return q;
    }

    public void updateQuest(Quest q) {
        super.update(q, session);
    }
}
