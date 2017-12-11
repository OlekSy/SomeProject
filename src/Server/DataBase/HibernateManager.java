package Server.DataBase;

import Server.DataBase.DataBaseContextClasses.CharacterContext;
import Server.DataBase.DataBaseContextClasses.UserContext;
import Server.DataBase.ModelClasses.*;
import Server.DataBase.ModelClasses.Character;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateManager {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("/Server/DataBase/resources/hibernate.cfg.xml");

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() throws HibernateException {
        return ourSessionFactory;
    }

    public static void main(final String[] args) throws Exception {

//        List<User> us = null;
          List<Character> ch = null;
//        List<NPC> npc = null;
//        List<Item> item = null;
//        List<Quest> quest = null;
        //Session session = HibernateManager.getSession();

        //session.beginTransaction();



//        session.save(us);
//
//        Character charac  = new Character();
//        charac.setName("Vasya");
//        charac.setLevel(10);
//        charac.setExpirience(500);
//        //charac.setId_Character(5);
//        charac.setUser(us);
//        us.getCharacters().add(charac);
//        session.save(charac);
//        Query q = session.createQuery("FROM User ");
//        Query q1 = session.createQuery("FROM Character");
//        Query q2 = session.createQuery("FROM NPC");
//        Query q3 = session.createQuery("FROM Item");
//        Query q4 = session.createQuery("FROM Quest");

//        session.getTransaction().commit();
////        System.out.println(q);
//        us = q.list();
//        ch = q1.list();
//        npc = q2.list();
//        item = q3.list();
//        quest = q4.list();
//        for (User c: us) {
//
//            System.out.println(c.toString());
//        }

//        for (Character c: ch) {
//
//            System.out.println(c.toString());
//        }

//        for (NPC np: npc) {
//
//            System.out.println(np.toString());
//        }
//        for (Item i: item) {
//
//            System.out.println(item.toString());
//        }
//        for (Quest qv: quest) {
//
//            System.out.println(qv.toString());
//        }

//        System.out.println(users);
        Session session = HibernateManager.getSessionFactory().openSession();
        //CharacterContext c = new CharacterContext(session);

//        for (Character asd: c.getAllCharacters()) {
//
//            System.out.println(asd.toString());
//        }
        UserContext u = new UserContext(session);
        User us = new User();
        us.setNickName("Ivan");
        us.setEmail("asdasdasd");
        us.setPassword("123123123");
        u.addUser(us);
//
//        Set<Item> item = new HashSet<>();
//        item = asd1.getItems();
//        User user = new User();
//        user = asd1.getUser();
//        Location loc = new Location();
//        loc = asd1.getLocation();
//
//        session.close();
//        session = HibernateManager.getSessionFactory().openSession();
//        c = new CharacterContext(session);
//
//        Character asd2 = new Character();
//        asd2.setName("Gregor");
//        asd2.setUser(user);
//        asd2.setItems(item);
//        asd2.setLocation(loc);
//        asd2.setExpirience(120);
//        asd2.setCoordinates("12,32,43");
//        asd2.setLevel(5);
//        c.addCharacter(asd2);
//
//        ch = c.getAllCharacters();
//        for (Character sdf: ch) {
//
//            System.out.println(sdf.toString());
//        }

        session.close();

    }
}