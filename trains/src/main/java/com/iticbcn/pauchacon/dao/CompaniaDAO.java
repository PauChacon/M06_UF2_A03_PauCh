package com.iticbcn.pauchacon.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.iticbcn.pauchacon.model.Compania;

public class CompaniaDAO {
    private SessionFactory sessionFactory;

    public CompaniaDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Compania obtenerCompaniaPorNombre(String nombre) {
        try (Session session = sessionFactory.openSession()) {
            Query<Compania> query = session.createQuery("FROM Compania WHERE nombre = :nombre", Compania.class);
            query.setParameter("nombre", nombre);
            List<Compania> result = query.list();
            return result.isEmpty() ? null : result.get(0);
        }
    }

    public void guardarCompania(Compania compania) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(compania);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public Compania obtenerOCrearCompania(String nombre) {
        Compania compania = obtenerCompaniaPorNombre(nombre);
        if (compania == null) {
            compania = new Compania();
            compania.setNombre(nombre);
            guardarCompania(compania);  
        }
        return compania;
    }
}
