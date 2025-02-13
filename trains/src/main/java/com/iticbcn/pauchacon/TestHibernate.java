package com.iticbcn.pauchacon;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iticbcn.pauchacon.model.Compania;

public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Iniciar una transacción
            transaction = session.beginTransaction();

            // Crear una instancia de la entidad Compania
            Compania compania = new Compania();
            compania.setNombre("Renfe");
            compania.setLocalidad("Barcelona");

            // Guardar la entidad en la base de datos
            session.save(compania);

            // Confirmar la transacción
            transaction.commit();

            System.out.println("Conexión exitosa. ¡Datos guardados correctamente!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
