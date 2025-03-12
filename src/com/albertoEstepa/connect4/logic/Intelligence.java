package com.albertoEstepa.connect4.logic;
import com.albertoEstepa.connect4.gui.Juego;
import com.albertoEstepa.connect4.gui.Ventana;
import com.albertoEstepa.connect4.logic.Logic;

import javax.swing.*;

public class Intelligence{
    int movimientosRealizados;
    boolean empiezo;
    int contador=0;
    int[][] partida;
    int color;
    Juego juego;
    JLabel [][]fichas;
    Ventana ventana;
    ImageIcon fichaRoja, fichaAmarilla;


    public Intelligence(int[][] partida, int columna, Juego juego, int color, JLabel[][] fichas, ImageIcon fichaRoja, ImageIcon fichaAmarilla, Ventana ventana,boolean empiezo){
        this.empiezo=empiezo;
        this.partida=partida;
    }
    public void queEstrategiaUtilizar(){
        if (empiezo){

        }else{

        }
    }
    //METODOS
    public void zugzwang(){}
    public void estrategiaNumero7(){
        if(empiezo){
            anadoFichaEnColumna(3);
        }else{

        }

        //colocar la ficha en el centro

    }
    public void analizarPartida(){
        if(movimientosRealizados<=3){

        }
    }

    public void anadirFichaEncima(){}



    public void anadoFichaEnColumna(int columna){
        Logic.anadirFicha(partida,columna,juego,color,fichas,fichaRoja,fichaAmarilla,ventana);

    }


}
