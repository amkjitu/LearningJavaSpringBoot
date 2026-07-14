
package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        /// 1. Create objects of robot
        Robot robot1 = new Robot();
        robot1.setId(1);
        robot1.setName("Robo");
        robot1.setTech("AI");
        robot1.setPoints(100);

        Robot robot2 = new Robot();
        robot2.setId(1);
        robot2.setName("R2-D2");
        robot2.setTech("Droid");
        robot2.setPoints(150);

        /// 2. Load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        /// 3. Tell configuration which class should be handled by Hibernate
        configuration.addAnnotatedClass(org.example.Robot.class);

        /// 4. Build the session factory with the config
        SessionFactory factory = configuration.buildSessionFactory();

//        // Open the session for the transaction.
//        // Note: Transaction is only need for non-select operations (insert, update, delete)
//        try (factory; Session session = factory.openSession()) {
//            session.beginTransaction();
//            // A. save/create/store with hibernate
//            session.persist(robot1);  // session.save is deprecated since version 6
//            session.getTransaction().commit();
//            session.close()
//        }

//        // B. fetch/get with hibernate
//        try (Session session = factory.openSession()) {
//            Robot robot = session.get(Robot.class, 1);
//            System.out.println(robot);
//            session.close();
//        }

//        // C. Update/modify with hibernate
//        // Note: merge updates the existing record if it exists, otherwise it creates a new record.
//        try (Session session = factory.openSession()) {
//            session.beginTransaction();
//            session.merge(robot2);
//            session.getTransaction().commit();
//            session.close();
//        }

        // D. Delete/Remove with hibernate
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            // first get the object which you want to delete
            Robot robot = session.get(Robot.class, 2);

            // then remove that object
            session.remove(robot);
            session.getTransaction().commit();
            session.close();
        }

        /// 5. Finally, close the factory
        factory.close();
    }
}