package Server.DataBase.DataBaseContextClasses;

import Server.DataBase.ModelClasses.NPC;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class NPCContext extends Context {

    Session session;

    public NPCContext(Session session) {
        this.session = session;
    }


    public NPC getNPCById(int id) {
        NPC npc = null;
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            String queryString = "from NPC where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            npc = (NPC) query.uniqueResult();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            //session.close();
        }
        return npc;
    }

    public void deleteNPC(int id) {
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            NPC npc = (NPC) session.load(NPC.class, new Integer(id));
            session.delete(npc);
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

    public void addNPC(NPC npc) {
        super.add(npc, session);
    }

    public List<NPC> getAllNPCs() {
        List<NPC> npc = new ArrayList<NPC>();
        Transaction trns = null;

        try {
            trns = session.beginTransaction();
            npc  = session.createQuery("from NPC").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            //session.flush();
            //session.close();
        }
        return npc;
    }

    public void updateNPC(NPC npc) {
        super.update(npc, session);
    }
}
