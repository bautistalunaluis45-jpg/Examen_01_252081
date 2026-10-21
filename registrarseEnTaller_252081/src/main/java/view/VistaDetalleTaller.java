/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Evento;
import model.IConsultaInscripcion;
import model.Observer;
import model.Taller;

/**
 *
 * @author luisb
 */
class VistaDetalleTaller extends JPanel implements Observer {
    private IConsultaInscripcion modelo;
    private JLabel lblId, lblNombre, lblInstructor, lblInicio, lblFin;

    public VistaDetalleTaller(IConsultaInscripcion modelo) {
        this.modelo = modelo;
        setLayout(new GridLayout(6, 1, 0, 6));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 225, 230), 1, true),
            new EmptyBorder(15, 20, 15, 20)
        ));

        JLabel lblEncabezado = new JLabel("Detalles del Taller Seleccionado");
        lblEncabezado.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblEncabezado.setForeground(new Color(40, 45, 55));

        lblId = crearLabelInfo("ID: ");
        lblNombre = crearLabelInfo("Nombre: ");
        lblInstructor = crearLabelInfo("Instructor: ");
        lblInicio = crearLabelInfo("Fecha/Hora Inicio: ");
        lblFin = crearLabelInfo("Fecha/Hora Fin: ");

        add(lblEncabezado);
        add(lblId);
        add(lblNombre);
        add(lblInstructor);
        add(lblInicio);
        add(lblFin);
    }

    private JLabel crearLabelInfo(String texto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lbl.setForeground(new Color(70, 80, 95));
        return lbl;
    }

    @Override
    public void update(Evento evento) {
        if (evento == Evento.TALLER_SELECCIONADO) {
            procesarTallerSeleccionado();
        }
    }
    
    private void procesarTallerSeleccionado() {
        Taller taller = modelo.getTallerOnSelect();
        if (taller != null) {
            lblId.setText("ID: " + taller.getId());
            lblNombre.setText("Nombre: " + taller.getNombre());
            lblInstructor.setText("Instructor: " + taller.getInstructor());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            lblInicio.setText("Fecha/Hora Inicio: " + (taller.getHoraFechaInicio() != null ? taller.getHoraFechaInicio().format(formatter) : ""));
            lblFin.setText("Fecha/Hora Fin: " + (taller.getHoraFechaFin() != null ? taller.getHoraFechaFin().format(formatter) : ""));
        }
    }
}