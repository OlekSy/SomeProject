package Client.DataBase;

import Client.DataBase.ModelClasses.FavoriteServer;
import Server.DataBase.ModelClasses.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateClientManager {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("/Client/DataBase/resources/hibernateClient.cfg.xml");

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
        //List<User> users = null;
        Session session = HibernateClientManager.getSession();
        List<FavoriteServer> s = null;

        session.beginTransaction();

        Query q = session.createQuery("FROM FavoriteServer");

        session.getTransaction().commit();
        s = q.list();
        for (FavoriteServer server: s) {

            System.out.println(server.toString()+"\n");
        }
        //users = q.list();
        //Criteria c = session.createCriteria(User.class);
//        for (User user: users) {
//
//            System.out.println(user.toString());
//        }
//        System.out.println(users);
        //session

    }
}
