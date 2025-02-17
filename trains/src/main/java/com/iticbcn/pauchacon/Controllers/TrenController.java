package com.iticbcn.pauchacon.Controllers;

import java.io.BufferedReader;
import java.util.List;

import org.hibernate.SessionFactory;

import com.iticbcn.pauchacon.dao.TrenDAO;
import com.iticbcn.pauchacon.model.Tren;


public class TrenController {
    public static List<Tren> ListarTrenes(SessionFactory sf) throws Exception {

        TrenDAO trendao = new TrenDAO(sf);
        return trendao.LlistarTrens();
    }
    public static void AddTren(BufferedReader br, SessionFactory sf) throws Exception {
        Tren t = new Tren();
        TrenDAO tdao = new TrenDAO(sf);
    
        System.out.println("INSERIR NOU NOM PEL TREN");
        String nombre = br.readLine();
        t.setNombre(nombre);
    
        System.out.println("INSERIR NOU MODEL PEL TREN");
        String modelo = br.readLine();
        t.setModelo(modelo);
    
        tdao.insertTren(t);
    
        System.out.println("Tren insertado correctamente");
    }
    
}
