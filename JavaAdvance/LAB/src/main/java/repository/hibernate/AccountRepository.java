package repository.hibernate;

import entity.Account;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.IRepository.IAccountRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository extends AbsRepository implements IAccountRepository {

    @Override
    public boolean isEmailExists(String email) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Long> query = session.createQuery("select count(*) from Account where email = :email");
            query.setParameter("email", email);
            return query.uniqueResult() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public boolean isUserNameExsist(String username) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Long> query = session.createQuery("select count(*) from Account where username = :username");
            query.setParameter("username", username);
            return query.uniqueResult() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public List<Account> getAll() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
//            Query<Account> accountQuery = session.createQuery("from Account");
//            return accountQuery.list();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Account> query = builder.createQuery(Account.class);
            Root<Account> root = query.from(Account.class); // from
            query.select(root);

            // criteria
//            co dieu kien
//            int id = 0;
//            query.where(builder.equal(root.get("id"),id));

//                get only fullname
//            query.multiselect(root.get("fullname"));

//                function in criteria
//            Expression<Integer> monthExp = builder.function("month",Integer.class,root.get("createdate"));
//            Expression<Integer> monthCurrent = builder.function("month",Integer.class,builder.currentDate());
//            query.where(builder.equal(monthExp,monthCurrent));

//                co sqp xep
//            query.orderBy(builder.desc(root.get("createdate")));
            // native query



            return session.createQuery(query).list();
        } catch (Exception e) {
            return new ArrayList<Account>();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public Account getAccountByEmail(String email) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Account> accountQuery = session.createQuery("from Account where email=:email");
            accountQuery.setParameter("email",email);
            return accountQuery.uniqueResult();
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public Account getAccountByUsername(String username) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Account> accountQuery = session.createQuery("from Account where username=:username");
            accountQuery.setParameter("username",username);
            return accountQuery.uniqueResult();
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public List<Account> getAccountForPaging(int page, int numPerPage) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Account> accountQuery = session.createQuery("from Account");
            int skiped = (page-1)*numPerPage;
            return accountQuery.setFirstResult(skiped).setMaxResults(numPerPage).list();
        } catch (Exception e) {
            return new ArrayList<Account>();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public boolean create(Account newAccount) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.getTransaction().begin();
            session.save(newAccount);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public boolean updateByID(int ID, Account newAccount) {
        return false;
    }

    @Override
    public boolean updateByEmail(String email, Account newAccount) {
        return false;
    }

    @Override
    public boolean updateByUsername(String username, Account newAccount) {
        return false;
    }

    @Override
    public boolean deleteAccountByEmail(String email) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.getTransaction().begin();
            Query query = session.createQuery("delete from Account where email = :email");
            query.setParameter("email", email);
            query.executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public boolean deleteAccountByUsername(String username) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.getTransaction().begin();
            Query query = session.createQuery("delete from Account where username = :username");
            query.setParameter("username", username);
            query.executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public boolean deleteAccountByID(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.getTransaction().begin();
            Query query = session.createQuery("delete from Account where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

//    public static void main(String[] args) {
//        AccountRepository accountRepository = new AccountRepository();
//        accountRepository.getAccountForPaging(2,5).forEach(System.out::println);
//    }
}
