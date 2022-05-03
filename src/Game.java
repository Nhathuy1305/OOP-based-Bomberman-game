import Input.Keyboard;
import Graphics.Screen;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.image.DataBufferInt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;


public class Game extends Canvas implements MouseListener {
    public static final int TILES_SIZE = 16, WIDTH = TILES_SIZE * (31 / 2), HEIGHT = TILES_SIZE * 13;
    public static int SCALE = 3;

    public static final String TITLE = "Bomberman";

    private static final int BOMBRATE = 1;
}
