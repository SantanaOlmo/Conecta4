package com.albertoEstepa.connect4.gui;

import com.albertoEstepa.connect4.depurar.Musica;

import javax.swing.*;

public class Ventana extends JFrame {
    int anchoVentana = 700;
    int altoVentana = 700;
    int numDificultad=0;
    boolean playerVsIA;

    public Ventana() {
        setTitle("Conecta4");
        setSize(anchoVentana, altoVentana);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // CARGA LA PANTALLA DE INICIO"
        mostrarPantallaInicio();
        setVisible(true);
    }
    public void mostrarPantallaInicio() {
        Musica.stopSound();
        getContentPane().removeAll(); // 🔹 Limpiar la ventana
        VentanaInicio inicio = new VentanaInicio(this);
        setContentPane(inicio);
        revalidate();
        repaint();
    }

    public void iniciarJuego(int numDificultad) {
        getContentPane().removeAll(); // 🔹 Limpiar la ventana
        Juego juego = new Juego(this,numDificultad);
        setContentPane(juego);
        revalidate();
        repaint();
    }
    public void iniciarJuegoDificil(){
        Musica.stopSound();
        Musica.playSound("rainingBlood.wav","rainingBlood.wav");
        numDificultad=1;
        iniciarJuego(numDificultad);
    }
    public void iniciarJuegoFacil(){
        Musica.stopSound();
        Musica.playSound("minuetto.wav","minuetto.wav");
        numDificultad=0;
        iniciarJuego(numDificultad);
    }
    public void iniciarJuegoVsIA(){
        Musica.stopSound();
        //Musica.playSound();

        getContentPane().removeAll(); //
        Juego juego = new Juego(this,playerVsIA);
        setContentPane(juego);
        revalidate();
        repaint();
    }

    public void mostrarPantallaFinal(){
        Musica.stopSound();
        getContentPane().removeAll();
        VentanaFinal ventanaFinal= new VentanaFinal(this);
        setContentPane(ventanaFinal);
        revalidate();
        repaint();
    }
    public void mostrarPantallaEmpate(){
        Musica.stopSound();
        getContentPane().removeAll();
        VentanaFinal ventanaFinal= new VentanaFinal(this,1);
        setContentPane(ventanaFinal);
        revalidate();
        repaint();
    }

    public int getAnchoVentana() {
        return anchoVentana;
    }
    public int getAltoVentana(){
        return altoVentana;
    }
}


