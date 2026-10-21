/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author luisb
 */
public interface IConsultaInscripcion {
    
    public Inscripcion getUltimaInscripcion();
    
    public Taller getTallerOnSelect();
    
    public Alumno getAlumnoActual();
    
    public List<Taller> getTalleresDisponibles();
    
    
    
    
    
    
}
