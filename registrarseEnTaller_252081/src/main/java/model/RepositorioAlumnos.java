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
public class RepositorioAlumnos {
    
    List<Alumno> alumnos;

    public RepositorioAlumnos() {
        this.alumnos = new ArrayList<>();
        cargarDatos();
    }
    
    
    public Alumno getByID(String id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId().equals(id)) {
                return alumno;
            }
        }

        return null;
    }
    
    
    /**
     * Este método simplemente es para cargar una cantidad grande de alumnos, y que el sistema ya tenga datos al empezar.
     */
    private void cargarDatos() {
        
        alumnos.add(new Alumno(
                "00000252081", "Luis Fernando",
                "Bautista", "Luna", 6, "ISW"));

        alumnos.add(new Alumno(
                "00000148372", "María Fernanda",
                "García", "López", 4, "ISW"));

        alumnos.add(new Alumno(
                "00000726194", "Carlos Eduardo",
                "Ramírez", "Torres", 8, "ISW"));

        alumnos.add(new Alumno(
                "00000381506", "Ana Sofía",
                "Hernández", "Castro", 2, "ISW"));

        alumnos.add(new Alumno(
                "00000943721", "Diego Alejandro",
                "Martínez", "Flores", 6, "ISW"));

        alumnos.add(new Alumno(
                "00000469283", "Valeria",
                "Sánchez", "Morales", 4, "ISW"));

        alumnos.add(new Alumno(
                "00000615740", "José Manuel",
                "López", "Navarro", 8, "ISW"));

        alumnos.add(new Alumno(
                "00000832461", "Camila",
                "Pérez", "Vargas", 2, "ISW"));

        alumnos.add(new Alumno(
                "00000570832", "Daniel Alberto",
                "Cruz", "Mendoza", 6, "ISW"));

        alumnos.add(new Alumno(
                "00000294617", "Ximena",
                "Ortega", "Reyes", 4, "ISW"));
        
        
    }
    
    
    
    
}
