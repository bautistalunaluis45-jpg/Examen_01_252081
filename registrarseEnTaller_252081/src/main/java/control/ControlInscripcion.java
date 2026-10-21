/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.ModeloInscripcion;
import model.Observer;

/**
 *
 * @author luisb
 */
public class ControlInscripcion {
    
    private ModeloInscripcion modelo;

    public ControlInscripcion(ModeloInscripcion modelo) {
        this.modelo = modelo;
    }
    
    private String normalizarId(String id) {
        if (id == null || !id.matches("\\d{1,11}")) {
            return null;
        }

        return String.format("%11s", id).replace(' ', '0');
    }
    
    
    public void solicitarInscripcion(){
        modelo.manejarInscripcion();
    }
    
    public void solicitarSeleccionarTaller(String idTaller){
        modelo.manejarSeleccion(idTaller);
    }
    
    public void solicitarFijarAlumno(String idAlumno){
        modelo.manejarFijarAlumno(normalizarId(idAlumno));
    }
    
    
    public void manejarSuscribir(Observer obs) {
        modelo.agregarObserver(obs);
    }
    
    
    
    
}
