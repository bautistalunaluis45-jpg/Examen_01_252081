/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisb
 */
public class RepositorioInscripciones {
    
    
    List<Inscripcion> inscripciones;

    public RepositorioInscripciones() {
        this.inscripciones = new ArrayList<>(); 
    }
    
    public void guardar(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }
    
    public boolean existeInscripcion(String idAlumno, String idTaller) {
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getAlumno().getId().equals(idAlumno)
                    && inscripcion.getTaller().getId().equals(idTaller)) {
                return true;
            }
        }

        return false;
    }
    
    public Inscripcion getUltimaInscripcion() {
        return inscripciones.getLast();
    }
    
    
}
