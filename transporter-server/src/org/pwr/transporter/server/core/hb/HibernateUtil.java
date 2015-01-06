package org.pwr.transporter.server.core.hb;


import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



/**
 * <pre>
 *    Hibernate utils class
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.2
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;


    private static SessionFactory buildSessionFactory() {
        if( sessionFactory != null )
            return sessionFactory;
        try {
            // Create Configuration
            File fileConfig = new File("hibernate.cfg.xml");
            Configuration cnf = new Configuration();
            cnf.configure(fileConfig);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cnf.getProperties()).build();

            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = cnf.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch ( Throwable ex ) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static SessionFactory getSessionFactory() {
        return buildSessionFactory();
    }


    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}
