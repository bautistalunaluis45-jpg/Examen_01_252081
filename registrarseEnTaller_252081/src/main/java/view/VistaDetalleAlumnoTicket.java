/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.ControlInscripcion;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Alumno;
import model.Evento;
import model.IConsultaInscripcion;
import model.Inscripcion;
import model.Observer;

/**
 *
 * @author luisb
 */
class VistaDetalleAlumnoTicket extends JPanel implements Observer {
    private IConsultaInscripcion modelo;
    private ControlInscripcion control;
    
    private JPanel panelBusqueda;
    private JTextField txtIdAlumno;
    private JButton btnInscribirId;

    private JPanel panelInfoAlumno;
    private JLabel lblAlumnoInfo;
    private JButton btnConfirmarInscripcion;

    private JPanel panelTicket;
    private JLabel lblTicketInfo;

    public VistaDetalleAlumnoTicket(IConsultaInscripcion modelo, ControlInscripcion control) {
        this.modelo = modelo;
        this.control = control;

        setLayout(new CardLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 225, 230), 1, true),
            new EmptyBorder(15, 20, 15, 20)
        ));

        // Estado 1: Ingresar ID Alumno
        panelBusqueda = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 25));
        panelBusqueda.setBackground(Color.WHITE);
        
        JLabel lblIdText = new JLabel("ID Alumno:");
        lblIdText.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblIdText.setForeground(new Color(60, 70, 85));
        
        txtIdAlumno = new JTextField(15);
        txtIdAlumno.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtIdAlumno.setPreferredSize(new Dimension(180, 32));
        
        btnInscribirId = crearBotonEstilizado("Buscar Alumno", new Color(0, 120, 215));
        
        panelBusqueda.add(lblIdText);
        panelBusqueda.add(txtIdAlumno);
        panelBusqueda.add(btnInscribirId);

        btnInscribirId.addActionListener(e -> solicitarFijarAlumno());

        // Estado 2: Info Alumno + Botón Confirmar Inscripción
        panelInfoAlumno = new JPanel(new BorderLayout(10, 10));
        panelInfoAlumno.setBackground(Color.WHITE);
        
        lblAlumnoInfo = new JLabel("", JLabel.CENTER);
        lblAlumnoInfo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblAlumnoInfo.setForeground(new Color(50, 60, 75));
        
        btnConfirmarInscripcion = crearBotonEstilizado("Confirmar Inscripción", new Color(40, 167, 69));
        
        JPanel panelBotonContenedor = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotonContenedor.setBackground(Color.WHITE);
        panelBotonContenedor.add(btnConfirmarInscripcion);

        panelInfoAlumno.add(lblAlumnoInfo, BorderLayout.CENTER);
        panelInfoAlumno.add(panelBotonContenedor, BorderLayout.SOUTH);

        btnConfirmarInscripcion.addActionListener(e -> solicitarInscripcion());

        // Estado 3: Ticket compacto
        panelTicket = new JPanel(new BorderLayout());
        panelTicket.setBackground(new Color(240, 248, 240));
        
        JLabel lblTituloTicket = new JLabel("<html><h3 align='center'>¡COMPROBANTE DE INSCRIPCIÓN!</h3></html>", JLabel.CENTER);
        lblTituloTicket.setForeground(new Color(30, 120, 50));
        
        lblTicketInfo = new JLabel("", JLabel.CENTER);
        lblTicketInfo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblTicketInfo.setForeground(new Color(40, 50, 60));
        
        panelTicket.add(lblTituloTicket, BorderLayout.NORTH);
        panelTicket.add(lblTicketInfo, BorderLayout.CENTER);

        add(panelBusqueda, "BUSQUEDA");
        add(panelInfoAlumno, "ALUMNO");
        add(panelTicket, "TICKET");

        mostrarPanelBusqueda();
    }

    private JButton crearBotonEstilizado(String texto, Color colorFondo) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return boton;
    }

    private void mostrarPanelBusqueda() {
        txtIdAlumno.setText("");
        CardLayout cl = (CardLayout) getLayout();
        cl.show(this, "BUSQUEDA");
    }

    private void solicitarFijarAlumno() {
        String idAlumno = txtIdAlumno.getText().trim();
        if (idAlumno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un ID de alumno.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            control.solicitarFijarAlumno(idAlumno);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void solicitarInscripcion() {
        try {
            control.solicitarInscripcion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Evento evento) {
        switch (evento) {
            case TALLER_SELECCIONADO:
                mostrarPanelBusqueda();
                break;
            case ALUMNO_ENCONTRADO:
                procesarAlumnoEncontrado();
                break;
            case ALUMNO_NO_ENCONTRADO:
                JOptionPane.showMessageDialog(this, "El ID que ingresó no se encuentra registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case INSCRIPCION_EXITOSA:
                procesarInscripcionExitosa();
                break;
            case INSCRIPCION_FALLIDA:
                JOptionPane.showMessageDialog(this, "La inscripción ha fallado.", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case ALUMNO_YA_INSCRITO:
                JOptionPane.showMessageDialog(this, "El alumno ya se encuentra inscrito en este taller.", "Aviso", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }

    private void procesarAlumnoEncontrado() {
        Alumno alumno = modelo.getAlumnoActual();
        if (alumno != null) {
            lblAlumnoInfo.setText("<html><div style='text-align: center;'><b>Alumno Encontrado:</b><br>" +
                    "Nombre: " + alumno.getNombreCompleto() + "<br>" +
                    "Semestre: " + alumno.getSemestre() + " &nbsp;|&nbsp; Programa: " + alumno.getPrograma() + "</div></html>");
            CardLayout cl = (CardLayout) getLayout();
            cl.show(this, "ALUMNO");
        }
    }

    private void procesarInscripcionExitosa() {
        Inscripcion insc = modelo.getUltimaInscripcion();
        if (insc != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            lblTicketInfo.setText("<html><body style='text-align: center; padding: 5px;'>" +
                    "<b>Taller:</b> " + insc.getTaller().getNombre() + "<br>" +
                    "<b>Instructor:</b> " + insc.getTaller().getInstructor() + "<br>" +
                    "<b>Alumno:</b> " + insc.getAlumno().getNombreCompleto() + "<br>" +
                    "<b>Programa:</b> " + insc.getAlumno().getPrograma() + "<br>" +
                    "<b>Fecha/Hora:</b> " + insc.getFechaHora().format(formatter) +
                    "</body></html>");
            CardLayout cl = (CardLayout) getLayout();
            cl.show(this, "TICKET");
        }
    }
}