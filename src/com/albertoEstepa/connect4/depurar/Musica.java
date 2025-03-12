package com.albertoEstepa.connect4.depurar;


import javax.sound.sampled.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Musica {
    private static Clip clip;
    private static List<Clip> activeClips = new ArrayList<>();
    public static void playSound(String nombre_archivo, String path) {
        try {
            InputStream is = Musica.class.getClassLoader().getResourceAsStream(path);
            if (is == null) {
                System.out.println("❌ No se encontró el archivo: " + path);
                return;
            } else {
                System.out.println("Reproduciendo: " + nombre_archivo);
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(is);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            activeClips.add(clip);
            // Obtener el control de volumen (GAIN_CONTROL)
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // Ajustar el volumen, el valor por defecto es 0.0 (volumen normal).
            // Puedes aumentar el volumen con valores positivos, pero ten cuidado de no sobrepasar el límite.
            float maxGain = volumeControl.getMaximum();
            float minGain = volumeControl.getMinimum();
            float range = maxGain - minGain;
            float newGain = minGain + (range * 0.8f); // Ajuste al 50% del volumen máximo
            volumeControl.setValue(newGain);

            clip.start();
        } catch (Exception ex) {
            System.out.println("❌ Error al reproducir la música.");
            ex.printStackTrace();
        }
    }
        public static void stopSound() {
            if (clip != null && clip.isRunning()) {
                clip.stop();
                clip.close();
            }
        }
    public static void stopAllSounds() {
        for (Clip clip : new ArrayList<>(activeClips)) {
            clip.stop();
            clip.close();
        }
        activeClips.clear();
    }
}
