package com.albertoEstepa.connect4.gui;
import com.albertoEstepa.connect4.depurar.Imagen;
import com.albertoEstepa.connect4.depurar.Musica;

import java.awt.*;
import javax.swing.*;
public class VentanaFinal extends JPanel {
JButton btnIniciar= new JButton();
JButton btnSalir=new JButton();


    public VentanaFinal(Ventana ventana){
        Musica.stopAllSounds();
        Musica.playSound("eh.wav","eh.wav");
        JLabel gifFinal= new JLabel(Imagen.resizedImageIconDepurada("final.gif","final.gif",700,700));
        gifFinal.setBounds(0,0,700,700);

        btnIniciar.setBounds(205,250,300,100);
        btnSalir.setBounds(205,300,300,100);

        btnIniciar.setText("Jugar otra partida");
        btnSalir.setText("Salir del juego");

        btnStyle(btnIniciar);
        btnStyle(btnSalir);

        btnSalir.addActionListener(e -> System.exit(0));
        btnIniciar.addActionListener(e -> ventana.mostrarPantallaInicio());

        JLayeredPane layeredPane= new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(700,700));

        layeredPane.add(btnIniciar);
        layeredPane.add(btnSalir);
        layeredPane.add(gifFinal);

        this.add(layeredPane);

    }
    public VentanaFinal(Ventana ventana,int number){
       Musica.stopAllSounds();
        Musica.playSound("spongeBob.wav","spongeBob.wav");
        JLabel gifFinal= new JLabel(Imagen.resizedImageIconDepurada("cow.png","cow.png",700,700));
        gifFinal.setBounds(0,0,700,700);

        btnIniciar.setBounds(420,300,300,100);
        btnSalir.setBounds(420,400,300,100);

        btnIniciar.setText("Otra partida");
        btnSalir.setText("Salir del juego");

        btnStyle(btnIniciar);
        btnStyle(btnSalir);

        btnSalir.addActionListener(e -> System.exit(0));
        btnIniciar.addActionListener(e ->  ventana.mostrarPantallaInicio());

        JLayeredPane layeredPane= new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(700,700));

        layeredPane.add(btnIniciar);
        layeredPane.add(btnSalir);
        layeredPane.add(gifFinal);

        this.add(layeredPane);

    }

    private void btnStyle(JButton btn) {
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        //btn.setPreferredSize(new Dimension(200, 100));
        btn.setFont(new Font("Arial",Font.BOLD,30));
        btn.setForeground(Color.WHITE);
    }
}
