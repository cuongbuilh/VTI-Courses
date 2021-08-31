package repository.hibernate;

import entity.Position;
import entity.enums.PositionName;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.IRepository.IPositionRepository;

import java.util.List;

public class PositionRepository extends AbsRepository implements IPositionRepository {
    @Override
    public List<Position> getAllPosition() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Position> positionQuery = session.createQuery("from Account");
            return positionQuery.list();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public Position getByName(String name) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Position> positionQuery = session.createQuery("from Position P where  name = :name");
            positionQuery.setParameter("name", PositionName.of(name));
            return positionQuery.list().get(0);
        }catch (Exception ignore){
            return null;
        }
        finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

//    public static void main(String[] args) {
//        PositionRepository positionRepository = new PositionRepository();
//        System.out.println( positionRepository.getByName("0"));
//    }
}
