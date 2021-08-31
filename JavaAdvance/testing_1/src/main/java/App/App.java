package App;

import entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

public class App {
    public static void main(String[] args) {
        HibernateUtils hibernateUtils = HibernateUtils.getInstance();
        Session session = hibernateUtils.openSession();
        session.getTransaction().begin();

        //  read data
        Query<User> query = session.createQuery("FROM User");
        query.list().forEach(System.out::println);

        // crete data
        session.save(new User( "b", "c", "1a"));
        query.list().forEach(System.out::println);

        // update data
        long _id = 10;
        User userGeted = (User) session.load(User.class, _id);
        userGeted.setPassword("newPassword");

        // delete  data
        _id = 12;
        User userDeleted = (User) session.load(User.class, _id);
        session.delete(userDeleted);

        System.out.println(query.getHibernateFlushMode());
        session.getTransaction().commit();
    }

}
