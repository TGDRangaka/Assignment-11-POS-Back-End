package lk.ijse.assignment11posbackend.util;

import lk.ijse.assignment11posbackend.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactoryConfig {
    private SessionFactory sessionFactory;
    public static HibernateFactoryConfig hibernateFactoryConfig;

    private HibernateFactoryConfig(){
        Configuration configuration = new Configuration();
        configuration.configure();

        configuration
                .addAnnotatedClass(Customer.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static HibernateFactoryConfig getInstance(){
        return hibernateFactoryConfig == null ? hibernateFactoryConfig = new HibernateFactoryConfig() : hibernateFactoryConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
