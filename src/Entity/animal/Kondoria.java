package Entity.animal;

import Control.Move;
import javafx.scene.image.Image;
import Graphics.Sprite;

import static GameRunner.RunBomberman.*;

public class Kondoria extends Animal {

    private static int swap_kill = 1;
    private static int count_kill = 0;
    private static boolean direction;

    public Kondoria(int x, int y, Image img) {
        super(x, y, img);
    }

    public Kondoria(int is_move, int swap, String directionection, int count, int count_to_run) {
        super(4, 1, "up", 0, 0);
    }

    public Kondoria(boolean life) {
        super(life);
    }

    public Kondoria() {
    }

    private void killKondoria(Animal animal) {
        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                animal.setImg(Sprite.kondoria_dead.getFxImage());
                swap_kill = 2;
            } 
            else if (swap_kill == 2) {
                animal.setImg(Sprite.player_dead3.getFxImage());
                swap_kill = 3;
            } 
            else {
                animal.setLife(false);
                enemy.remove(animal);
                swap_kill = 1;
            }
        }
    }

    @Override
    public void update() {
        count_kill++;
        for (Animal animal : enemy) {
            if (animal instanceof Kondoria && !animal.life)
                killKondoria(animal);
        }

        if (this.y % 16 == 0 && this.x % 16 == 0) {
            if (this.x / 32 <= 1 || this.x / 32 >= width - 2)
                direction = !direction;

            if (direction)
                Move.left(this);
            else
                Move.right(this);
        }
    }
}
