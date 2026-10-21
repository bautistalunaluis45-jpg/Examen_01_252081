/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to edit this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.ControlInscripcion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.IConsultaInscripcion;

/**
 *
 * @author luisb
 */
public class MainFrame extends JFrame {
    public MainFrame(IConsultaInscripcion modelo, ControlInscripcion control) {
        setTitle("Sistema de Inscripción a Talleres");
        setSize(950, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Fondo general limpio
        getContentPane().setBackground(new Color(245, 247, 250));
        setLayout(new BorderLayout(15, 15));
        ((JComponent) getContentPane()).setBorder(new EmptyBorder(15, 15, 15, 15));

        // Inicialización de los 3 paneles principales
        VistListaTalleres panelIzq = new VistListaTalleres(modelo, control);
        VistaDetalleTaller panelDerArriba = new VistaDetalleTaller(modelo);
        VistaDetalleAlumnoTicket panelDerAbajo = new VistaDetalleAlumnoTicket(modelo, control);

        control.manejarSuscribir(panelDerAbajo);
        control.manejarSuscribir(panelDerArriba);

        // Distribución en el JFrame principal
        add(panelIzq, BorderLayout.WEST);

        JPanel panelDerechoCentro = new JPanel(new GridLayout(2, 1, 0, 15));
        panelDerechoCentro.setOpaque(false);
        panelDerechoCentro.add(panelDerArriba);
        panelDerechoCentro.add(panelDerAbajo);

        add(panelDerechoCentro, BorderLayout.CENTER);
    }
}