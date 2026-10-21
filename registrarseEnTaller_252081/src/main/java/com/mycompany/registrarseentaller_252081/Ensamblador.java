/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrarseentaller_252081;

import control.ControlInscripcion;
import model.ModeloInscripcion;
import model.RepositorioAlumnos;
import model.RepositorioInscripciones;
import model.RepositorioTalleres;
import view.MainFrame;

/**
 *
 * @author luisb
 */
public class Ensamblador {

    public Ensamblador() {
        
        RepositorioAlumnos alumnos = new RepositorioAlumnos();
        RepositorioInscripciones inscripciones = new RepositorioInscripciones();
        RepositorioTalleres talleres = new RepositorioTalleres();
        
        
        ModeloInscripcion modelo = new ModeloInscripcion(alumnos, inscripciones, talleres);
        
        ControlInscripcion control = new ControlInscripcion(modelo);
        
        
        //Implementé que el controlador puediera manejar la suscripcion de observadores a la vista
        //Entonces cuando MainFrame arma cada uno de los paneles, cada uno de estos maneja su propia suscripción mediante el control
        MainFrame mainFrame = new MainFrame(modelo, control);
        
        mainFrame.setVisible(true);
        
    }
    
}
