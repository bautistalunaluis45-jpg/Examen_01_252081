/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to edit this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author luisb
 */
import control.ControlInscripcion;
import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class VistListaTalleres extends JPanel {
    private IConsultaInscripcion modelo;
    private ControlInscripcion control; 

    public VistListaTalleres(IConsultaInscripcion modelo, ControlInscripcion control) {
        this.modelo = modelo;
        this.control = control;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 225, 230), 1, true),
            new EmptyBorder(15, 15, 15, 15)
        ));
        setPreferredSize(new Dimension(300, 0));

        JLabel titulo = new JLabel("Talleres Disponibles");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titulo.setForeground(new Color(40, 45, 55));
        titulo.setBorder(new EmptyBorder(0, 0, 12, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel panelContenedorTalleres = new JPanel();
        panelContenedorTalleres.setLayout(new BoxLayout(panelContenedorTalleres, BoxLayout.Y_AXIS));
        panelContenedorTalleres.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(panelContenedorTalleres);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(Color.WHITE);
        add(scrollPane, BorderLayout.CENTER);

        // Carga la lista de talleres la primera vez
        List<Taller> talleres = modelo.getTalleresDisponibles();
        if (talleres != null) {
            for (Taller taller : talleres) {
                JPanel itemPanel = crearItemTaller(taller.getNombre(), taller.getId());
                panelContenedorTalleres.add(itemPanel);
                panelContenedorTalleres.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }
    }

    private JPanel crearItemTaller(String nombreTaller, String idTaller) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        panel.setBackground(new Color(245, 248, 250));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(215, 222, 230), 1, true),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));

        JLabel labelNombre = new JLabel(nombreTaller);
        labelNombre.setFont(new Font("Segoe UI", Font.BOLD, 13));
        labelNombre.setForeground(new Color(50, 60, 75));
        
        labelNombre.putClientProperty("idTaller", idTaller);

        labelNombre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String id = (String) labelNombre.getClientProperty("idTaller");
                invocarMetodoControl(id);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(new Color(230, 240, 250));
                panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(new Color(245, 248, 250));
                panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        panel.add(labelNombre, BorderLayout.CENTER);
        return panel;
    }

    private void invocarMetodoControl(String idTaller) {
        try {
            control.solicitarSeleccionarTaller(idTaller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}