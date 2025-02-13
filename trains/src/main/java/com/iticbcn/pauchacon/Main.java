package com.iticbcn.pauchacon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.SessionFactory;

import com.iticbcn.pauchacon.View.InputView;


public class Main {
    public static void main(String[] args) throws Exception {

        SessionFactory sf = HibernateUtil.getSessionFactory();

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("=============================");
            System.out.println("Gestio de Trens");
            System.out.println("=============================");
            InputView.mostrarMenu(bf,sf);

        } catch (IOException ioe) {
            System.err.println("Error d'entrada");
        }
    }


}   