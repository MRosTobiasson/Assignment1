import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

public class HibernateTest {

    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Tutor tutor1 = new Tutor("Nahid Nahidsson", "1-HOW-2017", 90000);
        // Student student1 = new Student("Bengt Bengtsson", "1-HOW-2017");
        // Student student2 = new Student("Adam Adamsson", "1-HOW-2017");
        // Student student3 = new Student("Sara Sarasson", "2-NIK-2019");

        // session.save(tutor1);
        // session.save(student1);
        // session.save(student2);
        // session.save(student3);

        Tutor myTutor = (Tutor) session.get(Tutor.class, 1);
        List<Student> students = myTutor.getTeachingGroup();

        for (Student student : students) {
            System.out.println(student);
        }

        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

}
