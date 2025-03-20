package com.albertoEstepa.connect4.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.albertoEstepa.connect4.depurar.*;

public class VentanaInicio extends JPanel {
    JLabel titulo;
    JButton partidaNueva, salir;

    VentanaInicio(Ventana ventana){

        // Reproducir música de fondo
        //Musica.playSound("Lake Romance","audio/LakeRomance.wav");

        // 🔹 Crear el panel en capas
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(ventana.getAnchoVentana(),  ventana.getAltoVentana()));


        // 🔹 Fondo
        JLabel fondoPanel = new JLabel( Imagen.resizedImagenDepurada("rainFondo.gif", "rainFondo.gif", ventana.getAnchoVentana(), ventana.getAltoVentana()));
        fondoPanel.setBounds(0, -10, ventana.getAnchoVentana(),  ventana.getAltoVentana());


        // 🔹 Contenedor de los elementos
        JPanel contenedorColumnas = new JPanel();
        contenedorColumnas.setLayout(new BoxLayout(contenedorColumnas, BoxLayout.Y_AXIS));
        contenedorColumnas.setOpaque(false);
        contenedorColumnas.setBounds(0, 0, ventana.getAnchoVentana(),  ventana.getAltoVentana()); // Ajusta posición

        // 🔹 Crear los componentes
        JLabel tituloLabel = new JLabel(Imagen.imageIconDepurada("jumpingTitulo.gif","jumpingTitulo.gif"));
        JButton btnIniciar = new JButton(Imagen.imageIconDepurada("staticJugar.png","staticJugar.png"));
        JButton btnSalir = new JButton(Imagen.imageIconDepurada("staticSalir.png","staticSalir.png"));
        JButton btnIniciarDificil= new JButton(Imagen.imageIconDepurada("moodExtremo.gif","moodExtremo.gif"));

        JButton btnOpciones = new JButton(Imagen.imageIconDepurada("staticOpciones.png","staticOpciones.png"));

        // 🔹 Estilizar
        btnStyle(btnIniciar);
        btnStyle(btnSalir);
        btnStyle(btnOpciones);
        btnStyle(btnIniciarDificil);

        tituloLabel.setForeground(Color.BLACK);
        tituloLabel.setFont(new Font("Arial", Font.BOLD,50));
        tituloLabel.setPreferredSize(new Dimension(1000,200));

        // 🔹 Asegurar alineación centrada
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIniciarDificil.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnOpciones.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 🔹 Espaciado entre los elementos
        //contenedorColumnas.add(Box.createVerticalGlue()); // Espacio flexible arriba
        contenedorColumnas.add(tituloLabel);
        contenedorColumnas.add(Box.createVerticalStrut(30)); // Espacio entre título y botón
        contenedorColumnas.add(btnIniciar);
        contenedorColumnas.add(Box.createVerticalStrut(10));
        contenedorColumnas.add(btnIniciarDificil);
        contenedorColumnas.add(Box.createVerticalStrut(10)); // Espacio entre título y botón
        contenedorColumnas.add(btnOpciones);
        contenedorColumnas.add(Box.createVerticalStrut(10)); // Espacio entre botones
        contenedorColumnas.add(btnSalir);
        contenedorColumnas.add(Box.createVerticalGlue()); // Espacio flexible abajo


        // 🔹 Añadir al panel en capas
        layeredPane.add(fondoPanel, JLayeredPane.DEFAULT_LAYER); // Fondo en la capa más baja
        layeredPane.add(contenedorColumnas, JLayeredPane.PALETTE_LAYER); // Elementos encima
        //layeredPane.setBackground(Color.WHITE);
        //layeredPane.setOpaque(true);

        add(layeredPane, BorderLayout.CENTER);


        btnIniciar.addActionListener(e -> ventana.iniciarJuegoFacil());
        btnIniciarDificil.addActionListener(e->ventana.iniciarJuegoDificil());
        // cerrar la ventana
        btnSalir.addActionListener(e -> System.exit(0));
        //hover sobre btnSalir
        btnSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSalir.setIcon(Imagen.imageIconDepurada("animatedSalir.gif","animatedSalir.gif"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSalir.setIcon(Imagen.imageIconDepurada("staticSalir.png","staticSalir.png"));
                btnStyle(btnSalir);
            }
        });
        //hover sobre btnOpciones
        btnOpciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnOpciones.setIcon(Imagen.imageIconDepurada("animatedOpciones.gif","animatedOpciones.gif"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnOpciones.setIcon(Imagen.imageIconDepurada("staticOpciones.png","staticOpciones.png"));
                btnStyle(btnSalir);
            }
        });
        //hover sobre btnIniciar
        btnIniciar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnIniciar.setIcon(Imagen.imageIconDepurada("animatedJugar.gif","animatedJugar.gif"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnIniciar.setIcon(Imagen.imageIconDepurada("staticJugar.png","staticJugar.png"));
                btnStyle(btnSalir);
            }
        });

    }

    // ESTILO DE LOS BOTONEES
    private void btnStyle(JButton btn) {
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setPreferredSize(new Dimension(175, 75));
       // btn.setFont(new Font("Arial",Font.BOLD,30));
       // btn.setForeground(Color.BLACK);
    }


}
