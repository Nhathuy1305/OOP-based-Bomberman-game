package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
    private boolean[] keys = new boolean[120];
    public boolean up, down, left, right, space, esc;

    public void update(){
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        space = keys[KeyEvent.VK_SPACE];
        esc = keys[KeyEvent.VK_ESCAPE];
    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE && keys[e.getKeyCode()] == true){
            keys[e.getKeyCode()] = false;
        }
        else{
            keys[e.getKeyCode()] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() != KeyEvent.VK_ESCAPE){
            keys[e.getKeyCode()] = false;
        }
    }
}
