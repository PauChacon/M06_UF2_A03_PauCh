package com.iticbcn.pauchacon.Controllers;


import java.util.List;

import org.hibernate.SessionFactory;

import com.iticbcn.pauchacon.dao.TrayectoDAO;
import com.iticbcn.pauchacon.model.Trayecto;

public class TrayectoController {

    private TrayectoDAO trayectoDAO;

    public TrayectoController(SessionFactory sessionFactory) {
        this.trayectoDAO = new TrayectoDAO(sessionFactory);
    }

    public List<Trayecto> obtenerTodosTrayectos() {
        return trayectoDAO.obtenerTodos();
    }
}
