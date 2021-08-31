package repository.hibernate;

import org.hibernate.Session;
import utils.HibernateUtils;

public abstract class AbsRepository {
    protected static HibernateUtils hibernateUtils;

    public AbsRepository(){
        if (hibernateUtils == null)
            hibernateUtils = HibernateUtils.getInstance();
    }
}
