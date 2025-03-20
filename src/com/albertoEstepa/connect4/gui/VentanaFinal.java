package com.albertoEstepa.connect4.gui;
import com.albertoEstepa.connect4.depurar.Imagen;
import com.albertoEstepa.connect4.depurar.Musica;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;
public class VentanaFinal extends JPanel {
    Random random= new Random();
    String[] frasesDemoledoras = {
            "No es menos el que más juega, sino el que menos aprende.",
            "Algunas derrotas enseñan… pero esta solo humilla.",
            "La vida da segundas oportunidades, pero este tablero no.",
            "No perdiste por mala suerte, perdiste por insistir en jugar.",
            "Tus fichas tardaron menos en caer que tu dignidad.",
            "El destino no existe, solo tus malas decisiones.",
            "Los amigos están en las buenas… y en las humillaciones públicas.",
            "La amistad es para siempre, pero mi victoria también.",
            "No hay traición sin confianza. Gracias por confiar.",
            "No es menos el que pierde, sino el que sigue aquí."
    };
    String[] imagenesFinales = {
            "burningSkeleton.gif",
            "hitBaby.gif",
            "danceSkeleton2.gif",
            "suicideSkeleton.gif",
            "skeletonPapyrus.gif",
            "walkSkeleton.gif",
            "myHonestReaction.gif",
            "danceSkeleton.gif",
            "danceSkeleton1.gif",
            "skeletonDance4.gif"
    };



    JLabel frase= new JLabel();
    JButton btnIniciar= new JButton();
    JButton btnSalir=new JButton();

        //ventana final
    public VentanaFinal(Ventana ventana){
        Musica.stopAllSounds();
        Musica.playSound("eh.wav","eh.wav");
        JLabel gifFinal= new JLabel(Imagen.resizedImageIconDepurada(imagenesFinales[randomNum()],imagenesFinales[randomNum()],700,700));
        gifFinal.setBounds(0,-100,700,700);

        btnIniciar.setBounds(50,500,300,100);
        btnSalir.setBounds(350,500,300,100);
        frase.setBounds(140,0,500,100);

        frase.setForeground(Color.WHITE);
        frase.setText(frasesDemoledoras[randomNum()]);
        frase.setFont(new Font("arial",Font.BOLD,15));

        btnIniciar.setIcon(Imagen.imageIconDepurada("volverStatic.png","volverStatic.png"));
        btnSalir.setIcon(Imagen.imageIconDepurada("staticSalir.png","staticSalir.png"));

        btnStyle(btnIniciar);
        btnStyle(btnSalir);

        ventana.setIconImage(Imagen.imagenDepurada("skull.png","skull.png"));
        btnSalir.addActionListener(e -> System.exit(0));
        btnIniciar.addActionListener(e->ventana.mostrarPantallaInicio());

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
        //hover sobre btnIniciar
        btnIniciar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnIniciar.setIcon(Imagen.imageIconDepurada("volverAnimated.gif","volverAnimated.gif"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnIniciar.setIcon(Imagen.imageIconDepurada("staticJugar.png","staticJugar.png"));
                btnStyle(btnSalir);
            }
        });

        JLayeredPane layeredPane= new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(700,700));
        layeredPane.setBackground(Color.BLACK);
        layeredPane.setOpaque(true);

        layeredPane.add(frase);
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
    private int randomNum(){
        int num= random.nextInt(10);
        return num;
    }
}
