package org.example.services;

import org.example.entities.Activite;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class ActiviteService extends BaseService implements Repository<Activite> {

    public ActiviteService(){
        super();
    }


    @Override
    public boolean create(Activite o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Activite o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Activite o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Activite findById(int id) {
        Activite activite = null;
        session = sessionFactory.openSession();
        activite = session.get(Activite.class, id);
        session.close();
        return activite;
    }

    @Override
    public List<Activite> find() {
        session = sessionFactory.openSession();
        Query<Activite> activiteQuery = session.createQuery("from Activite ");
        List<Activite> activites = activiteQuery.list();
        session.close();
        return activites;
    }
}
