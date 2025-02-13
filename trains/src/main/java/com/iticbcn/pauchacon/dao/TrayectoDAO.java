package com.iticbcn.pauchacon.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iticbcn.pauchacon.model.Trayecto;

public class TrayectoDAO {

    private SessionFactory sessionFactory;

    public TrayectoDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Trayecto> obtenerTodos() {
        List<Trayecto> trayectos = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession(); 
            transaction = session.beginTransaction();
            trayectos = session.createQuery("FROM Trayecto", Trayecto.class).list();
            transaction.commit(); 
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); 
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close(); // cerrar la sesión manualmente al final
            }
        }
        return trayectos;
    }
    
}
