import model.TestDatabaseHibernateLogin;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void insertStuff(Session session) {
        session.beginTransaction();
        List<TestDatabaseHibernateLogin> logins = new ArrayList<>();
        logins.add(TestDatabaseHibernateLogin.builder().nom("Wohler").prenom("Paraita").age(34).userName("paraita").build());
        logins.add(TestDatabaseHibernateLogin.builder().nom("Toto").prenom("Tata").age(18).userName("titi").build());
        logins.add(TestDatabaseHibernateLogin.builder().nom("AZE").prenom("RTY").age(50).userName("azerty").build());
        logins.forEach(session::save);
        session.getTransaction().commit();
    }

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        insertStuff(session);

        Query query = session.createQuery("from model.TestDatabaseHibernateLogin");
        List results = query.list();

        results.forEach(System.out::println);

        session.close();
        HibernateUtil.shutdown();

    }
}
