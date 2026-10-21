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
public class ModeloInscripcion implements IConsultaInscripcion{
    
    private Taller onSelect;
    private Alumno alumnoActual;
    private List<Observer> observers;
    
    
    //Repo
    private final RepositorioAlumnos alumnos;
    private final RepositorioInscripciones inscripciones;
    private final RepositorioTalleres talleres;

    public ModeloInscripcion(RepositorioAlumnos alumnos, RepositorioInscripciones inscripciones, RepositorioTalleres talleres) {
        this.observers = new ArrayList<>();
        this.alumnos = alumnos;
        this.inscripciones = inscripciones;
        this.talleres = talleres;
    }
    
    public void manejarInscripcion() {
        
        if(onSelect == null || alumnoActual == null) {
            notificarObservadore(Evento.INSCRIPCION_FALLIDA);
            return;
        }
        
        if(inscripciones.existeInscripcion(alumnoActual.getId(), onSelect.getId())) {
            notificarObservadore(Evento.ALUMNO_YA_INSCRITO);
            return;
        }
        
        Inscripcion inscripcion = new Inscripcion(alumnoActual, onSelect);
        
        inscripciones.guardar(inscripcion);
        
        onSelect = null;
        alumnoActual = null;
        
        notificarObservadore(Evento.INSCRIPCION_EXITOSA);
        
    }
    
    public void manejarSeleccion(String idTaller) {
        onSelect = null;
        
        
        if (idTaller == null || idTaller.isBlank()) {
            notificarObservadore(Evento.TALLER_NO_ENCONTRADO);
            return;
        }
        
        Taller taller = talleres.getByID(idTaller);
        
        if(taller == null) {
            notificarObservadore(Evento.TALLER_NO_ENCONTRADO);
            return;
        }
        
        onSelect = taller;
        
        notificarObservadore(Evento.TALLER_SELECCIONADO);
    }
    
    public void manejarFijarAlumno(String idAlumno) {
        alumnoActual = null;
        
        
        if (idAlumno == null || idAlumno.isBlank()) {
            notificarObservadore(Evento.ALUMNO_NO_ENCONTRADO);
            return;
        }
        
        Alumno alumno = alumnos.getByID(idAlumno);
        
        if(alumno == null) {
            notificarObservadore(Evento.ALUMNO_NO_ENCONTRADO);
            return;
        }
        
        alumnoActual = alumno;
        
        notificarObservadore(Evento.ALUMNO_ENCONTRADO);
        
    }
    
    
    public void notificarObservadore(Evento evento) {
        for(Observer obs:observers) {
            obs.update(evento);
        }
    }
    
    public void agregarObserver(Observer obs) {
        observers.add(obs);
    }
    
    @Override
    public Inscripcion getUltimaInscripcion() {
        return inscripciones.getUltimaInscripcion();
    }

    @Override
    public Taller getTallerOnSelect() {
        return this.onSelect;
    }

    @Override
    public Alumno getAlumnoActual() {
        return this.alumnoActual;
    }

    @Override
    public List<Taller> getTalleresDisponibles() {
        return talleres.getTalleres();
    }
    
    
    
    
    
    
    
}
