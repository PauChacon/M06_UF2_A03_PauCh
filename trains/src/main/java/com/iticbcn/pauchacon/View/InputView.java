package com.iticbcn.pauchacon.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.hibernate.SessionFactory;

import com.iticbcn.pauchacon.Controllers.TrayectoController;
import com.iticbcn.pauchacon.Controllers.TrenController;
import com.iticbcn.pauchacon.model.Trayecto;
import com.iticbcn.pauchacon.model.Tren;

public class InputView {

    public static void mostrarMenu(BufferedReader reader, SessionFactory sessionFactory) throws Exception {
        try {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Ver todos los trayectos");
            System.out.println("2. Ver todos los trenes");
            System.out.println("3.Afegit un Tren");
            System.out.println("4. Salir");

            String input = reader.readLine(); 
            int opcion = Integer.parseInt(input); 

            switch(opcion) {
                case 1:
                    mostrarTodosLosTrayectos(sessionFactory);
                    break;
                case 2:
                    MostrarTrenes(TrenController.ListarTrenes(sessionFactory));
                    break;
                case 3:
                    TrenController.AddTren(reader, sessionFactory);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                
                default:
                    System.out.println("Opción no válida.");
            }
        } catch (IOException e) {
            System.err.println("Error al leer la entrada.");
            e.printStackTrace();
        }
    }

    public static void mostrarTodosLosTrayectos(SessionFactory sessionFactory) {
        TrayectoController controller = new TrayectoController(sessionFactory);
        List<Trayecto> trayectos = controller.obtenerTodosTrayectos();

        System.out.println("Listado de Trayectos:");
        for (Trayecto t : trayectos) {
            System.out.println(t);
        }
    }

    public static void MostrarTrenes(List<Tren>trens){
        for(Tren t : trens){
            System.out.println("-----------");
             System.out.println("Id Tren: " + t.getIdTren());
            System.out.println("Nom tren: " + t.getNombre());
            System.out.println("Model tren: " + t.getModelo());
        }
    }
}
