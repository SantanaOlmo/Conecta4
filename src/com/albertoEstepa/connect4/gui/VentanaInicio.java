package com.albertoEstepa.connect4.gui;
import javax.swing.*;
import java.awt.*;
import com.albertoEstepa.connect4.depurar.*;

public class VentanaInicio extends JPanel {
    JLabel titulo;
    JButton partidaNueva, salir;

    VentanaInicio(Ventana ventana){
        ImageIcon fondo = Imagen.resizedImagenDepurada("fondoEspacial2.gif", "fondoEspacial2.gif", ventana.getAnchoVentana(), ventana.getAltoVentana());

        // Reproducir música de fondo
        //Musica.playSound("Lake Romance","audio/LakeRomance.wav");

        // 🔹 Crear el panel en capas
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(ventana.getAnchoVentana(),  ventana.getAltoVentana()));

        // 🔹 Fondo
        JLabel fondoPanel = new JLabel(fondo);
        fondoPanel.setBounds(0, -10, ventana.getAnchoVentana(),  ventana.getAltoVentana());


        // 🔹 Contenedor de los elementos
        JPanel contenedorColumnas = new JPanel();
        contenedorColumnas.setLayout(new BoxLayout(contenedorColumnas, BoxLayout.Y_AXIS));
        contenedorColumnas.setOpaque(false);
        contenedorColumnas.setBounds(0, 0, ventana.getAnchoVentana(),  ventana.getAltoVentana()); // Ajusta posición

        // 🔹 Crear los componentes
        JLabel tituloLabel = new JLabel("CONECTA 4");
        JButton btnIniciar = new JButton("Juego fácil");
        JButton btnIniciarDificil= new JButton("Juego difícil");
        JButton btnSalir = new JButton("Salir");

        // 🔹 Estilizar
        btnStyle(btnIniciar);
        btnStyle(btnSalir);
        btnStyle(btnIniciarDificil);
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setFont(new Font("Arial", Font.BOLD,50));
        tituloLabel.setPreferredSize(new Dimension(1000,100));

        // 🔹 Asegurar alineación centrada
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIniciarDificil.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 🔹 Espaciado entre los elementos
        contenedorColumnas.add(Box.createVerticalGlue()); // Espacio flexible arriba
        contenedorColumnas.add(tituloLabel);
        contenedorColumnas.add(Box.createVerticalStrut(20)); // Espacio entre título y botón
        contenedorColumnas.add(btnIniciar);
        contenedorColumnas.add(Box.createVerticalStrut(20)); // Espacio entre título y botón
        contenedorColumnas.add(btnIniciarDificil);
        contenedorColumnas.add(Box.createVerticalStrut(20)); // Espacio entre botones
        contenedorColumnas.add(btnSalir);
        contenedorColumnas.add(Box.createVerticalGlue()); // Espacio flexible abajo



        // 🔹 Añadir al panel en capas
        layeredPane.add(fondoPanel, JLayeredPane.DEFAULT_LAYER); // Fondo en la capa más baja
        layeredPane.add(contenedorColumnas, JLayeredPane.PALETTE_LAYER); // Elementos encima

        add(layeredPane, BorderLayout.CENTER);

        btnIniciar.addActionListener(e -> ventana.iniciarJuegoFacil());
        btnIniciarDificil.addActionListener(e->ventana.iniciarJuegoDificil());

        // cerrar la ventana
        btnSalir.addActionListener(e -> System.exit(0));

    }

    // 🔹 Método para aplicar estilos a los botones
    private void btnStyle(JButton btn) {
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setPreferredSize(new Dimension(200, 100));
        btn.setFont(new Font("Arial",Font.BOLD,30));
        btn.setForeground(Color.WHITE);
    }


}
