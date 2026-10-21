/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author luisb
 */
public class Inscripcion {
    
    
    private Alumno alumno;
    
    private Taller taller;
    
    private LocalDateTime fechaHora;

    public Inscripcion(Alumno alumno, Taller taller) {
        this.alumno = alumno;
        this.taller = taller;
        this.fechaHora = LocalDateTime.now();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Taller getTaller() {
        return taller;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    
    
    
    
    
    
    
    
}
