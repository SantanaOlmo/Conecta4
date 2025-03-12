package com.albertoEstepa.connect4.logic;

import com.albertoEstepa.connect4.depurar.Musica;
import com.albertoEstepa.connect4.gui.Juego;
import com.albertoEstepa.connect4.gui.Ventana;

import javax.swing.*;

public class Logic {

    static int contadorDeFichas=0;

    public static void anadirFicha(int[][] partida, int columna, Juego juego, int color, JLabel[][] fichas, ImageIcon fichaRoja, ImageIcon fichaAmarilla, Ventana ventana) {

        if (juego.getnumDificultad()==1){
            Musica.playSound("metalPipe.wav","MetalPipe.wav");
        } else if (juego.getnumDificultad()==0) {
            Musica.playSound("click.wav","click.wav");
        }

        // Recorro la columna de abajo hacia arriba buscando una casilla vacía (0)
        for (int i = 5; i >= 0; i--) {
            if (partida[i][columna] == 0) {
                //coloco la ficha en el hueco vacío más bajo
                partida[i][columna] = color;

            if (juego.playerVsIA){
                //esto es para pasarle a la ia cuál ha sido el ultimo movimiento realizado por el jugador
                int ultimoMovimientodelJugadorFila=i;
                int ultimoMovimientodelJugador=columna;
            }

                if (color == 2) {
                    fichas[i][columna].setIcon(fichaRoja);
                } else {
                    fichas[i][columna].setIcon(fichaAmarilla);
                }
                fichas[i][columna].setVisible(true);

                break;
            }
        }


        juego.setPartida(partida);

        if(buscarGanador(partida,color,juego)){
            contadorDeFichas=0;
            ventana.mostrarPantallaFinal();
        }else{
            contadorDeFichas+=1;
            cambiarTurno(juego);
            juego.mostrarTurno();
        }
        mostrarMatriz(juego.getPartida());

        if(contadorDeFichas==42){
            contadorDeFichas=0;
            ventana.mostrarPantallaEmpate();
        }


    }


    public static boolean buscarGanador(int[][] partida, int color,Juego juego){
        for (int i=0; i<7;i ++){
            for(int j=0;j<6;j++){
                if(cuatroEnRayaHorizontal(color,i,j ,juego)||cuatroEnRayaVertical(color,i,j,juego)||cuatroEnRayaDiagonalAscendente(color,i,j,juego)||cuatroEnRayaDiagonalDescendente(color,i,j,juego)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cuatroEnRayaHorizontal(int color,int columna,int fila ,Juego juego){
        //aquí me llega una ficha , por eso contador=1
        //de esa ficha cuento las siguientes 3 posiciones en linea horizontal a ver si son del mismo color
        int contador=0;

        if(columna>3){
            return false;
        } else {
            for (int i=0;i<4;i++){
                //juego.getColor() devuelve partida[COLUMNA][FILA]
                if (juego.getColor(fila,columna+i)==color){
                    contador++;
                }else{
                    break;
                }
            }
        }
        /*SI HE CONTADO CUATRO FICHAS DEL
        MISMO COLOR DEVUELVO TRUE*/
        if (contador>=4){
            System.out.println("Has ganado con 4 en Raya HORIZONTAL");
            return true;
        }else{
            return false;
        }
    }
    public static boolean cuatroEnRayaVertical(int color,int columna,int fila ,Juego juego ){
        //aquí me llega una ficha , por eso contador=1
        //de esa ficha cuento las siguientes 3 posiciones en linea horizontal a ver si son del mismo color
        int contador=0;
        if(fila>2){
            return false;
        } else {
            for (int i=0;i<4;i++){
                //juego.getColor() devuelve partida[fila][columna]
                if (juego.getColor(fila+i, columna)==color){
                    contador++;
                }else{
                    break;
                }
            }
        }
        /*SI HE CONTADO CUATRO FICHAS DEL
        MISMO COLOR DEVUELVO TRUE*/
        if (contador==4){
            System.out.println("Has ganado con 4 en Raya VERTICAL");
            return true;
        }else{
            return false;
        }
    }
    public static boolean cuatroEnRayaDiagonalAscendente(int color,int columna,int fila,Juego juego  ){
        //inicio el contador en 1 porque tengo una ficha contada
        int contador=0;
        if (columna>3||fila<3){
            return false;
        }else{
            for(int i=0;i<4;i++){
                if (juego.getColor(fila-i,columna+i)==color){
                    contador++;
                }else{
                    break;
                }
            }
        if (contador>=4){
            System.out.println("Has ganado con 4 en Raya VERTICAL ASCENDENTE");
            return true;
        }else
            return false;
        }

    }
    public static boolean cuatroEnRayaDiagonalDescendente(int color, int columna, int fila,Juego juego){
        int contador=0;
        if (columna>3||fila>2){
            return false;
        }else{
            for(int i=0;i<4;i++){
                if (juego.getColor(fila+i,columna+i)==color){
                    contador++;
                }else{
                    break;
                }
            }
            if (contador>=4){
                System.out.println("Has ganado con 4 en Raya VERTICAL DESCENDENTE");
                return true;
            }else
                return false;
        }

    }

    public static void mostrarMatriz(int [][] partida){
        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                System.out.print(partida[i][j]+"\t");
            }
            System.out.println("\n");
        }
        System.out.println("-------------------------");
        System.out.println("contador de fichas ="+contadorDeFichas);
    }


    public static void cambiarTurno(Juego juego){
        if (juego.getTurno()==1){
            juego.setTurno(2);
        }else{
            juego.setTurno(1);
        }
    }


}
