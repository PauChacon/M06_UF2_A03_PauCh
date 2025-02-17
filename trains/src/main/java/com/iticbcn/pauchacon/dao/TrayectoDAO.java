package com.iticbcn.pauchacon.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
    


    public Trayecto buscarTrayectoPorId(int idTrayecto) throws Exception {
        Trayecto trayecto = null;

        try (Session ses = sessionFactory.openSession()) {
            try {
                Query<Trayecto> query = ses.createQuery("from Trayecto t " +
                        "left join fetch t.compania " +
                        "left join fetch t.tren " +
                        "left join fetch t.reservas " +
                        "where t.idTrayecto = :idTrayecto", Trayecto.class);
                query.setParameter("idTrayecto", idTrayecto);
                
                trayecto = query.uniqueResult();
            } catch (Exception ex) {
                handleException(ses, ex, "Error al buscar trayecto por ID");
            }
        } catch (Exception e) {
            System.err.println("Error al abrir la sesión de Hibernate: " + e.getMessage());
            throw e;
        }

        return trayecto;
    }

    public void modificarTrayecto(Trayecto trayecto) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.merge(trayecto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }



    private void handleException(Session ses, Exception ex, String errorMsg) throws Exception{
        if (ses.getTransaction() != null && ses.getTransaction().isActive()) {
            ses.getTransaction().rollback();
        }
        System.err.println(errorMsg + ": " + ex.getMessage());
        throw ex;
    }
}
