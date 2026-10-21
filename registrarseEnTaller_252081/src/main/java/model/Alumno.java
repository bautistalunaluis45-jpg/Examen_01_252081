/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luisb
 */
public class Alumno {
    
    private String id;
    
    private String nombre;
    
    private String appPaterno;
    
    private String appMaterno;
    
    private int semestre;
    
    private String programa;

    public Alumno(String id, String nombre, String appPaterno, String appMaterno, int semestre, String programa) {
        this.id = id;
        this.nombre = nombre;
        this.appPaterno = appPaterno;
        this.appMaterno = appMaterno;
        this.semestre = semestre;
        this.programa = programa;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAppPaterno() {
        return appPaterno;
    }

    public String getAppMaterno() {
        return appMaterno;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getPrograma() {
        return programa;
    }
    
    
    public String getNombreCompleto() {
        return this.nombre + " " + this.appPaterno + " " + this.appMaterno;
    }
    
    
    
}
