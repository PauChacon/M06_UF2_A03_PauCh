package com.iticbcn.pauchacon.Controllers;


import java.io.BufferedReader;
import java.util.List;

import org.hibernate.SessionFactory;

import com.iticbcn.pauchacon.dao.CompaniaDAO;
import com.iticbcn.pauchacon.dao.TrayectoDAO;
import com.iticbcn.pauchacon.model.Compania;
import com.iticbcn.pauchacon.model.Trayecto;

public class TrayectoController {

    private TrayectoDAO trayectoDAO;

    public TrayectoController(SessionFactory sessionFactory) {
        this.trayectoDAO = new TrayectoDAO(sessionFactory);
    }

    public List<Trayecto> obtenerTodosTrayectos() {
        return trayectoDAO.obtenerTodos();
    }

    public static Trayecto buscarTrayectoPorId(int idTrayecto, SessionFactory sf) throws Exception {
        TrayectoDAO trayectoDAO = new TrayectoDAO(sf);
        return trayectoDAO.buscarTrayectoPorId(idTrayecto);
    }

     public static void buscarTrayecto(BufferedReader br, SessionFactory sf) throws Exception {
        System.out.println("Introduce el ID del trayecto que quieres buscar:");
        int idTrayecto = Integer.parseInt(br.readLine());

        Trayecto trayecto = buscarTrayectoPorId(idTrayecto, sf);

        if (trayecto != null) {
            System.out.println("====================");
            System.out.println("Trayecto encontrado:");
            System.out.println(trayecto);
             if (trayecto.getCompania() != null) {
                System.out.println("Compañía: " + trayecto.getCompania().getNombre());
            } else {
                System.out.println("Compañía: No disponible");
            }

            if (trayecto.getTren() != null) {
                System.out.println("Tren: " + trayecto.getTren().getNombre());
            } else {
                System.out.println("Tren: No disponible");
            }

            if (trayecto.getReservas() != null && !trayecto.getReservas().isEmpty()) {
                System.out.println("Reservas: ");

                trayecto.getReservas().forEach(reserva -> System.out.println(reserva));
                System.out.println("====================");

            } else {
                System.out.println("Reservas: No disponibles");
                System.out.println("====================");

            }
        } else {
            System.out.println("No se encontró un trayecto con el ID proporcionado.");
        }
    }
    public void modificarTrayecto(BufferedReader reader,SessionFactory sf) throws Exception {
        TrayectoDAO trayectoDAO = new TrayectoDAO(sf);
        CompaniaDAO companiaDAO = new CompaniaDAO(sf);
        
        // Pedir ID del trayecto
        System.out.print("Ingrese el ID del trayecto que desea modificar: ");
        int id = Integer.parseInt(reader.readLine());
        
        // Buscar trayecto
        Trayecto trayecto = trayectoDAO.buscarTrayectoPorId(id);
        if (trayecto == null) {
            System.out.println(" No se encontró un trayecto con ese ID.");
            return;
        }

        // Mostrar trayecto actual
        System.out.println("Trayecto actual: " + trayecto);
        System.out.print("¿Desea modificar este trayecto? (S/N): ");
        if (!reader.readLine().equalsIgnoreCase("S")) {
            return;
        }

        // Menú de modificación
        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("1. Precio");
        System.out.println("2. Llegada");
        System.out.println("3. Salida");
        System.out.println("4. Hora");
        System.out.println("5. Capacidad");
        System.out.println("6. Compañía");

        int opcion = Integer.parseInt(reader.readLine());

        switch (opcion) {
            case 1:
                System.out.print("Nuevo precio: ");
                trayecto.setPrecio(Double.parseDouble(reader.readLine()));
                break;
            case 2:
                System.out.print("Nueva llegada: ");
                trayecto.setLlegada(reader.readLine());
                break;
            case 3:
                System.out.print("Nueva salida: ");
                trayecto.setSalida(reader.readLine());
                break;
            case 4:
                System.out.print("Nueva hora: ");
                trayecto.setHora(reader.readLine());
                break;
            case 5:
                System.out.print("Nueva capacidad: ");
                trayecto.setCapacidad(Integer.parseInt(reader.readLine()));
                break;
            case 6:
                System.out.print("Nuevo nombre de compañía: ");
                String nombreCompania = reader.readLine();
                Compania nuevaCompania = companiaDAO.obtenerOCrearCompania(nombreCompania);
                trayecto.setCompania(nuevaCompania);
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        trayectoDAO.modificarTrayecto(trayecto);
        System.out.println(" Trayecto modificado correctamente.");
    }
}
