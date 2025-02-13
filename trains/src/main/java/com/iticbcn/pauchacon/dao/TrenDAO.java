package com.iticbcn.pauchacon.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.iticbcn.pauchacon.model.Tren;


public class TrenDAO {
    
     private SessionFactory sessionFactory;

    public TrenDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
     public List<Tren> LlistarTrens() throws Exception {
        List<Tren> trens = new ArrayList<>();

        try (Session ses = sessionFactory.openSession()) {
            try {
                Query<Tren> q = ses.createQuery("from Tren",Tren.class);
                trens = q.list();
            } catch (JDBCException jdbcex) {
                handleException(ses, jdbcex, "Error de JDBC");                       
            } catch (HibernateException hbex) {
                handleException(ses, hbex, "Error d'Hibernate a la consulta");     
            } catch (Exception ex) {
                handleException(ses, ex, "Altres excepcions");    
            }
        } catch (SessionException sesexcp) {
            System.err.println("Error de Sessió: "+sesexcp.getMessage());
            throw sesexcp;
        } catch (HibernateException hbex) {
            System.err.println("Error d'Hibernate: "+hbex.getMessage());
            throw hbex;
        }

        return trens;
    }

    public void insertTren(Tren tren) throws Exception {
        try (Session ses = sessionFactory.openSession()) {
            try {
                ses.beginTransaction();
                ses.persist(tren);  // Guarda el objeto tren en la base de datos
                ses.getTransaction().commit();
            } catch (JDBCException jdbcex) {
                handleException(ses, jdbcex, "Error de JDBC");                       
            } catch (HibernateException hbex) {
                handleException(ses, hbex, "Error de Hibernate a la consulta");     
            } catch (Exception ex) {
                handleException(ses, ex, "Altres excepcions");    
            }
        } catch (SessionException sesexcp) {
            System.err.println("Error de Sessió: "+sesexcp.getMessage());
            throw sesexcp;
        } catch (HibernateException hbex) {
            System.err.println("Error d'Hibernate: "+hbex.getMessage());
            throw hbex;
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
