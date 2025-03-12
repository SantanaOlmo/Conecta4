package com.albertoEstepa.connect4.gui;
import javax.swing.*;

import com.albertoEstepa.connect4.depurar.*;
import com.albertoEstepa.connect4.logic.Logic;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Juego extends JPanel {
    boolean playerVsIA;
    int posicionY=59, posicionx=60;
    int avanceY=88;
    int avanceX = 60;
    int numDificultad;
    JLabel imgTurno = new JLabel();
    JLabel[][]fichas = new JLabel[6][7];
    JButton columna1, columna2, columna3, columna4, columna5, columna6, columna0;
    int[][] partida = new int[6][7];
    int turno = 1;
    int cColumna1 = 0, cColumna2 = 0, cColumna3 = 0, cColumna4 = 0, cColumna5 = 0, cColumna0 = 0, cColumna6 = 0; // contadores de las fichas que hay en cada columna
    int VACIO = 0;
    Image fondo = Imagen.imagenDepurada("fondoBlanco", "fondoBlanco.png");
    ImageIcon tablero = Imagen.imageIconDepurada("tablero", "tablero.png");
    ImageIcon fichaAmarilla=Imagen.imageIconDepurada("fichaAmarillaCuadrada.png","fichaAmarillaCuadrada.png");
    ImageIcon fichaRoja = Imagen.imageIconDepurada("fichaRojaCuadrada.png","fichaRojaCuadrada.png");

    public Juego(Ventana ventana,int Dificultad, boolean playerVsIA) {
        this.setLayout(null);
        this.numDificultad=Dificultad;
        this.playerVsIA=playerVsIA;
        //inicializo el jlabel del turno
        mostrarTurno();
        imgTurno.setFont(new Font("Arial",Font.BOLD,25));
        imgTurno.setBounds(290,580,150,100);
        imgTurno.setVisible(true);
        this.add(imgTurno);

        // Inicializar los botones
        columna0 = new JButton();
        columna1 = new JButton();
        columna2 = new JButton();
        columna3 = new JButton();
        columna4 = new JButton();
        columna5 = new JButton();
        columna6 = new JButton();

        // Añadir los botones a la ventana
        anadirColumna(columna0);
        anadirColumna(columna1);
        anadirColumna(columna2);
        anadirColumna(columna3);
        anadirColumna(columna4);
        anadirColumna(columna5);
        anadirColumna(columna6);

        // Asignar listeners a los botones
        columna1.addActionListener(e -> {
            if (cColumna1 == 6) {
                mostrarMensajeError(1);
            } else {
                Logic.anadirFicha(partida, 1, this, turno,fichas,fichaRoja,fichaAmarilla,ventana);
            }
        });
        columna2.addActionListener(e -> {
            if (cColumna2 == 6) {
                mostrarMensajeError(2);
            } else {
                Logic.anadirFicha(partida, 2, this, turno,fichas,fichaRoja,fichaAmarilla,ventana);
            }
        });
        columna3.addActionListener(e -> {
            if (cColumna3 == 6) {
                mostrarMensajeError(3);
            } else {
                Logic.anadirFicha(partida, 3, this, turno,fichas,fichaRoja,fichaAmarilla,ventana);
            }
        });
        columna4.addActionListener(e -> {
            if (cColumna4 == 6) {
                mostrarMensajeError(4);
            } else {
                Logic.anadirFicha(partida, 4, this, turno,fichas,fichaRoja,fichaAmarilla,ventana);
            }
        });
        columna5.addActionListener(e -> {
            if (cColumna5 == 6) {
                mostrarMensajeError(5);
            } else {
                Logic.anadirFicha(partida, 5, this, turno,fichas,fichaRoja,fichaAmarilla,ventana);
            }
        });
        columna6.addActionListener(e -> {
            if (cColumna6 == 6) {
                mostrarMensajeError(6);
            } else {
                Logic.anadirFicha(partida, 6, this, turno,fichas,fichaRoja,fichaAmarilla,ventana);
            }
        });
        columna0.addActionListener(e -> {
            if (cColumna0 == 6) {
                mostrarMensajeError(0);
            } else {
                Logic.anadirFicha(partida, 0, this, turno,fichas,fichaRoja,fichaAmarilla,ventana);
            }
        });




        //CREO EL TABLERO Y LO PINTO SOBRE LAS FICHAS
        JLabel tableroImg= new JLabel(tablero);
        tableroImg.setBounds(0,0,ventana.getAnchoVentana(),ventana.getAltoVentana());
        this.add(tableroImg);

        //Inicializar las fichas
        avanceX=85;
        avanceY=95;
        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                JLabel label= new JLabel(fichaAmarilla);
                label.setBounds(posicionx, posicionY, 70, 70);
                fichas[i][j]=label;
                this.add(fichas[i][j]);
                posicionx+=avanceX;
                fichas[i][j].setVisible(false);
            }
            posicionx=60;
            posicionY+=avanceY;
        }

        this.setFocusable(true);
        this.requestFocus();


    }

    // Método para añadir los botones/columnas
    public void anadirColumna(JButton columna) {
        columna.setBounds(avanceX, 50, 85, 560);
        this.add(columna); // Asegúrate de que tu clase extienda de un contenedor como JPanel o JFrame
        this.avanceX += 82;

        // BOTOÓN INVISIBLE
        columna.setOpaque(false);
        columna.setContentAreaFilled(false);
        columna.setFocusPainted(false);
        columna.setBorder(BorderFactory.createEmptyBorder());

        // HOVER SOBRE LOS BOTONES
        columna.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                columna.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Borde visible en hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                columna.setBorder(BorderFactory.createEmptyBorder()); // Borde invisible cuando el mouse sale
            }
        });
    }


    public void setPartida(int[][] partida) {
        this.partida = partida;
    }

    public int[][] getPartida() {
        return this.partida;
    }

    public int getColor(int fila, int columna) {
        return partida[fila][columna];
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getTurno() {
        return this.turno;
    }

    public void mostrarMensajeError(int columna) {
        // Mensaje de error si la columna está llena (implementar si es necesario)
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

    }

    public void mostrarTurno(){
        if(turno==1){
            imgTurno.setText("YOUR TURN");
            imgTurno.setForeground(Color.YELLOW);
        }else{
            imgTurno.setText("YOUR TURN");
            imgTurno.setForeground(Color.RED);

        }
    }
    public int getnumDificultad(){
        return this.numDificultad;
    }

}
