package org.example.services;

import org.example.entities.Centre;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class CentreService extends BaseService implements Repository<Centre> {

    public CentreService() {
        super();
    }


    @Override
    public boolean create(Centre o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Centre o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Centre o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Centre findById(int id) {
        Centre centre = null;
        session = sessionFactory.openSession();
        centre = session.get(Centre.class, id);
        session.close();
        return centre;
    }

    @Override
    public List<Centre> find() {
        session = sessionFactory.openSession();
        Query<Centre> centreQuery = session.createQuery("from Centre ");
        List<Centre> centres = centreQuery.list();
        session.close();
        return centres;
    }
}
