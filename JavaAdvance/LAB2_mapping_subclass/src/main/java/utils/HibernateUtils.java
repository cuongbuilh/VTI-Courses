package utils;

import entity.Account;
import entity.Address;
import entity.Department;

import entity.DetailDepartment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;


public class HibernateUtils {
    private static HibernateUtils instance;

    private Configuration configuration;
    private SessionFactory sessionFactory;
    private final String HIBERNATE_CONFIG_FILE = "hibernate.cfg.xml";

    private HibernateUtils() {
        configure();
    }

    private void configure() {
        configuration = new Configuration();
        configuration.configure(HIBERNATE_CONFIG_FILE);

        // add entity
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(DetailDepartment.class);

    }

    public static HibernateUtils getInstance() {
        if (instance == null)
            instance = new HibernateUtils();
        return instance;
    }

    private SessionFactory buildSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    public Session openSession() {
        buildSessionFactory();
        return sessionFactory.openSession();
    }

    public void closeFactory() {
        if (sessionFactory != null && sessionFactory.isOpen())
            sessionFactory.close();
    }

    public static void main(String[] args) {
        Session session = HibernateUtils.getInstance().openSession();
        Query<Account> query  = session.createQuery("from Account ");
        List<Account> accounts = query.list();
        accounts.forEach(a -> {
            System.out.println(a.getDepartment().getName());
        });
    }
}
