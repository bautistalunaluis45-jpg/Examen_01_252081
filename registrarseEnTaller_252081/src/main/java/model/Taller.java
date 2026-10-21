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
public class Taller {
    
    private String id;
    
    private String nombre;
    
    private String instructor;
    
    private LocalDateTime horaFechaInicio;
    
    private LocalDateTime horaFechaFin;

    public Taller(String id, String nombre, String instructor, LocalDateTime horaFechaInicio, LocalDateTime horaFechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.instructor = instructor;
        this.horaFechaInicio = horaFechaInicio;
        this.horaFechaFin = horaFechaFin;
    }

    public String getId() {
        return id;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getInstructor() {
        return instructor;
    }

    public LocalDateTime getHoraFechaInicio() {
        return horaFechaInicio;
    }

    public LocalDateTime getHoraFechaFin() {
        return horaFechaFin;
    }
    
    
    
    
}
