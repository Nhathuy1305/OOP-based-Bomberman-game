package Features;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class SoundManager extends JFrame{
    public static Clip title_screen;
    public static Clip bomb_explosion;
    public static Clip just_died;
    public static boolean is_sound_died;
    public static boolean is_sound_title;
    private static boolean is_sound_complete;

    public SoundManager(String name, String sound) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            URL url = this.getClass().getClassLoader().getResource(name);
            assert  url != null;
            AudioInputStream audio_input = AudioSystem.getAudioInputStream(url);
            if (sound.equals("title")) {
                title_screen = AudioSystem.getClip();
                title_screen.open(audio_input);
                title_screen.start();
                title_screen.loop(10);
            }
            if (sound.equals("explosion")) {
                bomb_explosion = AudioSystem.getClip();
                bomb_explosion.open(audio_input);
                bomb_explosion.start();
            }
            if (sound.equals("just_died")) {
                just_died = AudioSystem.getClip();
                just_died.open(audio_input);
                just_died.start();
            }
            if (sound.equals("default")) {
                Clip clip = AudioSystem.getClip();
                clip.open(audio_input);
                clip.start();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void updateSound() {
        if (!is_sound_title) {
            new SoundManager("sound/title_screen.wav", "title");
            is_sound_title = true;
        }
        if (!player.isLife()) {
            title_screen.close();
            bomb_explosion.close();
            if (!is_sound_died) {
                new SoundManager("sound/just_died.wav", "just_died");
                is_sound_died = true;
            }
        }
        if (wait) {
            title_screen.close();
            bomb_explosion.close();
            if (!is_sound_complete) {
                new SoundManager("sound/level_complete.wav", "default");
                is_sound_complete = true;
            }
        }
    }
}
