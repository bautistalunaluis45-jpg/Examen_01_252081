package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author luisb
 */

public class RepositorioTalleres {

    private final List<Taller> talleres;

    public RepositorioTalleres() {
        this.talleres = new ArrayList<>();
        cargarDatos();
    }
    
    public List<Taller> getTalleres() {
        return this.talleres;
    }

    /**
     * Carga talleres de prueba para iniciar el sistema con datos.
     */
    private void cargarDatos() {
        talleres.add(new Taller(
                "T001", "Desarrollo Web con Spring Boot",
                "Ing. Roberto Martínez",
                LocalDateTime.of(2026, 11, 16, 9, 0),
                LocalDateTime.of(2026, 11, 16, 12, 0)));

        talleres.add(new Taller(
                "T002", "Introducción a la Ciberseguridad",
                "Mtra. Patricia López",
                LocalDateTime.of(2026, 11, 16, 10, 0),
                LocalDateTime.of(2026, 11, 16, 13, 0)));

        talleres.add(new Taller(
                "T003", "Desarrollo de Aplicaciones Android",
                "Ing. Carlos Ramírez",
                LocalDateTime.of(2026, 11, 16, 15, 0),
                LocalDateTime.of(2026, 11, 16, 18, 0)));

        talleres.add(new Taller(
                "T004", "Inteligencia Artificial con Python",
                "Dr. Alejandro Torres",
                LocalDateTime.of(2026, 11, 17, 9, 0),
                LocalDateTime.of(2026, 11, 17, 12, 0)));

        talleres.add(new Taller(
                "T005", "Fundamentos de Redes con Cisco",
                "Ing. Miguel Hernández",
                LocalDateTime.of(2026, 11, 17, 10, 0),
                LocalDateTime.of(2026, 11, 17, 13, 0)));

        talleres.add(new Taller(
                "T006", "Diseño de Interfaces UX/UI",
                "Mtra. Daniela Flores",
                LocalDateTime.of(2026, 11, 17, 15, 0),
                LocalDateTime.of(2026, 11, 17, 18, 0)));

        talleres.add(new Taller(
                "T007", "Introducción a Docker",
                "Ing. Fernando Castillo",
                LocalDateTime.of(2026, 11, 18, 9, 0),
                LocalDateTime.of(2026, 11, 18, 12, 0)));

        talleres.add(new Taller(
                "T008", "Bases de Datos con PostgreSQL",
                "Mtro. Jorge Navarro",
                LocalDateTime.of(2026, 11, 18, 10, 0),
                LocalDateTime.of(2026, 11, 18, 13, 0)));

        talleres.add(new Taller(
                "T009", "Control de Versiones con Git",
                "Ing. Ricardo Mendoza",
                LocalDateTime.of(2026, 11, 18, 15, 0),
                LocalDateTime.of(2026, 11, 18, 17, 0)));

        talleres.add(new Taller(
                "T010", "Desarrollo de APIs REST",
                "Ing. Andrea Sánchez",
                LocalDateTime.of(2026, 11, 19, 9, 0),
                LocalDateTime.of(2026, 11, 19, 12, 0)));
    }

    /**
     * Busca un taller por su ID.
     *
     * @param id identificador del taller
     * @return el taller encontrado o null si no existe
     */
    public Taller getByID(String id) {
        for (Taller taller : talleres) {
            if (taller.getId().equals(id)) {
                return taller;
            }
        }

        return null;
    }
}