package repository.hibernate;

import entity.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.IRepository.IDepartmentRepository;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository extends AbsRepository implements IDepartmentRepository {
    @Override
    public List<Department> getAllDepartment() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Department> departmentQuery = session.createQuery("from Department ");
            return departmentQuery.list();
        } catch (Exception e) {
            return new ArrayList<Department>();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public Department getByNamme(String name) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Department> departmentQuery = session.createQuery("from Department where name like :keyword");
            String keyword = "%"+name+"%";
            departmentQuery.setParameter("keyword", keyword);
            return departmentQuery.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public List<Department> getByKeyword(String key) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Department> departmentQuery = session.createQuery("from Department where name like :keyword");
            String keyword = "%" + key +"%";
            departmentQuery.setParameter("keyword",keyword);
            return departmentQuery.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Department>();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public boolean create(Department newDepartment) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.getTransaction().begin();
            session.save(newDepartment);
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
    public boolean deleteByName(String name) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.getTransaction().begin();
            Query query = session.createQuery("delete from Department where name = :name");
            query.setParameter("name",name);
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
    public boolean deleteByID(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.getTransaction().begin();
            Query query = session.createQuery("delete from Department where id = :id");
            query.setParameter("id",id);
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
//        new DepartmentRepository().getByKeyword("a").forEach(System.out::println);
//    }
}
