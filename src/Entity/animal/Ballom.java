package Entity.animal;

import Control.Move;
import javafx.scene.image.Image;
import Graphics.Sprite;

import java.util.Random;

public class Ballom extends Animal {
    private static int swap_kill = 1;
    private static int count_kill = 0;  // Count the number of Balloms destroyed

    public Ballom(int is_move, int swap, String direction, int count, int count_to_run) {
        super(4, 1, "up", 0, 0);
    }
    
    public Ballom(){

    }
    
    private void killBallom(Animal animal) {    //Bomber destroys Balloon
        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                animal.setImg(Sprite.mob_dead1.getFxImage());
                swap_kill = 2;
            } 
            else if (swap_kill == 2) {
                animal.setImg(Sprite.mob_dead2.getFxImage());
                swap_kill = 3;
            } 
            else if (swap_kill == 3) {
                animal.setImg(Sprite.mob_dead3.getFxImage());
                swap_kill = 4;
            } 
            else {
                animal.setLife(false);
                enemy.remove(animal);
                swap_kill = 1;
            }
        }
    }

    private void kill() {
        for (Animal animal : enemy) {
            if (list_kill[animal.getX() / 32][animal.getY() / 32] == 4) {
                animal.setLife(false);
            }
        }
    }

    public Ballom(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        kill();
        count_kill++;
        for (Animal animal : enemy) {
            if (animal instanceof Ballom && !animal.life)
                killBallom(animal);
        }

        if (this.y % 16 == 0 && this.x % 16 == 0) {
            Random random = new Random();
            int direction = random.nextInt(4);
            switch (direction) {
                case 0:
                    Move.down(this);
                    break;
                case 1:
                    Move.up(this);
                    break;
                case 2:
                    Move.left(this);
                    break;
                case 3:
                    Move.right(this);
                    break;
            }
        }
    }
}